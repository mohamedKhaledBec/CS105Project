public class Dessert extends Product {


    public Dessert(String name, double purchasePrice, double sellingPrice, double utilityCost) {
        super(name, purchasePrice, sellingPrice, utilityCost);
    }

    public double calculateExpense() {
        return getPurchasePrice()+getUtilityCost();
        
    }

}
