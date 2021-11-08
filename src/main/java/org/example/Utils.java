package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class Utils extends BasePage {

    int numberOfSearches = 0;

    public void naviagate() throws InterruptedException {
        driver.get("https://www.takealot.com");
        Thread.sleep(3000);
    }

    public void seacrhProduct(String searchProdItem) throws InterruptedException {

        numberOfSearches++;
        driver.findElement(By.cssSelector("[name='search']")).clear();
        driver.findElement(By.cssSelector("[name='search']")).sendKeys(searchProdItem);
        driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/header/div/div/div[2]/form/div/div[3]/button")).click();
        Thread.sleep(3000);

        System.out.println(" Number of searches = " + numberOfSearches);
        if (numberOfSearches < 2) {
            System.out.println(" Looping >>>> Number of searches = " + numberOfSearches + ", hence trying to click GRID");
            driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/div[4]/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/button[1]/div")).click();
        }

        int counterId = 0;

        List<WebElement> listItems = driver.findElements(By.xpath("//*[@class='listings-container  listings-container-module_listings-container_AC4LI']//*/h3"));
        System.out.println("Number of webelements = " + listItems.size());

        Thread.sleep(3000);
        for (int i = 0; i < listItems.size(); i++) {
            if (searchProdItem.equalsIgnoreCase(listItems.get(i).getText())) {
                System.out.println(" ***** Element found: " + searchProdItem + " at the position: " + (i));
                counterId = i;
                By by = By.xpath("//div[" + counterId + 1 + "]/div/div/div/div[3]//button[. = ' Add to Cart']");
                driver.findElement(by).click();
            }
        }

        int cartCcounterId = 0;
        Thread.sleep(3000);

        By by = By.xpath("//button//span");
        driver.findElement(by).click();
        Thread.sleep(3000);
        List<WebElement> cartItems = driver.findElements(By.xpath("//*[@class='cell cart-item-module_title-cell_1MHmD']//*/h3"));

        System.out.println("Number of CART elements = " + cartItems.size());

        Thread.sleep(3000);
        for (int j = 0; j < cartItems.size(); j++) {
            if (searchProdItem.equalsIgnoreCase(cartItems.get(j).getText())) {
                System.out.println(" ***** Element found in the CART: " + searchProdItem + " at the position: " + (j));
                Assert.assertEquals(searchProdItem, cartItems.get(j).getText());
            }
        }
    }

    public Character ramdomCharGenerator() {
        return RandomStringUtils.randomAlphanumeric(1).charAt(0);
    }

    public void teardown() {
        driver.close();
        driver.quit();
    }

}



