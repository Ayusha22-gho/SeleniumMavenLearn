package ShadowDOM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingleShadowDom {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.get("https://dev.automationtesting.in/shadow-dom");
//        First we need to identify the Shadow-Host component in the HTML
//        code where shadow-dom is attached, this shadow host is part of the
//        main(outer) dom hence can be directly accessed using a locator.
        WebElement shadowHost = driver.findElement(By.cssSelector("#shadow-root"));

//        Get the shadow-root attached to the shadow host using
//        getShadowRoot() method with the help of reference of the above
//        shadowHost element.
//        This will give the SearchContext of shadow-root as a return type, so
//        that we can get the access permission of the elements inside this
//        shadow-root section.

        SearchContext shadowRoot = shadowHost.getShadowRoot();

//        Now get the shadowWebElement using the reference of the above
//        shadowRoot
        WebElement shadowElement =
                shadowRoot.findElement(By.cssSelector("span#shadow-element"));

        System.out.println(shadowElement.getText());
        driver.quit();
    }
}
