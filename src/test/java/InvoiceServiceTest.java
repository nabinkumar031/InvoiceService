import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    static InvoiceGenerator invoiceGenerator=null;

    @BeforeAll
    static void beforeAll() {
         invoiceGenerator =new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        //InvoiceGenerator invoiceGenerator =new InvoiceGenerator();

        double distance=2.0;
        int time = 5;

        double totalFare = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(25,totalFare,0.0);
    }

    @Test
    void givenLessDistanceAndTime_shouldReturnMinimumFare() {
        double distance=0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(5,totalFare,0.0);

    }

    @Test
    void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare =invoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(30,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnInvoiceSummary() {
        //InvoiceGenerator invoiceGenerator =new InvoiceGenerator();

        double distance=2.0;
        int time = 5;

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        InvoiceSummary invoiceSummary = invoiceGenerator.getSummary(rides);
        InvoiceSummary expectedInvoiceSummary =new InvoiceSummary(2,30);
        Assertions.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
}
