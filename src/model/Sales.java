package model;

public class Sales extends BaseDocument {
    private String vanAgentName;

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
