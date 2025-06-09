package beverages;

public class Cinnamon extends SupplementDecorator {
    public Cinnamon(Beverage base) {
        super(base);
    }

    public double price() {
        return base.price() + 0.05;
    }
}
