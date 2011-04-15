/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditSenderDialog.java
 *
 * Created on Mar 3, 2011, 7:47:26 PM
 */

package com.spam.mctool.view.dialogs;

import com.spam.mctool.model.Sender;
import com.spam.mctool.view.main.MainFrame;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Tobias Schoknecht (Tobias.Schoknecht@de.ibm.com)
 */
public class EditSenderDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private Sender sender = null;
    private Map<String,String> interfaceMap = new HashMap<String, String>();
    private Map<String,String> packageMap = new HashMap<String, String>();
    private Map<String,String> analyzingBehaviourMap = new HashMap<String, String>();
    private MainFrame parent;
    //TODO loglevel?

	/** Creates new form EditSenderDialog */
    private EditSenderDialog(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadNetInterfaces();
        initComboBoxes();
    }

    public EditSenderDialog(MainFrame parent, boolean modal) {
        this((JFrame)parent, modal);
        this.parent = parent;
        setDefaultValues();
    }

    public EditSenderDialog(MainFrame parent, boolean modal, Sender sender, boolean create) {
        this(parent, modal);
        this.sender = sender;
        loadData(create);

        if(create){
            this.sender = null;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        interfaceCombo = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        interfaceLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        activateBox = new javax.swing.JCheckBox();
        dataLabel = new javax.swing.JLabel();
        dataField = new javax.swing.JTextField();
        packetRateLabel = new javax.swing.JLabel();
        packetSizeLabel = new javax.swing.JLabel();
        ttlLabel = new javax.swing.JLabel();
        packetStyleLabel = new javax.swing.JLabel();
        packetStyleCombo = new javax.swing.JComboBox();
        groupField = new javax.swing.JFormattedTextField();
        packetRateField = new javax.swing.JSpinner();
        packetSizeField = new javax.swing.JSpinner();
        ttlField = new javax.swing.JSpinner();
        analyzingBehaviourLabel = new javax.swing.JLabel();
        analyzingBehaviourCombo = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        portField = new javax.swing.JSpinner();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Bundle"); // NOI18N
        okButton.setText(bundle.getString("EditSenderDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        interfaceLabel.setText(bundle.getString("EditSenderDialog.interfaceLabel.text")); // NOI18N

        portLabel.setText(bundle.getString("EditSenderDialog.portLabel.text")); // NOI18N

        groupLabel.setText(bundle.getString("EditSenderDialog.groupLabel.text")); // NOI18N

        activateBox.setText(bundle.getString("EditSenderDialog.activateBox.text")); // NOI18N

        dataLabel.setText(bundle.getString("EditSenderDialog.dataLabel.text")); // NOI18N

        packetRateLabel.setText(bundle.getString("EditSenderDialog.packetRateLabel.text")); // NOI18N

        packetSizeLabel.setText(bundle.getString("EditSenderDialog.packetSizeLabel.text")); // NOI18N

        ttlLabel.setText(bundle.getString("EditSenderDialog.ttlLabel.text")); // NOI18N

        packetStyleLabel.setText(bundle.getString("EditSenderDialog.packetStyleLabel.text")); // NOI18N

        analyzingBehaviourLabel.setText(bundle.getString("EditSenderDialog.analyzingBehaviourLabel.text")); // NOI18N

        analyzingBehaviourCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        cancelButton.setText(bundle.getString("EditSenderDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
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
                        .addComponent(interfaceLabel)
                        .addContainerGap(519, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupLabel)
                            .addComponent(groupField, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(portLabel)
                            .addComponent(portField, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dataLabel)
                                    .addGap(240, 240, 240))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(packetRateField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                        .addComponent(dataField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                        .addComponent(ttlField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(packetRateLabel)
                                .addGap(150, 150, 150)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(packetSizeLabel)
                                .addContainerGap(224, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(packetStyleLabel)
                                .addContainerGap(217, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(packetSizeField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(packetStyleCombo, 0, 290, Short.MAX_VALUE))
                                .addGap(13, 13, 13))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ttlLabel)
                        .addContainerGap(492, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(analyzingBehaviourLabel)
                        .addContainerGap(453, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(analyzingBehaviourCombo, 0, 297, Short.MAX_VALUE)
                        .addGap(286, 286, 286))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(okButton)
                            .addComponent(activateBox, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(interfaceCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 571, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupLabel)
                    .addComponent(portLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(interfaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(interfaceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(packetStyleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(packetStyleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(packetRateLabel)
                    .addComponent(packetSizeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(packetRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(packetSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ttlLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ttlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyzingBehaviourLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyzingBehaviourCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activateBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        Map<String,String> senderMap = new HashMap<String, String>();

        if(this.sender == null){
            senderMap.put("group", this.groupField.getText());
            senderMap.put("port", this.portField.getValue().toString());
            senderMap.put("pps", this.packetRateField.getValue().toString());
            senderMap.put("psize", this.packetSizeField.getValue().toString());
            senderMap.put("ttl", this.ttlField.getValue().toString());
            senderMap.put("payload", this.dataField.getText());
            senderMap.put("ptype", this.packageMap.get(this.packetStyleCombo.getSelectedItem().toString()));
            senderMap.put("ninf",this.interfaceMap.get(this.interfaceCombo.getSelectedItem().toString()));
            senderMap.put("abeh",this.analyzingBehaviourMap.get(this.analyzingBehaviourCombo.getSelectedItem().toString()));
            parent.addSender(senderMap, this.activateBox.isSelected());
        }
        else{
            this.sender.setSenderConfiguredPacketRate(Integer.parseInt(this.packetRateField.getValue().toString()));
            this.sender.setPacketSize(Integer.parseInt(this.packetSizeField.getValue().toString()));
            this.sender.setTtl(Byte.parseByte(this.ttlField.getValue().toString()));
            this.sender.deactivate();
            if(this.activateBox.isSelected()){
                this.sender.activate();
            }
        }


        this.dispose();
}//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
}//GEN-LAST:event_cancelButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditSenderDialog dialog = new EditSenderDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void loadData(boolean create){
        this.groupField.setText(this.sender.getGroup().getHostAddress());
        this.portField.setValue(this.sender.getPort());
        this.dataField.setText(this.sender.getPayloadAsString());
        this.packetRateField.setValue(this.sender.getSenderConfiguredPacketRate());
        this.packetSizeField.setValue(this.sender.getPacketSize());
        this.ttlField.setValue(this.sender.getTtl());
        this.packetStyleCombo.setSelectedItem(this.sender.getpType().getDisplayName());

        for (InterfaceAddress interfaceAddress : this.sender.getNetworkInterface().getInterfaceAddresses()) {
            InetAddress address = interfaceAddress.getAddress();
            String ip = null;

            if(this.sender.getGroup() instanceof Inet4Address){
                if(address instanceof Inet4Address){
                    ip = address.getHostAddress();
                }
            }
            else if(this.sender.getGroup() instanceof Inet6Address){
                if(address instanceof Inet6Address){
                    ip = address.getHostAddress();
                }
            }

            this.interfaceCombo.setSelectedItem(this.sender.getNetworkInterface().getDisplayName() + " - " + ip);
        }

        Iterator it = analyzingBehaviourMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();

            if(entry.getValue().equals(this.sender.getAnalyzingBehaviour().getIdentifier())){
                this.analyzingBehaviourCombo.setSelectedItem(entry.getKey());
            }
        }

        if(this.sender.isActive()){
            this.activateBox.setSelected(true);
        }

        if(!create){
            this.groupField.setEnabled(false);
            this.portField.setEnabled(false);
            this.dataField.setEnabled(false);
            this.interfaceCombo.setEnabled(false);
        }
    }

    private void loadNetInterfaces(){
        this.interfaceCombo.removeAllItems();
	Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            Logger.getLogger(EditSenderDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();

            for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                InetAddress address = interfaceAddress.getAddress();

                this.interfaceCombo.addItem(networkInterface.getDisplayName() + " - " + address.getHostAddress());
                this.interfaceMap.put(networkInterface.getDisplayName() + " - " + address.getHostAddress(),address.getHostAddress());
            }
        }       
    }

    private void setDefaultValues(){
        this.groupField.setText("225.1.1.1");
        this.portField.setValue(12345);
        this.dataField.setText("Default");
        this.packetRateField.setValue(10);
        this.packetSizeField.setValue(200);
        this.ttlField.setValue(32);
        this.packetStyleCombo.setSelectedItem("Spam Packet Format");
    }

    private void initComboBoxes(){
        this.packageMap.put("Spam Packet Format","spam");
        this.packageMap.put("Hirschmann Packet Format","hmann");
        this.packetStyleCombo.removeAllItems();
        this.packetStyleCombo.addItem("Spam Packet Format");
        this.packetStyleCombo.addItem("Hirschmann Packet Format");

        this.analyzingBehaviourMap.put("Default","default");
        this.analyzingBehaviourMap.put("Lazy","lazy");
        this.analyzingBehaviourMap.put("Eager","eager");
        this.analyzingBehaviourCombo.removeAllItems();
        this.analyzingBehaviourCombo.addItem("Default");
        this.analyzingBehaviourCombo.addItem("Lazy");
        this.analyzingBehaviourCombo.addItem("Eager");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activateBox;
    private javax.swing.JComboBox analyzingBehaviourCombo;
    private javax.swing.JLabel analyzingBehaviourLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dataField;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JFormattedTextField groupField;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JComboBox interfaceCombo;
    private javax.swing.JLabel interfaceLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton okButton;
    private javax.swing.JSpinner packetRateField;
    private javax.swing.JLabel packetRateLabel;
    private javax.swing.JSpinner packetSizeField;
    private javax.swing.JLabel packetSizeLabel;
    private javax.swing.JComboBox packetStyleCombo;
    private javax.swing.JLabel packetStyleLabel;
    private javax.swing.JSpinner portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JSpinner ttlField;
    private javax.swing.JLabel ttlLabel;
    // End of variables declaration//GEN-END:variables

}
