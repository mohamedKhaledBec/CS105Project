import java.util.ArrayList;
public class Waiter extends Employee {
    private ArrayList<order> orders;

    public Waiter(int id, String name){
        super(id, name);
        this.orders = new ArrayList<>();
    }
    public void createOrder(Product productOrdered){
        order neworder = new order();
        neworder.addProduct(productOrdered);
        orders.add(neworder);
        System.out.println("Order created and added to the waiter's list.");
    }
    public ArrayList<order> getOrdersReceived(){
        return new ArrayList<>(orders);
    }
    public double calculateExpense(){
        double totalExpense = 0.0;
        for (order productordered : orders){
            totalExpense += order.sellingPrice();
        }
        return totalExpense*0.10;


    }
    
}
