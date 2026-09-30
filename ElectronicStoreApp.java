public class ElectronicStoreApp {

    public static void main(String[] args) {
        ElectronicStore store = ElectronicStore.createStore();
        Cart cart = new Cart();
        ElectronicStoreView view = new ElectronicStoreConsoleView();

        ElectronicStoreController controller =
                new ElectronicStoreController(store, cart, view);

        controller.start();
    }
}