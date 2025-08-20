package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class RolePage extends BasePage {

    public RolePage(WebDriver driver) {
        super(driver);
    }

    // Locators  //span[text()='Add Role']
    @FindBy(xpath = "//span[text()='Add Role']")
    WebElement addRole;

   // @FindBy(xpath = "//label[text()='Name']/following::input[1]")

    @FindBy(id = "roles_roleName")
    WebElement rolename;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement rolesubnit;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/section/div/div/main/section/div[4]/button[2]/span")
    WebElement nxtEmp;

    @FindBy(xpath = "//span[text()='Previous']")
    WebElement previousToRole;

    @FindBy(xpath = "//button[contains(@class,'MuiIconButton-root')])[5]")
    WebElement firstIcon;

    @FindBy(xpath = "//input[@name='roleName']")
    WebElement r1;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement s1;

    @FindBy(css="#__next > div:nth-child(2) > section > div > div > main > section > div:nth-child(3) > div > div > div.ant-table-wrapper.custom-antd-table.css-3rel02 > div > div > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > svg")
    WebElement firstEdit;

    @FindBy(css = "#__next > div > section > div > div > main > section > div:nth-child(3) > div > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiTableContainer-root.css-13xy2my > table > tbody > tr:nth-child(2) > td:nth-child(2) > div > button > svg")
    WebElement secondEdit;

    @FindBy(id = "roles_roleName")
    WebElement Data1;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submit1;


    //  Method to add a role (without verifying immediately)
    public void add(String roleName) throws InterruptedException {
        Thread.sleep(1000);
        addRole.click();
        Thread.sleep(1000);
        //   rolename.clear();
        rolename.sendKeys(roleName);
        Thread.sleep(1000);
        rolesubnit.click();
        Thread.sleep(1500); // Wait for table refresh
    }


    // ✅ Method to add a Role, handle duplicate role scenario, print message and continue with next test cases
  /*  public void add(String roleName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By addRoleButton = By.xpath("//button[text()='Add Role']");
        By roleNameInput = By.xpath("//input[@name='roleName']");
        By submitButton = By.xpath("//button[text()='Submit']");
        By duplicateError = By.xpath("//*[contains(text(), 'already exists') or contains(text(), 'duplicate')]");
        By closeButton = By.xpath("//button[text()='Close' or text()='CLOSE']");

        try {
            // 1️⃣ Click the Add Role button
            wait.until(ExpectedConditions.elementToBeClickable(addRoleButton)).click();

            // 2️⃣ Fill Role Name field
            WebElement roleField = wait.until(ExpectedConditions.visibilityOfElementLocated(roleNameInput));
            roleField.clear();
            roleField.sendKeys(roleName);

            // 3️⃣ Click Submit
            driver.findElement(submitButton).click();

            // 4️⃣ Check for duplicate error message (soft handling)
            try {
                WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateError));
                System.out.println("⚠ Duplicate Role Error Message for role '" + roleName + "': " + errorMsg.getText());

                // ✅ Close the modal so we can continue tests
                WebElement closeBtn = driver.findElement(closeButton);
                closeBtn.click();
                System.out.println("✅ Modal closed after duplicate role. Continuing with next test case...");
            } catch (TimeoutException te) {
                // No duplicate error shown - role likely added successfully
                System.out.println("✅ Role '" + roleName + "' added successfully (no duplicate found). ");
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to add role: '" + roleName + "'. Error: " + e.getMessage());
        }
    }*/


    //  Final verification after all roles added
    public void verifyRolesInTable(List<String> expectedRoles) {
        for (String role : expectedRoles) {
            try {
                WebElement nameCell = driver.findElement(By.xpath("//td[text()='" + role + "']"));
                Assert.assertEquals("Role name not matched!", role, nameCell.getText());
                System.out.println("Role '" + role + "' found in table.");
            } catch (Exception e) {
                System.out.println("Role '" + role + "' NOT found in table.");
                Assert.fail("Missing role: " + role);
            }
        }
    }

    public void nextBtn() throws InterruptedException {
        // System.out.println("Checked entered data are equal in the list ");
        System.out.println("Next button on role page is displayed or not: " + nxtEmp.isDisplayed());
        Thread.sleep(1000);
        System.out.println("**************************************************************************");
        nxtEmp.click();
        System.out.println("Previous to role page :"+previousToRole.isDisplayed());
        previousToRole.click();
    }

    public void editclick(String data) throws InterruptedException {
        System.out.println("In role to add ..**");
        System.out.println("1st icon is visible : "+firstEdit.isDisplayed());
        Thread.sleep(1000);
        firstEdit.click();
        Thread.sleep(1000);
        System.out.println("Data1 is visible : "+Data1.isDisplayed());
        Data1.clear();
        Data1.sendKeys(data);
        submit1.click();
//        System.out.println("2nd icon is visible : "+secondEdit.isDisplayed());
//        secondEdit.click();
//        Thread.sleep(1000);
//        System.out.println("Data2 is visible : "+Data1.isDisplayed());
//        Data1.clear();
//        Data1.sendKeys(data2);
//        System.out.println("---------");
//        submit1.click();
    }


  /*  public void verifyEditRole(List<String> lisEdi) {
        for (String role : lisEdi) {
            try {
                WebElement nameCell = driver.findElement(By.xpath("//td[text()='" + role + "']"));
                Assert.assertEquals("Role name not matched!", role, nameCell.getText());
                System.out.println("Role '" + role + "' found in table.");
            } catch (Exception e) {
                System.out.println("Role '" + role + "' NOT found in table.");
                Assert.fail("Missing role: " + role);
            }
        }
    }*/

    public void toFindDuplicate(String role) {
        System.out.println("...In duplicate method...");
        try {
            addRole.click();
            rolename.clear();
            rolename.sendKeys(role);
            rolesubnit.click();

            // Check if duplicate role error appears
            handleDuplicateRolePopupAndMoveNext(role);

        } catch (Exception e) {
            System.out.println("⚠ Unexpected error while adding role '" + role + "': " + e.getMessage());
        }
    }

    public void handleDuplicateRolePopupAndMoveNext(String role) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'ant-modal-content')]")
            ));

            String popupText = popup.getText();
            System.out.println("❌ Duplicate role detected for '" + role + "': " + popupText);

            // Close popup
            WebElement closeBtn = popup.findElement(
                    By.xpath(".//button[@aria-label='Close' or contains(@class,'ant-modal-close')]")
            );
            closeBtn.click();
            System.out.println("✅ Closed duplicate popup successfully.");

            // 👉 Now move to next page
            moveToNextPage();

        } catch (TimeoutException e) {
            System.out.println("⚠️ No duplicate popup found for '" + role + "'.");
            moveToNextPage(); // still move forward
        } catch (Exception e) {
            System.out.println("⚠️ Popup handling error for '" + role + "': " + e.getMessage());
            moveToNextPage(); // try to continue
        }
    }


    public void moveToNextPage(){
        System.out.println("In next button in role page ");
        nxtEmp.click();
    }

}