/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJPanel.java
 *
 * Created on 07.03.2011, 22:24:24
 */

package com.spam.mctool.view.main;

import com.spam.mctool.model.MulticastStream;
import com.spam.mctool.model.Sender;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Tobias
 */
public class StatusRenderer extends javax.swing.JPanel implements TableCellRenderer {

    /** Creates new form NewJPanel */
    public StatusRenderer() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 2));
        setLayout(new java.awt.BorderLayout(2, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spam/mctool/view/images/play_green.png"))); // NOI18N
        add(jLabel1, java.awt.BorderLayout.WEST);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spam/mctool/view/images/pause_orange.png"))); // NOI18N
        add(jLabel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        /*icon1 = new JLabel();
        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spam/mctool/view/images/play_green.png")));
        this.setLayout(new FlowLayout());
        this.add(icon1);*/
        if (isSelected) {
            this.setBackground(table.getSelectionBackground());
        } else {
            if (row % 2 == 0) {
                this.setBackground(table.getBackground());
            } else {
                this.setBackground(table.getGridColor());
            }
        }
        if(value instanceof MulticastStream) {
            MulticastStream s = (MulticastStream)value;
            jLabel1.setText("");
            if(s.isActive()) {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spam/mctool/view/images/play_green.png")));
                if(s.getMeasuredPacketRate() == 0) {
                //if(row % 2 == 0) {
                    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spam/mctool/view/images/pause_orange.png")));
                } else {
                    jLabel2.setIcon(null);
                }
            } else {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spam/mctool/view/images/stop_red.png")));
                jLabel2.setIcon(null);
            }
        } else {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spam/mctool/view/images/error.png")));
            jLabel2.setIcon(null);
        }
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
