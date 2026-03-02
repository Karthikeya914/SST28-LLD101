// TransportBookingService.java
public class TransportBookingService {

    private final DistanceService distanceService;
    private final DriverAllocation driverAllocation;
    private final PaymentService paymentService;

    public TransportBookingService(
            DistanceService distanceService,
            DriverAllocation driverAllocation,
            PaymentService paymentService
    ) {
        this.distanceService = distanceService;
        this.driverAllocation = driverAllocation;
        this.paymentService = paymentService;
    }

    public void book(TripRequest req) {

        double km = distanceService.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = driverAllocation.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = 50.0 + km * 6.6666666667;
        String txn = paymentService.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        System.out.println("RECEIPT: R-501 | fare=" + String.format("%.2f", fare));
    }
}