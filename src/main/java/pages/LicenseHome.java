package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LicenseHome extends ParentPage{
    @FindBy(xpath = ".//a[@id='ContentPlaceHolder1_btnAutoRenewSettings']")
    private WebElement tabAutoRenew;

    public LicenseHome(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isTabAutoRenewPresent(){
        return isElementPresent(tabAutoRenew);
    }
}
