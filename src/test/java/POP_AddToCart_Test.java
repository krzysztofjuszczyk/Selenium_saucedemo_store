import org.testng.annotations.Test;
import pages.LoginPage;

public class POP_AddToCart_Test extends SeleniumBaseTest{
    @Test
    public void correctlyAddToCart() {
        String name  = "Backpack";
        new LoginPage(driver).submitDefaultLogin()
                .addItemToCart(name)
                .goToShoppingCart();
    }
}

