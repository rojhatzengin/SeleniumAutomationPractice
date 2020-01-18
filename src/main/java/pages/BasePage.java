package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private int TIMEOUT_DURATION;

    public BasePage(WebDriver driver){
        this.driver = driver;
        TIMEOUT_DURATION = 30;
    }

    public void scrollDownToElement(By selector){
        WebElement element = driver.findElement(selector);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollDownToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("scrollTo(0, 0);");
    }

    public void waitFor(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_DURATION);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public WebElement waitAndReturnElement(By selector){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_DURATION);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public List<WebElement> waitAndReturnElements(By selector){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_DURATION);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public String getPageHeading() {
        return waitAndReturnElement(By.className("page-heading")).getText();
    }

    public void waitForCheckoutModal() {
        waitFor(By.id("layer_cart"));
    }

}
