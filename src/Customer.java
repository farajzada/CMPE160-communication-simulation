public class Customer {
    private int id;
    private String name;
    private int age;
    Operator operator;
    Bill bill;

    public Customer(int id, String name, int age, Operator operator, Bill bill) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.operator = operator;
        this.bill = bill;
    }

    public void talk(int minute,Customer other) {
        double cost = operator.calculateTalkingCost(minute, this);
        if (bill.check(cost)) {
            bill.add(cost);
            System.out.println(name + "talked with" + other.name + "for" + minute + " minutes");
        }else {
            System.out.println("Talk failed:Not enough limit");
        }
    }
    public void message(int quantity,Customer other) {
        double cost = operator.calculateMessageCost(quantity, this, other);
        if (bill.check(cost)) {
            bill.add(cost);
            System.out.println(name + " sent " + quantity + " messages to " + other.name + ".");
        } else {
            System.out.println("Message failed: Not enough limit.");
        }
    }
    public void connection(double amount){
        double cost = operator.calculateNetworkCost(amount);
        if (bill.check(cost)) {
            bill.add(cost);
            System.out.println(name + " used " + amount + " MB of data.");
        } else {
            System.out.println("Connection failed: Not enough limit.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
