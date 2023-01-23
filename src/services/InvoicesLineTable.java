package services;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.View;


public class InvoicesLineTable implements ListSelectionListener
{
    private View view=null;
    public InvoicesLineTable(View view) 
    {
        this.view=view;
    }

    
    @Override
    public void valueChanged(ListSelectionEvent e) 
    {

            if(!e.getValueIsAdjusting())
            {
                if(view.getInvoicesLineTable().getSelectedRow()>=0)
                {
                    view.getDeleteItemButton().setEnabled(true);
                }
                else
                {
                    view.getDeleteItemButton().setEnabled(false);
                }
            }
        }
}
