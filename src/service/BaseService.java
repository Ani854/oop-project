package service;

import model.BaseDocument;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class BaseService {
    public static BaseDocument create(BaseDocument doc) throws ParseException {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Date date = new Date();
        System.out.println("Enter customer name.");
        String customerName = scanner.next();

        System.out.println("Enter product name.");
        String productName = scanner.next();

        System.out.println("Enter product price.");
        double productPrice = scanner.nextDouble();

        doc.setDate(date);
        doc.setCustomerName(customerName);
        doc.setProductName(productName);
        doc.setProductPrice(productPrice);

        return doc;
    }

    public static void validate(BaseDocument document) throws Exception {
        if (document.getCustomerName().length() == 0) {
            throw new NullPointerException("Customer name is empty");
        }
        if (document.getProductName().length() == 0) {
            throw new NullPointerException("Product name is empty");
        }
        if (document.getProductPrice() < 0) {
            throw new Exception("Price can not be negative.");
        }
    }
}