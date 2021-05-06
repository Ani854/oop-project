package service;

import model.BaseDocument;
import model.Order;
import model.Sales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SalesService implements SaleBaseFunctionalities {
    @Override
    public Sales create() throws ParseException {
        System.out.println("Please insert sales document:");
        Sales sales = new Sales();
        sales = (Sales) BaseService.create(sales);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vanAgent name.");
        String vanAgent = scanner.next();
        sales.setVanAgentName(vanAgent);

        return sales;
    }

    @Override
    public void validate(BaseDocument document) throws Exception {
        if (!(document instanceof Sales)) {
            throw new Exception("This document is not an order document.");
        }
        BaseService.validate(document);
        if (((Sales) document).getVanAgentName().length() == 0) {
            throw new NullPointerException("VanAgent  name is empty");
        }
        System.out.println("Everything is OK");
    }


    @Override
    public String store(BaseDocument document) throws Exception {
        validate(document);
        Sales sales = (Sales) document;
        StringBuilder sb = new StringBuilder();
        String doc = sb.append(new SimpleDateFormat("dd.MM.yyyy").format(sales.getDate()))
                .append(",")
                .append(sales.getCustomerName())
                .append(",")
                .append(sales.getProductName())
                .append(",")
                .append(sales.getProductPrice())
                .append(",")
                .append(sales.getVanAgentName()).toString();
        return doc;
    }

    public void printSalesDocumentByProductPrice(Sales[] sales) {
        for (int i = 0; i < sales.length; i++) {
            if (sales[i].getProductPrice() < 3) {
                sales[i].printSalesDocumentInfo();
            }
        }
    }

    public void sortOrderDocumentByPrice(Sales[] sales) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < sales.length - 1 - count; i++) {
                if (sales[i].getProductPrice() > sales[i + 1].getProductPrice()) {
                    Sales temp = sales[i];
                    sales[i] = sales[i + 1];
                    sales[i + 1] = temp;
                    isActive = true;
                }
            }
            count++;
        }
        for (Sales sales1 : sales) {
            sales1.printSalesDocumentInfo();
        }
    }
}
