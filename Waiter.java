import java.util.ArrayList;

public class Waiter extends Employee {
    private ArrayList<order> orders; // Storing orders using lowercase 'order'
    public double taxRate=18/100;
    private double salary;
    public Waiter(int id, String name,double salary) {
        super(id, name);
        this.salary=salary;
        this.orders = new ArrayList<>();
    }

    // Create a new order with a product and add it to the list of orders
    // public void createOrder(Product productOrdered) {
    //     order newOrder = new order(); // Create a new order instance
    //     newOrder.addProduct(productOrdered); // Add the product to the order
    //     orders.add(newOrder); // Add the new order to the waiter's list
    //     System.out.println("Order created and added to the waiter's list.");
    // }
    public void addOrder(order order) {
        orders.add(order);
    }
    // Retrieve all orders assigned to this waiter
    public ArrayList<order> getOrdersReceived() {
        return new ArrayList<>(orders); // Return a copy to protect the internal list
    }

    // Calculate total income (10% of the total price of all orders)
    public double calculateExpense() {
        double totalExpense = 0.0;
        for (order ord : orders) {
            totalExpense += ord.calculateTotalPrice(); // Use order's total price
        }
        return totalExpense * 0.10+this.salary*this.taxRate; // Waiter gets 10% of the total
    }

    @Override
    public String toString() {
        return super.toString()+" is a waiter"+ " with salary "+this.salary;
    }


}
