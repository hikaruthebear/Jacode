/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package expenseManage;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User-PC
 */
public class MainFrame extends javax.swing.JFrame {

    ArrayList<Record> current = new ArrayList<>();
    boolean currenttype;

    public MainFrame() {

        initComponents();

        SwitchtoHome();
        //pwede tanggalin to tinest ko lang
        //String name, String time, double amount, boolean isIncome (if income yes, if expense false)
        ArrayList<Record> record1 = new ArrayList<>();
        record1.add(new Record("Grocery Shopping", "11:24 AM", 45.67, false));
        record1.add(new Record("Salary Deposit", "9:00 AM", 1500.00, true));
        record1.add(new Record("Gym Membership Payment", "7:45 PM", 25.00, false));
        record1.add(new Record("Gift Received", "3:15 PM", 100.00, true));
        record1.add(new Record("Utility Bill Payment", "5:30 PM", 78.90, false));
        RecordDay test = new RecordDay(this, "January 01, 2024", "Tuesday", record1);
        ArrayList<Record> record2 = new ArrayList<>();
        record2.add(new Record("Grocery Shopping", "11:24 AM", 45.67, false));
        record2.add(new Record("Salary Deposit", "9:00 AM", 50.00, true));
        record2.add(new Record("Gym Membership Payment", "7:45 PM", 25.00, false));
        record2.add(new Record("Gift Received", "3:15 PM", 50.00, true));
        record2.add(new Record("Utility Bill Payment", "5:30 PM", 78.90, false));
        RecordDay test1 = new RecordDay(this, "January 01, 2024", "Tuesday", record2);
        DayList.add(test);
        DayList.add(test1);

        //<--->
    }

    public void SwitchtoHome() {
        Icon plus = new ImageIcon("src/resources/add 1.png");

        HomeMainPanel.setVisible(true);
        ListMainPanel.setVisible(false);
        HomeButton.setSelected(true);
        ListButton.setSelected(false);
        ExpenseButton.setSelected(false);
        PopUpPanel.setVisible(false);
        ExpenseButton.setIcon(plus);
        ItemPanel.setVisible(false);
        HomeListContainer.setWheelScrollingEnabled(true);
        SetTopPanelInfo(current);
    }

    public void SwitchtoList() {
        Icon backarrow = new ImageIcon("src/resources/left-arrow 1.png");
        HomeMainPanel.setVisible(false);
        ListMainPanel.setVisible(true);
        HomeButton.setSelected(false);
        ListButton.setSelected(true);
        ExpenseButton.setSelected(false);
        PopUpPanel.setVisible(false);
        ExpenseButton.setIcon(backarrow);
        ItemPanel.setVisible(false);
    }

    public void SetTopPanelInfo(ArrayList<Record> records) { //may date pa to and SHIT!!!!!!!!!
        double balance = 0;
        double spent = 0;
        for (Record record : records) {
            if (record.isIncome) {
                balance += record.amount;
            } else {
                spent += record.amount;
            }
        }
        if (balance - spent < 0) {
            BalanceQuantity.setText(String.format("₱%.2f !!", balance - spent));
            BalanceBar.setValue(0);
            BalanceBarPercentage.setText("0%");
            BalanceBarSpent.setText(String.format("₱%.2f", spent));
        } else {
            BalanceQuantity.setText(String.format("₱%.2f", balance - spent));
            int tempvalue = (int) (((double) (balance - spent) / balance) * 100);
            BalanceBar.setValue(tempvalue);
            BalanceBarPercentage.setText(String.format("%d%%", tempvalue));
            BalanceBarSpent.setText(String.format("₱%.2f", spent));
        }
    }

    public void ParseList(ArrayList<Record> records) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        records.sort((now, next) -> {

            LocalTime nowtime = LocalTime.parse(now.time.toUpperCase(), formatter); //string to time houdini magic
            LocalTime nexttime = LocalTime.parse(next.time.toUpperCase(), formatter);

            boolean nowpm = now.time.contains("PM"); //kung pm ini
            boolean nextpm = next.time.contains("PM");

            if (nowpm && !nextpm) { // pm to am so now muna
                return -1;
            } else if (!nowpm && nextpm) {// am to pm so next muna
                return 1;
            } else {
                return nexttime.compareTo(nowtime); // ie kung 5 next, 3 now, return positive tas switch para 3, 5 (asc. order)
            }
        });

        HomeList.removeAll();
        for (Record record : records) {
            HomeList.add(record);
        }
        current = records;
    }

    public void ItemChecks() {
        NameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                NameLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (NameField.getText().trim().isEmpty()) {
                    NameLabel.setVisible(true);
                }
            }
        });
        NameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ValidateInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ValidateInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                ValidateInput();
            }
        });
        TimeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                TimeLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TimeField.getText().trim().isEmpty()) {
                    TimeLabel.setVisible(true);
                }
            }
        });
        TimeField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ValidateInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ValidateInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                ValidateInput();
            }
        });
        AmountField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Hide the label when the field gains focus
                AmountLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (AmountField.getText().trim().isEmpty()) {
                    AmountLabel.setVisible(true);
                }
            }
        });
        AmountField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ValidateInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ValidateInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                ValidateInput();
            }
        });
    }

    public void ValidateInput() {
        String amount = AmountField.getText();
        String name = NameField.getText();
        String time = TimeField.getText();
        String amountstruct = "^\\d*\\.?\\d+$";
        /*
        ^= Anchors the regex to the start of the string.
        \\d* = Matches zero or more digits (\\d is shorthand for [0-9]).
              The * quantifier means zero or more occurrences.
              This part ensures that the input can start with any number of digits (including none).
        \\.? = Matches an optional decimal point (\\. matches a literal period .):
               The ? quantifier means zero or one occurrence.
               This part allows for a decimal point but doesn't require it.
        \\d+ = Matches one or more digits.
               The + quantifier ensures that at least one digit follows the decimal point (if it exists).
        $ = Anchors to the end of the string.
        */
        String timestruct = "^([1-9]|1[0-2]):([0-5][0-9])\s[APap][Mm]$";
        /*
        ^ = Anchors the regex to the start of the string.
        ([1-9]|1[0-2]) = Matches the hour part:
        [1-9] = Matches single-digit hours (1-9).
        1[0-2] = Matches two-digit hours (10-12).
        : = Matches the colon separating the hour and minutes.
        ([0-5][0-9]) = Matches the minutes part, ensuring it's between 00 and 59.
        [0-5] = The first digit (0-5).
        [0-9] = The second digit (0-9).
        \s? = Optionally matches a space between the minutes and the AM/PM part.
        [APap][Mm] = Matches "AM" or "PM", case-insensitive.
        [APap] = Matches either 'A' or 'P', case-insensitive.
        [Mm] = Matches 'M', case-insensitive.
        $ = Anchors to the end of the string.
        */
        if (amount.matches(amountstruct) && time.matches(timestruct) && !name.isEmpty() && !time.isEmpty()) {
            ConfirmButton.setEnabled(true);
        } else {
            ConfirmButton.setEnabled(false);
        }
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
        ItemPanel = new javax.swing.JPanel();
        NameLabel = new javax.swing.JLabel();
        AmountLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        AmountField = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();
        TimeLabel = new javax.swing.JLabel();
        TimeField = new javax.swing.JTextField();
        PopUpPanel = new javax.swing.JPanel();
        AddIncomeButton = new javax.swing.JButton();
        AddExpenseButton = new javax.swing.JButton();
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
        HomeListContainer = new javax.swing.JScrollPane();
        HomeList = new javax.swing.JPanel();
        ListMainPanel = new javax.swing.JPanel();
        ListLabel1 = new javax.swing.JLabel();
        ListDayContainer = new javax.swing.JScrollPane();
        DayList = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 769));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ItemPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NameLabel.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(153, 153, 153));
        NameLabel.setText("Name of Expense");
        ItemPanel.add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 410, 30));

        AmountLabel.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        AmountLabel.setForeground(new java.awt.Color(153, 153, 153));
        AmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        AmountLabel.setText("Amount");
        ItemPanel.add(AmountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 130, 50));

        NameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });
        ItemPanel.add(NameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 420, 50));

        AmountField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AmountField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        ItemPanel.add(AmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, 50));

        ConfirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Plus.png"))); // NOI18N
        ConfirmButton.setEnabled(false);
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });
        ItemPanel.add(ConfirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 80, 50));

        TimeLabel.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(153, 153, 153));
        TimeLabel.setText("Time");
        ItemPanel.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 50));

        TimeField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ItemPanel.add(TimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 50));

        getContentPane().add(ItemPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 450, 180));

        PopUpPanel.setMaximumSize(new java.awt.Dimension(100, 100));
        PopUpPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        PopUpPanel.setOpaque(false);

        AddIncomeButton.setBackground(new java.awt.Color(106, 217, 106));
        AddIncomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image.png"))); // NOI18N
        AddIncomeButton.setBorderPainted(false);
        AddIncomeButton.setFocusable(false);
        AddIncomeButton.setOpaque(true);
        AddIncomeButton.setRolloverEnabled(false);
        AddIncomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddIncomeButtonActionPerformed(evt);
            }
        });

        AddExpenseButton.setBackground(new java.awt.Color(248, 149, 149));
        AddExpenseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image 1.png"))); // NOI18N
        AddExpenseButton.setBorderPainted(false);
        AddExpenseButton.setFocusable(false);
        AddExpenseButton.setOpaque(true);
        AddExpenseButton.setRolloverEnabled(false);
        AddExpenseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddExpenseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PopUpPanelLayout = new javax.swing.GroupLayout(PopUpPanel);
        PopUpPanel.setLayout(PopUpPanelLayout);
        PopUpPanelLayout.setHorizontalGroup(
            PopUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddExpenseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PopUpPanelLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(AddIncomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PopUpPanelLayout.setVerticalGroup(
            PopUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PopUpPanelLayout.createSequentialGroup()
                .addComponent(AddIncomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddExpenseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        getContentPane().add(PopUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, 100, 100));

        BarPanel.setBackground(new java.awt.Color(255, 255, 255));
        BarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExpenseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add 1.png"))); // NOI18N
        ExpenseButton.setBorderPainted(false);
        ExpenseButton.setContentAreaFilled(false);
        ExpenseButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-down-sign-to-navigate.png"))); // NOI18N
        ExpenseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpenseButtonActionPerformed(evt);
            }
        });
        BarPanel.add(ExpenseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 170, 70));

        ExpenseButtonLabel.setBackground(new java.awt.Color(255, 255, 255));
        ExpenseButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/file_optimized.png"))); // NOI18N
        BarPanel.add(ExpenseButtonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 170, 70));

        BarButtons.add(HomeButton);
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home.png"))); // NOI18N
        HomeButton.setSelected(true);
        HomeButton.setBorderPainted(false);
        HomeButton.setContentAreaFilled(false);
        HomeButton.setRolloverEnabled(false);
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
        ListButton.setRolloverEnabled(false);
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

        HomeListContainer.setBorder(null);
        HomeListContainer.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        HomeListContainer.setOpaque(false);

        HomeList.setBackground(new java.awt.Color(255, 255, 255));
        HomeList.setForeground(new java.awt.Color(255, 255, 255));
        HomeList.setLayout(new javax.swing.BoxLayout(HomeList, javax.swing.BoxLayout.Y_AXIS));
        HomeListContainer.setViewportView(HomeList);

        javax.swing.GroupLayout BottomPanelLayout = new javax.swing.GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
            BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ListSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeListContainer)
                .addContainerGap())
        );
        BottomPanelLayout.setVerticalGroup(
            BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ListLabel)
                .addGap(5, 5, 5)
                .addComponent(ListSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HomeListContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HomeMainPanel.add(BottomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 450, 490));

        getContentPane().add(HomeMainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        ListMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        ListMainPanel.setMaximumSize(new java.awt.Dimension(466, 769));
        ListMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListLabel1.setFont(new java.awt.Font("Afacad", 1, 26)); // NOI18N
        ListLabel1.setText("Daily Expenses");
        ListMainPanel.add(ListLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        ListDayContainer.setBorder(null);
        ListDayContainer.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ListDayContainer.setOpaque(false);

        DayList.setBackground(new java.awt.Color(255, 255, 255));
        DayList.setForeground(new java.awt.Color(255, 255, 255));
        DayList.setLayout(new javax.swing.BoxLayout(DayList, javax.swing.BoxLayout.Y_AXIS));
        ListDayContainer.setViewportView(DayList);

        ListMainPanel.add(ListDayContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 450, 660));

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
        SwitchtoHome();
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void ListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListButtonActionPerformed
        SwitchtoList();
    }//GEN-LAST:event_ListButtonActionPerformed

    private void AddIncomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddIncomeButtonActionPerformed
        NameLabel.setText("Name of Income");
        Color income = new Color(131, 255, 158);
        ItemPanel.setBackground(income);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime currenttime = LocalTime.now();
        TimeField.setText(currenttime.format(formatter));
        TimeLabel.setVisible(false);
        ItemPanel.setVisible(true);
        HomeListContainer.setWheelScrollingEnabled(false);
        currenttype = true;
        PopUpPanel.setVisible(false);
        ItemChecks();
    }//GEN-LAST:event_AddIncomeButtonActionPerformed

    private void ExpenseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpenseButtonActionPerformed
        HomeListContainer.setWheelScrollingEnabled(false);
        if (HomeMainPanel.isShowing()) {
            if (ExpenseButton.isSelected()) {
                PopUpPanel.setVisible(true);
            } else {
                PopUpPanel.setVisible(false);
                ItemPanel.setVisible(false);
                HomeListContainer.setWheelScrollingEnabled(true);
            }
        } else {
            SwitchtoHome();
        }
    }//GEN-LAST:event_ExpenseButtonActionPerformed

    private void AddExpenseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddExpenseButtonActionPerformed
        NameLabel.setText("Name of Expense");
        Color expense = new Color(255, 131, 131);
        ItemPanel.setBackground(expense);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime currenttime = LocalTime.now();
        TimeField.setText(currenttime.format(formatter));
        TimeLabel.setVisible(false);
        ItemPanel.setVisible(true);
        HomeListContainer.setWheelScrollingEnabled(false);
        currenttype = false;
        PopUpPanel.setVisible(false);
        ItemChecks();
    }//GEN-LAST:event_AddExpenseButtonActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed

    }//GEN-LAST:event_NameFieldActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        String name = NameField.getText();
        String time = TimeField.getText().toUpperCase();
        double amount = Double.parseDouble(AmountField.getText());
        boolean type = currenttype;

        current.add(new Record(name, time, amount, type));

        NameField.setText("");
        TimeField.setText("");
        AmountField.setText("");
        ParseList(current);
        SetTopPanelInfo(current);
        SwitchtoHome();
    }//GEN-LAST:event_ConfirmButtonActionPerformed

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
    private javax.swing.JButton AddExpenseButton;
    private javax.swing.JButton AddIncomeButton;
    private javax.swing.JTextField AmountField;
    private javax.swing.JLabel AmountLabel;
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
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JTextField DateNumber;
    private javax.swing.JPanel DayList;
    private javax.swing.JTextField DayName;
    private javax.swing.JToggleButton ExpenseButton;
    private javax.swing.JLabel ExpenseButtonLabel;
    private javax.swing.JToggleButton HomeButton;
    private javax.swing.JPanel HomeList;
    private javax.swing.JScrollPane HomeListContainer;
    private javax.swing.JPanel HomeMainPanel;
    private javax.swing.JPanel ItemPanel;
    private javax.swing.JToggleButton ListButton;
    private javax.swing.JScrollPane ListDayContainer;
    private javax.swing.JLabel ListLabel;
    private javax.swing.JLabel ListLabel1;
    private javax.swing.JPanel ListMainPanel;
    private javax.swing.JSeparator ListSeperator;
    private javax.swing.JTextField MonthName;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JPanel PopUpPanel;
    private javax.swing.JTextField TimeField;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel UserLabel;
    // End of variables declaration//GEN-END:variables
}
