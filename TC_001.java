//package TestBase;
//
//import PageObjects.*;
//import net.bytebuddy.utility.RandomString;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.testng.annotations.*;
//import java.time.Duration;
//import java.util.*;
//
//
//public class TC_001 extends BaseClass {
//
//    @Test(priority = 1)
//    public void testHomePageAndClickLogin() throws InterruptedException {
//        logger.info("In home page");
//
//        //login button visible
//        boolean w = driver.findElement(By.linkText("Start Free Trial →")).isDisplayed();
//        System.out.println("login button visible:" + w);
//
//        LogoPage lo = new LogoPage(driver);
//        lo.clickLogin();
//
//        logger.info("TestCase 1 passed");
//    }
//
//    //https://fabriplay.com/settings/boutique?id=502BoutiquePage bp = new BoutiquePage(driver);
//    @Test(priority = 2)
//    public void testLoginFunctionality() throws InterruptedException {
//        LoginPage lp = new LoginPage(driver);
//        lp.setPhonenumber("6369188818");
//        lp.setPassword("Mukilan@2003");
//        lp.clickLogin();
//
//        logger.info("Login successful");
//        logger.info("TestCase 2 passed");
//    }
//
//    @Test(priority = 3)
//    public void testDashboardAccess() throws InterruptedException {
//        DashboardPage dp = new DashboardPage(driver);
//        dp.clkSetting();
//
//        logger.info("On dashboard page");
//        logger.info("TestCase 3 passed");
//    }
//
//    @Test(priority = 4)
//    public void testAddNewBoutique() throws InterruptedException {
//        BoutiquePage bp = new BoutiquePage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        bp.clickAddBoutique();
//
//        //   bp.nextInB();
//        //  bp.nxt();
//        //   bp.addRole("res","rew",":fde");
//        logger.info("In creating of new boutique");
//        logger.info("TestCase 4 passed");
//    }
//
//    @Test(priority = 5)
//    public void shopDetails() throws InterruptedException {
//        BoutiquePage bm = new BoutiquePage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//   /*    bm.enterShopName("The Atelier Edi");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//       bm.enterLegalName("Looms");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//       bm.enterNickName("Maison");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//       bm.enterGst("HDJH373893HD");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//       bm.address("G-8","1/321,chennai","Chennai","Tamilnadu","636 012","7483947383");  */
//        bm.nextInB();
//    }
//
//    @Test(priority = 6)
//    public void testAddRoleAndEmployee() throws InterruptedException {
//        RolePage rp = new RolePage(driver);
//        List<String> expectedRoles = Arrays.asList("Master", "Tailor", "Designer", "Finishers", "Helpers", "Delivery");
//
//        /*for (String role : expectedRoles) {
//            rp.add(role);
//        }
//        rp.verifyRolesInTable(expectedRoles);
//        */
//        rp.nextBtn();
//        //-----------above for final execution--------------------//
//
//        //this is for edit.
//        String[] roles = {randomString(),randomString()};
//        rp.editclick(roles[0],roles[1]);
//
//        //For duplicate
//        // Add to RolePage class
//        rp.toFindDuplicate("master");
//        rp.printDuplicateRoleErrorMessage();
//        System.out.println("Between testcase occur and next page");
//        rp.moveToNextPage();
//
//
//        EmployeePage ep = new EmployeePage(driver);
//
//        String[] names = {randomString(), randomString()};
//        String[] role = {"Master","Tailor"};
//        String[] mobiles = {phoneRandom(), phoneRandom()};
//        String[] passwords = {randomAlphaAnumeric(), randomAlphaAnumeric()};
//        String[] gender = {"Female","Male"};
//
//// Add employees
//        for (int i = 0; i < 2; i++) {
//            ep.empDetail(names[i], role[i], mobiles[i], passwords[i], gender[i]);
//        }
//
//// ✅ Verify employees are present in table
//        ep.verifyEmployeesInTable(names, role);
//
//// Continue to next page
//        ep.nxtBtnEmp();
//
//    }
//
//    @Test(priority = 7)
//    public void testTaskSettings() throws InterruptedException {
//        TaskSettingPage tp = new TaskSettingPage(driver);
//        String[] taskname = {randomString(),randomString(),randomString(),randomString()};
//        String[] charge = {randomAmount(),randomAmount(),randomAmount(),randomAmount()};
//        //li[text()='Master']
//        String[] role = {"Master","Tailor"};//,"Embroider","Designer"
//
//        for(int i=0;i<2;i++){
//            tp.setAddTask(taskname[i],charge[i],role[i]);
//        }
//
//        tp.verifyTasksInTable(taskname, charge);
//
//        Thread.sleep(1000);
//        //For Duplicate.
//        String[] tasks = {"RSTbd",randomAmount(),"Master"};
//        tp.addTask(tasks[0],tasks[1],tasks[2]);
//
//        tp.printDuplicateTaskErrorMessage();
//        tp.nextInTask();
//        System.out.println("➡ Continue with the next test case...");
//
//        ProductPage pp = new ProductPage(driver);
//     /*   String[] prod = {"Blouse","Kurta","Skirt","Pant"};//"Tops / Dresses","Others"
//        String[] gen = {"Female","Female","Female","Male"};
//        for(int i=0;i<4;i++) {
//            pp.addProduct(prod[i],gen[i]);
//        }*/
//        // Optionally click back
//        pp.backButton();
//    }
//
//    /*
//    @Test(priority = 8)
//    public void testOrderPage() throws InterruptedException{
//        OrderPage op = new OrderPage(driver);
//        Thread.sleep(1000);
//      //  op.orderModuleClient(phoneRandom(),randomString(),randomString());
//      //  op.ProductDetail(randomString(),"27/07/2025",randomNumber(),randomLength(),randomLength(),randomLength());
//      //  op.paymentDetails(randomAmount());
//     //   System.out.println("***Order successfully created***");
//    }
//
//    @Test(priority = 9)
//    public void testCrm() throws InterruptedException {
//        CrmPage cp = new CrmPage(driver);
//        cp.clickCrm("Mallika","8575656565","FB","1/432,chennai,AnnaNagar","Alteration process");
//      //  cp.measurement("9","8","9","8","8","8","9","8","8","9","8","9","9","9","9","8","8","9");
//        cp.search("Ashim");
//    }*/
//
//    public String randomString(){
//        String s1 =  RandomStringUtils.randomAlphabetic(5);
//        return s1;
//    }
//
//    public String randomNumber(){
//        String s1 = RandomStringUtils.randomNumeric(5);
//        return s1;
//    }
//
//    public String phoneRandom(){
//        String ph = RandomStringUtils.randomNumeric(10);
//        return ph;
//    }
//
//    public String randomLength(){
//        String  len = RandomStringUtils.randomNumeric(2);
//        return len;
//    }
//
//    public String randomAmount(){
//        String  amt = RandomStringUtils.randomNumeric(3);
//        return amt;
//    }
//
//    public String randomAlphaAnumeric(){
//        String  num = RandomStringUtils.randomNumeric(2);
//        String nam = RandomStringUtils.randomAlphabetic(3);
//        return nam+"@"+num;
//    }
//
//}