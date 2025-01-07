package ActionsSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionClass_01 {
    public static WebDriver driver;

    @BeforeMethod
    public void invokeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void ActionClass() throws InterruptedException {
        String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement titleA = driver.findElement(By.xpath("//li[@name='A']"));
        WebElement titleC = driver.findElement(By.xpath("//li[@name='C']"));

        Actions action = new Actions(driver);

        action.moveToElement(titleA);
        action.clickAndHold();
        action.moveToElement(titleC);
        action.release().perform();

        Thread.sleep(5000);

    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        String url = "https://selenium08.blogspot.com/2020/01/drag-drop.html";
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement src = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(src,target);
        action.pause(Duration.ofSeconds(1));
        action.build().perform();
        action.pause(4000);
    }
    @Test
    public void VerifyToolTip(){
        driver.get("https://demoqa.com/tool-tips");
        Actions action = new Actions(driver);

        WebElement tooltip = driver.findElement(By.id("toolTipButton"));
        action.moveToElement(tooltip).perform();

        String tooltipText = tooltip.getText();
        System.out.println(tooltipText);
    }

}
