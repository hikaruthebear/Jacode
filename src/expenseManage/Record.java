/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package expenseManage;

import java.awt.Color;
import javax.swing.*;
/**
 *
 * @author hikaru
 */
public class Record extends javax.swing.JPanel {

    String name;
    String time;
    double amount;
    boolean isIncome;
    
    public Record (String name, String time, double quantity, boolean isIncome) {
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.isIncome = isIncome;
        Icon income = new ImageIcon("src/resources/income.png");
        Icon expense = new ImageIcon("src/resources/expense.png");
        Color incometimecolor = new Color (89, 111, 75);
        Color incomequantitycolor = new Color (0, 132, 29);
        Color expensetimecolor = new Color (138, 98, 98);
        Color expensequantitycolor = new Color (232, 0, 0);
        Color incomepanel = new Color (160, 224, 160);
        Color expensepanel = new Color (225, 193, 193);
        
        initComponents();
        
        if (isIncome == true) {
            ListItemPanel.setBackground(incomepanel);
            TypeIcon.setIcon(income);
            ItemTime.setForeground(incometimecolor);
            ItemQuantity.setForeground(incomequantitycolor);
            ItemQuantity.setText(String.format("+%.2f P", amount));
        }
        else {
            ListItemPanel.setBackground(expensepanel);
            TypeIcon.setIcon(expense);
            ItemTime.setForeground(expensetimecolor);
            ItemQuantity.setForeground(expensequantitycolor);
            ItemQuantity.setText(String.format("-%.2f P", amount));
        }
        
        ItemName.setText(name);
        ItemTime.setText(time);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ListItemContainer = new javax.swing.JPanel();
        ListItemPanel = new javax.swing.JPanel();
        TypeIcon = new javax.swing.JLabel();
        ItemName = new javax.swing.JLabel();
        ItemTime = new javax.swing.JLabel();
        ItemQuantity = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(438, 120));
        setMinimumSize(new java.awt.Dimension(438, 120));
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListItemContainer.setOpaque(false);
        ListItemContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListItemPanel.setBackground(new java.awt.Color(153, 153, 153));
        ListItemPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TypeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/expense.png"))); // NOI18N
        ListItemPanel.add(TypeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 70));

        ItemName.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        ItemName.setText("Placeholder blah");
        ListItemPanel.add(ItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 230, 30));

        ItemTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ItemTime.setText("12:00 am");
        ListItemPanel.add(ItemTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 80, 30));

        ItemQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ItemQuantity.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ItemQuantity.setText("+100.00 P");
        ItemQuantity.setToolTipText("");
        ListItemPanel.add(ItemQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 50));

        ListItemContainer.add(ListItemPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 410, 90));

        add(ListItemContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 4, 430, 100));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ItemName;
    private javax.swing.JLabel ItemQuantity;
    private javax.swing.JLabel ItemTime;
    private javax.swing.JPanel ListItemContainer;
    private javax.swing.JPanel ListItemPanel;
    private javax.swing.JLabel TypeIcon;
    // End of variables declaration//GEN-END:variables
}
