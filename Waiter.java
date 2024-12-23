import java.util.ArrayList;
public class Waiter extends Employee {
    private ArrayList<order> orders;

    public Waiter(int id, String name){
        super(id, name);
        this.orders = new ArrayList<>();
    }
    public void createOrder(order productordered){
        orders.add(productordered);
    }
    public ArrayList<order> getOrdersReceived(){
        return orders;
    }
    public double calculateExpense(){
        double totalExpense = 0.0;
        for (order productordered : orders){
            totalExpense += order.sellingPrice();
        }
        return totalExpense*0.10;


    }
    
}
