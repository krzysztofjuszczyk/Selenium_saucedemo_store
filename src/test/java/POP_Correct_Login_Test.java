import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class POP_Correct_Login_Test {
    private WebDriver driver;

    @DataProvider(name = "correctNames")
    public Object[][] getCorrectLoginNames(){
        return new Object[][]{
                {"standard_user"},
                {"locked_out_user"},
                {"problem_user"},
                {"performance_glitch_user"}
        };
    }

    @Test(dataProvider = "correctNames")
    public void correctLoginTest(String name){
        String webpage = "http://saucedemo.com";
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
