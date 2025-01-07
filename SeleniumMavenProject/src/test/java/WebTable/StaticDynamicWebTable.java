package WebTable;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class StaticDynamicWebTable extends BaseClass {

    @Test
    public void dynamicWebTable(){
        driver.get ("https://demo.guru99.com/test/web-table-element.php");

        WebElement baseTable = driver.findElement (By.tagName ("table"));

        //To find third row of table
        WebElement tableRow = baseTable.findElement(By.xpath("//tbody/tr[3]"));
        String rowtext = tableRow.getText () ;
        System.out.println ("Thizd row of table : "+rowtext) ;
        //to get 3zd cow's 2nd column data
        WebElement cellIneed = tableRow.findElement (By .xpath("//tbody/tr[3]/td[2]"));
        String valuelneed = cellIneed.getText () ;
        System.out.println ("Cell value is: " + valuelneed);
        WebElement directly = driver.findElement (By.xpath("//tbody/tr[3]/td[2]"));
        System.out.println ("Cell value is: " + directly.getText());
    }

    @Test
    public void iterateDynamicTable(){
        driver.get ("https://www.techlistic.com/p/demo-selenium-practice.html");

        WebElement tableBody = driver.findElement(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/tbody"));

        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

        int rowSize = rows.size();
        System.out.println("Row size "+rowSize);

        for(WebElement rowele : rows){
            List<WebElement> cols = rowele.findElements(By.tagName("td"));
            System.out.println("column size "+ cols.size());
            for(WebElement colele : cols ){
                System.out.println(colele.getText()+"\t");
            }
        }

        driver.quit();
    }


}
