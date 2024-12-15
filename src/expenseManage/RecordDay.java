/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package expenseManage;

import java.awt.Color;
import java.util.ArrayList;


/**
 *
 * @author User-PC
 */
public class RecordDay extends javax.swing.JPanel {
    
    MainFrame mainframe;
    String date;
    String day;
    ArrayList<Record> records = new ArrayList<>();
    
    double balance = 0;
    double spent = 0;
    
    public RecordDay(MainFrame mainframe, String date, String day, ArrayList<Record> records) {
        this.mainframe = mainframe;
        this.date = date;
        this.day = day;
        this.records = records;
        Color positivedatecolor = new Color (89, 111, 75);
        Color positivequantitycolor = new Color (0, 132, 29);
        Color negativedatecolor = new Color (138, 98, 98);
        Color negativequantitycolor = new Color (232, 0, 0);
        Color positivepanel = new Color (160, 224, 160);
        Color negativepanel = new Color (225, 193, 193);
        
        for (Record record : records) {
            if (record.isIncome) {
                balance += record.amount;
            }
            else {
                spent += record.amount;
            }
        }
        
        double totalamount = balance - spent;
        
        initComponents();
        
        if (totalamount < 0) {
            ListItemPanel.setBackground(negativepanel);
            DateLabel.setForeground(negativedatecolor);
            TotalQuantity.setForeground(negativequantitycolor);
            TotalQuantity.setText(String.format("%.2f ₱", totalamount));
        }
        else {
            ListItemPanel.setBackground(positivepanel);
            DateLabel.setForeground(positivedatecolor);
            TotalQuantity.setForeground(positivequantitycolor);
            TotalQuantity.setText(String.format("%.2f ₱", totalamount));
        }
        
        DayLabel.setText(day);
        DateLabel.setText(date);
        
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
        RedirectDayButton = new javax.swing.JButton();
        ListItemPanel = new javax.swing.JPanel();
        DayLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TotalQuantity = new javax.swing.JLabel();

        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(434, 113));
        setMinimumSize(new java.awt.Dimension(434, 113));
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListItemContainer.setFocusable(false);
        ListItemContainer.setOpaque(false);
        ListItemContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RedirectDayButton.setBorderPainted(false);
        RedirectDayButton.setContentAreaFilled(false);
        RedirectDayButton.setFocusable(false);
        RedirectDayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedirectDayButtonActionPerformed(evt);
            }
        });
        ListItemContainer.add(RedirectDayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 13, 410, 80));

        ListItemPanel.setBackground(new java.awt.Color(153, 153, 153));
        ListItemPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DayLabel.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        DayLabel.setText("Placeholder blah");
        ListItemPanel.add(DayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 30));

        DateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DateLabel.setText("January 01, 2024");
        ListItemPanel.add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, 30));

        TotalQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotalQuantity.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TotalQuantity.setText("+100.00 P");
        TotalQuantity.setToolTipText("");
        ListItemPanel.add(TotalQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 50));

        ListItemContainer.add(ListItemPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 410, 90));

        add(ListItemContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 4, 430, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void RedirectDayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedirectDayButtonActionPerformed
        mainframe.SwitchtoHome();
        mainframe.SetTopPanelInfo(balance, spent);
        mainframe.ParseList(records);
    }//GEN-LAST:event_RedirectDayButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DayLabel;
    private javax.swing.JPanel ListItemContainer;
    private javax.swing.JPanel ListItemPanel;
    private javax.swing.JButton RedirectDayButton;
    private javax.swing.JLabel TotalQuantity;
    // End of variables declaration//GEN-END:variables
}
