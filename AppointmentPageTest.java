package TestBase;

import PageObjects.AppointmentPage;
import org.testng.annotations.Test;

public class AppointmentPageTest extends BaseClass{
    @Test(priority = 12)
    public void testAppointment() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.clientDetails(phoneRandom(),randomString(),"River street ,karapakkam,indusland bank","Style consultation","Style consulting in boutique");
    }
}
