import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void Setup() throws URISyntaxException {
        URL chromeDriver = getClass().getResource("chromedriver");
        System.setProperty("webdriver.chrome.driver", Paths.get(chromeDriver.toURI()).toAbsolutePath().toString());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities);
        driver.get("http://automationpractice.com/");
    }

    @After
    public void Teardown(){
        driver.close();
    }

}
