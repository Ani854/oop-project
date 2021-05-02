package model;

public class Return extends BaseDocument {
    private String vanAgent;
    private int expiredDayCount;

    public int getExpiredDayCount() {
        return expiredDayCount;
    }

    public void setExpiredDayCount(int expiredDayCount) {
        this.expiredDayCount = expiredDayCount;
    }

    public String getVanAgent() {
        return vanAgent;
    }

    public void setVanAgent(String vanAgent) {
        this.vanAgent = vanAgent;
    }
}
