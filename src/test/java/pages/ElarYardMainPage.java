package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarYardMainPage {
    WebDriver driver;
    public ElarYardMainPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
}
