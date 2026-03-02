public class SingleRoomPricing implements PricingComponent {

    @Override
    public Money monthlyCharge(BookingRequest req) {
        if (req.roomType == LegacyRoomTypes.SINGLE) {
            return new Money(14000.00);
        }
        return new Money(0.00);
    }
}