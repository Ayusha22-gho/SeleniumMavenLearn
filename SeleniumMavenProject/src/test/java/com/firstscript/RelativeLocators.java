package com.firstscript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

    public class RelativeLocators {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
            driver.get("https://demo.guru99.com/test/newtours/");
            WebElement knownWebelement =
                    driver.findElement(By.xpath("//input[@name='password']"));
            WebElement elementUsingAboveLoc =
                    driver.findElement(RelativeLocator.with(By.tagName("input")).above(knownWebelement));
            Thread.sleep(2000);
            elementUsingAboveLoc.sendKeys("TestByAboveRelativeLocator");
            driver.findElement(RelativeLocator.with(By.tagName("input")).below(knownWebelement)).click();
            //directly tagname can be used to identify
            Thread.sleep(2000);
            driver.quit();
        }
    }


