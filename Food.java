public class Food extends Product {

    public Food(String name, double purchasePrice, double sellingPrice, double utilityCost) {
        super(name, purchasePrice, sellingPrice, utilityCost);
    }

 
    public double calculateExpenses() {
        return getPurchasePrice()+getUtilityCost();
    }

}
