package org.example;

import org.testng.annotations.Test;

public class TestAddProductsToCart extends BasePage {

    Utils utils = new Utils();
    RegisterPage registerPage = new RegisterPage();
    ProductSeacrchPage productSeacrchPage = new ProductSeacrchPage();

    @Test
    public void addingToCart() throws InterruptedException {
        // 1. To initialize chrome browser
        createDriverInstance();

        // 2. To launch www.takealot.com page
        utils.naviagate();

        // 3. To register a new user
        registerPage.registerToWebPage();

        // 4. To perform two searches.  One for Garmin Watch & other is for Band. Also to validating the contents in Cart.
        productSeacrchPage.seacrhItem();

        // 5. Closing the browser session logically.
        utils.teardown();
    }
}
