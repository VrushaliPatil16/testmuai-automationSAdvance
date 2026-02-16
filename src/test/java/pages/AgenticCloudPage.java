package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class AgenticCloudPage {

    WebDriver driver;
    WebDriverWait wait;

    By scaleSection =
            By.xpath("//*[contains(text(),'Seamlessly Scale with Agentic Cloud')]");

    By tryNowButton =
            By.xpath("//a[contains(text(),'Try Now For Free')]");

    public AgenticCloudPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void scrollToScaleSection() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(scaleSection));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickTryNow() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(tryNowButton));
        element.click();
    }
}
