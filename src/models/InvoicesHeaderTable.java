
package models;

import javax.swing.table.DefaultTableModel;
import view.View;


public class InvoicesHeaderTable 
{
    public static DefaultTableModel setInvoicesHeaderTableModel(View view)
    {
        DefaultTableModel newTable= new DefaultTableModel() {};
        newTable= (DefaultTableModel) view.getInvoiceTable().getModel();
        view.getInvoiceTable().setDefaultEditor(Object.class, null);
        return newTable;
    }
    
}
