public class Drinks extends Product{

    
    public Drinks(String name, double purchasePrice, double sellingPrice, double utilityCost) {
        super(name, purchasePrice, sellingPrice, utilityCost);
    }

    public double calculateExpenses() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
