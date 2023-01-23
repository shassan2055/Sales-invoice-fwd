package services;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import models.FileOperations;
import view.View;
import controller.Controllers;


public class MainFrameMouseMotion implements MouseMotionListener
{
    private View view=null;
    public MainFrameMouseMotion(View view)
    {
        this.view=view;
    }

    @Override
    public void mouseDragged(MouseEvent e){}

    @Override
    public void mouseMoved(MouseEvent e)
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
       if((Controllers.invoices.isEmpty())||(view.getInvoiceTable().getSelectedRow()<0))
        {
            view.getDeleteInvoiceButton().setEnabled(false);
        }
        else
        {
            view.getDeleteInvoiceButton().setEnabled(true);
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
    
}
