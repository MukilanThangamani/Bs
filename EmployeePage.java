package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeePage extends BasePage {

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//span[text()='Add Employee']")
    WebElement empbtn;

    @FindBy(id = "boutique_name")
    WebElement empName;

    @FindBy(xpath = "//*[@id=\"boutique_roleId\"]")
    WebElement roleDropdown;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div[1]/div/div/div[8]/div")
    WebElement role;

 /*
          //li[text()='Master']
          //li[text()='Tailor']
          //li[text()='Embroider']
          //li[text()='Designer']
          //li[text()='Finishers']
          //li[text()='Helpers']
          //li[text()='Delivery']
 * */

    @FindBy(xpath = "/html/body/div[7]/div/div[2]/div/div[2]/div/div[2]/form/div[1]/div[3]/div/div/div[2]/div/div/div")
    WebElement dob;

    @FindBy(xpath = "//*[@id=\"boutique_dateOfJoining\"]")
    WebElement doj;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div[1]/div[5]/div/div[1]/div[2]/div[1]/div/div/input")
    WebElement mobNum;

   @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div[1]/div[6]/div/div[1]/div[2]/div[1]/div/div/input")
   WebElement mobNum1;

    @FindBy(id = "boutique_password")
    WebElement pass;

    @FindBy(xpath = "//*[@id=\"boutique_gender\"]")
    WebElement genderDropdown;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/div/div/div[1]/div")
    WebElement genderMaleOption;


    @FindBy(xpath = "//span[text()='Submit']")
    WebElement subEmp;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;

    // Action
    public void empDetail() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(empbtn));
        System.out.println("Add emp button is displayed : " + empbtn.isDisplayed());
        Thread.sleep(2000);
        empbtn.click();

        wait.until(ExpectedConditions.visibilityOf(empName));
        System.out.println("Add emp name field is displayed : " + empName.isDisplayed());
        Thread.sleep(2000);
        empName.sendKeys(randomString());

        System.out.println("Role dropdown is visible: " + roleDropdown.isDisplayed());
        Thread.sleep(2000);
        roleDropdown.click();
        Thread.sleep(1000); // Optional, better to wait with WebDriverWait

        System.out.println("Clicking on 'role' option...");
        role.click();
        Thread.sleep(1000);
        dob.sendKeys("12/2/1982");
        Thread.sleep(1000);
        doj.sendKeys("16/09/2025");
        Thread.sleep(1000);

        mobNum.sendKeys(phoneRandom());
        Thread.sleep(1000);
        mobNum1.sendKeys(phoneRandom());
        Thread.sleep(1000);
        pass.sendKeys(randomAlphaAnumeric());

        System.out.println("Gender dropdown is visible: " + genderDropdown.isDisplayed());
        Thread.sleep(2000);
        genderDropdown.click(); // open dropdown
        Thread.sleep(1000); // or better: use WebDriverWait
        genderMaleOption.click();
        Thread.sleep(1000);
        System.out.println("Submit button is displayed: " + subEmp.isDisplayed());
        Thread.sleep(1000);
        subEmp.submit();
        System.out.println("Submit button is displayed: " + subEmp.isSelected());
    }

    public void nxtBtnEmp() throws InterruptedException {
        System.out.println("Next button is displayed: " + nextButton.isDisplayed());
        Thread.sleep(1000);
        nextButton.click();
    }

    public void verifyEmployeesInTable(String[] expectedNames, String[] expectedRoles) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 0; i < expectedNames.length; i++) {
            String name = expectedNames[i];
            String role = expectedRoles[i];

            try {
                // ✅ Wait for the row with matching Name and Role to appear in the table
                String xpath = "//td[normalize-space(text())='" + name + "']/following-sibling::td[normalize-space(text())='" + role + "']";
                WebElement roleCell = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

                // ✅ Validate Role text (Name is guaranteed by xpath, so no need to recheck Name again)
                Assert.assertEquals("Role not matched for " + name, role, roleCell.getText().trim());

                System.out.println("✅ Employee '" + name + "' with role '" + role + "' found in table.");
            } catch (Exception e) {
                System.out.println("❌ Employee '" + name + "' with role '" + role + "' NOT found in table.");
                Assert.fail("❌ Missing Employee: " + name + " | " + role);
            }
        }
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String phoneRandom() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaAnumeric() {
        String num = RandomStringUtils.randomNumeric(2);
        String nam = RandomStringUtils.randomAlphabetic(3);
        return nam + "@" + num;
    }

}
