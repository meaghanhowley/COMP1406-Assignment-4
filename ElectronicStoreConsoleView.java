import java.util.Scanner;

public class ElectronicStoreConsoleView implements ElectronicStoreView {

    private Scanner scanner;

    public ElectronicStoreConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void update(ElectronicStore store, Cart cart, int selectedStockIndex) {
        System.out.println("\n" + store.getName());

        System.out.println("----------------------------------");

        System.out.println("Sales: " + store.getSales());
        System.out.println("Revenue: $" + store.getRevenue());
        System.out.println("$ / Sale: $" + store.getRevenuePerSale());

        printStock(store, selectedStockIndex);
        printCart(cart);
        printPopular(store);
    }

    private void printStock(ElectronicStore store, int selectedIndex) {
        System.out.println("\nStore Stock:");

        int count = 1;
        for (Product p : store.getStock()) {
            if (count-1 == selectedIndex) {
                System.out.println("-> " + count + ". " + p + " (" + p.getStockQuantity() + " in stock)");
            } else {
                System.out.println("   " + count + ". " + p + " (" + p.getStockQuantity() + " in stock)");
            }
            count++;
        }
    }

    private void printCart(Cart cart) {
        System.out.println("\nCurrent Cart ($" + cart.getTotal() + "):");

        if (cart.isEmpty()) {
            System.out.println("(empty)");
        } else {
            int count = 1;

            for (Product p: cart.getCartList()) {
                System.out.println(count + ". " + cart.getCartMap().get(p) + " x " + p);
                count++;
            }
        }
    }

    private void printPopular(ElectronicStore store) {
        System.out.println("\nMost Popular Items:");

        int count = 1;
        for (Product p : store.getPopular()) {
            System.out.println(count + ". " + p + " (" + p.getSoldQuantity() + " sold)");
            count++;
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. View Store Stock");
        System.out.println("2. Select Product");
        System.out.println("3. Add Selected Product to Cart");
        System.out.println("4. Remove Product from Cart");
        System.out.println("5. Complete Sale");
        System.out.println("6. Reset Store");
        System.out.println("7. Quit");
    }

    @Override
    public int promptMenuChoice() {
        return promptInt("Enter choice: ", 1, 7);
    }

    @Override
    public String promptString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    @Override
    public int promptInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max)
                    return value;
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}