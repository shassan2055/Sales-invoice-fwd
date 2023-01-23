package view;

/**
 *
 * @author Thomas Samir
 */
import java.awt.Component;
import java.awt.Font;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.accessibility.AccessibleContext;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellEditor;

public class View extends javax.swing.JFrame {

    javax.swing.JFileChooser openFile;
    javax.swing.JOptionPane jOptionPaneMessage;
    private SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");

    public View() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Clasic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        disableAllButtons();
        /*After Review*/
        openFile = new JFileChooser();
        jOptionPaneMessage = new JOptionPane();
        CustomerNameTextField.setName("CustomerNameTextField");
        InvoiceDateTextField.setName("InvoiceDateTextField");
        InvoicesLineTable.setName("InvoicesLineTable");
        InvoiceTable.setName("InvoiceTable");
        
  
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CreateNewInvoiceDialog = new javax.swing.JDialog();
        NewCustomerName = new javax.swing.JTextField();
        NewCustomerNameLabel = new javax.swing.JLabel();
        NewInvoiceDateField = new javax.swing.JTextField();
        NewInvoiceDateLabel = new javax.swing.JLabel();
        CreateNewInvoiceOK = new javax.swing.JButton();
        CreateNewInvoiceCancel = new javax.swing.JButton();
        AddItemDialog = new javax.swing.JDialog();
        NewItemName = new javax.swing.JTextField();
        NewItemNameLabel = new javax.swing.JLabel();
        NewItemPriceLabel = new javax.swing.JLabel();
        AddItemDialogOK = new javax.swing.JButton();
        AddItemDialogCancel = new javax.swing.JButton();
        NewItemPrice = new javax.swing.JTextField();
        NewItemPriceSpinner = new javax.swing.JSpinner();
        NewItemCountLabel = new javax.swing.JLabel();
        LeftSidePanel = new javax.swing.JPanel();
        InvoicesTableLabel = new javax.swing.JLabel();
        CreateNewInvoiceButton = new javax.swing.JButton();
        DeleteInvoiceButton = new javax.swing.JButton();
        InvoiceTableScrollPane = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        RightSidePanel = new javax.swing.JPanel();
        InvoiceNumberStaticLabel = new javax.swing.JLabel();
        InvoiceNumberLabel = new javax.swing.JLabel();
        InvoiceDateLabel = new javax.swing.JLabel();
        CustomerNameLabel = new javax.swing.JLabel();
        InvoiceTotalStaticLabel = new javax.swing.JLabel();
        InvoicesItemsLabel = new javax.swing.JLabel();
        InvoiceDateTextField = new javax.swing.JTextField();
        CustomerNameTextField = new javax.swing.JTextField();
        InvoiceTotalLabel = new javax.swing.JLabel();
        InvoicesLineTableScrollPane = new javax.swing.JScrollPane();
        InvoicesLineTable = new javax.swing.JTable();
        DeleteItemButton = new javax.swing.JButton();
        AddItemButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        LoadFile = new javax.swing.JMenuItem();
        SaveFile = new javax.swing.JMenuItem();

        CreateNewInvoiceDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        CreateNewInvoiceDialog.setTitle("Create New Invoice");
        CreateNewInvoiceDialog.setBounds(new java.awt.Rectangle(100, 100, 100, 100));
        CreateNewInvoiceDialog.setMinimumSize(new java.awt.Dimension(400, 200));
        CreateNewInvoiceDialog.setModal(true);
        CreateNewInvoiceDialog.setSize(new java.awt.Dimension(100, 100));
        //Point p=LeftSidePanel.getLocationOnScreen();
        //CreatNewInvoiceDialog.setLocation(p.x+10,p.y+10);
        //CreatNewInvoiceDialog.setLocationRelativeTo(InvoiceTable);

        NewCustomerNameLabel.setText("Customer Name:");

        NewInvoiceDateField.setEditable(false);

        NewInvoiceDateLabel.setText("Invoice Date:");

        CreateNewInvoiceOK.setText("OK");

        CreateNewInvoiceCancel.setText("Cancel");

        javax.swing.GroupLayout CreateNewInvoiceDialogLayout = new javax.swing.GroupLayout(CreateNewInvoiceDialog.getContentPane());
        CreateNewInvoiceDialog.getContentPane().setLayout(CreateNewInvoiceDialogLayout);
        CreateNewInvoiceDialogLayout.setHorizontalGroup(
            CreateNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateNewInvoiceDialogLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(CreateNewInvoiceOK, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(CreateNewInvoiceCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateNewInvoiceDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CreateNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewCustomerNameLabel)
                    .addComponent(NewInvoiceDateLabel))
                .addGap(35, 35, 35)
                .addGroup(CreateNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NewInvoiceDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(NewCustomerName))
                .addGap(45, 45, 45))
        );
        CreateNewInvoiceDialogLayout.setVerticalGroup(
            CreateNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateNewInvoiceDialogLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(CreateNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewCustomerNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CreateNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewInvoiceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewInvoiceDateLabel))
                .addGap(26, 26, 26)
                .addGroup(CreateNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateNewInvoiceOK)
                    .addComponent(CreateNewInvoiceCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InvoicesTableLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceNumberStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));
        CreateNewInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));
        DeleteInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));

        AddItemDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        AddItemDialog.setTitle("Add New Item To Invoice Number ");
        AddItemDialog.setAlwaysOnTop(false);
        AddItemDialog.setBounds(new java.awt.Rectangle(100, 100, 100, 100));
        AddItemDialog.setLocation(new java.awt.Point(600, 250));
        AddItemDialog.setMinimumSize(new java.awt.Dimension(400, 200));
        AddItemDialog.setModal(true);
        AddItemDialog.setSize(new java.awt.Dimension(100, 100));

        NewItemNameLabel.setText("Item Name:");

        NewItemPriceLabel.setText("Item Price:");

        AddItemDialogOK.setText("OK");

        AddItemDialogCancel.setText("Cancel");

        NewItemPriceSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        NewItemCountLabel.setText("Item Count:");

        javax.swing.GroupLayout AddItemDialogLayout = new javax.swing.GroupLayout(AddItemDialog.getContentPane());
        AddItemDialog.getContentPane().setLayout(AddItemDialogLayout);
        AddItemDialogLayout.setHorizontalGroup(
            AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemDialogLayout.createSequentialGroup()
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddItemDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewItemNameLabel)
                            .addComponent(NewItemPriceLabel)
                            .addComponent(NewItemCountLabel))
                        .addGap(35, 35, 35)
                        .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewItemName)
                            .addComponent(NewItemPrice)
                            .addGroup(AddItemDialogLayout.createSequentialGroup()
                                .addComponent(NewItemPriceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
                                .addGap(71, 71, 71))))
                    .addGroup(AddItemDialogLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(AddItemDialogOK, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(AddItemDialogCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        AddItemDialogLayout.setVerticalGroup(
            AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemDialogLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewItemNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewItemPriceLabel)
                    .addComponent(NewItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewItemCountLabel)
                    .addComponent(NewItemPriceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddItemDialogOK)
                    .addComponent(AddItemDialogCancel))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        InvoicesTableLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceNumberStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));
        CreateNewInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));
        DeleteInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));
        NewItemPrice.setTransferHandler(null);
        ((JSpinner.DefaultEditor) NewItemPriceSpinner.getEditor()).getTextField().setEditable(false);
        InvoiceNumberStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1200, 0));

        InvoicesTableLabel.setText("Invoices Table");
        InvoicesTableLabel.setToolTipText("");

        CreateNewInvoiceButton.setText("Create New Invoice");
        CreateNewInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewInvoiceButtonActionPerformed(evt);
            }
        });

        DeleteInvoiceButton.setText("Delete Invoice");

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ));
        InvoiceTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        InvoiceTableScrollPane.setViewportView(InvoiceTable);
        if (InvoiceTable.getColumnModel().getColumnCount() > 0) {
            InvoiceTable.getColumnModel().getColumn(0).setResizable(false);
        }
        InvoiceTable.getAccessibleContext().setAccessibleName("InvoiceTable");

        javax.swing.GroupLayout LeftSidePanelLayout = new javax.swing.GroupLayout(LeftSidePanel);
        LeftSidePanel.setLayout(LeftSidePanelLayout);
        LeftSidePanelLayout.setHorizontalGroup(
            LeftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftSidePanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(CreateNewInvoiceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteInvoiceButton)
                .addGap(79, 79, 79))
            .addGroup(LeftSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InvoicesTableLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(InvoiceTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LeftSidePanelLayout.setVerticalGroup(
            LeftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftSidePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(InvoicesTableLabel)
                .addGroup(LeftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftSidePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(InvoiceTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftSidePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LeftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteInvoiceButton)
                            .addComponent(CreateNewInvoiceButton))
                        .addGap(24, 24, 24)))
                .addGap(3, 3, 3))
        );

        InvoicesTableLabel.setFont(new Font("Arial", Font.BOLD, 12));
        CreateNewInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));
        DeleteInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));

        RightSidePanel.setPreferredSize(new java.awt.Dimension(521, 472));

        InvoiceNumberStaticLabel.setText("Invoice Number");

        InvoiceDateLabel.setText("Invoice Date");

        CustomerNameLabel.setText("Customer Name");

        InvoiceTotalStaticLabel.setText("Invoice Total");

        InvoicesItemsLabel.setText("Invoice Items");

        InvoiceDateTextField.setEditable(false);

        CustomerNameTextField.setEditable(false);

        InvoicesLineTableScrollPane.setMinimumSize(new java.awt.Dimension(100, 100));

        InvoicesLineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ));
        InvoicesLineTable.setFocusTraversalPolicyProvider(true);
        InvoicesLineTable.setMinimumSize(new java.awt.Dimension(100, 100));
        InvoicesLineTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        InvoicesLineTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        InvoicesLineTableScrollPane.setViewportView(InvoicesLineTable);
        InvoicesLineTable.getAccessibleContext().setAccessibleName("");

        DeleteItemButton.setText("Delete Item");

        AddItemButton.setText("Add Item");

        CancelButton.setText("Cancel");
        CancelButton.setEnabled(false);
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightSidePanelLayout = new javax.swing.GroupLayout(RightSidePanel);
        RightSidePanel.setLayout(RightSidePanelLayout);
        RightSidePanelLayout.setHorizontalGroup(
            RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightSidePanelLayout.createSequentialGroup()
                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightSidePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InvoicesLineTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InvoicesItemsLabel)
                            .addGroup(RightSidePanelLayout.createSequentialGroup()
                                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InvoiceNumberStaticLabel)
                                    .addComponent(InvoiceDateLabel)
                                    .addComponent(CustomerNameLabel)
                                    .addComponent(InvoiceTotalStaticLabel))
                                .addGap(63, 63, 63)
                                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InvoiceDateTextField)
                                    .addComponent(CustomerNameTextField)
                                    .addGroup(RightSidePanelLayout.createSequentialGroup()
                                        .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(InvoiceNumberLabel)
                                            .addComponent(InvoiceTotalLabel))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(164, 164, 164))))
                    .addGroup(RightSidePanelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(AddItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(DeleteItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(113, 113, 113)))
                .addContainerGap())
        );
        RightSidePanelLayout.setVerticalGroup(
            RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InvoiceNumberStaticLabel)
                    .addComponent(InvoiceNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InvoiceDateLabel)
                    .addComponent(InvoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerNameLabel)
                    .addComponent(CustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InvoiceTotalStaticLabel)
                    .addComponent(InvoiceTotalLabel))
                .addGap(18, 18, 18)
                .addComponent(InvoicesItemsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InvoicesLineTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );

        InvoiceNumberStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceNumberLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceDateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        CustomerNameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceTotalStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoicesItemsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceDateTextField.setFont(new Font("Arial", Font.BOLD, 12));
        CustomerNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceTotalLabel.setFont(new Font("Arial", Font.BOLD, 12));
        DeleteItemButton.setFont(new Font("Arial", Font.BOLD, 12));
        AddItemButton.setFont(new Font("Arial", Font.BOLD, 12));
        CancelButton.setFont(new Font("Arial", Font.BOLD, 12));

        FileMenu.setText("File");

        LoadFile.setText("Load File");
        LoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileActionPerformed(evt);
            }
        });
        FileMenu.add(LoadFile);

        SaveFile.setText("Save File");
        SaveFile.setEnabled(false);
        FileMenu.add(SaveFile);

        MenuBar.add(FileMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(RightSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addComponent(LeftSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RightSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
            .addComponent(LeftSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoadFileActionPerformed

    private void CreateNewInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateNewInvoiceButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelButtonActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemButton;
    private static javax.swing.JDialog AddItemDialog;
    private javax.swing.JButton AddItemDialogCancel;
    public javax.swing.JButton AddItemDialogOK;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateNewInvoiceButton;
    private javax.swing.JButton CreateNewInvoiceCancel;
    private static javax.swing.JDialog CreateNewInvoiceDialog;
    public javax.swing.JButton CreateNewInvoiceOK;
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JTextField CustomerNameTextField;
    private javax.swing.JButton DeleteInvoiceButton;
    private javax.swing.JButton DeleteItemButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel InvoiceDateLabel;
    private javax.swing.JTextField InvoiceDateTextField;
    private javax.swing.JLabel InvoiceNumberLabel;
    private javax.swing.JLabel InvoiceNumberStaticLabel;
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JScrollPane InvoiceTableScrollPane;
    private javax.swing.JLabel InvoiceTotalLabel;
    private javax.swing.JLabel InvoiceTotalStaticLabel;
    private javax.swing.JLabel InvoicesItemsLabel;
    private javax.swing.JTable InvoicesLineTable;
    private javax.swing.JScrollPane InvoicesLineTableScrollPane;
    private javax.swing.JLabel InvoicesTableLabel;
    private javax.swing.JPanel LeftSidePanel;
    private javax.swing.JMenuItem LoadFile;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JTextField NewCustomerName;
    private javax.swing.JLabel NewCustomerNameLabel;
    private javax.swing.JTextField NewInvoiceDateField;
    private javax.swing.JLabel NewInvoiceDateLabel;
    private javax.swing.JLabel NewItemCountLabel;
    private javax.swing.JTextField NewItemName;
    private javax.swing.JLabel NewItemNameLabel;
    private javax.swing.JTextField NewItemPrice;
    private javax.swing.JLabel NewItemPriceLabel;
    private javax.swing.JSpinner NewItemPriceSpinner;
    private javax.swing.JPanel RightSidePanel;
    private javax.swing.JMenuItem SaveFile;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getLoadFile() {
        return LoadFile;
    }

    public JMenu getFileMenu() {
        return FileMenu;
    }

    public JTable getInvoiceTable() {
        return InvoiceTable;
    }

    public JTable getInvoicesLineTable() {
        return InvoicesLineTable;
    }

    public JButton getAddItemButton() {
        return AddItemButton;
    }

    public JButton getCancelButton() {
        return CancelButton;
    }

    public JTextField getCustomerNameTextField() {
        return CustomerNameTextField;
    }

    public JButton getDeleteItemButton() {
        return DeleteItemButton;
    }

    public JTextField getInvoiceDateTextField() {
        return InvoiceDateTextField;
    }

    public JLabel getInvoiceTotalLabel() {
        return InvoiceTotalLabel;
    }

    public JMenuItem getSaveFile() {
        return SaveFile;
    }

    public JButton getCreateNewInvoiceButton() {
        return CreateNewInvoiceButton;
    }

    public JButton getDeleteInvoiceButton() {
        return DeleteInvoiceButton;
    }

    public JLabel getInvoiceNumberLabel() {
        return InvoiceNumberLabel;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public JPanel getRightSidePanel() {
        return RightSidePanel;
    }

    public JPanel getLeftSidePanel() {
        return LeftSidePanel;
    }

    public JFileChooser getOpenFileJFileChooser() {
        return openFile;
    }

    public JRootPane getRootPane() {
        return rootPane;
    }

    public JTextField getNewInvoiceDateField() {
        return NewInvoiceDateField;
    }

    public static JDialog getCreateNewInvoiceDialog() {
        return CreateNewInvoiceDialog;
    }

    public static JDialog getAddItemDialog() {
        return AddItemDialog;
    }

    public JButton getAddItemDialogCancel() {
        return AddItemDialogCancel;
    }

    public JButton getCreateNewInvoiceOK() {
        return CreateNewInvoiceOK;
    }

    public JTextField getNewCustomerName() {
        return NewCustomerName;
    }

    public JButton getCreateNewInvoiceCancel() {
        return CreateNewInvoiceCancel;
    }

    public JButton getAddItemDialogOK() {
        return AddItemDialogOK;
    }

    public JSpinner getNewItemPriceSpinner() {
        return NewItemPriceSpinner;
    }

    public JTextField getNewItemName() {
        return NewItemName;
    }

    public JTextField getNewItemPrice() {
        return NewItemPrice;
    }

    public JScrollPane getJScrollPane2() {
        return InvoicesLineTableScrollPane;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setJOptionPaneMessageMessage(Component component, String message, String title, String messageType) {
        int messageTypeInteger = 0;
        switch (messageType) {
            case "ERROR_MESSAGE":
                messageTypeInteger = 0;
                break;
            case "QUESTION_MESSAGE":
                messageTypeInteger = 3;
                break;
            case "WARNING_MESSAGE":
                messageTypeInteger = 2;
                break;
            case "INFORMATION_MESSAGE":
                messageTypeInteger = 1;
                break;
        }
        jOptionPaneMessage.showMessageDialog(component, message, title, messageTypeInteger);
    }

    public int showYesNoCancelDialog(Component component, String message, String title) {
        Object[] yesNoCancel = {"Yes", "No", "Cancel"};
        return JOptionPane.showOptionDialog(component, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, yesNoCancel, yesNoCancel[0]);
    }

    public int showSaveDontSaveCancelDialog(Component component, String message, String title) {
        Object[] saveDontSaveCancel = {"Save", "Don't Save", "Cancel"};
        return JOptionPane.showOptionDialog(component, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, saveDontSaveCancel, saveDontSaveCancel[0]);
    }

    private void disableAllButtons() {
        CreateNewInvoiceButton.setEnabled(false);
        DeleteInvoiceButton.setEnabled(false);
        AddItemButton.setEnabled(false);
        DeleteItemButton.setEnabled(false);
        CancelButton.setEnabled(false);
    }

    public void setLocations() {
        CreateNewInvoiceDialog.setLocation(InvoiceTable.getLocationOnScreen().x + 50, InvoiceTable.getLocationOnScreen().y + 50);
        AddItemDialog.setLocation(InvoicesLineTable.getLocationOnScreen().x + 100, InvoicesLineTable.getLocationOnScreen().y);
    }
}

