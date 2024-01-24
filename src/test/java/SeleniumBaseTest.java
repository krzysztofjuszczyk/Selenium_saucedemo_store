import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SeleniumBaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void baseBeforeMethod(){
        String webpage = "http://saucedemo.com";

        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(webpage);
    }

    @AfterMethod
    public void baseAfterMethod(){
//        driver.quit();
    }
}
