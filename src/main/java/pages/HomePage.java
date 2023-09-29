package pages;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "title")
    private WebElement productsTxt;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerButton;

    @FindBy(className= "bm-menu-wrap")
    private WebElement leftMenu;

    @FindBy(id = "about_sidebar_link")
    private WebElement leftMenu_About;

    public boolean isMenuHidden(){
        return leftMenu.getAttribute("aria-hidden").contains("true");
    }

    private HomePage expandLeftMenu(){
        if (isMenuHidden()) burgerButton.click();
        return this;
    }

    public HomePage assertProductsElementIsShown(){
        Assert.assertTrue(productsTxt.isDisplayed());
        Assert.assertTrue(productsTxt.getText().contains("Products"), "element doesn't contain word 'Products'");
        return this;
    }

    public void assertAboutWorking(){
        expandLeftMenu();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(leftMenu_About));
        leftMenu_About.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://saucelabs.com/"));
    }
}
