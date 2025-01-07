package Waits;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait extends BaseClass {

    @Test
    public void explicitWait(){
        // Start application
        driver.get ("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
                // Click on timer button to start
        WebElement button = driver.findElement (By.xpath("//button [text()='Click me to start timer']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", button);
        // Create object of WebDriverWait class and it will wait max of 20 seconds.
        // By default it will accepts in Seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)) ;
        // Here we will wait until element is not visible, if element is visible then it will return web ele
        // or else it will throw exception
        WebElement element = wait.until (ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text () ='WebDriver']")));
        // if element found then we will use- In this example I just called isDisplayed method
        boolean status = element.isDisplayed();

        // if else condition
                if(status) {
                System. out.println("=--= WebDriver is visible ");}
                else {
                    System.out.println("=== WebDriver is not visible-");
                }

         driver.quit();
    }
}
