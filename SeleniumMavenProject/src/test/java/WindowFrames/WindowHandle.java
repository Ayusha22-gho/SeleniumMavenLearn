package WindowFrames;
import BaseClass.BaseClass;
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

import java.util.Iterator;
import java.util.Set;

public class WindowHandle extends BaseClass {


    @Test
    public void windowhandles() {
        // Start application
    driver.get ("https://demoqa.com/browser-windows");
        // Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();

        //Get handles of the windows
        //It stores parent window value in a unique identifier of string type.
        String mainWindowHandle = driver.getWindowHandle();

        //A11 child windows are stored in a set of strings.
        Set<String> allWindowHandles = driver.getWindowHandles() ;

        //Here we will iterate through all child windows.
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check it child window has other child windows and will fetch the
        // heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                //switching the focus
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }
}

@Test
    public void WorkingWindowHandles(){
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        WebElement followBoth = driver.findElement(By.id("followboth"));

        followBoth.click();//will open 2 windows

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main Window "+MainWindow);

        Set<String> allWindows = driver.getWindowHandles(); // sequence of unique values
        System.out.println("All Window "+allWindows);
        Iterator<String> it = allWindows.iterator(); //returns an iterator over the elements in this set

        while(it.hasNext()){
            String childWindow = it.next();
            System.out.println("childWindow "+childWindow);
            if(!MainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                String pageTitle = driver.getTitle();
                driver.close();
                System.out.println("pageTitle and driver window closed "+pageTitle);
            }
        }

        driver.switchTo().window(MainWindow);
        System.out.println(followBoth.getText());

    }

}
