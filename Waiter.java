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

   
    public void addOrder(order order) {
        orders.add(order);
    }
    
    public ArrayList<order> getOrdersReceived() {
        return new ArrayList<>(orders); 
    }

    
    public double calculateExpense() {
        double totalExpense = 0.0;
        for (order ord : orders) {
            totalExpense += ord.calculateTotalPrice(); 
        }
        return totalExpense * 0.10 + this.salary*(1+this.taxRate); // Waiter gets 10% of the total
    }

    @Override
    public String toString() {
        return super.toString()+" is a waiter"+ " with salary "+this.salary;
    }


}
