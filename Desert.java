public class Desert extends Product {


    public Desert(String name, double purchasePrice, double sellingPrice, double utilityCost) {
        super(name, purchasePrice, sellingPrice, utilityCost);
    }

    public double calculateExpenses() {
        return getPurchasePrice()+getUtilityCost();
        
    }

}
