package WindowFrames;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Frames extends BaseClass {

    @Test
    public void NumberFrame() {
        // Start application
        driver.get("https://demoqa.com/frames");
        // By executing a java script
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        // By finding all the web' elements using frame tag
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe")); //list allows duplicate elements
        System.out.println("The total number of iframes are " + iframeElements.size());
    }

    @Test
    public void FrameSwitch() {
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame("frame1");
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        System.out.println("heading " + heading.getText());

        driver.switchTo().defaultContent();
        driver.quit();
    }

    @Test
    public void SwitchNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        // driver. switchTo (). frame ("frameset-middle") :
        driver.switchTo().frame("frame-middle");
        WebElement p = driver.findElement(By.id("content"));
        String s = p.getText();
        System.out.println("Text content is: " + s);
        // Switch back to the main window
        driver.switchTo().defaultContent();
        // Switch to the outer frame
        driver.switchTo().frame("frame-top");
        // Switch to the inner frane
        driver.switchTo().frame("frame-right");
        System.out.println("Text from Right frame" + driver.findElement(By.xpath("/html/body")).getText());
        // Perform operations within the nested frane
        // Switch back to the parent frame of the outer frame
        driver.switchTo().parentFrame();//frame-top
        driver.switchTo().frame("frame-left");
        System.out.println("Text fxom left Frame " + driver.findElement(By.xpath("/html/body")).getText());
        // Perform operations within the outer frame
        // Switch back to the default content
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        System.out.println("Text from bottom frame " + driver.findElement(By.xpath("/html/body")).getText());
        driver.quit();

    }
    @Test
    public void IndexSwitchNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(0);
        // driver. switchTo (). frame ("frameset-middle") :
        driver.switchTo().frame(1);
        WebElement p = driver.findElement(By.id("content"));
        String s = p.getText();
        System.out.println("Text content is: " + s);
        // Switch back to the main window
        driver.switchTo().defaultContent();
        // Switch to the outer frame
        driver.switchTo().frame(0);
        // Switch to the inner frane
        driver.switchTo().frame(2);
        System.out.println("Text from Right frame" + driver.findElement(By.xpath("/html/body")).getText());
        // Perform operations within the nested frane
        // Switch back to the parent frame of the outer frame
        driver.switchTo().parentFrame();//frame-top
        driver.switchTo().frame(0);
        System.out.println("Text fxom left Frame " + driver.findElement(By.xpath("/html/body")).getText());
        // Perform operations within the outer frame
        // Switch back to the default content
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        System.out.println("Text from bottom frame " + driver.findElement(By.xpath("/html/body")).getText());
        driver.quit();

    }
}

