package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver){
        super(driver);
    }

    //locator
    @FindBy(xpath = "//button[text()='Add Product Type']")
    WebElement prodBtn;

    @FindBy(xpath = "//div[text()='Others']")
    WebElement othClick;

    @FindBy(xpath = "//li[text()='Blouse']")
    WebElement clkBls;

    @FindBy(xpath = "//label[text()='Gender']/following::div[1]")
    WebElement genderdrp;

    @FindBy(xpath = "//li[text()='Female']")
    WebElement clkGender;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement subInProd;

    @FindBy(xpath = "//button[@type='button']/following::span[text()='Back']")
    WebElement backButton;

    //Action
    public void addProduct(String produc ,String gender) throws InterruptedException {
        System.out.println("Product button is visible or not :" + prodBtn.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        prodBtn.click();
        Thread.sleep(1000);
        othClick.click();
        Thread.sleep(1000);
        WebElement type = driver.findElement(By.xpath("//li[text()='"+produc+"']"));
        type.click();
        System.out.println("gender dropdown is disp or not :" + genderdrp.isDisplayed());
        genderdrp.click();
        Thread.sleep(1000);
        WebElement clkGender = driver.findElement(By.xpath("//li[text()='"+gender+"']"));
        clkGender.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)"); // Scrolls down 500 pixels
        System.out.println("submit btn is displayed or not :" + subInProd.isDisplayed());
        Thread.sleep(1000);
        subInProd.submit();
    }
    public void backButton() throws InterruptedException {
        System.out.println("Back button :"+backButton.isDisplayed());
        Thread.sleep(2000);
        backButton.click();

        //  Thread.sleep(2000);
        //  driver.navigate().refresh();
    }
}