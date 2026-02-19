package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

// this page is where the logic of the test happens. It brings together the BaseTest and the LoginPage
// to perform a specific task and check if it worked
public class LoginTest extends BaseTest{ // because it inherits BaseTest, the browser will open @BeforeMethod and close @AfterMethod
    // automatically without you writing a single extra line of code here

    @Test
    public void testValidLogin()
    {
        // initialize our dictionary
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("john","demo");

        boolean isSuccess = driver.getCurrentUrl().contains("overview.htm");
        Assert.assertTrue(isSuccess, "Login Failed! We are not on the overview page!");
        // we use assert because if statements basically get skipped (when false) and the program moves to the next line
        // with Assert, if a login fails, Assert throws an Exception which tells TestNG to stop immediately and mark the test as FAIL in red
        // TestNG also automatically records exactly where it failed and prints your custom message
    }

    /*
    @Test
    public void testInvalidLoginErrorMessage(){
        LoginPage loginPage = new LoginPage(driver);

        // 1. attempt login with wrong password
        loginPage.login("john", "completely_wrong");

        // 2. verify the error message appears
        String errorText = loginPage.getErrorMessageText();
        Assert.assertEquals(errorText, "The username and password could not be verified",
                "the expected error message did not appear!" );

        // theres an issue where you need to tell Selenium to not just grab the text, wait up to 5 seconds for the error message
        // to actually appear on the screen. Alter the LoginPage getErrorMessageText() function



    }
    */

    @Test
    public void testEmptyLoginSecurity() {
        LoginPage loginPage = new LoginPage(driver);

        // Attempt login with absolutely nothing
        loginPage.login("", "");

        // Check for the exact text
        String actualError = loginPage.getErrorMessageText();
        String expectedError = "Please enter a username and password.";

        Assert.assertEquals(actualError, expectedError, "The blank login error message did not appear!");
    }

}
