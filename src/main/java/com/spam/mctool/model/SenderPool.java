package com.spam.mctool.model;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import com.spam.mctool.intermediates.SenderAddedOrRemovedEvent;

public class SenderPool implements SenderManager {
	private ScheduledThreadPoolExecutor stfe;
	private Set<Sender> senders = new HashSet<Sender>();
	private List<SenderAddedOrRemovedListener> saorl;
	
	private int threadPoolSize = 5;
	// statistics
	private int statsInterval = 1000;
	private long overallSendingPPS;
	
	public SenderPool() {
		this.saorl = new LinkedList<SenderAddedOrRemovedListener>();
		this.stfe = new ScheduledThreadPoolExecutor(threadPoolSize);
	}

	public Sender create(Map<String, String> params) throws IllegalArgumentException {
		Sender sender;
		InetAddress group;
		int port;
		byte ttl;
		int pps;
		int psize;
		String payload;
		Sender.PacketType ptype;
		NetworkInterface ninf;
		MulticastStream.AnalyzingBehaviour abeh;
		
		try {
			group = InetAddress.getByName(params.get("group"));
			ninf = NetworkInterface.getByInetAddress(InetAddress.getByName(params.get("ninf")));
			port = new Integer(params.get("port"));
			ttl = new Byte(params.get("ttl"));
			if(ttl<=0 || ttl>255) throw new Exception();
			pps = new Integer(params.get("pps"));
			if(pps<=0 || pps>1000) throw new Exception();
			psize = new Integer(params.get("psize"));
			if(psize<150 || psize>9000) throw new Exception();
			payload = params.get("payload");
			ptype = Sender.PacketType.getByIdentifier(params.get("ptype").toUpperCase());
			abeh = MulticastStream.AnalyzingBehaviour.getByIdentifier(params.get("abeh"));
		} catch(Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
		
		sender = new Sender(this.stfe);
		sender.setGroup(group);
		sender.setPort(port);
		sender.setTtl(ttl);
		sender.setSenderConfiguredPacketRate(pps);
		sender.setPacketSize(psize);
		sender.setPayloadFromString(payload);
		sender.setpType(ptype);
		sender.setNetworkInterface(ninf);
		sender.setAnalyzingBehaviour(abeh);
		sender.setStatsInterval(statsInterval);
		
		this.senders.add(sender);
		this.fireSenderAddedEvent(sender);
		return sender;
	}

	public void remove(Sender sender) {
		sender.deactivate();
		senders.remove(sender);
		this.fireSenderRemovedEvent(sender);
	}

	public Collection<Sender> getSenders() {
		return new HashSet<Sender>(senders);
	}

	public void killAll() {
		for(Sender s : senders) {
			if(s.getState() == MulticastStream.State.ACTIVE) {
				s.deactivate();
			}
		}
		this.stfe.shutdown();
	}

	public void addSenderAddedOrRemovedListener(SenderAddedOrRemovedListener l) {
		synchronized(this.saorl) {
			this.saorl.add(l);
		}
	}

	public void removeSenderAddedOrRemovedListener(SenderAddedOrRemovedListener l) {
		synchronized(this.saorl) {
			this.saorl.remove(l);
		}
	}
	
	private void fireSenderAddedEvent(Sender s) {
		synchronized(this.saorl) {
			for(SenderAddedOrRemovedListener l : this.saorl) {
				l.senderAdded(new SenderAddedOrRemovedEvent(s));
			}
		}
	}
	
	private void fireSenderRemovedEvent(Sender s) {
		synchronized(this.saorl) {
			for(SenderAddedOrRemovedListener l : this.saorl) {
				l.senderRemoved(new SenderAddedOrRemovedEvent(s));
			}
		}
	}
	
	public int getStatsInterval() {
		return statsInterval;
	}

	public void setStatsInterval(int statsInterval) {
		this.statsInterval = statsInterval;
	}
	
	private class OverallSenderStatisticAnalyzer implements Runnable {
		@Override
		public void run() {
			
		}
	}

}
