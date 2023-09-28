package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage typeUsername(String username){
        usernameTxt.clear();
        usernameTxt.sendKeys(username);
        return this;
    }

    public LoginPage typePassword (String password){
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public HomePage submitLogin(){
        loginBtn.click();
        return new HomePage(driver);
    }

    public LoginPage submitLoginWithFailure(){
        loginBtn.click();
        return this;
    }

}
