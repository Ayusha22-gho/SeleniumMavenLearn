package ActionsSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Set;

public class Cookies_01 {

    public static WebDriver driver;

    @BeforeMethod
    public void invokeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public void handlingCookies(){

        Set<Cookie> cookies = driver.manage().getCookies();

        Cookie cookie = new Cookie("name","value");
        driver.manage().addCookie(cookie);

        driver.manage().deleteCookieNamed("cookieName");
        driver.manage().deleteAllCookies();

        Cookie cookie1 = driver.manage().getCookieNamed("cookiename");
        cookie1.getName();

        driver.manage().addCookie(new Cookie("name","value","domain","path",null,false,false,"expiry"));
    }
}
