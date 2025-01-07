package com.firstscript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class FirstScript {
    public static void main(String[] args) throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\934197\\Desktop\\SeleniumMavenProject\\SeleniumMavenProject\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);
        Boolean logo = driver.findElement(By.xpath("//*[@alt ='Google']")).isDisplayed();
        System.out.println("Logo is visible"+logo);
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("Cognizant");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        int totalCount =0;
        //WebElement next = driver.findElement(By.id("pnnext"));
        //when next is defined outside the while loop then on each page load , there might be error showing
        //stae element not found => the webelement requires a reload, thus defining it in the loop so on every iteration
        //the element location is taken
        while(true){
            List<WebElement> searchResults = driver.findElements(By.cssSelector("div.g"));
            int pageResult = searchResults.size();
            totalCount += pageResult;
            List<WebElement> next = driver.findElements(By.id("pnnext"));
            if(next.size() >0){
                //driver.findElement(By.id("pnnext")).click();
                next.get(0).click();
                Thread.sleep(1000);
            }else{
                break;
            }

        }
        System.out.println(totalCount);
        driver.quit();
    }
}
