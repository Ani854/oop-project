package convertor;

import model.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderConvertor {
    public static Order[] makeStringsToOrderDocument(String[] strings) throws ParseException {
        Order[] orders = new Order[strings.length];
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < strings.length; ++i) {
            orders[i] = new Order();
            String[] split = strings[i].split(",");
            Date date = myFormat.parse(split[0]);
            Date deliveryDate = myFormat.parse(split[5]);
            orders[i].setDate(date);
            orders[i].setCustomerName(split[1]);
            orders[i].setProductName(split[2]);
            orders[i].setProductPrice(Double.parseDouble(split[3]));
            orders[i].setSalesAgentName(split[4]);
            orders[i].setDeliveryDate(deliveryDate);

        }

        return orders;
    }
}
