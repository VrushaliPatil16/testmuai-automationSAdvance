package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestMuaiTest extends BaseTest {

    @Test
    public void seleniumAdvancedAssignmentFlow() {

        HomePage homePage = new HomePage(driver);

        // 1 & 2
        homePage.openWebsite();

        // 3
        homePage.scrollToExploreAgenticCloud();

        // 4
        String parentWindow = driver.getWindowHandle();
        homePage.clickExploreAgenticCloud();

        // Wait until new tab opens
        new org.openqa.selenium.support.ui.WebDriverWait(driver,
                java.time.Duration.ofSeconds(20))
                .until(d -> driver.getWindowHandles().size() == 2);

        // 5
        Set<String> handles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(handles);

        System.out.println("Window Handles:");
        for (String handle : windowList) {
            System.out.println(handle);
        }

        // Identify child window
        String childWindow = null;
        for (String handle : windowList) {
            if (!handle.equals(parentWindow)) {
                childWindow = handle;
            }
        }

        driver.switchTo().window(childWindow);

        // 6
        String expectedUrl =
                "https://www.testmuai.com/agentic-cloud/";
        Assert.assertEquals(driver.getCurrentUrl(),
                expectedUrl, "URL mismatch!");

        AgenticCloudPage agenticPage =
                new AgenticCloudPage(driver);

        // 7
        agenticPage.scrollToScaleSection();

        // 8
        agenticPage.clickTryNow();

        SignUpPage signUpPage =
                new SignUpPage(driver);

        // 9
        String expectedTitle =
                "Sign up for free | Cross Browser Testing Tool";
        Assert.assertEquals(signUpPage.getPageTitle(),
                expectedTitle, "Title mismatch!");

        // 10
        driver.switchTo().window(childWindow);
        driver.close();

        // 11
        driver.switchTo().window(parentWindow);
        System.out.println("Current Window Count: "
                + driver.getWindowHandles().size());

        // 12
        driver.get("https://www.testmuai.com/blog");

        // 13
        homePage.clickCommunity();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://community.testmuai.com/",
                "Community URL mismatch!");

        // 14
        driver.close();
    }
}

