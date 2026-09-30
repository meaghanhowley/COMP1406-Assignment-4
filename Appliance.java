//Abstract class capturing shared state between Fridge and ToasterOven
public abstract class Appliance extends Product {
    private int wattage;
    private String color;
    private String brand;

    public Appliance(double initPrice, int initQuantity, int initWattage, String initColor, String initBrand) {
        super(initPrice, initQuantity);
        this.wattage = initWattage;
        this.color = initColor;
        this.brand = initBrand;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public int getWattage() {
        return wattage;
    }
}