public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        double totalFare = distance*MINIMUM_COST_PER_KM + time*COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride:rides){
            totalFare+= this.calculateFare(ride.distance,ride.time);
        }
        return totalFare;
    }

    public InvoiceSummary getSummary(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides){
            totalFare+= this.calculateFare(ride.distance,ride.time);
        }

        return new InvoiceSummary(rides.length, totalFare);
    }
}