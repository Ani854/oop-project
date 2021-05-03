package service;

import model.BaseDocument;
import model.Order;
import model.Return;

import java.text.ParseException;
import java.util.Scanner;

public class ReturnService implements SaleBaseFunctionalities {

    @Override
    public Return create() throws ParseException {
        System.out.println("Please insert return document:");
        Return salesReturn = new Return();
        salesReturn = (Return) BaseService.create(salesReturn);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter vanAgent name.");
        String vanAgent = scanner.next();

        System.out.println("Enter expired day count:");
        int expiredDayCount = scanner.nextInt();
        salesReturn.setExpiredDayCount(expiredDayCount);
        salesReturn.setVanAgent(vanAgent);

        return salesReturn;
    }

    @Override
    public boolean validate(BaseDocument document) throws Exception {
        if (!(document instanceof Order)) {
            throw new Exception("This document is not an order document.");
        }
        BaseService.validate(document);
        if (((Return) document).getVanAgent().length() == 0) {
            throw new NullPointerException("VanAgent  name is empty");
        }
        if (((Return) document).getExpiredDayCount() < 0) {
            throw new NullPointerException("Expired Day Count  can not be negative.");
        }
        System.out.println("Everything is OK");
        return true;
    }

    @Override
    public String store(BaseDocument document) throws Exception {
        if (!validate(document)) {
            throw new Exception("Document was not validated");
        }
        Return salesReturn = (Return) document;
        String doc = salesReturn.getDate() + "," +
                salesReturn.getCustomerName() + "," +
                salesReturn.getProductName() + "," +
                salesReturn.getProductPrice() + "," +
                salesReturn.getVanAgent() + "," +
                salesReturn.getExpiredDayCount();
        return doc;
    }
}
