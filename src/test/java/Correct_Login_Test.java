import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Correct_Login_Test {
    @Test
    public void correctLoginTest(){
        String name = "standard_user";
        String password = "secret_sauce";
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
        passwordTxt.sendKeys(password);
        loginBtn.click();

    }
}
