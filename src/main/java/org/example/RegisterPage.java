package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    Utils utils = new Utils();

    public void registerToWebPage() throws InterruptedException {

        driver.findElement(By.xpath("//a[text()='Register']")).click();

        Thread.sleep(300);
        Character randomChar = utils.ramdomCharGenerator();
        driver.findElement(By.id("firstname")).sendKeys("practice" + randomChar);
        driver.findElement(By.id("surname")).sendKeys("auto");
        driver.findElement(By.id("email")).sendKeys("practice" + randomChar + "@taklot.com");
        driver.findElement(By.id("email2")).sendKeys("practice" + randomChar + "@taklot.com");
        driver.findElement(By.id("password")).sendKeys("autologin1");
        driver.findElement(By.id("password2")).sendKeys("autologin1");
        driver.findElement(By.id("telno1")).sendKeys("0890978349");
        driver.findElement(By.name("registerButton")).click();
        Thread.sleep(300);
        String name = driver.findElement(By.xpath("//*[@id=\"welcome\"]/h3")).getText();
        System.out.println("Hey you have registered:  " + name);
        driver.findElement(By.xpath("//*[@id=\"welcome\"]/p[2]/a")).click();
        Thread.sleep(3000);
    }


}
