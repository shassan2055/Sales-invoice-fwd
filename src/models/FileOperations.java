package models;

import controller.Controllers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.View;

public class FileOperations {

    public static File selectedInvoiceHeader = null;
    public static File selectedInvoiceLine = null;

    public static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
    private View view = null;

    public FileOperations(View view) {
        this.view = view;
    }

    public void getFilesPaths() {

        selectedInvoiceHeader = null;
        selectedInvoiceLine = null;

        boolean extensionFlag = false;

        boolean cancelButton = false;

        int clicked;

        String fileName = null;

        String fileExtension = null;

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");

        view.getOpenFileJFileChooser().setCurrentDirectory(new File(System.getProperty("user.dir")));

        view.setJOptionPaneMessageMessage(view, "Select Invoice Header File", "Invoice Header", "WARNING_MESSAGE");
        do {

            view.getOpenFileJFileChooser().setSelectedFile(new File(""));

            view.getOpenFileJFileChooser().resetChoosableFileFilters();
            view.getOpenFileJFileChooser().setFileFilter(filter);

            view.getOpenFileJFileChooser().setDialogTitle("Open Invoice Header File");
            clicked = view.getOpenFileJFileChooser().showOpenDialog(view);
            if (clicked == view.getOpenFileJFileChooser().APPROVE_OPTION) {
                Controllers.invoices.clear();
                cancelButton = false;

                fileName = view.getOpenFileJFileChooser().getSelectedFile().getName();

                fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

                if (fileExtension.equalsIgnoreCase("csv")) {
                    extensionFlag = false;
                    selectedInvoiceHeader = view.getOpenFileJFileChooser().getSelectedFile();
                } else {
                    extensionFlag = true;
                    view.setJOptionPaneMessageMessage(view, "Error: Load File With Extension .CSV Only", "Wrong File Selected", "ERROR_MESSAGE");
                }
            } else {
                cancelButton = true;
            }
        } while ((extensionFlag == true) && (cancelButton == false));

        extensionFlag = true;
        if (selectedInvoiceHeader != null) {

            view.setJOptionPaneMessageMessage(view, "Select Invoice Line File", "Invoice Line", "WARNING_MESSAGE");
        }
        while ((extensionFlag == true) && (cancelButton == false)) {

            view.getOpenFileJFileChooser().setSelectedFile(new File(""));

            view.getOpenFileJFileChooser().resetChoosableFileFilters();
            view.getOpenFileJFileChooser().setFileFilter(filter);

            view.getOpenFileJFileChooser().setDialogTitle("Open Invoice Line File");

            clicked = view.getOpenFileJFileChooser().showOpenDialog(view);
            if (clicked == view.getOpenFileJFileChooser().APPROVE_OPTION) {
                cancelButton = false;

                fileName = view.getOpenFileJFileChooser().getSelectedFile().getName();

                fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

                if (fileExtension.equalsIgnoreCase("csv")) {
                    extensionFlag = false;
                    selectedInvoiceLine = view.getOpenFileJFileChooser().getSelectedFile();
                } else {
                    extensionFlag = true;
                    view.setJOptionPaneMessageMessage(view, "Error: Load File With Extension .CSV Only", "Wrong File Selected", "ERROR_MESSAGE");
                }
            } else {
                cancelButton = true;
            }
        }

    }

    public ArrayList<InvoiceHeader> readFile() {

        String Line = null;

        String[] invoicesHeader = null;

        String invoiceNumberStr = null;

        String invoiceDateStr = null;

        String invoiceCustomerName = null;

        int invoiceNumber = 0;

        Date invoiceDate = null;

        InvoiceHeader header = null;

        InvoiceLine line = null;

        String[] invoicesLine = null;

        String invoiceItemName = null;

        String itemPriceStr = null;

        String itemCountStr = null;

        float itemPrice = 0;

        int itemCount = 0;

        InvoiceHeader temporary = null;

        ArrayList<InvoiceHeader> invoices = Controllers.invoices;

        try {
            if ((selectedInvoiceHeader != null) && (selectedInvoiceLine != null)) {
                invoices = new ArrayList<>();
                FileReader file = new FileReader(selectedInvoiceHeader);
                BufferedReader B = new BufferedReader(file);
                while ((Line = B.readLine()) != null) {

                    invoicesHeader = Line.split(",");
                    if (invoicesHeader.length != 3) {
                        throw new Exception("Wrong File Internal Format");
                    }

                    invoiceNumberStr = invoicesHeader[0];
                    if (!(invoiceNumberStr.matches("^\\d+$"))) {
                        throw new Exception("Wrong File Internal Format");
                    }
                    invoiceDateStr = invoicesHeader[1];
                    if (!(invoiceDateStr.matches("^\\d{2}\\-\\d{2}\\-\\d{4}$"))) {
                        throw new Exception("Wrong File Internal Format");
                    }
                    invoiceCustomerName = invoicesHeader[2];
                    view.getDate().setLenient(false);
                    invoiceDate = view.getDate().parse(invoiceDateStr);
                    invoiceNumber = Integer.parseInt(invoiceNumberStr);
                    header = new InvoiceHeader(invoiceNumber, invoiceDate, invoiceCustomerName);
                    invoices.add(header);
                }
                B.close();
                file.close();
            }
        } catch (Exception e) {
            selectedInvoiceHeader = null;
            selectedInvoiceLine = null;
            invoices.clear();
            view.getCreateNewInvoiceButton().setEnabled(false);
            if (e.toString().contains("Wrong File Internal Format")) {
                view.setJOptionPaneMessageMessage(view, "Wrong File Internal Format", "Error", "ERROR_MESSAGE");
            }
            if (e.toString().contains("Unparseable date")) {
                view.setJOptionPaneMessageMessage(view, "Wrong Date", "Error", "ERROR_MESSAGE");
            }
        }
        try {
            if ((selectedInvoiceHeader != null) && (selectedInvoiceLine != null)) {
                FileReader file = new FileReader(selectedInvoiceLine);
                BufferedReader B = new BufferedReader(file);
                while ((Line = B.readLine()) != null) {
                    invoicesLine = Line.split(",");
                    if (invoicesLine.length != 4) {
                        throw new Exception("Wrong File Internal Format");
                    }
                    invoiceNumberStr = invoicesLine[0];
                    if (!(invoiceNumberStr.matches("^\\d+$"))) {
                        throw new Exception("Wrong File Internal Format");
                    }
                    invoiceItemName = invoicesLine[1];
                    itemPriceStr = invoicesLine[2];
                    itemCountStr = invoicesLine[3];
                    if ((!(itemCountStr.matches("^\\d+$"))) || (Integer.parseInt(itemCountStr) < 1)) {
                        throw new Exception("Wrong File Internal Format");
                    }
                    invoiceNumber = Integer.parseInt(invoiceNumberStr);
                    itemPrice = Float.parseFloat(itemPriceStr);
                    itemCount = Integer.parseInt(itemCountStr);
                    temporary = findParentHeader(invoiceNumber, invoices);
                    line = new InvoiceLine(invoiceItemName, itemPrice, itemCount, temporary);
                    temporary.getInvoicerow().add(line);
                }
                B.close();
                file.close();
            }
        } catch (Exception e) {
            selectedInvoiceHeader = null;
            selectedInvoiceLine = null;
            invoices.clear();
            view.getCreateNewInvoiceButton().setEnabled(false);
            view.setJOptionPaneMessageMessage(view, "Wrong File Internal Format", "Error", "ERROR_MESSAGE");
        }
        return invoices;
    }

    public void writeFile(ArrayList<InvoiceHeader> invoices) {
        Controllers.isBeingEdited = false;
        int InvoiceLinelines = 0;
        int totalInvoiceLinelines = 0;
        int actualLine = 0;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(selectedInvoiceHeader);
        } catch (IOException e) {
        }
        for (int i = 0; i < invoices.size(); i++) {
            String Line = invoices.get(i).getInoviceNumber() + "," + date.format(invoices.get(i).getInoviceDate()) + "," + invoices.get(i).getInoviceCustomerName();
            if (i != invoices.size() - 1) {
                Line += "\n";
            }
            try {
                fileWriter.write(Line);
            } catch (IOException e) {
            }
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
        }
        try {
            fileWriter = new FileWriter(selectedInvoiceLine);
        } catch (IOException e) {
        }
        for (int i = 0; i < invoices.size(); i++) {
            totalInvoiceLinelines += invoices.get(i).getInvoicerow().size();
        }
        for (int i = 0; i < invoices.size(); i++) {
            InvoiceLinelines = invoices.get(i).getInvoicerow().size();
            for (int j = 0; j < InvoiceLinelines; j++) {
                String Line = Integer.toString(invoices.get(i).getInvoicerow().get(j).getMainInvoice().getInoviceNumber()) + ",";
                Line += invoices.get(i).getInvoicerow().get(j).getItemName() + ",";
                Line += Float.toString(invoices.get(i).getInvoicerow().get(j).getItemPrice()) + ",";
                Line += Integer.toString(invoices.get(i).getInvoicerow().get(j).getItemCount());
                actualLine++;

                if (!(totalInvoiceLinelines == actualLine)) {
                    Line += "\n";
                } else {
                }
                try {
                    fileWriter.write(Line);
                } catch (IOException e) {
                }
            }
        }
        view.setJOptionPaneMessageMessage(view, "The old files were overwritten by the new data", "Save Done", "INFORMATION_MESSAGE");
        try {
            fileWriter.close();
        } catch (IOException e) {
        }
    }

    private InvoiceHeader findParentHeader(int invoiceNumber, ArrayList<InvoiceHeader> invoices) {
        InvoiceHeader returnElement = null;
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getInoviceNumber() == invoiceNumber) {
                returnElement = invoices.get(i);
            }
        }
        return returnElement;
    }

    public void getMaxNumberOfExistedInvoices(int maxNumberOfExistedInvoices, ArrayList<InvoiceHeader> invoices) {
        for (int i = 0; i < invoices.size(); i++) {
            if ((invoices.get(i).getInoviceNumber()) > Controllers.numberOfCurrentInvoices) {
                Controllers.numberOfCurrentInvoices = invoices.get(i).getInoviceNumber();
            }
        }
    }
}
