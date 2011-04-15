/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ShowReceiverDialog.java
 *
 * Created on Mar 3, 2011, 7:47:50 PM
 */

package com.spam.mctool.view.dialogs;

import com.spam.mctool.intermediates.ReceiverDataChangedEvent;
import com.spam.mctool.model.Receiver;
import com.spam.mctool.model.ReceiverDataChangeListener;
import com.spam.mctool.model.ReceiverGroup;
import com.spam.mctool.view.main.MainFrame;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tobias Schoknecht (Tobias.Schoknecht@de.ibm.com)
 */
public class ShowReceiverDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private Receiver receiver;
    private ReceiverGroup receivergroup;
    private MainFrame parent;
    private ReceiverDataChangeListener listener = new ReceiverDataChangeListener() {
            public void dataChanged(ReceiverDataChangedEvent e) {
                SwingUtilities.invokeLater(new DataLoader());
            }
        };

	/** Creates new form ShowReceiverDialog */
    private ShowReceiverDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private ShowReceiverDialog(MainFrame parent, boolean modal) {
        this((JFrame)parent, modal);
        this.parent = parent;
    }

    public ShowReceiverDialog(MainFrame parent, boolean modal, Receiver receiver, ReceiverGroup receivergroup) {
        this(parent, modal);
        this.receiver = receiver;
        this.receivergroup = receivergroup;
        receivergroup.addReceiverDataChangeListener(listener);
        SwingUtilities.invokeLater(new DataLoader());
    }

    private class DataLoader implements Runnable {

        public void run() {
            loadData();
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        senderIDLabel = new javax.swing.JLabel();
        senderIDData = new javax.swing.JLabel();
        interfaceLabel = new javax.swing.JLabel();
        interfaceData = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        groupData = new javax.swing.JLabel();
        packetStyleLabel = new javax.swing.JLabel();
        packetStyleData = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        portData = new javax.swing.JLabel();
        dataData = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        packetSizeData = new javax.swing.JLabel();
        packetSizeLabel = new javax.swing.JLabel();
        confPPSData = new javax.swing.JLabel();
        senderPPSLabel = new javax.swing.JLabel();
        senderPPSData = new javax.swing.JLabel();
        confPPSLabel = new javax.swing.JLabel();
        receiverPPSLabel = new javax.swing.JLabel();
        receiverPPSData = new javax.swing.JLabel();
        lostPacketsLabel = new javax.swing.JLabel();
        lostPacketsData = new javax.swing.JLabel();
        maxDelayLabel = new javax.swing.JLabel();
        maxDelayData = new javax.swing.JLabel();
        avgTraversalLabel = new javax.swing.JLabel();
        avgTraversalData = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Bundle"); // NOI18N
        senderIDLabel.setText(bundle.getString("ShowReceiverDialog.senderIDLabel.text")); // NOI18N

        senderIDData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        senderIDData.setText(bundle.getString("ShowReceiverDialog.senderIDData.text")); // NOI18N

        interfaceLabel.setText(bundle.getString("ShowReceiverDialog.interfaceLabel.text")); // NOI18N

        interfaceData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        interfaceData.setText(bundle.getString("ShowReceiverDialog.interfaceData.text")); // NOI18N

        groupLabel.setText(bundle.getString("ShowReceiverDialog.groupLabel.text")); // NOI18N

        groupData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        groupData.setText(bundle.getString("ShowReceiverDialog.groupData.text")); // NOI18N

        packetStyleLabel.setText(bundle.getString("ShowReceiverDialog.packetStyleLabel.text")); // NOI18N

        packetStyleData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        packetStyleData.setText(bundle.getString("ShowReceiverDialog.packetStyleData.text")); // NOI18N

        portLabel.setText(bundle.getString("ShowReceiverDialog.portLabel.text")); // NOI18N

        portData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        portData.setText(bundle.getString("ShowReceiverDialog.portData.text")); // NOI18N

        dataData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dataData.setText(bundle.getString("ShowReceiverDialog.dataData.text")); // NOI18N

        dataLabel.setText(bundle.getString("ShowReceiverDialog.dataLabel.text")); // NOI18N

        packetSizeData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        packetSizeData.setText(bundle.getString("ShowReceiverDialog.packetSizeData.text")); // NOI18N

        packetSizeLabel.setText(bundle.getString("ShowReceiverDialog.packetSizeLabel.text")); // NOI18N

        confPPSData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        confPPSData.setText(bundle.getString("ShowReceiverDialog.confPPSData.text")); // NOI18N

        senderPPSLabel.setText(bundle.getString("ShowReceiverDialog.senderPPSLabel.text")); // NOI18N

        senderPPSData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        senderPPSData.setText(bundle.getString("ShowReceiverDialog.senderPPSData.text")); // NOI18N

        confPPSLabel.setText(bundle.getString("ShowReceiverDialog.confPPSLabel.text")); // NOI18N

        receiverPPSLabel.setText(bundle.getString("ShowReceiverDialog.receiverPPSLabel.text")); // NOI18N

        receiverPPSData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        receiverPPSData.setText(bundle.getString("ShowReceiverDialog.receiverPPSData.text")); // NOI18N

        lostPacketsLabel.setText(bundle.getString("ShowReceiverDialog.lostPacketsLabel.text")); // NOI18N

        lostPacketsData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lostPacketsData.setText(bundle.getString("ShowReceiverDialog.lostPacketsData.text")); // NOI18N

        maxDelayLabel.setText(bundle.getString("ShowReceiverDialog.maxDelayLabel.text")); // NOI18N

        maxDelayData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maxDelayData.setText(bundle.getString("ShowReceiverDialog.maxDelayData.text")); // NOI18N

        avgTraversalLabel.setText(bundle.getString("ShowReceiverDialog.avgTraversalLabel.text")); // NOI18N

        avgTraversalData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        avgTraversalData.setText(bundle.getString("ShowReceiverDialog.avgTraversalData.text")); // NOI18N

        closeButton.setText(bundle.getString("ShowReceiverDialog.closeButton.text")); // NOI18N
        closeButton.setActionCommand(bundle.getString("ShowReceiverDialog.closeButton.actionCommand")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senderIDLabel)
                            .addComponent(interfaceLabel)
                            .addComponent(groupLabel)
                            .addComponent(portLabel)
                            .addComponent(packetStyleLabel)
                            .addComponent(receiverPPSLabel)
                            .addComponent(lostPacketsLabel)
                            .addComponent(packetSizeLabel)
                            .addComponent(dataLabel)
                            .addComponent(confPPSLabel)
                            .addComponent(senderPPSLabel)
                            .addComponent(maxDelayLabel)
                            .addComponent(avgTraversalLabel))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(groupData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(interfaceData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(senderIDData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(packetSizeData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(dataData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(confPPSData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(senderPPSData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(receiverPPSData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(lostPacketsData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(maxDelayData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(avgTraversalData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(packetStyleData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(portData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(closeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(senderIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(interfaceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groupLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(packetStyleLabel)
                        .addGap(18, 18, 18)
                        .addComponent(packetSizeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confPPSLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senderPPSLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receiverPPSLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lostPacketsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxDelayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avgTraversalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(senderIDData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(interfaceData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groupData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(packetStyleData)
                        .addGap(18, 18, 18)
                        .addComponent(packetSizeData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confPPSData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senderPPSData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receiverPPSData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lostPacketsData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxDelayData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avgTraversalData)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        receivergroup.removeReceiverDataChangeListener(listener);
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowReceiverDialog dialog = new ShowReceiverDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void loadData(){
        for (InterfaceAddress interfaceAddress : this.receivergroup.getNetworkInterface().getInterfaceAddresses()) {
            InetAddress address = interfaceAddress.getAddress();
            String ip = null;

            if(this.receivergroup.getGroup() instanceof Inet4Address){
                if(address instanceof Inet4Address){
                    ip = address.getHostAddress();
                }
            }
            else if(this.receivergroup.getGroup() instanceof Inet6Address){
                if(address instanceof Inet6Address){
                    ip = address.getHostAddress();
                }
            }

            this.interfaceData.setText(this.receivergroup.getNetworkInterface().getDisplayName() + " - " + ip);
        }
        this.senderIDData.setText(String.valueOf(this.receiver.getSenderId()));
        this.packetStyleData.setText(this.receiver.getPacketType().toString());
        this.packetSizeData.setText(String.valueOf(this.receiver.getPacketSize()));
        this.dataData.setText(this.receiver.getPayloadAsString());
        this.confPPSData.setText(String.valueOf(this.receiver.getSenderConfiguredPPS()));
        this.senderPPSData.setText(String.valueOf(this.receiver.getSenderMeasuredPPS()));
        this.receiverPPSData.setText(String.valueOf(this.receiver.getSenderMeasuredPPS()));
        this.lostPacketsData.setText(String.valueOf(this.receiver.getLostPackets()));
        this.maxDelayData.setText(String.valueOf(this.receiver.getMaxDelay()));
        this.avgTraversalData.setText(String.valueOf(this.receiver.getAvgTraversal()));
        this.groupData.setText(this.receivergroup.getGroup().getHostAddress());
        this.portData.setText(String.valueOf(this.receivergroup.getPort()));
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avgTraversalData;
    private javax.swing.JLabel avgTraversalLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel confPPSData;
    private javax.swing.JLabel confPPSLabel;
    private javax.swing.JLabel dataData;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JLabel groupData;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel interfaceData;
    private javax.swing.JLabel interfaceLabel;
    private javax.swing.JLabel lostPacketsData;
    private javax.swing.JLabel lostPacketsLabel;
    private javax.swing.JLabel maxDelayData;
    private javax.swing.JLabel maxDelayLabel;
    private javax.swing.JLabel packetSizeData;
    private javax.swing.JLabel packetSizeLabel;
    private javax.swing.JLabel packetStyleData;
    private javax.swing.JLabel packetStyleLabel;
    private javax.swing.JLabel portData;
    private javax.swing.JLabel portLabel;
    private javax.swing.JLabel receiverPPSData;
    private javax.swing.JLabel receiverPPSLabel;
    private javax.swing.JLabel senderIDData;
    private javax.swing.JLabel senderIDLabel;
    private javax.swing.JLabel senderPPSData;
    private javax.swing.JLabel senderPPSLabel;
    // End of variables declaration//GEN-END:variables

}
