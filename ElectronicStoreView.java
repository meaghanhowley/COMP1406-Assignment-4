public interface ElectronicStoreView {

    // Displays the current state of the application
    void update(ElectronicStore store, Cart cart, int selectedStockIndex);

    // Displays the menu of possible actions
    void displayMenu();

    // Prompts the user to choose a menu option
    int promptMenuChoice();

    // Prompt helpers
    String promptString(String prompt);
    int promptInt(String prompt, int min, int max);

    // Display a message to the user
    void showMessage(String message);
}