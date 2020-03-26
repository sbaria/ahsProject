package ahs.Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MasterScreen_SubTest {
    @FindBy(xpath = "//a[contains(text(),'Sub Test')]")
    public WebElement subtest_link;
    @FindBy(xpath = "//a[@id='sample_editable_1_new']")
    public WebElement add_btn;
    @FindBy(xpath = "//select[@id='maintestlist']")
    public WebElement select_test;
    @FindBy(id = "SubTestName")
    public WebElement subtest_name;
    @FindBy(id = "price")
    public WebElement test_price;
    @FindBy(xpath = "//button[@class='btn green']")
    public WebElement submit_button;
    @FindBy(xpath = "//div[@class='breadcrumbs']")
    public WebElement page_text;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement errorMassge;
    @FindBy(xpath = "//I[@class='fa fa-trash']")
    public WebElement delete_btn;
    @FindBy(xpath = "//h4[@class='caption-subject bold uppercase']")
    public WebElement subTestPage_text;



}
