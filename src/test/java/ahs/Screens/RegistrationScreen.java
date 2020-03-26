package ahs.Screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen {
    @FindBy(xpath = "//li[@id='liRegistration']//a[1]")
    public WebElement register_link;
    @FindBy(xpath = "//input[@id='AppointmentDate']")
    public WebElement appointment_box;
    @FindBy(xpath = "//div[@class='portlet-body']//div[2]//div[1]//span[1]//div[1]//button[1]//span[1]")
    public WebElement test_HAEMATOLOGY;
    @FindBy(xpath = "//button[@id='btnBook']")
    public WebElement booking_button;
    @FindBy(css = "#Name")
    public WebElement name;
    @FindBy(css = "#Age")
    public WebElement age;
    @FindBy(css = "#RefDoctor")
    public WebElement refDoctor;
    @FindBy(css = "#MobileNumber")
    public WebElement mobile_no;
    @FindBy(css = "#Email")
    public WebElement email;
    @FindBy(css = "#Address")
    public WebElement address;
    @FindBy(css = "#BranchID")
    public WebElement branch_name;
    @FindBy(xpath = "//select[@id='TimeSlotID']//option")
    public WebElement time;
    @FindBy(xpath = "//span[@class='caption-subject font-red sbold uppercase']" )
    public WebElement taxt;
    @FindBy(xpath = "//h1[contains(text(),'Appointments Details')]" )
    public WebElement return_page;
}
