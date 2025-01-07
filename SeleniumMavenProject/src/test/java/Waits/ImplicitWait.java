package Waits;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ImplicitWait extends BaseClass {

    @Test
    public void implicitWait(){
        //wait is defined in base class
        driver.get("https://www.redbus.in/");
        WebElement textBox = driver.findElement(By.id("src"));
        textBox.sendKeys("Ban");
        driver.findElement(By.xpath("//*[@id='autoSuggestContainer']//li[1]//text")).click();
        driver.quit();
    }
}
