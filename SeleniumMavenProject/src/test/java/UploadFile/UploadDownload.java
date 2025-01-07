package UploadFile;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UploadDownload extends BaseClass {



    public void upload(){

        WebElement uploadButton = driver.findElement(By.xpath(""));
        uploadButton.sendKeys("path of the file");
    }

    @Test
    public void downLoad(){
        //click on download button

        //when there is a pdf download, it opens in the same broswer and then there is a download sign
        //steps to automate  such scenarios

        driver.get("https://www.princexml.com/samples/");
        WebElement pdfLink = driver.findElement(By.xpath("//*[@id=\"dictionary\"]/p[2]/a[2]"));
        pdfLink.click();

    }

}
