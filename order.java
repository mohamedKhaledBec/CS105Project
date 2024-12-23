
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
        ArrayList<Product> products1 = menuOfProducts.getProducts();
        System.out.println(products1);
    }


    ArrayList<Product> getOrderedProducts() {
        return purchaseList;
    }

    double calculateTotalPrice() {
        double totalPrice=0.0;
        for (Product product : purchaseList) {
            totalPrice=+product.calculateExpense();
        }
        return totalPrice;
    }
    
}
