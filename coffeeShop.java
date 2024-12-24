import java.util.ArrayList;
import java.util.Random;

public class CoffeeShop {

    private ArrayList<Employee> empList;
    private ArrayList<Barista> barList;
    private ArrayList<Waiter> waiList;
    private ArrayList<order> orderList;
    private ArrayList<Product> productsList;
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
            totalExpenses += ord.calculateTotalPrice();
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
        return totalRevenue;
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
    }

    public void listProducts() {
        System.out.println("Available Products:");
        for (Product product : productsList) {
            if (product instanceof menuOfProducts) {
                System.out.println("Menu: " + product.getName());
                ((menuOfProducts) product).listMenuProducts();
            } else {
                System.out.println("- " + product.getName() + " ($" + product.getSellingPrice() + ")");
            }
        }
    }

    public ArrayList<Product> getProducts() {
        return productsList;
    }
}
