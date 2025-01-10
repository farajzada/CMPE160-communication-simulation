import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

//        if (args.length < 2) {
//            System.out.println("Error: Input and output file names are required.");
//            return;
//        }


        BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/output.txt"));

        int numCustomers = Integer.parseInt(reader.readLine());
        System.out.println(numCustomers);
        int numOperators = Integer.parseInt(reader.readLine());
        System.out.println(numOperators);
        int numEvents = Integer.parseInt(reader.readLine());
        System.out.println(numEvents);

        Customer[] customers = new Customer[1];
        Operator[] operators = new Operator[1];


        for (int i = 0; i < 2; i++) {
            String[] tokens = reader.readLine().split(" ");
            System.out.println(Arrays.toString(tokens));
            int eventType = Integer.parseInt(tokens[0]);
            System.out.println(eventType);
            switch (eventType) {
                case 1: {
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    int operatorID = Integer.parseInt(tokens[3]);
                    double limitingAmount = Double.parseDouble(tokens[4]);
                    customers[0] = new Customer(i, name, age, operators[operatorID], limitingAmount);
                    System.out.println(Arrays.toString(customers));
                    break;
                }
                case 2: {
                    double talkingCharge = Double.parseDouble(tokens[1]);
                    double messageCost = Double.parseDouble(tokens[2]);
                    double networkCharge = Double.parseDouble(tokens[3]);
                    int discountRate = Integer.parseInt(tokens[4]);
                    operators[0] = new Operator(i, talkingCharge, messageCost, networkCharge, discountRate);
                    System.out.println(Arrays.toString(operators));
                    break;
                }


                case 3: {
                    int firstCustomerID = Integer.parseInt(tokens[1]);
                    int secondCustomerID = Integer.parseInt(tokens[2]);
                    int time = Integer.parseInt(tokens[3]);
                    customers[firstCustomerID].talk(time, customers[secondCustomerID]);
                    break;
                }
                case 4: {
                    int firstCustomerID = Integer.parseInt(tokens[1]);
                    int secondCustomerID = Integer.parseInt(tokens[2]);
                    int quantity = Integer.parseInt(tokens[3]);
                    customers[firstCustomerID].message(quantity, customers[secondCustomerID]);
                    break;
                }
                case 5: {
                    int customerID = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    customers[customerID].connection(amount);
                    break;
                }
                case 6: {
                    int customerID = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    customers[customerID].getBill().pay(amount);
                    break;
                }
                case 7: {
                    int customerID = Integer.parseInt(tokens[1]);
                    int newOperatorID = Integer.parseInt(tokens[2]);
                    customers[customerID].setOperator(operators[newOperatorID]);
                    break;
                }
                case 8: {
                    int customerID = Integer.parseInt(tokens[1]);
                    double newLimit = Double.parseDouble(tokens[2]);
                    customers[customerID].getBill().changeTheLimit(newLimit);
                    break;
                }

            }


        }
        for (
                Operator operator : operators) {
            if (operator != null) {
                writer.write("Operator " + operator.getId() + ": " +
                        operator.getTalkingCharge() + " " +
                        operator.getMessageCost() + " " +
                        operator.getNetworkCharge() + "\n");
            }
        }

        for (
                Customer customer : customers) {
            if (customer != null) {
                writer.write("Customer " + customer.getId() + ": " +
                        customer.getBill().getCurrentDebt() + " " +
                        customer.getBill().getLimitingAmount() + "\n");
            }
        }

        reader.close();
        writer.close();

    }
}