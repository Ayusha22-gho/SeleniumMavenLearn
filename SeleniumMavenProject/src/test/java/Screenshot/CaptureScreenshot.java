package Screenshot;

import BaseClass.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class CaptureScreenshot extends BaseClass {

    public static void captureScreenshot() throws IOException {
         File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         Date date = new Date();
         String name = date.toString().replace(":","_").replace(" ","_");
         String destination = "src/test/java/Screenshot/"+name+".png";
         FileUtils.copyFile(screenshot,new File(destination));
    }

    @Test
    public void testLogin() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("Admin");
        driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,\"content--error\")]")));
        captureScreenshot();
        driver.quit();
    }
}
