package beverages;

public class Cream extends SupplementDecorator {
    public Cream(Beverage base) {
        super(base);
    }

    public double price() {
        return base.price() + 0.15;
    }
}
