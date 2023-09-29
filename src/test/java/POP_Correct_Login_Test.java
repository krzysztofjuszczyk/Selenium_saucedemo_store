import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class POP_Correct_Login_Test extends SeleniumBaseTest{

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
        String password = "secret_sauce";

        new LoginPage(driver)
                .typeUsername(name)
                .typePassword(password)
                .submitLogin()
                .assertProductsElementIsShown();
    }

    @Test
    public void correctLogin_About(){
        String password = "secret_sauce";
        String name = "standard_user";
        new LoginPage(driver)
                .typeUsername(name)
                .typePassword(password)
                .submitLogin()
                .assertProductsElementIsShown()
                .expandLeftMenu()
                .assertAboutWorking();
    }
}
