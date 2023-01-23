package main;

import controller.Controllers;
import java.io.File;
import java.util.ArrayList;
import models.FileOperations;
import models.InvoiceHeader;
import view.View;

public class Main {

    public static void main(String[] args) {
        ArrayList<InvoiceHeader> invoices = new ArrayList<>();
        View view = new View();
        view.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        view.setVisible(true);
        view.setLocations();
        new Controllers(invoices, view);
        FileOperations fileOperations = new FileOperations(view);
        FileOperations.selectedInvoiceHeader = new File("resources/InvoiceHeader.csv");
        FileOperations.selectedInvoiceLine = new File("resources/InvoiceLine.csv");
        Controllers.invoices = fileOperations.readFile();
        Controllers.calculateTotal(Controllers.invoices);
        Controllers.loadTable(view, Controllers.invoices);
        fileOperations.getMaxNumberOfExistedInvoices(Controllers.numberOfCurrentInvoices, Controllers.invoices);

        for (int i = 0; i < Controllers.invoices.size(); i++) {
            System.out.println("Invoice" + Controllers.invoices.get(i).getInoviceNumber() + "Num");
            System.out.println("{");
            System.out.println(Controllers.invoices.get(i).getInoviceDate() + ", " + Controllers.invoices.get(i).getInoviceCustomerName());
            for (int j = 0; j < Controllers.invoices.get(i).getInvoicerow().size(); j++) {
                System.out.println(Controllers.invoices.get(i).getInvoicerow().get(j).getItemName() + ", "
                        + Controllers.invoices.get(i).getInvoicerow().get(j).getItemPrice() + ", "
                        + Controllers.invoices.get(i).getInvoicerow().get(j).getItemCount());
            }
            System.out.println("}");
        }

    }

}
