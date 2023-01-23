package services;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import view.View;
import controller.Controllers;
import models.FileOperations;


public class MainFrameWindow implements WindowListener
{
    private final FileOperations fileOperations;
    private final InvoiceTable invoiceTableListener;
    private View view=null;
    public MainFrameWindow(View view, FileOperations fileOperations, InvoiceTable invoiceTableListener)
    {
        this.view=view;
        this.fileOperations=fileOperations;
        this.invoiceTableListener=invoiceTableListener;
    }
    
    @Override
    public void windowClosing(WindowEvent e)
    {
        int option;
        if(Controllers.isBeingEdited)
        {
            option= view.showSaveDontSaveCancelDialog(view, "Do You Want To Save Changes?", "Exit");
            if(option == 1)
            {
                System.exit(0);
            }
            else if(option == 0)
            {
                view.setVisible(false);
                saveFile();
                System.exit(0);
            }
            else {}
        }
        else {System.exit(0);}
    }
    void saveFile()
    {

        fileOperations.writeFile(Controllers.invoices);

        if((FileOperations.selectedInvoiceHeader!=null)&&(FileOperations.selectedInvoiceLine!=null))
        {
            view.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTableListener);
            Controllers.invoices=fileOperations.readFile();
            Controllers.calculateTotal(Controllers.invoices);
            Controllers.loadTable(view,Controllers.invoices);
            Controllers.isBeingEdited=false;
            view.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTableListener);
            if(Controllers.invoices.size()>=1)
            view.getInvoiceTable().setRowSelectionInterval(0, 0);
        }
        if(Controllers.isBeingEdited)
        {
            view.getCancelButton().setEnabled(Controllers.isBeingEdited);
        }
        else
        {
            view.getCancelButton().setEnabled(Controllers.isBeingEdited);
        }
    }
    @Override
    public void windowOpened(WindowEvent e){}

    @Override
    public void windowClosed(WindowEvent e){}

    @Override
    public void windowIconified(WindowEvent e){}

    @Override
    public void windowDeiconified(WindowEvent e){}

    @Override
    public void windowActivated(WindowEvent e)
    {

        if((FileOperations.selectedInvoiceHeader!=null)&&(FileOperations.selectedInvoiceLine!=null))
        {
            view.getCreateNewInvoiceButton().setEnabled(true);
        }
        else
        {
            view.getCreateNewInvoiceButton().setEnabled(false);
            view.getDeleteInvoiceButton().setEnabled(false);
            view.getInvoiceTotalLabel().setText("");
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {

        if((FileOperations.selectedInvoiceHeader!=null)&&(FileOperations.selectedInvoiceLine!=null))
        {
            view.getCreateNewInvoiceButton().setEnabled(true);
        }
        else
        {
            view.getCreateNewInvoiceButton().setEnabled(false);
            view.getDeleteInvoiceButton().setEnabled(false);
            view.getInvoiceTotalLabel().setText("");
        }
    }
    
}
