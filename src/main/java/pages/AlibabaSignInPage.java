package pages;

import constants.locators.AlibabaSignInPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlibabaSignInPage {
    private WebDriver driver;
    private By accountField = By.id(AlibabaSignInPageConstants.ACCOUNT_FIELD);
    private By passwordField = By.id(AlibabaSignInPageConstants.PASSWORD_FIELD);
    private By signInButton = By.id(AlibabaSignInPageConstants.SIGNIN_BUTTON);
    private By staySignedInCheckBox = By.id(AlibabaSignInPageConstants.STAYSIGNEDIN_CHECKBOX);

    public AlibabaSignInPage(WebDriver driver){
        this.driver = driver;
    }

    public void setAccount(String account){
        driver.findElement(accountField).sendKeys(account);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setStaySignedInCheckBox(boolean staySignedInFlag){
        boolean checkboxStatus = driver.findElement(staySignedInCheckBox).isSelected();
        if(staySignedInFlag && !checkboxStatus){
            driver.findElement(staySignedInCheckBox).click();
        }else if(!staySignedInFlag && checkboxStatus){
            driver.findElement(staySignedInCheckBox).click();
        }
    }

    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
}
