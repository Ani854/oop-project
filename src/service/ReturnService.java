package service;

import model.BaseDocument;
import model.Return;
import java.text.ParseException;
import java.util.Scanner;

public class ReturnService implements Functionalities {

    @Override
    public Return create() throws ParseException {
        System.out.println("Return document:");
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
        if (document instanceof Return) {
            BaseService.validate(document);
            if (((Return) document).getVanAgent().length() == 0) {
                throw new NullPointerException("VanAgent  name is empty");
            }
            if (((Return) document).getExpiredDayCount() < 0) {
                throw new NullPointerException("Expired Day Count  can not be negative.");
            }
        }
    }

    @Override
    public String store(BaseDocument document) throws Exception {
        validate(document);
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
