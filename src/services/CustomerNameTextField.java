package services;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.View;
import controller.Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerNameTextField implements FocusListener, ActionListener
{
    private View view=null;
    
    public CustomerNameTextField(View view)
    {
        this.view=view;
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        if(!((Controllers.invoices.get(Controllers.selectedRow).getInoviceCustomerName()).equals((view.getCustomerNameTextField().getText()))))
        {
            Controllers.changNameTextField(view,Controllers.invoices);
            view.getInvoiceTable().setRowSelectionInterval(Controllers.selectedRow, Controllers.selectedRow);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(!((Controllers.invoices.get(Controllers.selectedRow).getInoviceCustomerName()).equals((view.getCustomerNameTextField().getText()))))
        {
            Controllers.changNameTextField(view,Controllers.invoices);
        }
    }
    
    @Override
    public void focusGained(FocusEvent e){}

   
}
