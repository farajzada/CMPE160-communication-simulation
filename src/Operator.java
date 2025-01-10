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
        double cost = talkingCharge * minute;
        if (customer.getAge() < 18 || customer.getAge() > 65) {
            cost -= cost * (discountRate / 100.0);
        }
        return cost;
    }
    public double calculateMessageCost(int quantity,Customer sender,Customer receiver) {
        double cost = quantity * messageCost;
        if (sender.getOperator() == receiver.getOperator()) {
            cost -= cost * (discountRate / 100.0); // Eyni operator üçün endirim
        }
        return cost;
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

    public int getId() {
        return id;
    }
}
