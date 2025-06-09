package beverages;


public class Milk extends SupplementDecorator {
    public Milk(Beverage base) {
        super(base);
    }

    public double price() {
        return base.price() + 0.10;
    }
}
