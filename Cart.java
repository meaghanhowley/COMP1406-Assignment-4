// Represents the current customer's shopping cart.
// The cart tracks products that have been selected but not yet sold.
// It should not permanently modify the store until a sale is completed.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> items;

    public Cart() { this.items = new HashMap<>(); }

    public Map<Product, Integer> getCartMap() {return items; }

    public List<Product> getCartList() { return new ArrayList<>(items.keySet()); }

    public double getTotal() {
        double cartTotal = 0;

        for (Product p : items.keySet()) {
            cartTotal += p.getPrice() * items.get(p);
        }

        return cartTotal;
    }

    public void addProduct(Product p) {
        if (items.containsKey(p)) {
            items.put(p, items.get(p) + 1);
        } else {
            items.put(p, 1);
        }
    }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) {
            return;
        }

        if (items.get(p) <= 1) {
            items.remove(p);
        } else {
            items.put(p, items.get(p) - 1);
        }

    }

    public boolean isEmpty() { return items.isEmpty(); }

    public void clearCart() { items = new HashMap<>(); }

}