package TestBase;

import PageObjects.RolePage;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class RolePageTest extends BaseClass {

    @Test(priority = 6)
    public void testAddRole() throws InterruptedException {
        RolePage rp = new RolePage(driver);
        List<String> expectedRoles = Arrays.asList(randomString(), randomString(), randomString());

      /*  for (String role : expectedRoles) {
            rp.add(role);
        }*/

        System.out.println("verifying data in the table");
    //    rp.verifyRolesInTable(expectedRoles);

        rp.nextBtn();
        //-----------above for final execution--------------------//
        //this is for edit.

        String[] roles = {randomString()};
        rp.editclick(roles[0]);
        //For duplicate
        // Add to RolePage class
        Thread.sleep(1000);
        rp.toFindDuplicate("master");
        System.out.println("Between testcase occur and next page");
        rp.moveToNextPage();

    }
}