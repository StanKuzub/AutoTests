package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LicenseHome;
import pages.OLCustomerLookup;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;

    public class BaseTest {
    WebDriver webDriver;
    protected OLCustomerLookup olCustomerLookup;
    public LicenseHome licenseHome;
    @Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
    webDriver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    webDriver.manage().window().maximize();

    olCustomerLookup = new OLCustomerLookup(webDriver);
    licenseHome = new LicenseHome(webDriver);
    }
    @After
    public void tearDown(){ webDriver.quit();}

    protected void checkExpectedResult(String message, boolean actualResult, boolean expectedResult){
        Assert.assertThat(message, actualResult, is(expectedResult));
    }
}
