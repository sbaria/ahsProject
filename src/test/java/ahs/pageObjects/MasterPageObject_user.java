package ahs.pageObjects;

import ahs.Screens.MasterScreen_user;
import ahs.support.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MasterPageObject_user extends basePage {
    WebDriver driver;
    MasterScreen_user masterScreenUser=new MasterScreen_user();

    public MasterPageObject_user(){
        driver=BrowserFactory.getBrowser();
        PageFactory.initElements(driver,masterScreenUser);
    }
    public void validateUserTab(){
        masterScreenUser.user_tab.click();
    }
    public void inputDetail(String Name,String mobNumber,String emailID,String pswrd,String type,String branch){
        masterScreenUser.add_button.click();
        masterScreenUser.uers_name.sendKeys(Name);
        masterScreenUser.mobile_number.sendKeys(mobNumber);
        masterScreenUser.email_id.sendKeys(emailID);
        masterScreenUser.password.sendKeys(pswrd);
        WebElement element =masterScreenUser.user_type;
        Select select=new Select(element);
        select.selectByVisibleText(type);  //you can select or use sendkey
        masterScreenUser.branch_ID.sendKeys(branch);
        //masterScreenUser.submit_button.click();
    }
    public void submitButton(){
        masterScreenUser.submit_button.click();
    }
    public void cancelButton(){
        masterScreenUser.cancel.click();
    }
    public String pageText(){
        return masterScreenUser.page_text.getText();
    }
    public boolean verifyUserDetailsInList(String name){
      List<WebElement> list= driver.findElements(By.xpath("//div[@class='table-scrollable']//tr//td"));
        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if(webElement.getText().equals(name)){
                break;
            }
        }
        return true;
    }
    public boolean verifyErrorMessage(){
        masterScreenUser.submit_button.click();
        WebElement element=masterScreenUser.error_msg;
        String text=element.getText();
        System.out.println(text);
        if (text.contains("Oops!Mobile Number is already Existing")){
           driver.navigate().refresh();
        }else{
            System.out.println("Expected text not obtain");
        }
        return true;
    }
    public boolean verifyDisplayMessage1() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='table-scrollable']//tr"));
        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals("No matching records found")) {
                break;
            }
        }
        return true;
    }
    public boolean verifyDisplayMessage(){
        WebElement element=masterScreenUser.error_msg;
        String text=element.getText();
        System.out.println(text);
        if (text.contains("No matching records found")){
            driver.navigate().refresh();
        }else{
            System.out.println("Expected text not obtain");
        }
        return true;
    }
    public void editDetail(String name){
        masterScreenUser.search_box.sendKeys(name);
        masterScreenUser.edit_detail.click();
        masterScreenUser.cancel.click();
    }

    public void deleteDetail(String name){
        masterScreenUser.search_box.sendKeys(name);
        masterScreenUser.delete_detail.click();
        driver.switchTo().alert().accept();
    }
    public void searchDeletedName(String name){
        masterScreenUser.search_box.sendKeys(name);
    }
}
