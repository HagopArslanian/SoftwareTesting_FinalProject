package itemSearchTests;

import base.BaseTest;
import constants.messages.ErrorMessages;
import org.testng.annotations.Test;
import pages.AlibabaHomePage;
import pages.AlibabaSearchPage;

import static org.testng.Assert.assertTrue;

public class ItemSearchTests extends BaseTest {

    private String searchText = "shoes";
    private String maxPrice = "2";

    @Test
    public void testItemSearchFunctionality(){
        AlibabaHomePage homePage = goHome();
        AlibabaSearchPage alibabaSearchPage = homePage.search(searchText);
        assertTrue(alibabaSearchPage.checkItemsTitles(searchText), ErrorMessages.ITEM_SEARCH_NOT_WORKING);
    }

    @Test
    public void testSearchFilterByPrice(){
        AlibabaHomePage homePage = goHome();
        AlibabaSearchPage alibabaSearchPage = homePage.search(searchText);
        alibabaSearchPage.inputMaxPriceField(maxPrice);
        assertTrue(alibabaSearchPage.checkItemsPrices(Integer.parseInt(maxPrice)), ErrorMessages.SEARCH_FILTER_BY_PRICE_NOT_WORKING);
    }

    @Test
    public void testVerifiedSupplierFilter(){
        AlibabaHomePage homePage = goHome();
        AlibabaSearchPage alibabaSearchPage = homePage.search(searchText);
        alibabaSearchPage.clickVerifiedSupplier();
        assertTrue(alibabaSearchPage.checkIfAllItemsAreVerifiedSupplier(), ErrorMessages.VERIFIED_SUPPLIER_FILTER_NOT_WORKING);
    }
}
