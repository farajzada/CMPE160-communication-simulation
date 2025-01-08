public class Operator {
    private int id;
    private double talkingCharge;
    private double messageCost;
    private double networkCharge;
    private  int discountRate;

    public Operator(int id, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
        this.id = id;
        this.talkingCharge = talkingCharge;
        this.messageCost = messageCost;
        this.networkCharge = networkCharge;
        this.discountRate = discountRate;
    }
    public double calculateTalkingCost(int minute,Customer customer) {
        return talkingCharge * minute;
    }
    public double calculateMessageCost(int quantity,Customer customer,Customer other) {
        return messageCost * quantity;
    }
    public double calculateNetworkCost(double amount){
        return networkCharge * amount;
    }

    public double getTalkingCharge() {
        return talkingCharge;
    }

    public void setTalkingCharge(double talkingCharge) {
        this.talkingCharge = talkingCharge;
    }

    public double getMessageCost() {
        return messageCost;
    }

    public void setMessageCost(double messageCost) {
        this.messageCost = messageCost;
    }

    public double getNetworkCharge() {
        return networkCharge;
    }

    public void setNetworkCharge(double networkCharge) {
        this.networkCharge = networkCharge;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}
