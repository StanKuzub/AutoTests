package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTestWithPageObject extends BaseTest {
    @Test
    public void validLogin(){
        olCustomerLookup.openCustomerLookup();
        olCustomerLookup.clickOnLoginButton();
        olCustomerLookup.enterDOB("02/09/1989");
        olCustomerLookup.enterCustomerLastName("Kuzub");
        olCustomerLookup.enterLastOfSSN("1111");
        olCustomerLookup.clickOnSubmitButton();
        olCustomerLookup.clockOnCertifyButton();

        checkExpectedResult("Auto-Renew tab is not visible", licenseHome.isTabAutoRenewPresent(),true);
    }
}
