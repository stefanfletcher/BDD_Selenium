package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base_Class {

    // Instantiate
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    private final By Login_Username = By.xpath("//input[@name='username']");
    private final By Login_Password = By.xpath("//input[@name='password']");
    private final By Login_Submit = By.xpath("//button[@type='submit']");
    private final By FailedLogin = By.xpath("//div[@class='oxd-alert oxd-alert--error']");


    public String getLoginPageSource() {
        return driver.getPageSource();
    }

    public Boolean FailedLoginError() {
        Boolean Failedloginisdisplayed = driver.findElement(FailedLogin).isDisplayed();
        return Failedloginisdisplayed;
    }

    public void EnterUsername(String Email) {
        driver.findElement(Login_Username).sendKeys(Email);
    }
    public void EnterPassword(String Password) {
        driver.findElement(Login_Password).sendKeys(Password);
    }
    public void ClickLoginSubmit() {
        driver.findElement(Login_Submit).click();
    }



}


