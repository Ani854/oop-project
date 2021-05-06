package service;

import model.BaseDocument;
import model.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class OrderService implements SaleBaseFunctionalities {
    @Override
    public Order create() throws ParseException {
        System.out.println("Please insert order document:");
        Order order = new Order();
        order = (Order) BaseService.create(order);

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Enter sales agent name.");
        String salesAgentName = scanner.next();

        System.out.println("Enter delivery date.");
        String deliveryDate = scanner.next();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date docDate = format.parse(deliveryDate);
        order.setSalesAgentName(salesAgentName);
        order.setDeliveryDate(docDate);

        return order;
    }

    @Override
    public void validate(BaseDocument document) throws Exception {
        if (!(document instanceof Order)) {
            throw new Exception("This document is not an order document.");
        }
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date validDate = format.parse("01.01.1900");
        BaseService.validate(document);
        if (((Order) document).getSalesAgentName().length() == 0) {
            throw new NullPointerException("Sales agent  name is empty");
        }
        if (validDate.compareTo(((Order) document).getDeliveryDate()) > 0) {
            throw new Exception("The date of the document is less than");
        }
        System.out.println("Everything is OK");
    }

    @Override
    public String store(BaseDocument document) throws Exception {
        validate(document);
        Order order = (Order) document;
        StringBuilder sb = new StringBuilder();
        String doc = sb.append(new SimpleDateFormat("dd.MM.yyyy").format(order.getDate()))
                .append(",")
                .append(order.getCustomerName())
                .append(",")
                .append(order.getProductName())
                .append(",")
                .append(order.getProductPrice())
                .append(",")
                .append(order.getSalesAgentName())
                .append(",")
                .append(new SimpleDateFormat("dd.MM.yyyy").format(order.getDeliveryDate())).toString();

        return doc;
    }

    public void printOrderDocumentByCustomerName(Order[] orders) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getCustomerName().charAt(0) == 'A') {
                orders[i].printOrderDocumentInfo();
            }

        }
    }


}
