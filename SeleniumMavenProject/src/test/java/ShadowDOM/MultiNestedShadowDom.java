package ShadowDOM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultiNestedShadowDom {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.get("https://dev.automationtesting.in/shadow-dom");

        //Get the location of main shadow host
        WebElement outerShadowHost = driver.findElement(By.cssSelector("#shadow-root"));
        //get the root of the shadow host, root then can have access to Shadow DOM elements
        SearchContext outerShadowRoot = outerShadowHost.getShadowRoot();

        WebElement innerShadowHost = outerShadowRoot.findElement(By.cssSelector("#inner-shadow-dom"));
        SearchContext innerShadowRoot = innerShadowHost.getShadowRoot();

        WebElement multiShadowHost = innerShadowRoot.findElement(By.cssSelector("#nested-shadow-dom"));
        SearchContext multiShadowRoot = multiShadowHost.getShadowRoot();

        WebElement multiElement = multiShadowRoot.findElement(By.cssSelector("#multi-nested-shadow-element"));
        System.out.println(multiElement.getText());


        driver.quit();
    }
}
