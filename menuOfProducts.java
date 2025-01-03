import java.util.ArrayList;

public class menuOfProducts extends Product  {
    private  ArrayList<Product> products;

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
            
            double discount=0;
            if(product instanceof Food){
                discount=0.1;
            }else if(product instanceof Dessert){
                discount=0.2;
            }else if(product instanceof Drinks){
                discount=0.5;
            }
            totalSellingPrice+=product.getSellingPrice()*(1-discount);
        }
        
        this.setSellingPrice(totalSellingPrice);
    }

    //
    public void listMenuProducts() {
        calculateMenuPrice();
        for (Product product : products) {
            System.out.println("\t- " + product.getName() );

        }
        System.out.println("\tTotal Price: $" + this.getSellingPrice());
    }

// <<<<<<< Updated upstream
// =======
    public   ArrayList<Product> getProducts() {
        return this.products;
    }

// >>>>>>> Stashed changes
}
