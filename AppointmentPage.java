package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentPage extends BasePage {

    public AppointmentPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//span[text()='Appointments']")
    WebElement appmodule;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/section/div/header/div/div[3]/button")
    WebElement scheduleApp;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement phoneNUmber;

    @FindBy(name = "clientName")
    WebElement clientName;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(xpath = "//select[@name='reference']")
    WebElement ref;

    @FindBy(xpath = "//option[text()='WhatsApp']")
    WebElement referenceOption;

    @FindBy(name = "purpose")
    WebElement purpose;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/section/div/div/main/section/section/section/section[2]/div[2]/div/div[2]/div[2]/div[6]/div[8]/div[1]")
    WebElement appointment;

    @FindBy(name = "notes")
    WebElement notes;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement subApp;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement closebtn;

    @FindBy(xpath = "body > div:nth-child(13) > div > div.ant-modal-wrap > div > div:nth-child(2) > div > button > span > span > svg")
    WebElement crossbtn;

    //Actions
    public void clientDetails(String num,String cname,String add,String pur,String not) throws InterruptedException {
        System.out.println("Appointment module button is displayed :"+appmodule.isDisplayed());
        appmodule.click();
        Thread.sleep(1000);
        System.out.println("Select then appointment slot is visible :"+appointment.isDisplayed());
        Thread.sleep(1000);
        appointment.click();
        Thread.sleep(1000);
        //  scheduleApp.click();
        //  Thread.sleep(1000);
        System.out.println("Phone number field is visible :"+phoneNUmber.isDisplayed());
        phoneNUmber.sendKeys(num);
        Thread.sleep(1000);
        System.out.println("Client name field is visible :"+clientName.isDisplayed());
        clientName.sendKeys(cname);
        Thread.sleep(1000);
        System.out.println("Address field is visible :"+address.isDisplayed());
        address.sendKeys(add);
        Thread.sleep(1000);
        System.out.println("Reference field is visible :"+ref.isDisplayed());
        ref.click();
        Thread.sleep(1000);
        System.out.println("Reference option field is visible :"+referenceOption.isDisplayed());
        referenceOption.click();
        Thread.sleep(1000);
        System.out.println("Purpose field is visible :"+purpose.isDisplayed());
        purpose.sendKeys(pur);
        Thread.sleep(1000);
        System.out.println("Notes field is visible :"+notes.isDisplayed());
        notes.sendKeys(not);
        Thread.sleep(1000);
        System.out.println("Submit button in appointment modal is visible :"+subApp.isDisplayed());
        subApp.submit();
        System.out.println("close button in appointment modal is visible :"+closebtn.isDisplayed());
      //  closebtn.click();
    }

}