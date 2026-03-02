public class MessAddOnPricing implements PricingComponent {

    @Override
    public Money monthlyCharge(BookingRequest req) {
        if (req.addOns.contains(AddOn.MESS)) {
            return new Money(1000.0);
        }
        return new Money(0.0);
    }
}