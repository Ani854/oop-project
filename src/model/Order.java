package model;

import java.util.Date;

public class Order extends BaseDocument {
    private String salesAgentName;
    private Date deliveryDate;


    public String getSalesAgentName() {
        return salesAgentName;
    }

    public void setSalesAgentName(String salesAgentName) {
        this.salesAgentName = salesAgentName;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
