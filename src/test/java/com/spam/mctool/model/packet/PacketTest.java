package com.spam.mctool.model.packet;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author konne
 * 
 * Tests the Packet implementations
 */
public class PacketTest {
	@Test
	public void test_validHirschmannPackets() {
		// test if a valid packet will be parsed correctly
		
		byte[] raw = {
			'H','i','r','s','c','h','m','a','n','n',
			' ','I','P',' ','T','e','s','t','-','M',
			'u','l','t','i','c','a','s','t','\0',
			(byte)0x7E, (byte)0xCD, 							// sender id
			(byte)0x00, (byte)0x00, (byte)0x00, (byte)0xE6, 	// sequence number
			(byte)0x00, (byte)0x01,								// pps
			(byte)0x20,											// ttl
			(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, 	// reset 'bit'
			(byte)0xDA, (byte)0x5F
		};
		
		ByteBuffer data = ByteBuffer.wrap(raw);
		Packet ap = new AutoPacket();
		
		for(int i=0 ; i<2 ; ++i){
			try {
				ap.fromByteArray(data);
			} catch (DataFormatException e) {
				fail(e.getMessage());
			}
			
			assertEquals(0x7ECD, ap.getSenderId());
			assertEquals(1, ap.getConfiguredPacketsPerSecond());
			assertEquals(0xE6, ap.getSequenceNumber());
			
			// test if the byte rendering of the packet
			// will still contain all the information
			data = ap.toByteArray();
			ap = new AutoPacket();
		}
	}
	
	@Test
	public void test_invalidHirschmannPackets() {
		byte[] raw = {
			'H','i','r','s','c','h','m','a','n','n',
			' ','I','P',' ','T','e','s','t','-','M',
			'u','l','t','i','c','a','s','t','\0',
			(byte)0x7E, (byte)0xCD, 							// sender id
			(byte)0x00, (byte)0x00, (byte)0x00, (byte)0xE6, 	// sequence number
			(byte)0x00, (byte)0x01,								// pps
			(byte)0x20,											// ttl
			(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, 	// reset 'bit'
			(byte)0xDA, (byte)0x5F,
			(byte)0xFF						// this should not be part of the checksum
		};
		
		ByteBuffer data = ByteBuffer.wrap(raw);
		Packet ap = new AutoPacket();
		
		// make sure the 0xFF after the checksum is not use for the checksum
		try {
			ap.fromByteArray(data);
		} catch(DataFormatException e) {
			fail(e.getMessage());
		}
			
		// change some stuff to make the checksum incorrect
		raw[30] = 0x0A;
		
		for(int i=0 ; i<2 ; ++i){
			try {
				data.rewind();
				ap.fromByteArray(data);
			} catch (DataFormatException e) {
				System.out.println(e.getMessage());
				// truncate array to check underflows
				raw = Arrays.copyOf(raw, raw.length-2);
				data = ByteBuffer.wrap(raw);
				continue;
			}
			fail("Exception should have been thrown");
		}
	}
	
	@Test
	public void test_validSpamPackets() {
		// test if a valid packet will be parsed correctly
		
		byte[] raw = {
			5,57,  0,0,0,0,		    					// header
			0, 1,  0,0,0,4,    -1,  -1,  -1,  -1,		// id
			0, 2,  0,0,0,4,   127,  -1,  -1,  -1,		// pps
			0, 3,  0,0,0,4,     5, 127,   0, 111,		// mpr
			0, 4,  0,0,0,4,    -1,  -1,  -1,  -1,		// sequence
			0,99,  0,0,0,9,   'I', 'G', 'N', 'O', 'R', 'E', ' ', 'M', 'E',
			0, 5,  0,0,0,8,    -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,	// time
			0, 6,  0,0,0,4,   'T', 'e', 's',  't'		// payload
		};
		ByteBuffer data = ByteBuffer.wrap(raw);
		Packet ap = new AutoPacket();

		for(int i=0 ; i<2 ; ++i){
			try {
				ap.fromByteArray(data);
			} catch (DataFormatException e) {
				fail(e.getMessage());
			}
			
			assertEquals(0xffffffffL, ap.getSenderId());
			assertEquals(0x7fffffffL, ap.getConfiguredPacketsPerSecond());
			assertEquals(5*0x1000000L+127*0x10000L+111L, ap.getSenderMeasuredPacketRate());
			assertEquals(0xffffffffL, ap.getSequenceNumber());
			assertEquals(0xffffffffffffffffL, 0xffffffffffffffffL & ap.getDispatchTime());
			assertEquals("Test", new String(ap.getPayload()));
			
			// test if the byte rendering of the packet
			// will still contain all the information
			data = ap.toByteArray();
			ap = new AutoPacket();
		}
	}

	@Test
	public void test_invalidSpamPackets() {
		// test that invalid packets will actually fail
				
		byte[][] errors = {
				// since the algorithm ignores minor errors in the format
				// packets without a header may in some cases still be valid
				// one can thus only test if tlv field with id 1337 is empty
				{5,57,0,0,0,1},
				// wrong size for field
				{0,1,0,0,0,3,0,0,0},	
				// wrong size for field
				{0,2,0,0,0,3,0,0,0},	
				// wrong size for field
				{0,3,0,0,0,3,0,0,0},	
				// wrong size for field
				{0,4,0,0,0,3,0,0,0},	
				// wrong size for field
				{0,5,0,0,0,9,0,0,0,0,0,0,0,0,0},	
				// size mismatch for payload
				{0,6,0,0,0,4},
				// payload too big
				{0,6,-1,0,0,0},
				// wrong tlv format	(size mismatch)
				{0,10,0,0,0,1},
				// wrong tlv format (illegal size, buffer overflow)
				{0,10,-1,-1,-1,-1}
		};
		
		for(byte[] raw : errors){
			ByteBuffer data = ByteBuffer.wrap(raw);
			Packet p = new SpamPacket();
	
			try {
				p.fromByteArray(data);
			} catch (DataFormatException e) {
				continue;
			}
			fail("Exception should have been thrown");
		}
	}
}