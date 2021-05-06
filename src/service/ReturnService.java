package service;

import model.BaseDocument;
import model.Order;
import model.Return;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void validate(BaseDocument document) throws Exception {
        if (!(document instanceof Return)) {
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
    }

    @Override
    public String store(BaseDocument document) throws Exception {
        validate(document);
        Return salesReturn = (Return) document;
        StringBuilder sb = new StringBuilder();
        String doc = sb.append(new SimpleDateFormat("dd.MM.yyyy").format(salesReturn.getDate()))
                .append(",")
                .append(salesReturn.getCustomerName())
                .append(",")
                .append(salesReturn.getProductName())
                .append(",")
                .append(salesReturn.getProductPrice())
                .append(",")
                .append(salesReturn.getVanAgent())
                .append(",")
                .append(salesReturn.getExpiredDayCount()).toString();

        return doc;
    }

    public void printReturnDocumentByExpiredDay(Return[] returns) {
        for (Return salesReturn : returns) {
            if (salesReturn.getExpiredDayCount() > 6) {
                salesReturn.printReturnDocumentInfo();
            }
        }
    }
}
