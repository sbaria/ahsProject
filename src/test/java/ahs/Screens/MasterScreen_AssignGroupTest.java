package ahs.Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterScreen_AssignGroupTest {
    @FindBy(xpath = "//a[contains(text(),'Assign Group Test')]")
    public WebElement assignGroupTest_link;
    @FindBy(xpath = "//div[@class='breadcrumbs']")
    public WebElement page_text;
    @FindBy(xpath = "//a[@id='sample_editable_1_new']")
    public WebElement add_button;
    @FindBy(xpath = "//div[@class='form-body']//div[1]//div[1]//select[1]")
    public WebElement groupTestBox;
    @FindBy(xpath = "//div[@class='form-body']//div[2]//div[1]//select[1]")
    public WebElement mainTestBox;
    @FindBy(xpath = "//div[@class='form-body']//div[3]//div[1]//select[1]")
    public WebElement subTestBox;
    @FindBy(xpath = "//button[@class='btn green']")
    public WebElement submit_btn;
    @FindBy(xpath = "//i[@class='fa fa-trash']")
    public WebElement delete_btn;


}
