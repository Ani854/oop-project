package service;

import model.BaseDocument;
import model.Sales;

import java.text.ParseException;
import java.util.Scanner;

public class SolesService implements Functionalities {
    @Override
    public Sales create() throws ParseException {
        System.out.println("Sales document:");
        Sales sales = new Sales();
        sales = (Sales) BaseService.create(sales);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vanAgent name.");
        String vanAgent = scanner.next();
        sales.setVonAgentName(vanAgent);

        return sales;
    }

    @Override
    public void validate(BaseDocument document) throws Exception {
        if (document instanceof Sales) {
            BaseService.validate(document);
            if (((Sales) document).getVonAgentName().length() == 0) {
                throw new NullPointerException("VanAgent  name is empty");
            }
        }
    }

    @Override
    public String store(BaseDocument document) throws Exception {
        validate(document);
        Sales sales = (Sales) document;
        String doc = sales.getDate() + "," +
                sales.getCustomerName() + "," +
                sales.getProductName() + "," +
                sales.getProductPrice() + "," +
                sales.getVonAgentName();
        return doc;
    }
}
