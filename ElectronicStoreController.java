public class ElectronicStoreController {

    private ElectronicStore store;
    private Cart cart;
    private ElectronicStoreView view;

    private int selectedStockIndex;

    public ElectronicStoreController(ElectronicStore store, Cart cart, ElectronicStoreView view) {
        this.store = store;
        this.cart = cart;
        this.view = view;
        this.selectedStockIndex = 0;
    }

    public void start() {
        while (true) {
            view.update(store, cart, selectedStockIndex);
            view.displayMenu();

            int choice = view.promptMenuChoice();

            if (choice == 2) {
                handleSelect();
            } else if (choice == 3) {
                handleAdd();
            } else if (choice == 4) {
                handleRemove();
            } else if (choice == 5) {
                handleSale();
            } else if (choice == 6) {
                handleReset();
            } else if (choice == 7) {
                break;
            }
        }
    }

    private void handleSelect() {
        int max = store.getStock().size();
        selectedStockIndex = view.promptInt("\nEnter product number to select (1 - " + max + "): ",
                1, max) - 1;
    }

    private void handleAdd() {
        Product selected = store.getStock().get(selectedStockIndex);

        if (selected.getStockQuantity() > 0) {
            cart.addProduct(selected);
            selected.setStockQuantity(selected.getStockQuantity() - 1);
        } else {
            view.showMessage("\nOut of stock");
        }
    }

    private void handleRemove() {
        if (cart.isEmpty()) {
            System.out.println("\nCart is empty.");
        } else {
            int selectedCartIndex = view.promptInt("\nEnter product number to remove (1 - "+ cart.getCartList().size() + "): ",
                    1, cart.getCartList().size()) - 1;
            Product selectedProduct = cart.getCartList().get(selectedCartIndex);

            cart.removeProduct(selectedProduct);
            selectedProduct.setStockQuantity(selectedProduct.getStockQuantity() + 1);
        }
    }

    private void handleSale() {
        if (cart.isEmpty()) {
            System.out.println("\nCart is empty.");
        } else {
            store.sellCart();
            store.setRevenue(store.getRevenue() + cart.getTotal());

            for (Product p : cart.getCartList()) {
                p.setSoldQuantity(p.getSoldQuantity() + cart.getCartMap().get(p));
            }

            cart.clearCart();
        }
    }

    private void handleReset() {
        this.store = ElectronicStore.createStore();
        cart.clearCart();
    }
}