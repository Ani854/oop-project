package convertor;

import model.Return;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnConvertor {
    public static Return[] makeStringsToReturnDocument(String[] strings) throws ParseException {
        Return[] returns = new Return[strings.length];
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < strings.length; ++i) {
            returns[i] = new Return();
            String[] split = strings[i].split(",");
            Date date = myFormat.parse(split[0]);
            returns[i].setDate(date);
            returns[i].setCustomerName(split[1]);
            returns[i].setProductName(split[2]);
            returns[i].setProductPrice(Double.parseDouble(split[3]));
            returns[i].setVanAgent(split[4]);
            returns[i].setExpiredDayCount(Integer.parseInt(split[5]));

        }

        return returns;
    }
}
