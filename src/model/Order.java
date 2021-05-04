package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends BaseDocument {
    private String salesAgentName;
    private Date deliveryDate;

    public void printOrderDocumentInfo() {
        StringBuilder sb = new StringBuilder();
        String doc = sb.append(getDate())
                .append(",")
                .append(getCustomerName())
                .append(",")
                .append(getProductName())
                .append(",")
                .append(getProductPrice())
                .append(",")
                .append(getSalesAgentName())
                .append(",")
                .append(getDeliveryDate()).toString();
        System.out.println(doc);
    }

    public String getSalesAgentName() {
        return salesAgentName;
    }

    public void setSalesAgentName(String salesAgentName) {
        if (salesAgentName.length() == 0) {
            System.out.println("Sales agent  name is empty");
        } else {
            this.salesAgentName = salesAgentName;
        }
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date validDate = format.parse("01.01.1900");
        if (validDate.compareTo(deliveryDate) > 0) {
            System.out.println("The date of the document is less than");
        } else {
            this.deliveryDate = deliveryDate;
        }
    }
}
