package org.example;

public class ProductSeacrchPage extends BasePage {

    Utils utils = new Utils();

    public void seacrhItem() throws InterruptedException {

        String productName1 = "Garmin QuickFit 22mm Silicone Watch Band - Flame Red";
        String productName2 = "Garmin Forerunner 45 Sports Smartwatch (42mm) - Lava Red";
        utils.seacrhProduct(productName1);
        Thread.sleep(3000);
        utils.seacrhProduct(productName2);

    }
}
