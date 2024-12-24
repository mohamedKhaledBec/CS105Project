import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeShop coffeeShop = new CoffeeShop();

        while (true) {
            System.out.println("\n=== Coffee Shop Application ===");
            System.out.println("1. Create Order");
            System.out.println("2. Manage Coffee Shop");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createOrder(scanner, coffeeShop);
                    break;
                case 2:
                    manageCoffeeShop(scanner, coffeeShop);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createOrder(Scanner scanner, CoffeeShop coffeeShop) {
        System.out.println("\n--- Create Order ---");
        order order = new order();

        while (true) {
            System.out.println("\nMenu:");
            coffeeShop.listProducts();// List all available products
            System.out.print("Enter product ID to add to the order (or 0 to finish): ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // if (productId == 0) break;

            // Product product = coffeeShop.getProducts().stream()
            //         .filter(p -> p.getId() == productId) // Assuming `getId()` exists in `Product`
            //         .findFirst()
            //         .orElse(null);

            // if (product != null) {
            //     order.addProduct(product);
            //     System.out.println(product.getName() + " added to the order.");
            // } else {
            //     System.out.println("Invalid product ID. Please try again.");
            // }
        }

        // if (!order.getOrderedProducts().isEmpty()) {
        //     Waiter waiter = coffeeShop.assignWaiter();
        //     if (waiter != null) {
        //         waiter.createOrder(order);
        //         System.out.println("Order created and assigned to " + waiter.getName() + ".");
        //     } else {
        //         System.out.println("No waiters available to assign the order.");
        //     }
        // } else {
        //     System.out.println("No products added. Order not created.");
        // }
    }

    private static void manageCoffeeShop(Scanner scanner, CoffeeShop coffeeShop) {
        while (true) {
            System.out.println("\n--- Manage Coffee Shop ---");
            System.out.println("1. List Employees");
            System.out.println("2. Add Barista");
            System.out.println("3. Add Waiter");
            System.out.println("4. Calculate Expenses");
            System.out.println("5. Calculate Revenue");
            System.out.println("6. Return to Main Menu");
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
                    coffeeShop.addBarista(baristaName, baristaSalary);
                    System.out.println("Barista added.");
                    break;
                case 3:
                    System.out.print("Enter waiter's name: ");
                    String waiterName = scanner.nextLine();
                    coffeeShop.addWaiter(waiterName);
                    System.out.println("Waiter added.");
                    break;
                case 4:
                    System.out.println("Total Expenses: $" + coffeeShop.calculateExpenses());
                    break;
                case 5:
                    System.out.println("Total Revenue: $" + coffeeShop.calculateRevenue());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
