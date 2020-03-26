package ahs.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MasterScreen {

    //===============================================================
    @FindBy(xpath ="//ul[@class='nav navbar-nav']/li[5]/a/i")
    public WebElement masters_link;
    @FindBy(xpath= "//li[@id='liAdmin']//li[3]//a[1]")
    public WebElement grouptest_link;
    @FindBy(xpath= "//a[@id='sample_editable_1_new']")
    public WebElement add_new_btn;
    @FindBy(id = "GrouptestName")
    public WebElement group_test_box;
    @FindBy(id= "Price")
    public WebElement price_box;
    @FindBy(xpath = "//button[@class='btn green']")
    public WebElement grouptest_submit_btn;
    @FindBy(xpath= "//input[@class='form-control input-sm input-small input-inline']")
    public WebElement search_name;
    @FindBy(xpath = "//li[@class='next']//a")
    public WebElement next_pagesign;
    @FindBy(xpath = "//li[@class='prev']//a")
    public WebElement previous_pagesign;
    @FindBy(xpath= "//a[contains(text(),'2')]")
    public WebElement page_number;
    @FindBy(xpath ="//div[@class='alert alert-danger']" )
    public WebElement alert_massage;
    @FindBy(xpath = "//select[@name='sample_length']")
    public WebElement num_entries;
    @FindBy(xpath = "//button[@class='btn green btn-xs btn-outline dropdown-toggle']")
    public WebElement select_option;
    @FindBy(xpath = "//div[@class='breadcrumbs']")
    public WebElement page_text;



}
