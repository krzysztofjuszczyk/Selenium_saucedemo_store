import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Incorrect_Login_Test {
    @Test
    public void correctLoginTest(){
            String name = "standard_user";
        String incorrectPassword1 = "secret_sauce1";
        String webpage = "http://saucedemo.com";

        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(webpage);

        WebElement usernameTxt = driver.findElement(By.cssSelector("input[id='user-name']"));
        WebElement passwordTxt = driver.findElement(By.cssSelector("#password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("#login-button"));

        usernameTxt.sendKeys(name);
        passwordTxt.sendKeys(incorrectPassword1);
        loginBtn.click();

        WebElement errorElm = driver.findElement(By.cssSelector(".error-message-container > h3:nth-child(1)"));
        Assert.assertEquals(errorElm.getText(),"Epic sadface: Username and password do not match any user in this service");
    }
}
