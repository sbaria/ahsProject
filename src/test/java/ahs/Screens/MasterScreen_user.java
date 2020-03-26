package ahs.Screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterScreen_user {
    @FindBy(xpath = "//a[contains(text(),'Users')]//i")
    public WebElement user_tab;
    @FindBy(xpath = "//a[@id='sample_editable_1_new']")
    public WebElement add_button;
    @FindBy(css = "#UserName")
    public WebElement uers_name;
    @FindBy(css = "#MobileNumber")
    public WebElement mobile_number;
    @FindBy(css = "#EmailID")
    public WebElement email_id;
    @FindBy(css = "#Password")
    public WebElement password;
    @FindBy(css = "#UserType")
    public WebElement user_type;
    @FindBy(css = "#BranchID")
    public WebElement branch_ID;
    @FindBy(xpath = "//button[@class='btn green']")
    public WebElement submit_button;
    @FindBy(linkText = "Cancel")
    public WebElement cancel;
    @FindBy(xpath = "//div[@class='table-scrollable']//tr//td")
    public WebElement table;
    @FindBy(xpath = "//h1[contains(text(),'User Details')]")
    public WebElement page_text;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement search_box;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement error_msg;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    public WebElement displayMessage_row;
    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    public WebElement edit_detail;
    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement delete_detail;

}
