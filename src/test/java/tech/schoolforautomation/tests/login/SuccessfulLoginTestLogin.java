package tech.schoolforautomation.tests.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import tech.schoolforautomation.base.LoginBaseTest;
import tech.schoolforautomation.selenium.pages.LoginPage;

public class SuccessfulLoginTestLogin extends LoginBaseTest {

    @Test
    public void successfulLoginTest() {
        logger.info("Go to Landing Page");
        goToLandingPage();

        logger.info("Create LoginPage object and log in a valid user");
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("tester", "test1234");

        logger.info("Verify login was successful");
        WebElement getStartedButton = new WebDriverWait(getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.id("get-started")));
        Assert.assertTrue(getStartedButton.isDisplayed());
    }
}
