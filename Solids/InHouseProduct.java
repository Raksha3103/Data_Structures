public class InHouseProduct extends Product {
    @Override
    public double getDiscount()
    {
        applyExtraDiscount();
        return discount;
    }
    public void applyExtraDiscount()
    {
        discount=discount*1.5;
    }
}