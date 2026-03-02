import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        List<PricingComponent> pricingComponents = List.of(
            new SingleRoomPricing(),
            new DoubleRoomPricing(),
            new TripleRoomPricing(),
            new MessAddOnPricing(),
            new LaundryAddOnPricing(),
            new GymAddOnPricing()
        );

        HostelFeeCalculator calc =
            new HostelFeeCalculator(pricingComponents, new FakeBookingRepo());
        calc.process(req);
    }
}
