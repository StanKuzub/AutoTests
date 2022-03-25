package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OLCustomerLookup extends ParentPage {
     @FindBy(xpath = ".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtDateOfBirth_inputDate']")
     private WebElement enterDOB;

     @FindBy(xpath = ".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtLastName']")
    private WebElement enterLastName;
     @FindBy(xpath = ".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtLastFourSSN']")
    private WebElement enterSSN;
     @FindBy(xpath = ".//a[contains(@title,'Click to login')]")
    private WebElement buttonLogin;
     @FindBy(xpath = ".//a[@id='ContentPlaceHolder1_CustomerLookupControl_btnSignIn']")
    private WebElement buttonSubmit;
     @FindBy(xpath = ".//button[@id='ContentPlaceHolder1_modal_CertifyResidency_btnCertifyResidency']")
    private WebElement buttonCertify;

    public OLCustomerLookup(WebDriver webDriver) {
        super(webDriver);
    }

    public void openCustomerLookup() {
        try {
            webDriver.get("https://commontestlicense.gooutdoorsvirginia.com/Licensing/CustomerLookup.aspx");
            logger.info("Customer Lookup Page Was Opened");
        } catch (Exception e) {
            logger.error("Cannot work with Customer Lookup Page" + e);
            Assert.fail("Cannot work with Customer Lookup Page");
        }
    }

    public void enterDOB(String dob) {
/*        try {
        //    WebElement element = webDriver.findElement(By.xpath(".//input[@id='ContentPlaceHolder1_CustomerLookupControl_txtDateOfBirth_inputDate']"));
            enterDOB.clear();
            enterDOB.sendKeys(dob);
            logger.info(dob + " was entered into DOB field");

            logger.info("Login button was clicked");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }*/
        enterTextToElement(enterDOB, dob);
    }

    public void enterCustomerLastName(String lastName) {
        enterTextToElement(enterLastName, lastName);
    }

    public void enterLastOfSSN(String ssn) {
        enterTextToElement(enterSSN, ssn);
    }

    public void clickOnLoginButton() {
        clickOnElement(buttonLogin);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }

    public void clockOnCertifyButton() {
        clickOnElement(buttonCertify);
    }
}
