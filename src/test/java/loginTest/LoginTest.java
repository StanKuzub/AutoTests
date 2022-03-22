package loginTest;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @Test
    public  void validLogin(){
        File fileFF = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://commontestlicense.gooutdoorsvirginia.com/Licensing/CustomerLookup.aspx");
        System.out.println("Page is opened");

        webDriver.findElement(By.xpath(".//a[contains(@title,'Click to login')]")).click();
        System.out.println("Login button is clicked");

        webDriver.findElement(By.xpath(".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtDateOfBirth_inputDate']")).clear();
        webDriver.findElement(By.xpath(".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtDateOfBirth_inputDate']")).sendKeys("02/09/1989");
        System.out.println("DOB is entered");

        webDriver.findElement(By.xpath(".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtLastName']")).clear();
        webDriver.findElement(By.xpath(".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtLastName']")).sendKeys("Kuzub");
        System.out.println("Last Name is entered");

        webDriver.findElement(By.xpath(".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtLastFourSSN']")).clear();
        webDriver.findElement(By.xpath(".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtLastFourSSN']")).sendKeys("1111");
        System.out.println("Last Four of SSN were entered");

        webDriver.findElement(By.xpath(".//a[@id='ContentPlaceHolder1_CustomerLookupControl_btnSignIn']")).click();
        System.out.println("Submit button is clicked");

        webDriver.findElement(By.xpath(".//button[@id='ContentPlaceHolder1_modal_CertifyResidency_btnCertifyResidency']")).click();
        System.out.println("Certify Button is clicked on Residency Modal");

        Assert.assertTrue("AutoRenew Tab is not displayed", isAutoRenewTabVisible());

        webDriver.quit();
    }

    private boolean isAutoRenewTabVisible() {

        try{
            return webDriver.findElement(By.xpath(".//a[@id='ContentPlaceHolder1_btnAutoRenewSettings']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
