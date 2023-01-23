package services;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.View;
import controller.Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InvoiceDateTextField implements FocusListener, ActionListener
{
    private View view=null;
    
    public InvoiceDateTextField(View view)
    {
        this.view=view;
    }
    
    @Override
    public void focusLost(FocusEvent e)
    {
        if((!(Controllers.invoices.isEmpty()))&&(Controllers.selectedRow>=0))
        {
            if(!((view.getDate().format(Controllers.invoices.get(Controllers.selectedRow).getInoviceDate())).equals((view.getInvoiceDateTextField().getText()))))
            {
                Controllers.fieldValidator(view,Controllers.invoices);
                view.getInvoiceTable().setRowSelectionInterval(Controllers.selectedRow, Controllers.selectedRow);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(!((view.getDate().format(Controllers.invoices.get(Controllers.selectedRow).getInoviceDate())).equals((view.getInvoiceDateTextField().getText()))))
        {
            Controllers.fieldValidator(view,Controllers.invoices);
        }
    }
    @Override
    public void focusGained(FocusEvent e){}   
}
