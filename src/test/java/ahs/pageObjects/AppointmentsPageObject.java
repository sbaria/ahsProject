package ahs.pageObjects;

import ahs.Screens.AppointmentScreen;
import ahs.support.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AppointmentsPageObject extends basePage {
    AppointmentScreen appointmentScreen=new AppointmentScreen();

    public AppointmentsPageObject(){
        driver = BrowserFactory.getBrowser();
        PageFactory.initElements(driver, appointmentScreen);
    }
    public void validateAppoinmentLink(String page){
            List<WebElement> link = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a/i"));
            if (page.equals("Appointment Details")) {
                link.get(0).click();
            } else link.get(1).click();
    }
    public void navigateTo(String page) throws Exception {//not working
        for(WebElement link:appointmentScreen.menu_links){
            if(page.equals(link.getText())){
                link.click();
                return;
            }
        }
        throw new Exception("Menu item not found"+page);
    }
    public void enterDateRange(String fromdate,String toDate){
        appointmentScreen.fromdate_box.sendKeys(fromdate);
        appointmentScreen.toDate_box.sendKeys(toDate);
        appointmentScreen.submit_button.click();
    }
    public void validateEntryFunction(){
        WebElement entry =appointmentScreen.noOf_entry;
        Select select=new Select(entry);
        select.selectByVisibleText("All");
    }
    public void searchEntry(String name){
        appointmentScreen.search_button.clear();
        appointmentScreen.search_button.sendKeys(name);
        appointmentScreen.plus_sign.click();
        driver.navigate().refresh();
    }
    public boolean verifyPatientEntry(String patientName){
        boolean flag=false;
        List<WebElement> entry_list=driver.findElements(By.xpath("//table[@id='sample_123']//tbody//tr//td[3]"));
        System.out.println(entry_list.size());
        for (WebElement webElement : entry_list) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals(patientName)) {
               flag=true;
                break;
            }
        }
        return flag;
    }
    public void verifyArrowButton(){
        appointmentScreen.arrow_button.click();
    }
    public void verifyAssignUser(){//not working but this the method to catch alert
        appointmentScreen.assignUser_tab.click();
        appointmentScreen.submit_button2.click();
        // Switch the driver context to the alert
        //Alert alertDialog = driver.switchTo().alert();
        // Get the alert text
        // alertText = alertDialog.getText();
        // Click the OK button on the alert.
        //alertDialog.accept();
        String alertText=driver.switchTo().alert().getText();
        System.out.println(alertText);
        if (alertText.contains("Please select an item in the list")){
            driver.navigate().to("http://ahs.bananaapps.co.uk/ObservedValues/ObservedValues");
        }else {
            System.out.println("false");
        }
    }
    public void verifyCancelAction(String name){
        appointmentScreen.search_button.sendKeys(name);
        WebElement element=driver.findElement(By.xpath("//div[@class='table-scrollable']//td[10]"));
        if(element.getText().contains("Canceled")){
            driver.navigate().refresh();
        }else {if (element.getText().contains("Pending")) {
            appointmentScreen.cancel_tab.click();
            appointmentScreen.send_text.sendKeys(name);
            appointmentScreen.send_button.click();
        }
        }

    }
    public String verifyReturnPge(){
        return appointmentScreen.inner_text.getText();
    }
    public String validatePageUrl(){
        return driver.getCurrentUrl();
    }
}