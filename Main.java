import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main { 
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    

    public static void mainScreen(CoffeeShop coffeeShop){
    
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
           
            
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        if ((coffeeShop.getBarList().isEmpty() || coffeeShop.getWaiList().isEmpty())) {
                            clearConsole();
                            System.out.println("No employees available to take orders!");
                            break;
                        }
                        else{
                        createOrder(scanner, coffeeShop);
                        break;}
                    case 2:
                        manageCoffeeShop(scanner, coffeeShop);
                        break;
                    case 3:
                        System.out.println("Exiting the application. Goodbye!");
                        return;
                    default:
                        clearConsole();
                        System.out.println("Invalid choice. Please try again.");
                }
    }
    public static void main(String[] args) {
        clearConsole();
        CoffeeShop coffeeShop = new CoffeeShop();

        while (true) {
            System.out.println("\n=== Coffee Shop Application ===");
            System.out.println("1. Create Order");
            System.out.println("2. Manage Coffee Shop");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
             try {
                mainScreen(coffeeShop);
                
            } catch (InputMismatchException e) {
                clearConsole();
                System.out.println("Invalid choice. ");
                
                
                }
        }
    }

    private static void createOrder(Scanner scanner, CoffeeShop coffeeShop) {
        clearConsole();
        System.out.println("\n--- Create Order ---");
        order order = new order();
        Waiter waiter =coffeeShop.assignWaiter();
        ArrayList<Product> products = CoffeeShop.getProducts();
        while (true) {
            try{
            
            System.out.println("\nMenu:");
            coffeeShop.listProducts(true); 
            System.out.print("Enter product ID to add to the order (or 0 to finish): ");
            int productId = scanner.nextInt();
            scanner.nextLine();
            
            try {
                order.addProduct(products.get(productId - 1));
            } catch (IndexOutOfBoundsException e) {
                if (productId == 0) {
                    order.listOrder();
                    
                    clearConsole();
                    System.out.println("Total Price: $" + order.calculateTotalPrice());
                    waiter.addOrder(order);
                    coffeeShop.addOrder(order);
                    break;
                }
                System.out.println("Invalid product ID. Please try again.");
            }
        
        }
        catch (Exception e) {
            System.out.println("Invalid choice. cancelling order.....");
            return;
        }}


    }

    private static void manageCoffeeShop(Scanner scanner, CoffeeShop coffeeShop) {
        clearConsole();
        while (true) {
            try{
            System.out.println("\n--- Manage Coffee Shop ---");
            System.out.println("1. List Employees");
            System.out.println("2. Add Barista");
            System.out.println("3. Add Waiter");
            System.out.println("4. Calculate Expenses");
            System.out.println("5. Calculate Revenue");
            System.out.println("6. Add Product");
            System.out.println("7. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    coffeeShop.listEmployees();
                    break;
                case 2:
                    System.out.print("Enter barista's name: ");
                    String baristaName = scanner.nextLine();
                    System.out.print("Enter barista's salary: ");
                    double baristaSalary = scanner.nextDouble();
                    if (baristaSalary < 0) {
                        clearConsole();
                        System.out.println("Invalid salary. Please try again.");
                        return;
                    }
                    coffeeShop.addBarista(baristaName, baristaSalary);
                    clearConsole();
                    System.out.println("Barista added.");
                    break;
                case 3:
                    System.out.print("Enter waiter's name: ");
                    String waiterName = scanner.nextLine();
                    System.out.print("Enter waiter's salary: ");
                    double waiterSalary = scanner.nextDouble();
                    if (waiterSalary < 0) {
                        clearConsole();
                        System.out.println("Invalid salary. Please try again.");
                        return;
                    }
                    coffeeShop.addWaiter(waiterName,waiterSalary);
                    clearConsole();
                    System.out.println("Waiter added.");
                    break;
                case 4:
                    clearConsole();
                    System.out.println("Total Expenses: $" + coffeeShop.calculateExpenses());
                    break;
                case 5:
                    clearConsole();
                    System.out.println("Total Revenue: $" + coffeeShop.calculateRevenue());
                    break;
                case 6:
                    clearConsole();
                    System.out.println("Select product type:");
                    System.out.println("1. Food");
                    System.out.println("2. Dessert");
                    System.out.println("3. Drink");
                    System.out.println("4. Menu");
                    System.out.print("Enter your choice (1/2/3/4): ");
                    int productTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    String productType;
                    switch (productTypeChoice) {
                        case 1:
                            productType = "Food";
                            break;
                        case 2:
                            productType = "Dessert";
                            break;
                        case 3:
                            productType = "Drink";
                            break;
                        case 4:
                            productType = "Menu";
                            break;
                        default:
                            System.out.println("Invalid choice! Defaulting to 'Food'.");
                            
                            return;
                    }
                    if (productType.equals("Menu")) {
                        System.out.print("Enter menu name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter the number of the products in the menu: (o to finish) ");
                        coffeeShop.listProducts(false);
                        ArrayList<Integer> productIDs = new ArrayList<>();
                        while (true) {
                            try {
                                int productID = scanner.nextInt();
                                if (productID == 0) {
                                    break;
                                }
                                productIDs.add(productID - 1);
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid product ID. Please try again.");
                                scanner.nextLine(); // Consume newline left-over
                            }
                            
                        }
                        String productID = scanner.nextLine();
                        // for (String s1 : productID.split("")) { // Split input by spaces
                        //     try {
                        //         int id = Integer.parseInt(s1); 
                        //         productIDs.add(id); 
                        //     } catch (NumberFormatException e) {
                               
                        //     }
                        // }
                   
                        System.out.println("Product to be added to the menu"+productIDs);

                        coffeeShop.addProduct(productName, 0, 0, 0,productType,productIDs);
                        
                        System.out.println("Menu added successfully!");
                        break;
                    }
                    else {
                        // Prompt for product details
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();

                        System.out.print("Enter selling price: $");
                        double sellingPrice = scanner.nextDouble();

                        System.out.print("Enter utility cost: $");
                        double utilityCost = scanner.nextDouble();

                        System.out.print("Enter purchase price: $");
                        double purchasePrice = scanner.nextDouble();

                        // Add product to the coffee shop
                        coffeeShop.addProduct( productName, purchasePrice, sellingPrice, utilityCost,productType,null);
                        System.out.println("Product added successfully!");

                
                    break;
                }
                case 7:
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        catch (Exception e) {
            clearConsole();
            System.out.println("Invalid choice. Please try again.");
            break;
        }}
    }
    
}
