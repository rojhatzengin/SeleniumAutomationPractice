import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.SignInPage;

import java.util.List;

public class HomeTest extends BaseTest {

    @Test
    public void ShouldHaveSevenFeaturedProducts(){
        HomePage homePage = new HomePage(driver);

        List<WebElement> products = homePage.scrollDownToProducts().getAllFeaturedProducts();

        Assert.assertEquals(products.size(), 7);
    }

    @Test
    public void ShouldHaveThreeParentCategories(){
        HomePage homePage = new HomePage(driver);

        List<WebElement> parentCategories = homePage.getAllParentCategories();

        Assert.assertEquals(parentCategories.size(), 3);
    }

    @Test
    public void ShouldAddProductToCartSuccessfully() {
        HomePage homePage = new HomePage(driver);

        homePage.scrollDownToProducts()
                .addProductToCart(0);
        homePage.waitForCheckoutModal();
        homePage.scrollUp();

        String cartQty = homePage.waitAndReturnElement(By.className("ajax_cart_quantity")).getText();

        Assert.assertEquals(cartQty, "1");
    }

    @Test
    public void ShouldNavigateToSignIn() {
        HomePage homePage = new HomePage(driver);

        SignInPage signInPage = homePage.navigateToSignIn();

        Assert.assertEquals(signInPage.getPageHeading(), "AUTHENTICATION");
    }

}
