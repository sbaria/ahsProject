package ahs.pageObjects;

import ahs.Screens.MasterScreen_AssignGroupTest;
import ahs.support.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class MasterPageObject_AssignGroupTest extends basePage {
     WebDriver driver;
     MasterScreen_AssignGroupTest masterScreenAGT=new MasterScreen_AssignGroupTest();

    public MasterPageObject_AssignGroupTest(){
     driver= BrowserFactory.getBrowser();
         PageFactory.initElements(driver,masterScreenAGT);
     }

     public void validateAssignGroupTest(){
         masterScreenAGT.assignGroupTest_link.click();
     }

     public boolean verifyPageText(){
         WebElement element=masterScreenAGT.page_text;
         String text=element.getText();
         System.out.println(text);
         if (text.contains("ASSIGN GROUPTEST LIST")){
             System.out.println("Expected text obtain");
         }else{
             System.out.println("Expected text not obtain");
         }
         return true;
     }

     public void validateTestAddBtn(){
         masterScreenAGT.add_button.click();
     }

     public void validateAddTestBox(){
         // How to create reusable method
         //group test
         WebElement dropdown_list=masterScreenAGT.groupTestBox;
         Select obj_select=new Select(dropdown_list);//to fetch the count
         List<WebElement> list=obj_select.getOptions();
         int noOfItem=list.size();//to count the list
         Random num=new Random(); //to generate random value
         int iselect=num.nextInt(noOfItem);//to read the value
         obj_select.selectByIndex(iselect);//to select the value from the dropdown list
         //main test
         WebElement dropdown_list2=masterScreenAGT.mainTestBox;
         Select obj_seleect2=new Select(dropdown_list2);
         List<WebElement>list2=obj_seleect2.getOptions();
         int noOfItem2=list2.size();
         Random num2=new Random();
         int iselect2=num2.nextInt(noOfItem2);
         obj_seleect2.selectByIndex(iselect2);
         //sub test
         WebElement dropdown_list3=masterScreenAGT.subTestBox;
         Select obj_select3=new Select(dropdown_list3);
         List<WebElement> list3=obj_select3.getOptions();
         int noOfItem3=list3.size();
         Random num3=new Random();
         int iselect3=num3.nextInt(noOfItem3);
         obj_select3.selectByIndex(iselect3);
         //submit button
         masterScreenAGT.submit_btn.click();
     }

     public boolean varifyTestNameInTestList(String subtest) throws InterruptedException {
         boolean flag = false;
        List<WebElement> list=driver.findElements(By.xpath("//div[@class='table-scrollable']//td[2]"));
        for(WebElement element:list){
            System.out.println(element.getText());
            if (element.getText().equals(subtest)) {
                flag = true;
                break;
            }
        }
         return flag;
     }

     public void deleteAddedTest() throws InterruptedException {
        masterScreenAGT.delete_btn.click();
        Thread.sleep(2000);
         driver.switchTo().alert().dismiss();
     }
}
