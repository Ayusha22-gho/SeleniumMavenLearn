package Waits;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;


public class FluentWaitEx extends BaseClass {


    @Test
    public void fluentWait() {

            FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))  // Maximum time to wait
            .pollingEvery(Duration.ofMillis(500)) // Interval between each poll
            .ignoring(NoSuchElementException.class); // Exceptions to ignore

            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementID")));
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(NoSuchElementException.class);

    }

}

