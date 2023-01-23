package services;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.FileOperations;
import view.View;
import controller.Controllers;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class FileMenuItems implements ActionListener ,MenuListener
{
    private final FileOperations fileOperations;
    private final InvoiceTable invoiceTableListener;
    private View view=null;
    
    public FileMenuItems(View view,FileOperations fileOperations,InvoiceTable invoiceTableListener) 
    {
        this.view=view;
        this.fileOperations=fileOperations;
        this.invoiceTableListener=invoiceTableListener;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case "Load File Sequence":
            {

                Controllers.isBeingEdited=false;
                Controllers.cleanInvsHeaderTable(view);
                Controllers.cleanInvsLineTable(view);

                view.getInvoiceTotalLabel().setText("");
                fileOperations.getFilesPaths();
                if((FileOperations.selectedInvoiceHeader!=null)&&(FileOperations.selectedInvoiceLine!=null))
                {
                    Controllers.invoices=fileOperations.readFile();
                    Controllers.calculateTotal(Controllers.invoices);
                    Controllers.loadTable(view,Controllers.invoices);
                    fileOperations.getMaxNumberOfExistedInvoices(Controllers.numberOfCurrentInvoices,Controllers.invoices);
                }
                break;
            }
            case "Save File":
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
                break;
            }
        }
    }

    @Override
    public void menuSelected(MenuEvent e) 
    {
        if((Controllers.isBeingEdited))
        {
            view.getSaveFile().setEnabled(true);
        }
        else
        {
            view.getSaveFile().setEnabled(false);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e){}

    @Override
    public void menuCanceled(MenuEvent e){}
    
}
