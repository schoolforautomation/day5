package tech.schoolforautomation.tests.signup;

import org.testng.Assert;
import org.testng.annotations.Test;

import tech.schoolforautomation.base.AppBaseTest;
import tech.schoolforautomation.model.SignUp;
import tech.schoolforautomation.selenium.modals.EnrollMeModal;
import tech.schoolforautomation.selenium.pages.HomePage;
import tech.schoolforautomation.selenium.pages.SignUpPage;

public class EnrollMeTest extends AppBaseTest {

    @Test
    public void enrollMeTest() {
        logger.info("Go to Home Page and click Get Started button");
        HomePage homePage = new HomePage(getWebDriver());
        SignUpPage signUpPage = homePage.clickGetStartedButton();

        logger.info("Fill the Sign Up form");
        SignUp signUp = new SignUp(2, 2, "Kevin", "kevin@email.com", "Test Message");
        EnrollMeModal enrollMeModal = signUpPage.fillSignUpForm(signUp);

        logger.info("Verify the correct values are displayed in the Enroll Me modal");
        Assert.assertEquals(enrollMeModal.getStudentName(), signUp.getName());
        Assert.assertEquals(enrollMeModal.getCourseName(), "Testing with Kafka");
        Assert.assertEquals(enrollMeModal.getLevel(), "Intermediate");
        Assert.assertEquals(enrollMeModal.getEmailAddr(), signUp.getEmail());

        logger.info("Close the Enroll Me modal");
        enrollMeModal.close();
    }
}
