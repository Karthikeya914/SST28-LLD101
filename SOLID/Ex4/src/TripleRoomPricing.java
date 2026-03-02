public class TripleRoomPricing implements PricingComponent {

    @Override
    public Money monthlyCharge(BookingRequest req) {
        if (req.roomType == LegacyRoomTypes.TRIPLE) {
            return new Money(12000.00);
        }
        return new Money(0.00);
    }
}