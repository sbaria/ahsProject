package ahs.pageObjects;

import ahs.Screens.RegistrationScreen;
import ahs.support.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class RegisterPageObject extends basePage{
   // WebDriver driver;
    RegistrationScreen registrationScreen=new RegistrationScreen();
    AppointmentsPageObject appointmentsPageObject=new AppointmentsPageObject();
    public RegisterPageObject(){
        driver= BrowserFactory.getBrowser();
        PageFactory.initElements(driver,registrationScreen);
    }
    public void validateRegisterLink(){
        registrationScreen.register_link.click();
    }
    public String validateInnerText(){
        return registrationScreen.taxt.getText();
    }

    public void genderSelection(String gender){
        List<WebElement> gender_list=driver.findElements(By.xpath("//input[@id='Gender']"));
        System.out.println(gender_list.size());
        if (gender.equals("Male")) {
            gender_list.get(0).click();
        } else if (gender.equals("Female")) {
             gender_list.get(1).click();
        }
    }
    public void select_Status(String status) {
        List<WebElement> status_list=driver.findElements(By.xpath("//div[@class='md-radio-inline']//div"));
        System.out.println(status_list.size());
        if (status.equals("New User")) {
            status_list.get(0).click();
        } else if (status.equals("Existing")) {
            status_list.get(1).click();
        }
    }
    public void enterValidDetail( String Name,String Age,String refDoctor,String MobileNumber,String email,String address) throws InterruptedException {
        registrationScreen.name.clear();
        registrationScreen.name.sendKeys(Name);
        registrationScreen.age.clear();
        registrationScreen.age.sendKeys(Age);
        registrationScreen.refDoctor.clear();
        registrationScreen.refDoctor.sendKeys(refDoctor);
        registrationScreen.mobile_no.clear();
        registrationScreen.mobile_no.sendKeys(MobileNumber);
        registrationScreen.email.clear();
        registrationScreen.email.sendKeys(email);
        registrationScreen.address.clear();
        registrationScreen.address.sendKeys(address);


    }

    public void selectDate(String date) throws InterruptedException {
        registrationScreen.appointment_box.sendKeys(date);
    }

    public void appointmentTime(){//to select random time from drop down
        WebElement dropdown_list = registrationScreen.time;
        Select obj_select = new Select(dropdown_list);
        List<WebElement> list = obj_select.getOptions();
        int noOfItem = list.size();
        Random num = new Random();
        int iselect = num.nextInt(noOfItem);
        obj_select.selectByIndex(iselect);
    }
    public void selectTime(String time){//to select parametrise time
        List<WebElement> time_list=driver.findElements(By.xpath("//select[@id='TimeSlotID']//option"));
        System.out.println(time_list.size());
        for (WebElement webElement : time_list) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals(time)) {
                webElement.click();
                break;
            }
        }
    }
    public void appointmentBranch(String branch) {
        WebElement element = registrationScreen.branch_name;
        Select select = new Select(element);
        select.selectByVisibleText(branch);
    }
    public void selectTest(){
            registrationScreen.test_HAEMATOLOGY.click();
            List<WebElement>listofbutton=driver.findElements(By.xpath("//div[@class='btn-group open']//li"));
            Random random = new Random();
            int index = random.nextInt(listofbutton.size());
            listofbutton.get(index).click();
    }
    public AppointmentsPageObject confirmBooking() throws InterruptedException {
        registrationScreen.booking_button.click();
        /*another way to assert
         if(driver.getCurrentUrl().equalsIgnoreCase("url")){
            System.out.println("test pass");
        }else {
            System.out.println("test fail");
        }

         */
        return new AppointmentsPageObject();
    }
//    public String validatePageUrl(){
//       return driver.getCurrentUrl();
//    }
    public String verifyReturnPge(){
        return registrationScreen.return_page.getText();
    }
}