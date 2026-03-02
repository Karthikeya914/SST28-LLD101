public class GymAddOnPricing implements PricingComponent {

    @Override
    public Money monthlyCharge(BookingRequest req) {
        if (req.addOns.contains(AddOn.GYM)) {
            return new Money(300.0);
        }
        return new Money(0.0);
    }
}