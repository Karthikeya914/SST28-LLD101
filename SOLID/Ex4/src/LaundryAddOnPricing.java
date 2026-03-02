public class LaundryAddOnPricing implements PricingComponent {

    @Override
    public Money monthlyCharge(BookingRequest req) {
        if (req.addOns.contains(AddOn.LAUNDRY)) {
            return new Money(500.0);
        }
        return new Money(0.0);
    }
}