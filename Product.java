public abstract class Product implements Expense {
    private String name;
    private double purchasePrice;
    private static double sellingPrice; 
    private double utilityCost;

    protected Product(String name, double purchasePrice, double sellingPrice, double utilityCost) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.utilityCost = utilityCost;
    }

    protected Product(String name) {
        this(name, 0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public static double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getUtilityCost() {
        return utilityCost;
    }

    public void setUtilityCost(double utilityCost) {
        this.utilityCost = utilityCost;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', purchasePrice=" + purchasePrice + 
               ", sellingPrice=" + sellingPrice + ", utilityCost=" + utilityCost + "}";
    }

    @Override
    public abstract double calculateExpense();
}
