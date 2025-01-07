package Assignments.WebElemInteractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebElementInteractionAssignments {
    public static WebDriver driver;

    @BeforeMethod
    public void invokeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    
    @Test
    public void HandsOn_01(){
        //Browser Navigation
        try {
            driver.navigate().to("https://demoqa.com/forms");
            driver.navigate().refresh();
            String currentURL = driver.getCurrentUrl();
            String pageSource = driver.getPageSource();
            String title = driver.getTitle();
            System.out.println(currentURL + "\n" + pageSource + "\n" + title);
            driver.navigate().to("https://demoqa.com/text-box");
            driver.navigate().back();
            driver.navigate().forward();
            //WebDriverManager.chromedriver().setup();
            WebDriver driver1 = new ChromeDriver(new ChromeOptions().addArguments("--disable-blink-features=AutomationControlled"));
            driver1.get("https://demoqa.com/forms");
            driver1.close();
            driver.quit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void HandsOn_02() {
        driver.navigate().to("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Test123");
        driver.findElement(By.id("userEmail")).sendKeys("test.dew@mail.com");
        String name = driver.findElement(By.id("userName")).getAttribute("value");
        System.out.println(name);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement submit = driver.findElement(By.id("submit"));

        js.executeScript("arguments[0].scrollIntoView(true)",submit);
        submit.click();
        System.out.println("Submitted");
        driver.close();
    }

    @Test
    public void HandsOn_03(){
        try {
            driver.navigate().to("https://demoqa.com/checkbox");
            //Verify if Commands checkbox is already selected, If not then
            //select the Commands checkbox
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement expandAll = driver.findElement(By.xpath("//button[@aria-label=\"Expand all\"]"));
            js.executeScript("arguments[0].scrollIntoView(true)",expandAll);
            if(expandAll.isDisplayed()){
                expandAll.click();
            }
            WebElement commandCheckbox = driver.findElement(By.xpath("//input[@id='tree-node-commands']//following-sibling::span[@class='rct-checkbox']"));
            if(!commandCheckbox.isSelected()){
                commandCheckbox.click();
            }else{
                System.out.println("Command Checkbox already selected");
            }
            //Verify if Classified checkbox is displayed
            WebElement classifiedCheckbox = driver.findElement(By.xpath("//input[@id='tree-node-classified']//following-sibling::span[@class='rct-checkbox']"));
            if(classifiedCheckbox.isDisplayed()){
                System.out.println("Classsfied displayed");
            }else{
                System.out.println("Classified not displayed");
            }
            //Select Classified check box and unslect Commands checkbox
            if(!classifiedCheckbox.isSelected()){
                classifiedCheckbox.click();
            }
            if(commandCheckbox.isSelected()){
                commandCheckbox.click();
            }
            //Verify if Excel.file checkbox is enabled
            WebElement excelCheckbox = driver.findElement(By.xpath("//input[@id='tree-node-excelFile']//following-sibling::span[@class='rct-checkbox']"));
            if(excelCheckbox.isEnabled()){
                System.out.println("Excel enabled");
            }else{
                System.out.println("excel not enabled");
            }

            //Select Excel.file checkbox along with Notes Checkbox
            WebElement notesCheckbox = driver.findElement(By.xpath("//input[@id='tree-node-notes']//following-sibling::span[@class='rct-checkbox']"));
            js.executeScript("arguments[0].scrollIntoView(true)",excelCheckbox);
            if(!excelCheckbox.isSelected()){
                excelCheckbox.click();
            }

            js.executeScript("arguments[0].scrollIntoView(true)",notesCheckbox);
            if(!notesCheckbox.isSelected()){
                notesCheckbox.click();
            }
        }catch(Exception e){
            e.printStackTrace();

        }finally {
            driver.quit();
        }
    }

    @Test
    public void HandsOn_04(){
        driver.get("https://demoqa.com/radio-button");
        WebElement noRadio = driver.findElement(By.id("noRadio"));
        //Verify if 'No' radio button is enabled
        if(noRadio.isEnabled()){
            System.out.println("No is enabled");
        }else{
            System.out.println("No is not enabled");
        }
        //4 Verify if 'No' radio button is displayed
        if(noRadio.isDisplayed()){

            System.out.println("No is displayed");
        }else{
            System.out.println("No is not displayed");
        }
        //Verify if 'Yes' radio button is selected, If not selected then select
        //the 'Yes' radio button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));

        if(!yesRadio.isSelected()){
            js.executeScript("arguments[0].click()",yesRadio);
        }
        //6
        //Verify if the your able to select only one option the radio button
        //out of three radio buttons
        WebElement immpressiveRadio = driver.findElement(By.id("impressiveRadio"));
        if(!immpressiveRadio.isSelected()){
            js.executeScript("arguments[0].click()",immpressiveRadio);
            if(!yesRadio.isSelected() && !noRadio.isSelected()){
                System.out.println("Other two not selected");
            }else{
                System.out.println("Radio button not working as expected");
            }
        }else if(!yesRadio.isSelected()){
            js.executeScript("arguments[0].click()",yesRadio);
            if(!immpressiveRadio.isSelected() && !noRadio.isSelected()){
                System.out.println("Other two not selected");
            }else{
                System.out.println("Radio button not working as expected");
            }
        }else if(!noRadio.isSelected()){
            js.executeScript("arguments[0].click()",noRadio);
            if(!yesRadio.isSelected() && !immpressiveRadio.isSelected()){
                System.out.println("Other two not selected");
            }else{
                System.out.println("Radio button not working as expected");
            }
        }else{
            System.out.println("Nothing is clicked");
        }
    driver.quit();
    }

    @Test
    public void HandsON_05(){
        driver.get("https://demoqa.com/automation-practice-form");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement submit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView(true)",submit);

        System.out.println(submit.getCssValue("background-color"));
        System.out.println(submit.getTagName());
        System.out.println(submit.getAttribute("type"));
        driver.close();
    }

    @Test
    public void HandsOn_06(){
        driver.get("https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement currentAddress = driver.findElement(By.id("currentAddress-label"));
        js.executeScript("arguments[0].scrollIntoView(true)",currentAddress);
        WebElement currentAddresssText = driver.findElement(By.id("currentAddress"));
        System.out.println(currentAddresssText.getSize());
        Point point = currentAddresssText.getLocation();
        System.out.println(point);
        driver.close();
    }

    @Test
    public void HandsOn_07(){
        driver.get("https://demoqa.com/selectable");
        List<WebElement> listElements = driver.findElements(By.xpath("//*[@id='verticalListContainer']/li"));
        System.out.println(listElements.size());
        for(WebElement elem : listElements){
            System.out.println(elem.getText());
        }
        driver.close();
    }

    @Test
    public  void HandsOn_08(){
        driver.get("https://demoqa.com/automation-practice-form");
        //Check if the City dropdown is enabled
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement city = driver.findElement(By.xpath("//div[@id='city']//input"));
        js.executeScript("arguments[0].scrollIntoView(true)",city);
        if(!city.isEnabled()){
            System.out.println("city not enabled");
        }
        //4 Check if the State dropdown is enabled
        WebElement state = driver.findElement(By.xpath("//div[@id='state']//input"));
        if(!state.isEnabled()){
            System.out.println("state not enabled");
        }
        //5 Select the State as 'NCR' from drop down
//        Select selectState = new Select(state);
//        selectState.selectByVisibleText("NCR");
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);
        //6 Select the City as 'Delhi' from drop down
//        Select selectCity = new Select(city);
//        selectCity.selectByVisibleText("Delhi");
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);
        driver.close();
    }


}
