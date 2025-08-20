package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.model.WebAppManifest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class CrmPage extends BasePage{

    public CrmPage(WebDriver driver){
        super(driver);
    }

    //delete for full
    @FindBy(xpath = "//h3[text()='KumarTailor']" )
    WebElement boutiques;

    @FindBy(xpath = "//li[text()='Elise']" )
    WebElement clickOneBoutique;

    //Locator
    @FindBy(xpath = "//span[text()='CRM']")
    WebElement clickCrm;

    @FindBy(xpath = "//button[text()='+ Add New Customer']")
    WebElement addCustomer;

    @FindBy(name = "clientName")
    WebElement clientname;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement tele;

    @FindBy(name = "reference")
    WebElement ref;

    @FindBy(xpath = "//option[text()='Others']")
    WebElement refOption;

    @FindBy(name = "otherReference")
    WebElement otherName;

    @FindBy(name = "address")
    WebElement add;

    @FindBy(name = "preference")
    WebElement preference;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement subBtn;

    @FindBy(xpath = "//button[text()='Measurements']")
    WebElement meas;

    @FindBy(xpath = "//button[text()='Add Measurement']")
    WebElement addMeas;

    @FindBy(name = "products.0.productTypeId']")
    WebElement prodType;

    @FindBy(xpath = "(//tr[contains(@class,'MuiTableRow-root')]//td[last()]//button)[4]")
    WebElement editIcon;

    @FindBy(name = "products.0.measurements.0.value")
    WebElement lenfront;

    @FindBy(name = "products.0.measurements.1.value")
    WebElement lenBack;

    @FindBy(name = "products.0.measurements.2.value")
    WebElement shoulder;

    @FindBy(name = "products.0.measurements.3.value")
    WebElement sleeve;

    @FindBy(name = "products.0.measurements.4.value")
    WebElement armhole;

    @FindBy(name = "products.0.measurements.5.value")
    WebElement bicep;

    @FindBy(name = "products.0.measurements.6.value")
    WebElement sr;

    @FindBy(name = "products.0.measurements.7.value")
    WebElement thlen;

    @FindBy(name = "products.0.measurements.8.value")
    WebElement cutoff;

    @FindBy(name = "products.0.measurements.9.value")
    WebElement chest;

    @FindBy(name = "products.0.measurements.10.value")
    WebElement chestCir;

    @FindBy(name = "products.0.measurements.11.value")
    WebElement waist;

    @FindBy(name = "products.0.measurements.12.value")
    WebElement frontdept;

    @FindBy(name = "products.0.measurements.13.value")
    WebElement backdepth;

    @FindBy(name = "products.0.measurements.14.value")
    WebElement point;

    @FindBy(name = "products.0.measurements.15.value")
    WebElement shoulderdepth;

    @FindBy(name = "products.0.measurements.16.value")
    WebElement frontneck;

    @FindBy(name = "products.0.measurements.17.value")
    WebElement backneck;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement save;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement close;

    @FindBy(xpath = "//button[text()='Download Excel']")
    WebElement downloadExcel;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search;

    @FindBy(xpath = "//span[@aria-label='search']")
    WebElement searchIcon;

    //Action
    public void clickCrm(String name,String phone,String other,String address,String prefer){
        boutiques.click();

        clickOneBoutique.click();

        System.out.println("Crm button is visible :"+clickCrm.isDisplayed());
        clickCrm.click();

        System.out.println("Add customer button is displayed :"+addCustomer.isDisplayed());
        addCustomer.click();

        System.out.println("client name field is visible :"+clientname.isDisplayed());
        clientname.sendKeys(name);

        System.out.println("Phone number field is visible :"+tele.isDisplayed());
        tele.sendKeys(phone);

        System.out.println("Reference field is visible :"+ref.isDisplayed());
        ref.click();

        System.out.println("RefOption is visible :"+refOption.isDisplayed());
        refOption.click();

        System.out.println("Other field :"+otherName.isDisplayed());
        otherName.sendKeys(other);

        System.out.println("Address field is visible:"+add.isDisplayed());
        add.sendKeys(address);

        System.out.println("Preference field is visible:"+preference.isDisplayed());
        preference.sendKeys(prefer);

        System.out.println("Submit in client detail :"+subBtn.isDisplayed());
        System.out.println("Close button is visible :"+close.isDisplayed());
        close.click();

        //   subBtn.submit();  --> uncomment this for final execution
    }

    public void measurement(String lenfronts,String lenBacks,String shoulders,String sleeves,String armholes,String biceps,String srs
            ,String thlens,String cutoffs,String chests,String chestCirs,String waists,String frontdepts,String backdepths,String  points,String shoulderdepths,String frontnecks,
                            String backnecks) throws InterruptedException {

        System.out.println("Crm module is visible :"+clickCrm.isDisplayed());
        clickCrm.click();
        Thread.sleep(1200);
        //  editIcon.click();
        //  Thread.sleep(1200);
        System.out.println("measurement button is displayed :"+meas.isDisplayed());
        meas.click();
        Thread.sleep(1200);
        System.out.println("Add measurement button is displayed:"+addMeas.isDisplayed());
        addMeas.click();

        //  prodType.click();
        //(//tr[contains(@class,'MuiTableRow-root')]//td[last()]//button)[1]

        WebElement drop = driver.findElement(By.xpath("//label[text()='Product Type']/following::div[@role='combobox'][1]"));
        System.out.println("Product type :"+drop.isDisplayed());
        drop.click();
        Thread.sleep(1200);
        WebElement down = driver.findElement(By.xpath("//li[text()='Blouse']"));
        down.click();
        Thread.sleep(1200);
        lenfront.sendKeys(lenfronts);
        Thread.sleep(1000);
        lenBack.sendKeys(lenBacks);
        Thread.sleep(1000);
        shoulder.sendKeys(shoulders);
        Thread.sleep(1000);
        sleeve.sendKeys(sleeves);
        Thread.sleep(1000);
        armhole.sendKeys(armholes);
        Thread.sleep(1000);
        bicep.sendKeys(biceps);
        Thread.sleep(1000);
        sr.sendKeys(srs);
        Thread.sleep(1000);
        thlen.sendKeys(thlens);
        Thread.sleep(1000);
        cutoff.sendKeys(cutoffs);
        Thread.sleep(1000);
        chest.sendKeys(chests);
        Thread.sleep(1000);
        chestCir.sendKeys(chestCirs);
        Thread.sleep(1000);
        waist.sendKeys(waists);
        Thread.sleep(1000);
        frontdept.sendKeys(frontdepts);
        Thread.sleep(1000);
        backdepth.sendKeys(backdepths);
        Thread.sleep(1000);
        point.sendKeys(points);
        Thread.sleep(1000);
        shoulderdepth.sendKeys(shoulderdepths);
        Thread.sleep(1000);
        frontneck.sendKeys(frontnecks);
        Thread.sleep(1000);
        backneck.sendKeys(backnecks);
        Thread.sleep(1000);
        save.click();
        Thread.sleep(1000);
        close.click();
        Thread.sleep(1000);
        downloadExcel.click();


//        Select dropdown = new Select(drop);
//        List<WebElement> allOption = dropdown.getOptions();
//
//        for(WebElement option : allOption){;
//            if(option.getText().equals("Blouse")){
//                System.out.println(option.getText());
//            }
//        }

    }

    public void search(String name) throws InterruptedException {
        search.sendKeys(name);
        Thread.sleep(1000);
        searchIcon.click();
    }

}
