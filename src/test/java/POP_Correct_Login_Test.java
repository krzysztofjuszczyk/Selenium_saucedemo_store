import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class POP_Correct_Login_Test {
    private WebDriver driver;

    @Test
    public void correctLoginTest(){
        String webpage = "http://saucedemo.com";
        String name = "standard_user";
        String password = "secret_sauce";

        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(webpage);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(name)
                .typePassword(password);

        HomePage homePage = loginPage.submitLogin();

        Assert.assertTrue(homePage.productsTxt.isDisplayed());
        Assert.assertTrue(homePage.productsTxt.getText().contains("Products"), "element doesn't contain word 'Products'");
    }
}
