package convertor;

import model.Sales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesConvertor {
    public static Sales[] makeStringsToSalesDocument(String[] strings) throws ParseException {
        Sales[] sales = new Sales[strings.length];
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < strings.length; ++i) {
            sales[i] = new Sales();
            String[] split = strings[i].split(",");
            Date date = myFormat.parse(split[0]);
            sales[i].setDate(date);
            sales[i].setCustomerName(split[1]);
            sales[i].setProductName(split[2]);
            sales[i].setProductPrice(Double.parseDouble(split[3]));
            sales[i].setVanAgentName(split[4]);


        }

        return sales;
    }
}
