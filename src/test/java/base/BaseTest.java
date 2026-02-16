package base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    String username = "patilvb22nov21";
    String accessKey = "LT_BCIbGZ3M8ofU65bM9pEEnq3hZKuVHd9DMfTt7Qqfu3hnoRO";

    @Parameters({"browser", "browserVersion", "platformName", "testName"})
    @BeforeMethod(alwaysRun = true)
    public void setup(String browser,
                      String browserVersion,
                      String platformName,
                      String testName) throws Exception {

        MutableCapabilities options;

        if (browser.equalsIgnoreCase("Chrome")) {
            options = new ChromeOptions();
        } else {
            options = new EdgeOptions();
        }

        options.setCapability("browserName", browser);
        options.setCapability("browserVersion", browserVersion);
        options.setCapability("platformName", platformName);

        // TestMu AI specific capabilities
        Map<String, Object> testmuOptions = new HashMap<>();
        testmuOptions.put("name", testName);
        testmuOptions.put("build", "Selenium Advanced Assignment");
        testmuOptions.put("networkLogs", true);
        testmuOptions.put("consoleLogs", true);
        testmuOptions.put("video", true);
        testmuOptions.put("screenshots", true);

        options.setCapability("testmu:options", testmuOptions);

        String hubURL = "https://" + username + ":" + accessKey +
                "@hub.testmuai.com/wd/hub";

        driver = new RemoteWebDriver(new URL(hubURL), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
