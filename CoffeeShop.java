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

    public void addWaiter(String name,double salary) {
        Waiter waiter = new Waiter(generateEmployeeId(), name,salary);
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
        return totalRevenue*0.9;//10% is taken by the waiter the rest is the revenue
    }

    public void initProducts() {
        
        productsList.add(new Food("Sandwich", 3.0, 5.0, 1.0));
        productsList.add(new Dessert("Cake", 2.0, 4.0, 1.5));
        productsList.add(new Drinks("Coffee", 1.0, 3.0));

        // Menus
        menuOfProducts breakfastMenu = new menuOfProducts("Breakfast Combo");
        breakfastMenu.addProduct(productsList.get(0)); // Sandwich
        breakfastMenu.addProduct(productsList.get(2)); // Coffee
        breakfastMenu.calculateMenuPrice(); // Calculate price 
        productsList.add(breakfastMenu); // Add the menu to the products list


        menuOfProducts lunchMenu = new menuOfProducts("lunch Combo");
        lunchMenu.addProduct(productsList.get(0)); // Sandwich
        lunchMenu.addProduct(productsList.get(2)); // Coffee
        lunchMenu.calculateMenuPrice(); // Calculate price 
        productsList.add(lunchMenu); // Add the menu to the products list
    }

    public void listProducts(boolean showMenu) {
        System.out.println("Available Products:");
        int enumerate=1;
        for (Product product : productsList) {
            if (product instanceof menuOfProducts) {
                if (!showMenu) {
                    continue;
                }
                else {
                System.out.println(enumerate+"- Menu: " + product.getName());
                ((menuOfProducts) product).listMenuProducts();
                enumerate++;}
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
        
             
            
                menuOfProducts menu = new menuOfProducts(name);
                for (Integer id : productsIds) {
                   
                    if (productsList.get(id) instanceof menuOfProducts) {
                        for (Product product : ((menuOfProducts) productsList.get(id)).getProducts()) {
                            menu.addProduct(product);
                        }
                        
                    }

                    menu.addProduct(productsList.get(id));
                }
                menu.calculateMenuPrice();
                productsList.add(menu);
                break;
            default:
                throw new AssertionError();
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
