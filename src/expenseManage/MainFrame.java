/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package expenseManage;

/**
 *
 * @author User-PC
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarButtons = new javax.swing.ButtonGroup();
        BarPanel = new javax.swing.JPanel();
        ExpenseButton = new javax.swing.JToggleButton();
        ExpenseButtonLabel = new javax.swing.JLabel();
        HomeButton = new javax.swing.JToggleButton();
        ListButton = new javax.swing.JToggleButton();
        HomeMainPanel = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        UserLabel = new javax.swing.JLabel();
        BalanceLabel = new javax.swing.JLabel();
        BalanceQuantity = new javax.swing.JLabel();
        BalancePanel = new javax.swing.JPanel();
        BalanceBar = new javax.swing.JProgressBar();
        BalanceBarPercentage = new javax.swing.JLabel();
        CalendarPanel = new javax.swing.JPanel();
        DateNumber = new javax.swing.JTextField();
        DayName = new javax.swing.JTextField();
        MonthName = new javax.swing.JTextField();
        BalanceBarSpent = new javax.swing.JLabel();
        BottomPanel = new javax.swing.JPanel();
        ListLabel = new javax.swing.JLabel();
        ListSeperator = new javax.swing.JSeparator();
        ListScrollPane = new javax.swing.JScrollPane();
        ListMainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 769));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarPanel.setBackground(new java.awt.Color(255, 255, 255));
        BarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExpenseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add 1.png"))); // NOI18N
        ExpenseButton.setBorderPainted(false);
        ExpenseButton.setContentAreaFilled(false);
        ExpenseButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-down-sign-to-navigate.png"))); // NOI18N
        BarPanel.add(ExpenseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 170, 70));

        ExpenseButtonLabel.setBackground(new java.awt.Color(255, 255, 255));
        ExpenseButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/file_optimized.png"))); // NOI18N
        BarPanel.add(ExpenseButtonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 170, 70));

        BarButtons.add(HomeButton);
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home.png"))); // NOI18N
        HomeButton.setSelected(true);
        HomeButton.setBorderPainted(false);
        HomeButton.setContentAreaFilled(false);
        HomeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-filled.png"))); // NOI18N
        HomeButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home.png"))); // NOI18N
        HomeButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-filled.png"))); // NOI18N
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });
        BarPanel.add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 50, 50));

        BarButtons.add(ListButton);
        ListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/menu-burger.png"))); // NOI18N
        ListButton.setBorderPainted(false);
        ListButton.setContentAreaFilled(false);
        ListButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/menu-burger -active.png"))); // NOI18N
        ListButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/menu-burger.png"))); // NOI18N
        ListButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/menu-burger -active.png"))); // NOI18N
        ListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListButtonActionPerformed(evt);
            }
        });
        BarPanel.add(ListButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 50, 50));

        getContentPane().add(BarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 450, 100));

        HomeMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        HomeMainPanel.setMaximumSize(new java.awt.Dimension(466, 769));
        HomeMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TopPanel.setBackground(new java.awt.Color(226, 255, 223));
        TopPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserLabel.setFont(new java.awt.Font("Albert Sans", 1, 24)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(51, 51, 51));
        UserLabel.setText("Hi, User1234");
        TopPanel.add(UserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 34, -1, -1));

        BalanceLabel.setFont(new java.awt.Font("Afacad Medium", 0, 18)); // NOI18N
        BalanceLabel.setForeground(new java.awt.Color(51, 51, 51));
        BalanceLabel.setText("Balance");
        TopPanel.add(BalanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        BalanceQuantity.setBackground(new java.awt.Color(0, 0, 0));
        BalanceQuantity.setFont(new java.awt.Font("Albert Sans", 1, 48)); // NOI18N
        BalanceQuantity.setText("P251.99");
        TopPanel.add(BalanceQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 111, -1, 43));

        BalancePanel.setBackground(new java.awt.Color(226, 255, 223));

        BalanceBar.setBackground(new java.awt.Color(255, 255, 255));
        BalanceBar.setToolTipText("");
        BalanceBar.setValue(30);
        BalanceBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 89, 35)));
        BalanceBar.setOpaque(true);

        BalanceBarPercentage.setFont(new java.awt.Font("Albert Sans", 1, 12)); // NOI18N
        BalanceBarPercentage.setForeground(new java.awt.Color(51, 51, 51));
        BalanceBarPercentage.setText("25%");

        javax.swing.GroupLayout BalancePanelLayout = new javax.swing.GroupLayout(BalancePanel);
        BalancePanel.setLayout(BalancePanelLayout);
        BalancePanelLayout.setHorizontalGroup(
            BalancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BalancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BalanceBarPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BalanceBar, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        );
        BalancePanelLayout.setVerticalGroup(
            BalancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BalancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BalancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BalanceBarPercentage, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(BalanceBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TopPanel.add(BalancePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 178, 417, -1));

        CalendarPanel.setBackground(new java.awt.Color(226, 255, 223));
        CalendarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DateNumber.setEditable(false);
        DateNumber.setBackground(new java.awt.Color(174, 253, 163));
        DateNumber.setFont(new java.awt.Font("Albert Sans", 1, 48)); // NOI18N
        DateNumber.setForeground(new java.awt.Color(28, 108, 30));
        DateNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DateNumber.setText("01");
        DateNumber.setFocusable(false);
        DateNumber.setMaximumSize(new java.awt.Dimension(104, 79));
        DateNumber.setMinimumSize(new java.awt.Dimension(104, 79));
        DateNumber.setPreferredSize(new java.awt.Dimension(104, 79));
        DateNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateNumberActionPerformed(evt);
            }
        });
        CalendarPanel.add(DateNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 100, 60));

        DayName.setEditable(false);
        DayName.setBackground(new java.awt.Color(0, 102, 0));
        DayName.setFont(new java.awt.Font("Afacad Medium", 0, 18)); // NOI18N
        DayName.setForeground(new java.awt.Color(255, 255, 255));
        DayName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DayName.setText("Tuesday");
        DayName.setFocusable(false);
        DayName.setMinimumSize(new java.awt.Dimension(104, 37));
        DayName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayNameActionPerformed(evt);
            }
        });
        CalendarPanel.add(DayName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 100, 30));

        MonthName.setEditable(false);
        MonthName.setBackground(new java.awt.Color(87, 184, 91));
        MonthName.setFont(new java.awt.Font("Afacad Medium", 0, 18)); // NOI18N
        MonthName.setForeground(new java.awt.Color(255, 255, 255));
        MonthName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MonthName.setText("January");
        MonthName.setFocusable(false);
        MonthName.setMaximumSize(new java.awt.Dimension(104, 37));
        MonthName.setMinimumSize(new java.awt.Dimension(104, 37));
        MonthName.setPreferredSize(new java.awt.Dimension(104, 37));
        MonthName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthNameActionPerformed(evt);
            }
        });
        CalendarPanel.add(MonthName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        TopPanel.add(CalendarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 28, 101, -1));

        BalanceBarSpent.setFont(new java.awt.Font("Albert Sans", 0, 18)); // NOI18N
        BalanceBarSpent.setForeground(new java.awt.Color(51, 51, 51));
        BalanceBarSpent.setText("P749.99");
        TopPanel.add(BalanceBarSpent, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        HomeMainPanel.add(TopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 260));

        BottomPanel.setBackground(new java.awt.Color(255, 255, 255));

        ListLabel.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N
        ListLabel.setText("Today's Expenses");

        ListScrollPane.setOpaque(false);

        javax.swing.GroupLayout BottomPanelLayout = new javax.swing.GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
            BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ListSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        BottomPanelLayout.setVerticalGroup(
            BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ListLabel)
                .addGap(5, 5, 5)
                .addComponent(ListSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(529, 529, 529))
        );

        HomeMainPanel.add(BottomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 450, 490));

        getContentPane().add(HomeMainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        ListMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        ListMainPanel.setMaximumSize(new java.awt.Dimension(466, 769));
        ListMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(ListMainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DateNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateNumberActionPerformed

    private void MonthNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthNameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_MonthNameActionPerformed

    private void DayNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayNameActionPerformed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        HomeMainPanel.setVisible(true);
        ListMainPanel.setVisible(false);
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void ListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListButtonActionPerformed
        HomeMainPanel.setVisible(false);
        ListMainPanel.setVisible(true);
    }//GEN-LAST:event_ListButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>
        com.formdev.flatlaf.FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BalanceBar;
    private javax.swing.JLabel BalanceBarPercentage;
    private javax.swing.JLabel BalanceBarSpent;
    private javax.swing.JLabel BalanceLabel;
    private javax.swing.JPanel BalancePanel;
    private javax.swing.JLabel BalanceQuantity;
    private javax.swing.ButtonGroup BarButtons;
    private javax.swing.JPanel BarPanel;
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel CalendarPanel;
    private javax.swing.JTextField DateNumber;
    private javax.swing.JTextField DayName;
    private javax.swing.JToggleButton ExpenseButton;
    private javax.swing.JLabel ExpenseButtonLabel;
    private javax.swing.JToggleButton HomeButton;
    private javax.swing.JPanel HomeMainPanel;
    private javax.swing.JToggleButton ListButton;
    private javax.swing.JLabel ListLabel;
    private javax.swing.JPanel ListMainPanel;
    private javax.swing.JScrollPane ListScrollPane;
    private javax.swing.JSeparator ListSeperator;
    private javax.swing.JTextField MonthName;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel UserLabel;
    // End of variables declaration//GEN-END:variables
}
