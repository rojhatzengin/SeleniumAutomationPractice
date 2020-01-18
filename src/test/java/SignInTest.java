import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.SignInPage;

public class SignInTest extends BaseTest {

    @Test
    public void ShouldCreateNewAccount() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.navigateToSignIn();

        signInPage.createAnAccount();

        WebElement account = homePage.waitAndReturnElement(By.className("account"));

        Assert.assertEquals(account.getText(), "Rojhat Zengin");
    }

}
