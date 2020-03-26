package ahs.pageObjects;

import ahs.Screens.MasterScreen;
import ahs.support.AutomationContants;
import ahs.support.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MasterPageObject extends basePage {
      WebDriver driver;
     MasterScreen masterScreen=new  MasterScreen();
    public Object String;

    public MasterPageObject(){
         driver= BrowserFactory.getBrowser();
         PageFactory.initElements(driver,masterScreen);
     }
     public void validateMasterLink(){
        masterScreen.masters_link.click();
     }
     public String validatePageText(){
         return masterScreen.page_text.getText();
     }
     public void validateGroupTest(){
         masterScreen.grouptest_link.click();
     }
     public void validateAddnewButton(){
         masterScreen.add_new_btn.click();
     }
     public void validateGroupTestNameBox(){
         masterScreen.group_test_box.sendKeys(AutomationContants.GROUP_TEST_NAME);//if you enter new test name it is failing the test
         masterScreen.price_box.clear();
         masterScreen.price_box.sendKeys(AutomationContants.PRICE);
         masterScreen.grouptest_submit_btn.submit();
         WebElement element=masterScreen.alert_massage;
         String msg=element.getText();
         System.out.println(msg);
         if (element.getText().contains("Oops!TestName already exists")){
             driver.navigate().to("http://ahs.bananaapps.co.uk/Master/GroupTestNamesList");
         }else {
             System.out.println("false");
         }
         //if test name is not exit then what? like if you put TB13
     }
     public void validateNameEntry(){//1 to 5 per page
         //masterScreen.entries.click();
         WebElement element=masterScreen.num_entries;
             Select select = new Select(element);
             select.selectByValue("5");
     }
     public void validateSearchBox(String name){
         masterScreen.search_name.sendKeys(name);
         masterScreen.search_name.clear();
         driver.navigate().refresh();
     }
     public boolean searchGroupTestByName(String testname){
         boolean flag=false;
        List<WebElement>list=driver.findElements(By.xpath("//div[@class='table-scrollable']//tr//td[1]"));
         for (WebElement webElement : list) {
             System.out.println(webElement.getText());
             if (webElement.getText().equals(testname)) {
                 flag = true;
                 break;
             }
         }
        /* boolean flag=false;
        WebElement table=driver.findElement(By.id("sample"));
         List<WebElement> rows=table.findElements(By.tagName("tr"));
         for (WebElement row : rows) {
             String name = row.findElement(By.xpath("//td")).getText();
             System.out.println(name);
             if (name.equals(testname)) {
                 flag = true;
             }
         }
         return flag;
         */
         return flag;
     }
     public boolean changeGroupTestNameStatus() throws InterruptedException {
        masterScreen.select_option.click();
        List<WebElement> droupdown_list=driver.findElements(By.xpath("//div[@class='btn-group pull-right open']" +
                "//ul[@class='dropdown-menu pull-right']"));//similar method in MasterPageObject_AssignGroupTest
         System.out.println(droupdown_list.size());         //keep it both to understand difference.
         for (WebElement webElement : droupdown_list) {
             System.out.println(webElement.getText());
             if (webElement.getText().contains("Inactive")) {
                 webElement.click();
                 Thread.sleep(2000);
                 driver.switchTo().alert().accept();
                 driver.navigate().refresh();
             }
         }
         return true;
    }
    public void validateNextPageSign(){
         masterScreen.next_pagesign.click();
    }
    public void validatePreviousPageSign(){
         masterScreen.previous_pagesign.click();
    }
    public void validatePageNumber(){
         masterScreen.page_number.click();
    }
}