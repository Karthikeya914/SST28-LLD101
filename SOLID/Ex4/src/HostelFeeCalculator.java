import java.util.*;

public class HostelFeeCalculator {

    private final List<PricingComponent> pricingComponents;
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(List<PricingComponent> pricingComponents,
                               FakeBookingRepo repo) {
        this.pricingComponents = pricingComponents;
        this.repo = repo;
    }

    public void process(BookingRequest req) {

        Money monthly = new Money(0.0);
        for (PricingComponent pc : pricingComponents) {
            monthly = monthly.plus(pc.monthlyCharge(req));
        }

        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }
}