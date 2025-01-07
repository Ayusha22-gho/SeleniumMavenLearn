package ShadowDOM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NestedShadowDOM {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.get("https://dev.automationtesting.in/shadow-dom");
        WebElement outerShadowHost = driver.findElement(By.cssSelector("#shadowroot"));
        SearchContext OuterShadowRoot = outerShadowHost.getShadowRoot();

//        Again get the innerShadowHost inside the OuterShadowRoot.
        WebElement innerShadowHost =
                OuterShadowRoot.findElement(By.cssSelector("#inner-shadow-dom"));
        SearchContext innerShadowRoot = innerShadowHost.getShadowRoot();

        WebElement innerShadowElement =
                innerShadowRoot.findElement(By.cssSelector("span#nested-shadow-element"));
        System.out.println(innerShadowElement.getText());
        driver.quit();

    }
}
