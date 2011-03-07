/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditReceiverDialog.java
 *
 * Created on Mar 3, 2011, 7:47:08 PM
 */

package com.spam.mctool.view.dialogs;

import com.spam.mctool.model.Receiver;

/**
 *
 * @author Tobias Stöckel (Tobias.Stoeckel@de.ibm.com)
 */
public class EditReceiverDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private Receiver receiver;
    private int test;

	/** Creates new form EditReceiverDialog */
    public EditReceiverDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public EditReceiverDialog(java.awt.Frame parent, boolean modal, Receiver receiver) {
        this(parent, modal);
        this.receiver = receiver;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditReceiverDialog dialog = new EditReceiverDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
