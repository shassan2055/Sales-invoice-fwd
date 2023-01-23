package controller;

import services.InvoiceDateTextField;
import services.InvoiceTable;
import services.AddItemDialogWindow;
import services.FileMenuItems;
import services.MainFrameMouseMotion;
import services.MainFrameWindow;
import services.CustomerNameTextField;
import services.InvoicesLineTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Date;
import models.FileOperations;
import models.InvoiceHeader;
import models.InvoiceLine;
import models.InvoicesHeaderTable;
import models.InvoicesLineTableM;
import view.View;


public class Controllers implements ActionListener, KeyListener {

    private final View view;
    private final FileOperations fileOperations;
    public volatile static ArrayList<InvoiceHeader> invoices = new ArrayList<>();
    public volatile static int selectedRow = 0;
    public volatile static boolean isBeingEdited = false;
    public volatile static int numberOfCurrentInvoices = 0;
    private final InvoiceTable invoiceTable;
    private final InvoicesLineTable invoicesLineTable;
    private final FileMenuItems fileMenuItems;
    private final MainFrameWindow mainFrameWindow;
    private final MainFrameMouseMotion mainFrameMouseMotion;
    private final AddItemDialogWindow addItemDialogWindow;
    private final InvoiceDateTextField invoiceDateTextField;
    private final CustomerNameTextField customerNameTextField;

    public Controllers(ArrayList<InvoiceHeader> invoices, View view) {
        this.invoices = invoices;
        this.view = view;
        fileOperations = new FileOperations(this.view);

        invoicesLineTable = new InvoicesLineTable(view);
        invoiceTable = new InvoiceTable(view, fileOperations, invoicesLineTable);
        fileMenuItems = new FileMenuItems(view, fileOperations, invoiceTable);
        mainFrameWindow = new MainFrameWindow(view, fileOperations, invoiceTable);
        addItemDialogWindow = new AddItemDialogWindow(view);
        mainFrameMouseMotion = new MainFrameMouseMotion(view);
        invoiceDateTextField = new InvoiceDateTextField(view);
        customerNameTextField = new CustomerNameTextField(view);
        turnOnActionListeners(view);
    }

    private void turnOnActionListeners(View view) {
        view.getLoadFile().addActionListener(fileMenuItems);
        view.getLoadFile().setActionCommand("Load File Sequence");
        view.getSaveFile().addActionListener(fileMenuItems);
        view.getSaveFile().setActionCommand("Save File");
        view.getFileMenu().addMenuListener(fileMenuItems);
        view.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTable);
        view.getInvoicesLineTable().getSelectionModel().addListSelectionListener(invoicesLineTable);
        view.addWindowListener(mainFrameWindow);
        view.getAddItemDialog().addWindowListener(addItemDialogWindow);
        view.getInvoiceDateTextField().addActionListener(invoiceDateTextField);
        view.getInvoiceDateTextField().addFocusListener(invoiceDateTextField);
        view.getCustomerNameTextField().addActionListener(customerNameTextField);
        view.getCustomerNameTextField().addFocusListener(customerNameTextField);
        view.getRootPane().addMouseMotionListener(mainFrameMouseMotion);
        view.getCreateNewInvoiceButton().addActionListener(this);
        view.getCreateNewInvoiceButton().setActionCommand("Create New Invoice");
        view.getCreateNewInvoiceOK().addActionListener(this);
        view.getCreateNewInvoiceOK().setActionCommand("Create New Invoice OK");
        view.getCreateNewInvoiceCancel().addActionListener(this);
        view.getCreateNewInvoiceCancel().setActionCommand("Create New Invoice Cancel");
        view.getDeleteInvoiceButton().addActionListener(this);
        view.getDeleteInvoiceButton().setActionCommand("Delete Invoice");
        view.getAddItemButton().addActionListener(this);
        view.getAddItemButton().setActionCommand("Add Item");
        view.getNewItemPrice().addKeyListener(this);
        view.getAddItemDialogCancel().addActionListener(this);
        view.getAddItemDialogCancel().setActionCommand("Add Item Dialog Cancel");
        view.getAddItemDialogOK().addActionListener(this);
        view.getAddItemDialogOK().setActionCommand("Add Item Dialog OK");
        view.getDeleteItemButton().addActionListener(this);
        view.getDeleteItemButton().setActionCommand("Delete Item");
        view.getCancelButton().addActionListener(this);
        view.getCancelButton().setActionCommand("Cancel");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Create New Invoice": {
                if (view.getFocusOwner() != null) {
                    CreateInvoice(view);
                }
                break;
            }
            case "Create New Invoice OK": {

                view.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTable);

                addInvoice(view, invoices);

                view.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTable);
                if (isBeingEdited) {
                    view.getCancelButton().setEnabled(isBeingEdited);
                } else {
                    view.getCancelButton().setEnabled(isBeingEdited);
                }
                break;
            }
            case "Create New Invoice Cancel": {
                view.getNewCustomerName().setText("");
                View.getCreateNewInvoiceDialog().setVisible(false);
                break;
            }
            case "Delete Invoice": {
                if (view.getFocusOwner() != null) {

                    view.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTable);

                    deleteInvoice(view, invoices);

                    view.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTable);
                    if (isBeingEdited) {
                        view.getCancelButton().setEnabled(isBeingEdited);
                    } else {
                        view.getCancelButton().setEnabled(isBeingEdited);
                    }
                }
                break;
            }
            case "Add Item": {
                if (view.getFocusOwner() != null) {
                    createNewItem(view);
                }
                break;
            }
            case "Add Item Dialog OK": {
                addItem(view, invoices);
                calculateTotal(invoices);
                updateTotal(view, invoices);
                rightPanelTestUpdater(view, invoices, view.getInvoiceTable().getSelectedRow());
                loadLineTable(view, invoices);
                int sizeOfInvoicesLinesForTheSelectedInvoice = invoices.get(view.getInvoiceTable().getSelectedRow()).getInvoicerow().size();
                view.getInvoicesLineTable().setRowSelectionInterval((sizeOfInvoicesLinesForTheSelectedInvoice - 1), (sizeOfInvoicesLinesForTheSelectedInvoice - 1));
                View.getAddItemDialog().setVisible(false);
                if (isBeingEdited) {
                    view.getCancelButton().setEnabled(isBeingEdited);
                } else {
                    view.getCancelButton().setEnabled(isBeingEdited);
                }
                break;
            }
            case "Add Item Dialog Cancel": {
                View.getAddItemDialog().setVisible(false);
                view.getNewItemName().setText("");
                view.getNewItemPrice().setText("");
                view.getNewItemPriceSpinner().setValue((Object) 1);
                break;
            }
            case "Delete Item": {
                if (view.getFocusOwner() != null) {
                    deleteItem(view, invoices);
                    calculateTotal(invoices);
                    updateTotal(view, invoices);
                    rightPanelTestUpdater(view, invoices, view.getInvoiceTable().getSelectedRow());
                    System.out.println(selectedRow);
                    loadLineTable(view, invoices);
                    int sizeOfInvoicesLinesForTheSelectedInvoice = invoices.get(view.getInvoiceTable().getSelectedRow()).getInvoicerow().size();
                    if (sizeOfInvoicesLinesForTheSelectedInvoice > 0) {
                        view.getInvoicesLineTable().setRowSelectionInterval((sizeOfInvoicesLinesForTheSelectedInvoice - 1), (sizeOfInvoicesLinesForTheSelectedInvoice - 1));
                    }
                    if (isBeingEdited) {
                        view.getCancelButton().setEnabled(isBeingEdited);
                    } else {
                        view.getCancelButton().setEnabled(isBeingEdited);
                    }
                }
                break;
            }
            case "Cancel": {

                if ((FileOperations.selectedInvoiceHeader != null) && (FileOperations.selectedInvoiceLine != null)) {
                    view.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTable);
                    invoices = fileOperations.readFile();
                    calculateTotal(invoices);
                    loadTable(view, invoices);
                    numberOfCurrentInvoices = 0;
                    fileOperations.getMaxNumberOfExistedInvoices(numberOfCurrentInvoices, invoices);
                    isBeingEdited = false;
                    view.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTable);
                    if (invoices.size() >= 1) {
                        view.getInvoiceTable().setRowSelectionInterval(0, 0);
                    }
                }
                if (isBeingEdited) {
                    view.getCancelButton().setEnabled(isBeingEdited);
                } else {
                    view.getCancelButton().setEnabled(isBeingEdited);
                }
                break;
            }
        }

    }


    @Override
    public void keyTyped(KeyEvent event) {
        char price = event.getKeyChar();
        if (Character.isLetter(price) && !event.isAltDown() && event.isShiftDown() && event.isControlDown()) {
            event.consume();
        }
        if ((price == 'f') || (price == 'd')) {
            event.consume();
        }
        try {
            Float.parseFloat(view.getNewItemPrice().getText() + price);
        } catch (NumberFormatException e) {
            event.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void cleanInvsHeaderTable(View view) {
        while (InvoicesHeaderTable.setInvoicesHeaderTableModel(view).getRowCount() > 0) {
            InvoicesHeaderTable.setInvoicesHeaderTableModel(view).removeRow(0);
        }
    }

    public static void cleanInvsLineTable(View view) {
        while (InvoicesLineTableM.setInvoicesLineTableModel(view).getRowCount() > 0) {
            InvoicesLineTableM.setInvoicesLineTableModel(view).removeRow(0);
        }
    }

    static void updateTable(View view, ArrayList<InvoiceHeader> invoices) {
        InvoicesHeaderTable.setInvoicesHeaderTableModel(view).setValueAt(invoices.get(view.getInvoiceTable().getSelectedRow()).getInoviceDate(), view.getInvoiceTable().getSelectedRow(), 1);
    }

    static void updateCustomerName(View view, ArrayList<InvoiceHeader> invoices) {
        InvoicesHeaderTable.setInvoicesHeaderTableModel(view).setValueAt(invoices.get(view.getInvoiceTable().getSelectedRow()).getInoviceCustomerName(), view.getInvoiceTable().getSelectedRow(), 2);
    }

    static void updateTotal(View view, ArrayList<InvoiceHeader> invoices) {
        InvoicesHeaderTable.setInvoicesHeaderTableModel(view).setValueAt(invoices.get(view.getInvoiceTable().getSelectedRow()).getInoviceTotal(), view.getInvoiceTable().getSelectedRow(), 3);
    }

    static void CreateInvoice(View view) {
        Date invDate = new Date();
        view.setLocations(); 
        view.getNewInvoiceDateField().setText(view.getDate().format(invDate)); 
        View.getCreateNewInvoiceDialog().setVisible(true); 
    }

    static void addInvoice(View view, ArrayList<InvoiceHeader> invoices) {
        //check if no customer name entered 
        if (view.getNewCustomerName().getText().equalsIgnoreCase("")) {
            View.getCreateNewInvoiceDialog().setModal(false);
            view.setJOptionPaneMessageMessage(view.getLeftSidePanel(), "Please Enter A Name For The Customer", "Empty Name Entered", "ERROR_MESSAGE");
            View.getCreateNewInvoiceDialog().setModal(true);
            CreateInvoice(view);
        } else {
            Controllers.numberOfCurrentInvoices++;
            Controllers.isBeingEdited = true;
            try {
                InvoiceHeader newRow = new InvoiceHeader((Controllers.numberOfCurrentInvoices), (view.getDate().parse(view.getNewInvoiceDateField().getText())), (view.getNewCustomerName().getText()));
                invoices.add(newRow);
                loadTable(view, invoices);
                View.getCreateNewInvoiceDialog().setVisible(false);
                view.getInvoiceTable().setRowSelectionInterval((invoices.size() - 1), (invoices.size() - 1));
                view.getNewCustomerName().setText("");
                view.getNewInvoiceDateField().setText("");
                rightPanelTestUpdater(view, invoices, invoices.size() - 1);
                loadLineTable(view, invoices);
            } catch (ParseException e) {
                System.out.println(e.toString());
            }
        }
    }

    static void deleteInvoice(View view, ArrayList<InvoiceHeader> invoices) {
        int invoiceToBeDeleted = view.getInvoiceTable().getSelectedRow();
        //check if no row selected
        if ((invoiceToBeDeleted == -1)) {
            view.setJOptionPaneMessageMessage(view.getLeftSidePanel(), "Select Invoice Row First", "Error", "ERROR_MESSAGE");
        } else {
            Controllers.isBeingEdited = true;
            //remove the selected row from the invoice array list
            invoices.remove(invoiceToBeDeleted);
            //reload the invoice header table
            loadTable(view, invoices);
            //Select the row before deleted row automatically
            if (!invoices.isEmpty()) {
                view.getInvoiceTable().setRowSelectionInterval((invoices.size() - 1), (invoices.size() - 1));
                rightPanelTestUpdater(view, invoices, invoices.size() - 1);
                loadLineTable(view, invoices);
            } else {
                view.getDeleteInvoiceButton().setEnabled(false);
                rightPanelDisable(view);
                cleanInvsLineTable(view);
            }
        }
    }

    public static void calculateTotal(ArrayList<InvoiceHeader> invoices) {
        float total = 0; //to store total of each invoice
        for (int i = 0; i < invoices.size(); i++) {
            total = 0;
            for (int j = 0; j < invoices.get(i).getInvoicerow().size(); j++) {
                total = total + ((invoices.get(i).getInvoicerow().get(j).getItemPrice()) * (invoices.get(i).getInvoicerow().get(j).getItemCount()));
            }
            invoices.get(i).setInoviceTotal(total);
        }
    }

    public static void loadTable(View view, ArrayList<InvoiceHeader> invoices) {
        cleanInvsHeaderTable(view);
        Object data[] = new Object[4];
        for (int i = 0; i < invoices.size(); i++) {
            data[0] = invoices.get(i).getInoviceNumber();
            data[1] = invoices.get(i).getInoviceDate();
            data[2] = invoices.get(i).getInoviceCustomerName();
            data[3] = invoices.get(i).getInoviceTotal();
            InvoicesHeaderTable.setInvoicesHeaderTableModel(view).addRow(data);
        }
    }

    public static void loadLineTable(View view, ArrayList<InvoiceHeader> invoices) {
        float total = 0;
        Object data[] = new Object[5];
        int selectedRow = view.getInvoiceTable().getSelectedRow();
        //check if no row is selected after it was selected before
        if (selectedRow == -1) {
            //clear all fields and disable all buttons of right side in GUI
            rightPanelDisable(view);
            cleanInvsLineTable(view);
            //disable delete invoice button on left side if there's no row selected
            view.getDeleteInvoiceButton().setEnabled(false);
        } else {
            //enable all buttons of the right side in GUI
            rightPanelEnable(view);
            //enable delete invoice button on left side if there's row selected
            view.getDeleteInvoiceButton().setEnabled(true);
            cleanInvsLineTable(view);
            InvoicesLineTableM.setInvoicesLineTableModel(view).setRowCount(0);
            for (int j = 0; j < invoices.get(selectedRow).getInvoicerow().size(); j++) {
                //Calculate and Set invoice total
                total = ((invoices.get(selectedRow).getInvoicerow().get(j).getItemPrice()) * (invoices.get(selectedRow).getInvoicerow().get(j).getItemCount()));
                invoices.get(selectedRow).getInvoicerow().get(j).setItemTotal(total);
                data[0] = invoices.get(selectedRow).getInvoicerow().get(j).getMainInvoice().getInoviceNumber();
                data[1] = invoices.get(selectedRow).getInvoicerow().get(j).getItemName();
                data[2] = invoices.get(selectedRow).getInvoicerow().get(j).getItemPrice();
                data[3] = invoices.get(selectedRow).getInvoicerow().get(j).getItemCount();
                data[4] = invoices.get(selectedRow).getInvoicerow().get(j).getItemTotal();
                InvoicesLineTableM.setInvoicesLineTableModel(view).addRow(data);
                rightPanelTestUpdater(view, invoices, selectedRow);
            }
        }
    }

    static void rightPanelDisable(View view) {
        view.getInvoiceDateTextField().setText("");
        view.getCustomerNameTextField().setText("");
        view.getInvoiceTotalLabel().setText("");
        view.getInvoiceNumberLabel().setText("");
        view.getAddItemButton().setEnabled(false);
        view.getDeleteItemButton().setEnabled(false);
        view.getInvoiceDateTextField().setEditable(false);
        view.getCustomerNameTextField().setEditable(false);
    }

    static void rightPanelEnable(View view) {
        view.getAddItemButton().setEnabled(true);
        view.getInvoiceDateTextField().setEditable(true);
        view.getCustomerNameTextField().setEditable(true);
    }

    public static void rightPanelTestUpdater(View view, ArrayList<InvoiceHeader> invoices, int selectedRow) {
        if (selectedRow != -1) {
            view.getInvoiceNumberLabel().setText(Integer.toString(invoices.get(selectedRow).getInoviceNumber()));
            view.getInvoiceDateTextField().setText(view.getDate().format(invoices.get(selectedRow).getInoviceDate()));
            view.getCustomerNameTextField().setText(invoices.get(selectedRow).getInoviceCustomerName());
            view.getInvoiceTotalLabel().setText(Float.toString(invoices.get(selectedRow).getInoviceTotal()));
        }
    }

    public static void fieldValidator(View view, ArrayList<InvoiceHeader> invoices) {
        //Confirm that user want to change date
        int choice = view.showYesNoCancelDialog(view.getRightSidePanel(), "Do you want To save date changes?", "Date change confirmation");
        switch (choice) {
        //yes
            case 0:
                try {
                    //Check if new date have the pattern "dd-MM-yyyy" exactly using regex expression
                    if (!(view.getInvoiceDateTextField().getText().matches("^\\d{2}\\-\\d{2}\\-\\d{4}"))) {
                        throw new Exception();
                    }
                    //Check if Date is valid date
                    FileOperations.date.setLenient(false);
                    FileOperations.date.parse(view.getInvoiceDateTextField().getText());
                    invoices.get(view.getInvoiceTable().getSelectedRow()).setInoviceDate(view.getDate().parse(view.getInvoiceDateTextField().getText()));
                    updateTable(view, invoices);
                    view.getInvoiceDateTextField().requestFocus();
                    Controllers.isBeingEdited = true;
                } catch (ParseException ex) {
                    view.setJOptionPaneMessageMessage(view.getRightSidePanel(), "Please Enter A Valid Date", "Wrong Date", "ERROR_MESSAGE");
                    view.getInvoiceDateTextField().setText(view.getDate().format(invoices.get(view.getInvoiceTable().getSelectedRow()).getInoviceDate()));
                    view.getInvoiceDateTextField().requestFocus();
                } catch (Exception ex) {
                    view.setJOptionPaneMessageMessage(view.getRightSidePanel(), "Please Enter A Valid Date Format (e.g 05-09-1993)", "Wrong Date Format", "ERROR_MESSAGE");
                    view.getInvoiceDateTextField().setText(view.getDate().format(invoices.get(view.getInvoiceTable().getSelectedRow()).getInoviceDate()));
                    view.getInvoiceDateTextField().requestFocus();
                }   break;
        //no
            case 1:
                view.getInvoiceDateTextField().requestFocus();
                break;
        //cancel
            default:
                view.getInvoiceDateTextField().setText(view.getDate().format(invoices.get(Controllers.selectedRow).getInoviceDate()));
                view.getInvoiceDateTextField().requestFocus();
                break;
        }
    }

    public static void changNameTextField(View view, ArrayList<InvoiceHeader> invoices) {
        //Confirm that user want to customer name
        int choice = view.showYesNoCancelDialog(view.getRightSidePanel(), "Do you want To save customer name changes?", "Customer name change confirmation");
        switch (choice) {
        //yes
            case 0:
                invoices.get(view.getInvoiceTable().getSelectedRow()).setInoviceCustomerName(view.getCustomerNameTextField().getText());
                updateCustomerName(view, invoices);
                view.getCustomerNameTextField().requestFocus();
                Controllers.isBeingEdited = true;
                break;
        //no
            case 1:
                view.getCustomerNameTextField().requestFocus();
                break;
        //cancel
            default:
                view.getCustomerNameTextField().setText(invoices.get(Controllers.selectedRow).getInoviceCustomerName());
                view.getCustomerNameTextField().requestFocus();
                break;
        }
    }

    static void addItem(View view, ArrayList<InvoiceHeader> invoices) {
        String itemName;
        float price = 0;
        int count = 0;
        boolean errorFlag = false;
        itemName = view.getNewItemName().getText();
        if (itemName.equalsIgnoreCase("")) {
            View.getAddItemDialog().setVisible(false);
            view.setJOptionPaneMessageMessage(view.getRightSidePanel(), "Please Enter A Name For The Item", "Empty Item Name Entered", "ERROR_MESSAGE");
            createNewItem(view);
        } else if (view.getNewItemPrice().getText().equalsIgnoreCase("")) {
            View.getAddItemDialog().setVisible(false);
            view.setJOptionPaneMessageMessage(view.getRightSidePanel(), "Please Enter A Price For The Item", "Empty Price Entered", "ERROR_MESSAGE");
            createNewItem(view);
        } else {
            try {
                price = Float.parseFloat(view.getNewItemPrice().getText());
            } catch (NumberFormatException e) {
                errorFlag = true;
            }
            try {
                view.getNewItemPriceSpinner().commitEdit();
                count = (Integer) view.getNewItemPriceSpinner().getValue();
            } catch (ParseException e) {
                errorFlag = true;
            }
            if (!errorFlag) {
                InvoiceHeader temp = invoices.get(view.getInvoiceTable().getSelectedRow());
                InvoiceLine newItem = new InvoiceLine(itemName, price, count, temp);
                temp.getInvoicerow().add(newItem);
                Controllers.isBeingEdited = true;
            }
            view.getNewItemName().setText("");
            view.getNewItemPrice().setText("");
            view.getNewItemPriceSpinner().setValue((Object) 1);
        }
    }

    static void createNewItem(View view) {
        view.setLocations();
        View.getAddItemDialog().setTitle("Add New Item To Invoice Number " + view.getInvoiceNumberLabel().getText());
        View.getAddItemDialog().setVisible(true);
    }

    static void deleteItem(View view, ArrayList<InvoiceHeader> invoices) {
        if (view.getInvoicesLineTable().getSelectedRow() >= 0) {
            int rowToBeDeleted;
            rowToBeDeleted = view.getInvoicesLineTable().getSelectedRow();
            invoices.get(view.getInvoiceTable().getSelectedRow()).getInvoicerow().remove(rowToBeDeleted);
            Controllers.isBeingEdited = true;
        }
    }

}
