package tech.schoolforautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void getStarted() {
        new WebDriverWait(getWebDriver(), 3)
                .until(webDriver -> webDriver.findElement(By.id("get-started"))).click();
    }
}
