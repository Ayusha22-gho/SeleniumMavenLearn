package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {
    public static WebDriver driver;

    @BeforeMethod
    public void invokeBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String,Object> prefs = new HashMap<String,Object>();
        prefs.put("plugins.always_open_pdf_externally",true);
        //prefs.put("download.default_directory","directory path");
        options.setExperimentalOption("prefs",prefs);
        options.addArguments("--remote-allow-origins=*");

        //driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //driver will wait max 5 seconds for all the async scripts to get finished executing
       // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));

        // webdriver will wait for the page to load for max of 10 seconds before throwing an exception
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
}
