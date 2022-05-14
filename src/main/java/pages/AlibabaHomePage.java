package pages;

import constants.locators.AlibabaHomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlibabaHomePage {

    private WebDriver driver;
    private By searchField = By.name(AlibabaHomePageConstants.SEARCH_FIELD);
    private By signInButton = By.linkText(AlibabaHomePageConstants.SIGNIN_BUTTON);

    public AlibabaHomePage(WebDriver driver){
        this.driver = driver;
    }

    public AlibabaSignInPage navigateToSignInPage(){
        try {
            WebElement date = driver.findElement(signInButton);
            date.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement date = driver.findElement(signInButton);
            date.click();
        }
        return new AlibabaSignInPage(driver);
    }

    public AlibabaSearchPage search(String searchText){
        driver.findElement(searchField).sendKeys(searchText + Keys.ENTER);
        return new AlibabaSearchPage(driver);
    }
}
