package model;

public class Sales extends BaseDocument {
    private String vanAgentName;

    public void printSalesDocumentInfo() {
        StringBuilder sb = new StringBuilder();
        String doc = sb.append(getDate())
                .append(",")
                .append(getCustomerName())
                .append(",")
                .append(getProductName())
                .append(",")
                .append(getProductPrice())
                .append(",")
                .append(getVanAgentName()).toString();
        System.out.println(doc);
    }

    public String getVanAgentName() {
        return vanAgentName;
    }

    public void setVanAgentName(String vanAgentName) {
        if (vanAgentName.length() == 0) {
            System.out.println("VanAgent name is empty.");
        } else {
            this.vanAgentName = vanAgentName;
        }
    }
}
