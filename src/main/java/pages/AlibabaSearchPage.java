package pages;

import constants.locators.AlibabaSearchPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class AlibabaSearchPage {
    private WebDriver driver;
    private By maxPriceField = By.xpath(AlibabaSearchPageConstants.MAX_PRICE_FIELD);
    private By priceOkButton = By.xpath(AlibabaSearchPageConstants.PRICE_OK_BUTTON);
    private By items = By.tagName(AlibabaSearchPageConstants.ITEMS_TAG);
    private By itemsPrices = By.className(AlibabaSearchPageConstants.SEARCH_ITEMS_PRICES_CLASS);
    private By verifiedSupplierFilter = By.xpath(AlibabaSearchPageConstants.VERIFIED_SUPPLIER_FILTER);
    private By verifiedSpans = By.className(AlibabaSearchPageConstants.VERIFIED_SPAN_CLASS);
    private By itemsContents = By.className(AlibabaSearchPageConstants.ITEMS_CONTENTS_CLASS);

    public AlibabaSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean checkItemsTitles(String searchText){
        List<WebElement> searchList = driver.findElements(items);
        for(WebElement searchItem : searchList){
            System.out.println(searchItem.getText());
            if(!searchText.toLowerCase().contains(searchItem.getText().toLowerCase())){
                return false;
            }
        }
        return true;
    }

    public void inputMaxPriceField(String maxPrice){
        driver.findElement(maxPriceField).sendKeys(maxPrice);
        driver.findElement(priceOkButton).click();
    }

    public void clickVerifiedSupplier(){
        driver.findElement(verifiedSupplierFilter).click();
    }

    public boolean checkItemsPrices(int maxPrice){
        String priceText = "";
        double price = 0.00;
        List<WebElement> searchItemsPrices = driver.findElements(itemsPrices);
        for(WebElement searchItemsPrice : searchItemsPrices){
            priceText = searchItemsPrice.getText();
            priceText = priceText.substring(priceText.length() - 3);
            price = Double.parseDouble(priceText);
            if(!(price <= (double) maxPrice)){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfAllItemsAreVerifiedSupplier(){
        int verifiedSpansSize = driver.findElements(verifiedSpans).size();
        int itemsContentsSize = driver.findElements(itemsContents).size();
        if(verifiedSpansSize == itemsContentsSize){
            return true;
        }
        return false;
    }
}
