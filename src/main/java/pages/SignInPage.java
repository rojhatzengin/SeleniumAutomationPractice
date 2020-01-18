package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void createAnAccount() {
        long unixTime = System.currentTimeMillis() / 1000L;
        String dummyEmail = "example-" + unixTime + "@example.com";

        WebElement emailField = waitAndReturnElement(By.id("email_create"));
        emailField.sendKeys(dummyEmail);

        WebElement submitCreate = waitAndReturnElement(By.id("SubmitCreate"));
        submitCreate.click();

        waitAndReturnElement(By.id("customer_firstname"))
                .sendKeys("Rojhat");
        waitAndReturnElement(By.id("customer_lastname"))
                .sendKeys("Zengin");
        waitAndReturnElement(By.id("passwd"))
                .sendKeys("123123");
        waitAndReturnElement(By.id("firstname"))
                .sendKeys("Rojhat");
        waitAndReturnElement(By.id("lastname"))
                .sendKeys("Zengin");
        waitAndReturnElement(By.id("address1"))
                .sendKeys("Street address, P.O. Box, Company name, etc");
        waitAndReturnElement(By.id("city"))
                .sendKeys("Istanbul");

        new Select(driver.findElement(By.id("id_state")))
                .selectByValue("1");

        waitAndReturnElement(By.id("postcode"))
                .sendKeys("34200");

        new Select(driver.findElement(By.id("id_country")))
                .selectByValue("21");

        waitAndReturnElement(By.id("phone_mobile"))
                .sendKeys("0505 555 55 55");

        waitAndReturnElement(By.id("alias"))
                .sendKeys("My Address");

        WebElement submitAccount = waitAndReturnElement(By.id("submitAccount"));
        submitAccount.click();
    }

}
