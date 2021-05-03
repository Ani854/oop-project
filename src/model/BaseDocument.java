package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseDocument {
    private Date date;
    private String customerName;
    private String productName;
    private double productPrice;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date validDate = format.parse("01.01.1900");
        if (validDate.compareTo(date) > 0) {
            System.out.println("The date of the document is less than");
        } else {
            this.date = date;
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName.length() == 0) {
            System.out.println("Customer name is empty");
        } else {
            this.customerName = customerName;
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName.length() == 0) {
            System.out.println("Product name is empty");
        } else {
            this.productName = productName;
        }
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        if (productPrice <= 0) {
            System.out.println("Product price can not be negative.");
        } else {
            this.productPrice = productPrice;
        }
    }
}
