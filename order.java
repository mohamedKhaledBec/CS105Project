
import java.util.ArrayList;
public class order {
    ArrayList<Product> purchaseList;

    order() {
        purchaseList = new ArrayList<>();
    }

    void addProduct(Product product) {
        purchaseList.add(product);
    }

    //menu page
    void listOrder() {
        
        for (Product product : purchaseList) {
            System.out.println(product);
        }
        
    }


    ArrayList<Product> getOrderedProducts() {
        return purchaseList;
    }

    double calculateTotalPrice() {
        double totalPrice=0.0;
        for (Product product : purchaseList) {
            totalPrice+=product.getSellingPrice();
            
        }
        
        return totalPrice;
    }
    double calculateTotalExpense() {
        double totalExpense=0;
        for(Product product : purchaseList){
            totalExpense+=product.calculateExpense();
        }
        return totalExpense;
        
    }

    
}
