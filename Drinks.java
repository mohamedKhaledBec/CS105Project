public class Drinks extends Product{
    
    
    public Drinks(String name, double purchasePrice, double sellingPrice) {
        super(name, purchasePrice, sellingPrice,0);
    }

    public double calculateExpenses() {
        return getPurchasePrice();
        
    }

}
