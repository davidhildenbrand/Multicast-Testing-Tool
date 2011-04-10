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

        SenderIDLabel = new javax.swing.JLabel();
        SenderIDData = new javax.swing.JLabel();
        InterfaceLabel = new javax.swing.JLabel();
        InterfaceData = new javax.swing.JLabel();
        GroupLabel = new javax.swing.JLabel();
        GroupData = new javax.swing.JLabel();
        ActivationTimeData = new javax.swing.JLabel();
        ActivationTimeLabel = new javax.swing.JLabel();
        PacketStyleLabel = new javax.swing.JLabel();
        PacketStyleData = new javax.swing.JLabel();
        PortLabel = new javax.swing.JLabel();
        PortData = new javax.swing.JLabel();
        DataData = new javax.swing.JLabel();
        DataLabel = new javax.swing.JLabel();
        PacketSizeData = new javax.swing.JLabel();
        PacketSizeLabel = new javax.swing.JLabel();
        ConfPPSData = new javax.swing.JLabel();
        SenderPPSLabel = new javax.swing.JLabel();
        SenderPPSData = new javax.swing.JLabel();
        ConfPPSLabel = new javax.swing.JLabel();
        ReceiverPPSLabel = new javax.swing.JLabel();
        ReceiverPPSData = new javax.swing.JLabel();
        LostPacketsLabel = new javax.swing.JLabel();
        LostPacketsData = new javax.swing.JLabel();
        MaxDelayLabel = new javax.swing.JLabel();
        MaxDelayData = new javax.swing.JLabel();
        AvgDelayData = new javax.swing.JLabel();
        AvgDelayLabel = new javax.swing.JLabel();
        AvgTraversalLabel = new javax.swing.JLabel();
        AvgTraversalData = new javax.swing.JLabel();
        CloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Bundle"); // NOI18N
        SenderIDLabel.setText(bundle.getString("ShowReceiverDialog.SenderIDLabel.text")); // NOI18N

        SenderIDData.setText(bundle.getString("ShowReceiverDialog.SenderIDData.text")); // NOI18N

        InterfaceLabel.setText(bundle.getString("ShowReceiverDialog.InterfaceLabel.text")); // NOI18N

        InterfaceData.setText(bundle.getString("ShowReceiverDialog.InterfaceData.text")); // NOI18N

        GroupLabel.setText(bundle.getString("ShowReceiverDialog.GroupLabel.text")); // NOI18N

        GroupData.setText(bundle.getString("ShowReceiverDialog.GroupData.text")); // NOI18N

        ActivationTimeData.setText(bundle.getString("ShowReceiverDialog.ActivationTimeData.text")); // NOI18N

        ActivationTimeLabel.setText(bundle.getString("ShowReceiverDialog.ActivationTimeLabel.text")); // NOI18N

        PacketStyleLabel.setText(bundle.getString("ShowReceiverDialog.PacketStyleLabel.text")); // NOI18N

        PacketStyleData.setText(bundle.getString("ShowReceiverDialog.PacketStyleData.text")); // NOI18N

        PortLabel.setText(bundle.getString("ShowReceiverDialog.PortLabel.text")); // NOI18N

        PortData.setText(bundle.getString("ShowReceiverDialog.PortData.text")); // NOI18N

        DataData.setText(bundle.getString("ShowReceiverDialog.DataData.text")); // NOI18N

        DataLabel.setText(bundle.getString("ShowReceiverDialog.DataLabel.text")); // NOI18N

        PacketSizeData.setText(bundle.getString("ShowReceiverDialog.PacketSizeData.text")); // NOI18N

        PacketSizeLabel.setText(bundle.getString("ShowReceiverDialog.PacketSizeLabel.text")); // NOI18N

        ConfPPSData.setText(bundle.getString("ShowReceiverDialog.ConfPPSData.text")); // NOI18N

        SenderPPSLabel.setText(bundle.getString("ShowReceiverDialog.SenderPPSLabel.text")); // NOI18N

        SenderPPSData.setText(bundle.getString("ShowReceiverDialog.SenderPPSData.text")); // NOI18N

        ConfPPSLabel.setText(bundle.getString("ShowReceiverDialog.ConfPPSLabel.text")); // NOI18N

        ReceiverPPSLabel.setText(bundle.getString("ShowReceiverDialog.ReceiverPPSLabel.text")); // NOI18N

        ReceiverPPSData.setText(bundle.getString("ShowReceiverDialog.ReceiverPPSData.text")); // NOI18N

        LostPacketsLabel.setText(bundle.getString("ShowReceiverDialog.LostPacketsLabel.text")); // NOI18N

        LostPacketsData.setText(bundle.getString("ShowReceiverDialog.LostPacketsData.text")); // NOI18N

        MaxDelayLabel.setText(bundle.getString("ShowReceiverDialog.MaxDelayLabel.text")); // NOI18N

        MaxDelayData.setText(bundle.getString("ShowReceiverDialog.MaxDelayData.text")); // NOI18N

        AvgDelayData.setText(bundle.getString("ShowReceiverDialog.AvgDelayData.text")); // NOI18N

        AvgDelayLabel.setText(bundle.getString("ShowReceiverDialog.AvgDelayLabel.text")); // NOI18N

        AvgTraversalLabel.setText(bundle.getString("ShowReceiverDialog.AvgTraversalLabel.text")); // NOI18N

        AvgTraversalData.setText(bundle.getString("ShowReceiverDialog.AvgTraversalData.text")); // NOI18N

        CloseButton.setText(bundle.getString("ShowReceiverDialog.CloseButton.text")); // NOI18N
        CloseButton.setActionCommand(bundle.getString("ShowReceiverDialog.CloseButton.actionCommand")); // NOI18N
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReceiverPPSLabel)
                            .addComponent(LostPacketsLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SenderIDLabel)
                                    .addComponent(InterfaceLabel)
                                    .addComponent(GroupLabel)
                                    .addComponent(PortLabel)
                                    .addComponent(PacketStyleLabel)
                                    .addComponent(ActivationTimeLabel)
                                    .addComponent(PacketSizeLabel)
                                    .addComponent(DataLabel)
                                    .addComponent(ConfPPSLabel)
                                    .addComponent(SenderPPSLabel)
                                    .addComponent(MaxDelayLabel)
                                    .addComponent(AvgDelayLabel)
                                    .addComponent(AvgTraversalLabel))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AvgTraversalData)
                                    .addComponent(MaxDelayData)
                                    .addComponent(AvgDelayData)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(SenderPPSData)
                                        .addComponent(ConfPPSData)
                                        .addComponent(DataData, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ReceiverPPSData)
                                        .addComponent(LostPacketsData))
                                    .addComponent(PacketSizeData)
                                    .addComponent(ActivationTimeData)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PacketStyleData)
                                        .addComponent(PortData)
                                        .addComponent(GroupData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(InterfaceData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SenderIDData))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(CloseButton)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SenderIDLabel)
                    .addComponent(SenderIDData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InterfaceLabel)
                    .addComponent(InterfaceData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GroupLabel)
                    .addComponent(GroupData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PortLabel)
                    .addComponent(PortData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PacketStyleLabel)
                    .addComponent(PacketStyleData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActivationTimeLabel)
                    .addComponent(ActivationTimeData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PacketSizeLabel)
                    .addComponent(PacketSizeData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataLabel)
                    .addComponent(DataData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfPPSLabel)
                    .addComponent(ConfPPSData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SenderPPSLabel)
                    .addComponent(SenderPPSData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReceiverPPSLabel)
                    .addComponent(ReceiverPPSData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LostPacketsLabel)
                    .addComponent(LostPacketsData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MaxDelayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AvgDelayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AvgTraversalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CloseButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MaxDelayData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AvgDelayData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AvgTraversalData)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        receivergroup.removeReceiverDataChangeListener(listener);
        this.dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

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
        this.SenderIDData.setText(String.valueOf(this.receiver.getSenderId()));
        this.PacketStyleData.setText(this.receiver.getPacketType().toString());
        this.PacketSizeData.setText(String.valueOf(this.receiver.getPacketSize()));
        this.DataData.setText(this.receiver.getPayloadAsString());
        this.ConfPPSData.setText(String.valueOf(this.receiver.getSenderConfiguredPPS()));
        this.SenderPPSData.setText(String.valueOf(this.receiver.getSenderSentPackets()));
        this.ReceiverPPSData.setText(String.valueOf(this.receiver.getSenderMeasuredPPS()));
        this.LostPacketsData.setText(String.valueOf(this.receiver.getLostPackets()));
        this.MaxDelayData.setText(String.valueOf(this.receiver.getMaxDelay()));
        //AvgDelayData;
        this.AvgTraversalData.setText(String.valueOf(this.receiver.getAvgTraversal()));
        //InterfaceData;
        this.GroupData.setText(this.receivergroup.getGroup().getHostAddress());
        this.PortData.setText(String.valueOf(this.receivergroup.getPort()));
        //ActivationTimeData;
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActivationTimeData;
    private javax.swing.JLabel ActivationTimeLabel;
    private javax.swing.JLabel AvgDelayData;
    private javax.swing.JLabel AvgDelayLabel;
    private javax.swing.JLabel AvgTraversalData;
    private javax.swing.JLabel AvgTraversalLabel;
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel ConfPPSData;
    private javax.swing.JLabel ConfPPSLabel;
    private javax.swing.JLabel DataData;
    private javax.swing.JLabel DataLabel;
    private javax.swing.JLabel GroupData;
    private javax.swing.JLabel GroupLabel;
    private javax.swing.JLabel InterfaceData;
    private javax.swing.JLabel InterfaceLabel;
    private javax.swing.JLabel LostPacketsData;
    private javax.swing.JLabel LostPacketsLabel;
    private javax.swing.JLabel MaxDelayData;
    private javax.swing.JLabel MaxDelayLabel;
    private javax.swing.JLabel PacketSizeData;
    private javax.swing.JLabel PacketSizeLabel;
    private javax.swing.JLabel PacketStyleData;
    private javax.swing.JLabel PacketStyleLabel;
    private javax.swing.JLabel PortData;
    private javax.swing.JLabel PortLabel;
    private javax.swing.JLabel ReceiverPPSData;
    private javax.swing.JLabel ReceiverPPSLabel;
    private javax.swing.JLabel SenderIDData;
    private javax.swing.JLabel SenderIDLabel;
    private javax.swing.JLabel SenderPPSData;
    private javax.swing.JLabel SenderPPSLabel;
    // End of variables declaration//GEN-END:variables

}
