package ahs.Screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LoginScreen {


    @FindBy(how = How.ID, using = "MobileNumber")
    public WebElement username_TextBox;

    @FindBy(how = How.ID, using = "Password")
    public WebElement password_TextBox;

    @FindBy(how = How.CLASS_NAME, using = "chic-button")
    public WebElement login_Button;
}
