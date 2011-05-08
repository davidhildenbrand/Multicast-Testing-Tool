/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TwoColorRenderer.java
 *
 * Created on 08.03.2011, 16:40:03
 */

package com.spam.mctool.view.main;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * A <code>TableCellRenderer</code> that renders the rows of a table with
 * alternating background colors. The renderer will display the according cell's
 * value's string representation.
 *
 * @author Tobias Stöckel
 */
public class TwoColorRenderer extends javax.swing.JPanel implements TableCellRenderer {

    /** Creates new form TwoColorRenderer */
    public TwoColorRenderer() {
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

        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Hello?");
        add(jLabel1, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            this.setBackground(table.getSelectionBackground());
            this.jLabel1.setForeground(table.getSelectionForeground());
        } else {
            this.jLabel1.setForeground(table.getForeground());
            if (row % 2 == 0) {
                this.setBackground(table.getBackground());
            } else {
                this.setBackground(table.getGridColor());
            }
        }
        if (value != null) {
            this.jLabel1.setText(value.toString());
        }
        else {
            this.jLabel1.setText("");
        }
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
