package loginTests;

import base.BaseTest;
import constants.locators.AlibabaSignInPageConstants;
import constants.messages.ErrorMessages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AlibabaHomePage;
import pages.AlibabaSignInPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    private By loginError = By.id(AlibabaSignInPageConstants.LOGIN_ERROR);

    @Test
    public void testFailedLogin(){
        AlibabaHomePage homePage = goHome();
        AlibabaSignInPage alibabaSignInPage = homePage.navigateToSignInPage();
        alibabaSignInPage.setAccount("invalid_gmail");
        alibabaSignInPage.setPassword("invalid_password");
        alibabaSignInPage.setStaySignedInCheckBox(false);//by default
        alibabaSignInPage.clickSignInButton();
        assertTrue(driver.findElements(loginError).size() != 0, ErrorMessages.LOGIN_FAILED_MESSAGE);
    }
}
