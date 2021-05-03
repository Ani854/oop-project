package model;

public class Return extends BaseDocument {
    private String vanAgent;
    private int expiredDayCount;

    public int getExpiredDayCount() {
        return expiredDayCount;
    }

    public void setExpiredDayCount(int expiredDayCount) {
        if (expiredDayCount <= 0) {
            System.out.println("Expires day count can not be negative.");
        } else {
            this.expiredDayCount = expiredDayCount;
        }
    }

    public String getVanAgent() {
        return vanAgent;
    }

    public void setVanAgent(String vanAgent) {
        if (vanAgent.length() == 0) {
            System.out.println("VanAgent name is empty");
        } else {

            this.vanAgent = vanAgent;
        }
    }
}
