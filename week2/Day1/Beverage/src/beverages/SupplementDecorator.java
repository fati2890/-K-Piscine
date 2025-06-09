package beverages;

public abstract class SupplementDecorator implements Beverage {
    protected Beverage base;

    public SupplementDecorator(Beverage base) {
        this.base = base;
    }
}
