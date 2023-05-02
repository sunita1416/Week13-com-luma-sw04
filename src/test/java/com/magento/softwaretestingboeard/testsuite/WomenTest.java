package com.magento.softwaretestingboeard.testsuite;

import com.magento.softwaretestingboeard.pages.HomePage;
import com.magento.softwaretestingboeard.pages.ProductPage;
import com.magento.softwaretestingboeard.testbase.BaseTest;
import org.testng.annotations.Test;

public class WomenTest extends BaseTest {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        Thread.sleep(5000);

        // Mouse Hover on Women Menu
        homePage.mouseHoverOnWomenTab();
        // Mouse Hover on Tops
        homePage.mouseHoverOnTopsInWomenTab();
        // Click on Jackets
        homePage.mouseHoverAndClickOnJacketsInWomen();
        // Select Sort By filter “Product Name”
        // Verify the products name display in alphabetical order
        productPage.verifySortingOfProductsInAscendingOrder("Product Name");

    }
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException{
        //  Mouse Hover on Women Menu
        homePage.mouseHoverOnWomenTab();
        Thread.sleep(1000);
        // Mouse Hover on Tops
        homePage.mouseHoverOnTopsInWomenTab();
        Thread.sleep(1000);
        // Click on Jackets
        homePage.mouseHoverAndClickOnJacketsInWomen();
        Thread.sleep(1000);
        //  Select Sort By filter “Price”
        // Verify the products price display in Low to High
        productPage.verifySortingOfPriceInAscendingOrder("Price");
        Thread.sleep(1000);
    }
}
