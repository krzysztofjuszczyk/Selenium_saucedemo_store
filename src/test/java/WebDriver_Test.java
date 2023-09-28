import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriver_Test {
    @Test
    public void playWithDriver(){
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        driver.get("http://saucedemo.com");


        WebElement usernameTxt = driver.findElement(By.cssSelector("input[id='user-name']"));
        WebElement passwordTxt = driver.findElement(By.cssSelector("#password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("#login-button"));

        usernameTxt.sendKeys("asdf");
        passwordTxt.sendKeys("asdf" + Keys.ENTER);
        loginBtn.click();


    }



}
