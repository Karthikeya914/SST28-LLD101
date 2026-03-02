public class DoubleRoomPricing implements PricingComponent {

    @Override
    public Money monthlyCharge(BookingRequest req) {
        if (req.roomType == LegacyRoomTypes.DOUBLE) {
            return new Money(15000.0);
        }
        return new Money(0.0);
    }
}