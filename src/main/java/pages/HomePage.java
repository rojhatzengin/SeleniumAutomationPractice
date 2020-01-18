package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage scrollDownToProducts(){
        scrollDownToElement(By.id("homefeatured"));
        return this;
    }

    public List<WebElement> getAllParentCategories() {
        return waitAndReturnElements(By.cssSelector("#block_top_menu > ul > li"));
    }

    public List<WebElement> getAllFeaturedProducts() {
        return waitAndReturnElements(By.cssSelector("#homefeatured .ajax_block_product"));
    }

    public HomePage addProductToCart(int itemPos) {
        WebElement element = getAllFeaturedProducts()
                .get(itemPos);

        element.click();

        element.findElement(By.className("ajax_add_to_cart_button"))
                .click();

        return this;
    }

    public SignInPage navigateToSignIn() {
        scrollUp();
        waitAndReturnElement(By.className("login")).click();

        return new SignInPage(driver);
    }

}
