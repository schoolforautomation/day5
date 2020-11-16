package tech.schoolforautomation.base;

import org.testng.annotations.BeforeTest;

import lombok.Getter;
import tech.schoolforautomation.selenium.pages.LoginPage;

@Getter
public class AppBaseTest extends BaseTest {

    @BeforeTest
    public void logIntoApp() {
        goToLandingPage();
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("tester", "test1234");
    }
}
