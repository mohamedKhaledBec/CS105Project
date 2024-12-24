import java.util.ArrayList;

public class menuOfProducts extends Product  {
    private static ArrayList<Product> products;

    public menuOfProducts(String name) {
        super(name);
        this.products=new ArrayList<>();
    }
    public void addProduct(Product product){
        products.add(product);
    }

    @Override
    public double calculateExpense() {
        double totalExpense=0;
         for(Product product : products){
             totalExpense+=product.calculateExpense();
         }
        return totalExpense;
        
    }
    public void calculateMenuPrice(){
        double totalSellingPrice=0;
        for(Product product : products){
            //discount is not needed here and can be remomved or costomed 
            //discount was just an example for the restaurant type we are free to choose our values and alter whatever we want
            double discount=0;
            if(product instanceof Food){
                discount=0.1;
            }else if(product instanceof Dessert){
                discount=0.2;
            }else if(product instanceof Drinks){
                discount=0.5;
            }
            totalSellingPrice+=Product.getSellingPrice()*(1-discount);
        }
        
        setSellingPrice(totalSellingPrice);
    }

    //
    public void listMenuProducts() {
        System.out.println("Menu Products:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + Product.getSellingPrice() + ")");
        }
    }

// <<<<<<< Updated upstream
// =======
    public  static ArrayList<Product> getProducts() {
        return menuOfProducts.products;
    }

// >>>>>>> Stashed changes
}
