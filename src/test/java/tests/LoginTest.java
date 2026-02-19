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
}
