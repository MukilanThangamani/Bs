package PageObjects;

import org.apache.logging.log4j.core.config.Order;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage extends BasePage{

    public OrderPage(WebDriver driver){
        super(driver);
    }

    //locators:
    @FindBy(xpath = "//span[text()=' Orders']")
    WebElement order;

    @FindBy(xpath = "//h3[text()='ThreadHeart']" )
    WebElement boutiques;

    @FindBy(xpath = "//li[text()='ThreadHeart']" )
    WebElement clickOneBoutique;

    @FindBy(xpath = "//button[text()='+ Create order']")
    WebElement createOrder;

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

    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//label[text()='Product Type']/following::div[contains(@class,'MuiInputBase-root')][1]")
    WebElement prodType;

    @FindBy(xpath = "//li[text()='Skirt']")
    WebElement productOption;

    @FindBy(xpath = "//input[contains(@name,'products.0.productName')]")
    WebElement productName;

    @FindBy(name = "products.0.deliveryDate")
    WebElement delDate;

    @FindBy(name = "products.0.productAmount")
    WebElement prodAmount;

    @FindBy(name = "products.0.rushOrder")
    WebElement rushorder;

    @FindBy(id="outlined-Length")
    WebElement length;

    @FindBy(id = "outlined-Waist")
    WebElement waisst;

    @FindBy(id = "outlined-Hip")
    WebElement hip;

    @FindBy(name = "products.0.notes")
    WebElement Notes;

    // @FindBy(id = "outlined-Thigh Circumference")
    //  WebElement outThigh;

    // @FindBy(id = "outlined-Knee Circumference")
    //  WebElement knee;

    //  @FindBy(id="outlined-Shoulder")
    //  WebElement shoulder;

  /*  @FindBy(xpath = "//span[text()='Embroid']")
    WebElement src;

    @FindBy(xpath = "//div[@data-rbd-droppable-id='steps-0']")
    WebElement tar;*/

    @FindBy(xpath = "//button[@type='button']/following::span[text()='Next']")
    WebElement nxtButton;

    @FindBy(xpath = "//span[text()='Previous']")
    WebElement previous;

    @FindBy(name = "orderAmount")
    WebElement orderamt;

    @FindBy(name = "advanceReceived")
    WebElement advance;

    @FindBy(xpath = "//button[text()='Create order']")
    WebElement orderSubmission;

    @FindBy(xpath = "//button[text()='Add item']")
    WebElement addItem;

    String naame,num;

    //Action
    public void orderModuleClient(String number,String name,String add) throws InterruptedException {
        naame = name;
        num=number;
        System.out.println("Order button is displayed or not :" + order.isDisplayed());
        Thread.sleep(1000);
        order.click();
        Thread.sleep(1000);
        System.out.println("Boutiques dropdown is visible :" + boutiques.isDisplayed());
        boutiques.click();
        Thread.sleep(1000);
        System.out.println("Boutique visible :" + clickOneBoutique.isDisplayed());
        Thread.sleep(1000);
        clickOneBoutique.click();
        System.out.println("Order button is displayed or not :" + createOrder.isDisplayed());
        createOrder.click();
        Thread.sleep(2000);
        System.out.println("Phone field is present:" + phoneNUmber.isDisplayed());
        phoneNUmber.sendKeys(number);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Client name field is enabled :" + clientName.isEnabled());
        clientName.sendKeys(name);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Address field is present or not :" + address.isDisplayed());
        address.sendKeys(add);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        System.out.println("Reference dropdown is displayed :" + ref.isDisplayed());
        ref.click();
        Thread.sleep(1000);
        referenceOption.click();
        Thread.sleep(1000);
        System.out.println("Next button in client details :" + nextButton.isDisplayed());
        nextButton.click();
    }

    public void checkValueOfOrderDetail() throws InterruptedException {
        System.out.println("Checking values of order details:");
        Thread.sleep(1000);
        String ph = phoneNUmber.getAttribute("value");
        System.out.println(ph);
        System.out.println("Entered PhNo:"+ph);
        Thread.sleep(1000);
        String cName = driver.findElement(By.name("clientName")).getAttribute("value");
        System.out.println("Entered client name :"+cName);
        Thread.sleep(1000);
        String addre = driver.findElement(By.name("address")).getAttribute("value");
        System.out.println("Entered address :"+addre);
        Thread.sleep(1000);
        String reference = driver.findElement(By.xpath("//select[@name='reference']")).getAttribute("value");
        System.out.println(reference);
        System.out.println("values checked completely in order page");
     }

     public void checkValueOfProductDetail(){
         System.out.println("Checking values of product details:");
         WebElement dropdown = driver.findElement(By.xpath("//div[@role='combobox']"));
         String selectedItem = dropdown.getText();
         System.out.println("Selected dropdown value: " + selectedItem);
         String Pname = driver.findElement(By.name("products.0.productName")).getAttribute("value");
         System.out.println("Entered value: " + Pname);
         String Ddate = driver.findElement(By.name("products.0.deliveryDate")).getAttribute("value");
         System.out.println("Entered value: " + Ddate);
         String pAmount = driver.findElement(By.name("products.0.productAmount")).getAttribute("value");
         System.out.println("Entered value: " + pAmount);
         String l = length.getAttribute("value");
         System.out.println("length :"+l);
         String w = waisst.getAttribute("value");
         System.out.println("Waaist:"+w);
         String H = hip.getAttribute("value");
         System.out.println("Hip:"+H);
         System.out.println("values checked completely in product page");
     }

     public void checkValueOfPaymentDetail(){
         System.out.println("Checking value in paymentDetail:");
         String amount = driver.findElement(By.name("orderAmount")).getAttribute("value");
         System.out.println("Order Amount: " + amount);
         String advanceReceived = driver.findElement(By.name("advanceReceived")).getAttribute("value");
         System.out.println("Advance Received: " + advanceReceived);
         System.out.println("Checking completed in paymentDetail:");
     }

    public void previousPage() throws InterruptedException {
        previous.click();
        System.out.println("Im in  order page ..");
        Thread.sleep(1200);
        checkValueOfOrderDetail();
        System.out.println("Next in my order page ..");
        checkValueOfProductDetail();
        nextButton.click();
    }

    public void previousPage1() throws InterruptedException {
        previous.click();
        System.out.println("In product detail");
        previous.click();
        Thread.sleep(1000);
        System.out.println("In order detail");
        System.out.println("In order detail next button is displayed:"+nextButton.isDisplayed());
        nextButton.click();
        Thread.sleep(1000);
        System.out.println("In product detail next button is displayed:"+nextButton.isDisplayed());
        nextButton.click();
    }

    public void ProductDetail(String productname,String date,String amount,String leen,String vaist,String hiip,String notes) throws InterruptedException {
        //span[text()='Previous']
        Thread.sleep(1000);
        System.out.println("Product type is displayed : "+prodType.isDisplayed());
        prodType.click();
        Thread.sleep(1000);
        productOption.click();
        Thread.sleep(1000);
        productName.sendKeys(productname);
        Thread.sleep(1000);
        delDate.sendKeys(date);
        Thread.sleep(1000);
        prodAmount.sendKeys(amount);
        System.out.println("checkbox is displayed :" + rushorder.isDisplayed());
        rushorder.click();
        Thread.sleep(2000);
        System.out.println("Length measurement is displayed :"+length.isDisplayed());
        length.sendKeys(leen);
        Thread.sleep(1000);
        System.out.println("waist measurement is displayed :"+waisst.isDisplayed());
        waisst.sendKeys(vaist);
        Thread.sleep(1000);
        System.out.println("hip measurement is displayed :"+hip.isDisplayed());
        hip.sendKeys(hiip);
        Thread.sleep(1000);
        System.out.println("Notes field is measurement :"+Notes.isDisplayed());
        Notes.sendKeys(notes);

      /*  outThigh.sendKeys(calf);
        Thread.sleep(1000);
        knee.sendKeys(hems);
        Thread.sleep(1000);
        shoulder.sendKeys(cro);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",src);
        Thread.sleep(500); // give time for scroll to complete
        src.click();
        Thread.sleep(1000);
        tar.click();
        Thread.sleep(1500);
        Actions builder = new Actions(driver);
        builder.dragAndDrop(src,tar).perform();*/

        System.out.println("Next button in product details :" + nxtButton.isDisplayed());
        Thread.sleep(1000);
        previousPage();
        Thread.sleep(1000);
        Thread.sleep(1000);
        nxtButton.click();
    }

    public void paymentDetails(String advamt) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Order amount is not enabled right :"+orderamt.isDisplayed());
        System.out.println("Order amount is not enabled right :"+orderamt.isEnabled());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Advance field is displayed :"+advance.isDisplayed());
        Thread.sleep(1000);
        advance.sendKeys(advamt);
        System.out.println("moving from payment to order");
        previousPage1();
        Thread.sleep(1000);
        checkValueOfPaymentDetail();
        System.out.println("rommed from payment to order and returned");
        System.out.println("Create order in order submit :"+orderSubmission.isDisplayed());
        Thread.sleep(1000);
        orderSubmission.submit();

        Thread.sleep(5000);
   /*      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();

       try{
            WebElement nameCell = driver.findElement(By.xpath("//div[text()='"+naame+"']"));
            WebElement nameCell1 = driver.findElement(By.xpath("//div[text()='"+num+"']"));
            String actualText = nameCell.getText();
            String actualText1 = nameCell1.getText();
            Assert.assertEquals(actualText,naame);
            Assert.assertEquals(actualText1,num);
            System.out.println("Client detail name and you've entered name :"+naame);
            System.out.println("Client detail name and you've entered name :"+"+91 "+num);
        }

        catch (Exception e){
            e.printStackTrace();
        }*/

    }
}