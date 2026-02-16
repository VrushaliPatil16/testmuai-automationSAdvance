package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By exploreAgenticCloud =
            By.xpath("//a[contains(text(),'Explore Agentic Clouds')]");

    By communityLink = By.linkText("Community");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openWebsite() {
        driver.get("https://www.testmuai.com/");

        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public void scrollToExploreAgenticCloud() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(exploreAgenticCloud));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickExploreAgenticCloud() {
        driver.findElement(exploreAgenticCloud).click();
    }

    public void clickCommunity() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(communityLink));
        element.click();
    }
}
