import java.util.ArrayList;
import java.util.Random;

public class CoffeeShop {

    private ArrayList<Employee> empList;
    private ArrayList<Barista> barList;
    private ArrayList<Waiter> waiList;
    private ArrayList<order> orderList;
    private static ArrayList<Product> productsList;
    private int nextEmployeeId;

    public CoffeeShop() {
        empList = new ArrayList<>();
        barList = new ArrayList<>();
        waiList = new ArrayList<>();
        orderList = new ArrayList<>();
        productsList = new ArrayList<>();
        nextEmployeeId = 1;
        initProducts(); // Initialize sample products
    }

    private int generateEmployeeId() {
        return nextEmployeeId++;
    }

    public void addBarista(String name, double salary) {
        Barista barista = new Barista(generateEmployeeId(), name, salary);
        barList.add(barista);
        empList.add(barista);
    }

    public void addWaiter(String name) {
        Waiter waiter = new Waiter(generateEmployeeId(), name);
        waiList.add(waiter);
        empList.add(waiter);
    }

    public Waiter assignWaiter() {
        Random random = new Random();
        if (waiList.isEmpty()) {
            System.out.println("No waiters available!");
            return null;
        }
        return waiList.get(random.nextInt(waiList.size()));
    }

    public void listEmployees() {
        System.out.println("Employees:");
        for (Employee emp : empList) {
            System.out.println(emp.toString());
        }
    }



    public double calculateExpenses() {
        double totalExpenses = 0;
        for (Employee emp : empList) {
            totalExpenses += emp.calculateExpense();
        }
        for (order ord : orderList) {
            totalExpenses += ord.calculateTotalExpense();
        }
        return totalExpenses;
    }

    public double calculateRevenue() {
        double totalRevenue = 0.0;
        for (order ord : orderList) {
            for (Product prod : ord.getOrderedProducts()) {
                totalRevenue += prod.getSellingPrice();
            }
        }
        return totalRevenue-this.calculateExpenses();
    }

    public void initProducts() {
        // Sample individual products
        productsList.add(new Food("Sandwich", 3.0, 5.0, 1.0));
        productsList.add(new Dessert("Cake", 2.0, 4.0, 1.5));
        productsList.add(new Drinks("Coffee", 1.0, 3.0));

        // Menu
        menuOfProducts breakfastMenu = new menuOfProducts("Breakfast Combo");
        breakfastMenu.addProduct(productsList.get(0)); // Sandwich
        breakfastMenu.addProduct(productsList.get(2)); // Coffee
        breakfastMenu.calculateMenuPrice(); // Calculate price based on logic
        productsList.add(breakfastMenu); // Add the menu to the products list


        menuOfProducts lunchMenu = new menuOfProducts("lunch Combo");
        breakfastMenu.addProduct(productsList.get(0)); // Sandwich
        breakfastMenu.addProduct(productsList.get(2)); // Coffee
        breakfastMenu.calculateMenuPrice(); // Calculate price based on logic
        productsList.add(breakfastMenu); 
    }

    public void listProducts() {
        System.out.println("Available Products:");
        int enumerate=1;
        for (Product product : productsList) {
            if (product instanceof menuOfProducts) {
                System.out.println(enumerate+"- Menu: " + product.getName());
                ((menuOfProducts) product).listMenuProducts();
                enumerate++;
            } else {
                System.out.println(enumerate+"- " + product.getName() + " ($" + product.getSellingPrice() + ")");
            enumerate++;
            }
        }

    }
    
    public void addProduct(String name, double purchasePrice, double sellingPrice, double utilityCost,String type,ArrayList<Integer> productsIds) {
        switch (type) {
            case "Food": 
                productsList.add(new Food(name, purchasePrice, sellingPrice, utilityCost));
                break;
            case "Dessert":
                productsList.add(new Dessert(name, purchasePrice, sellingPrice, utilityCost));
                break;
            case "Drinks":
                productsList.add(new Drinks(name, purchasePrice, sellingPrice));
                break;
            case "Menu":
            menuOfProducts breakfastMenu = new menuOfProducts("Breakfast Combo");
            breakfastMenu.addProduct(productsList.get(0)); // Sandwich
            breakfastMenu.addProduct(productsList.get(2)); // Coffee
            breakfastMenu.calculateMenuPrice(); // Calculate price based on logic
            
                menuOfProducts menu = new menuOfProducts(name);
                for (Integer id : productsIds) {
                    menu.addProduct(productsList.get(id));
                }
                menu.calculateMenuPrice();
                productsList.add(menu);
                break;
            default:
                throw new AssertionError();
        }
    }
    public void configMenu(ArrayList<Integer> menu , menuOfProducts menuOfProducts){
        for (int i = 0; i < menu.size(); i++) {
            menuOfProducts.addProduct(productsList.get(menu.get(i)));
        }
    }
    public static ArrayList<Product> getProducts() {
        return productsList;
    }

    public void addOrder(order order) {
        orderList.add(order);
        
    }

    public ArrayList<Barista> getBarList() {
        return barList;
    }

    public ArrayList<Waiter> getWaiList() {
        return waiList;
    }
}
