package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    String username = "patilvb22nov21";
    String accessKey = "LT_BCIbGZ3M8ofU65bM9pEEnq3hZKuVHd9DMfTt7Qqfu3hnoRO";

    @BeforeMethod
    public void setup() throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "Chrome");
        options.setCapability("browserVersion", "latest");
        options.setCapability("platformName", "Windows 11");
        options.setCapability("name", "Selenium Advanced Assignment");

        String hubURL = "https://" + username + ":" + accessKey +
                "@hub.testmuai.com/wd/hub";

        driver = new RemoteWebDriver(new URL(hubURL), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
