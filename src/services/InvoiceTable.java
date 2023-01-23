package services;

import controller.Controllers;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.FileOperations;
import view.View;


public class InvoiceTable implements ListSelectionListener
{
    private final FileOperations fileOperations;
    private View view=null;
    private final InvoicesLineTable invoicesLineTableListener;
    public InvoiceTable(View view,FileOperations fileOperations,InvoicesLineTable invoicesLineTableListener) 
    {
        this.view=view;
        this.fileOperations=fileOperations;
        this.invoicesLineTableListener=invoicesLineTableListener;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) 
    {
        if(Controllers.invoices.size()>=1)
        {

            if(!e.getValueIsAdjusting())
            {
                view.getDeleteItemButton().setEnabled(false);
                Controllers.selectedRow=view.getInvoiceTable().getSelectedRow();
                view.getInvoicesLineTable().getSelectionModel().removeListSelectionListener(invoicesLineTableListener);
                Controllers.loadLineTable(view, Controllers.invoices);
                Controllers.rightPanelTestUpdater(view, Controllers.invoices, Controllers.selectedRow);
                view.getInvoicesLineTable().getSelectionModel().addListSelectionListener(invoicesLineTableListener);
            }
        }
    }
}
