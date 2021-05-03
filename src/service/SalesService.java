package service;

import model.BaseDocument;
import model.Order;
import model.Sales;

import java.text.ParseException;
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
    public boolean validate(BaseDocument document) throws Exception {
        if (!(document instanceof Order)) {
            throw new Exception("This document is not an order document.");
        }
        BaseService.validate(document);
        if (((Sales) document).getVanAgentName().length() == 0) {
            throw new NullPointerException("VanAgent  name is empty");
        }
        System.out.println("Everything is OK");
        return true;
    }


    @Override
    public String store(BaseDocument document) throws Exception {
       if (!validate(document)){
           throw new Exception("Document was not validated");
        }
        Sales sales = (Sales) document;
        String doc = sales.getDate() + "," +
                sales.getCustomerName() + "," +
                sales.getProductName() + "," +
                sales.getProductPrice() + "," +
                sales.getVanAgentName();
        return doc;
    }
}
