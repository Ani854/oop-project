package service;

import model.BaseDocument;
import model.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class OrderService implements Functionalities {
    @Override
    public Order create() throws ParseException {
        System.out.println("Order document:");
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
        if (document instanceof Order) {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            Date validDate = format.parse("01.01.1900");
            BaseService.validate(document);
            if (((Order) document).getSalesAgentName().length() == 0) {
                throw new NullPointerException("Sales agent  name is empty");
            }
            if (validDate.compareTo(((Order) document).getDeliveryDate()) > 0) {
                throw new Exception("Delivery  date is smaller 01.01.1900");
            }
        }
    }

    @Override
    public String store(BaseDocument document) throws Exception {
        validate(document);
        Order order = (Order) document;
        String doc = order.getDate() + "," +
                order.getCustomerName() + "," +
                order.getProductName() + "," +
                order.getProductPrice() + "," +
                order.getSalesAgentName() + "," +
                order.getDeliveryDate();
        return doc;
    }
}
