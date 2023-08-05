package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarYardLoginPage {
    WebDriver driver;
    public ElarYardLoginPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "input-login")
    public WebElement loginInput;

    @FindBy(id = "id_input_pass")
    public WebElement passwordInput;

    @FindBy(className = "btn-login")
    public WebElement loginBtn;
}
