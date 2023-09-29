import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class POP_Incorrect_Login_Test extends SeleniumBaseTest{
    @DataProvider
    public Object[][] getIncorrectNames(){
        return new Object[][]{
                {"a"},
                {"12345678 "},
                {"standard_use"},
                {"ocked_out_user"},
                {"roblem_use"},
                {" performance_glitch_user"}
        };
    }

    @Test(dataProvider = "getIncorrectNames")
    public void incorrectLoginTest_incorrectName(String name){
        String password = "secret_sauce";
        new LoginPage(driver)
                .typeUsername(name)
                .typePassword(password)
                .submitLoginWithFailure();
    }
}
