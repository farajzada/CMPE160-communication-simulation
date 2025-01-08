public class Bill {
    private double limitingAmount;
    private double currentDebt;

    public Bill(double limitingAmount) {
        this.limitingAmount = limitingAmount;
        this.currentDebt = 0.0;
    }

    public boolean check(double amount) {
        return (currentDebt + amount) <= limitingAmount;
    }
    public void add(double amount) {
        currentDebt += amount;
    }
    public void pay(double amount) {
        currentDebt -= amount;
        if (currentDebt < 0) currentDebt = 0;
    }
    public void changeTheLimit(double amount) {
        limitingAmount = amount;
    }

    public double getLimitingAmount() {
        return limitingAmount;
    }

    public double getCurrentDebt() {
        return currentDebt;
    }
}
