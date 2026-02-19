package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// this base test is the foundation of the entire automation framework.
// Its purpose is to eliminate code duplication by centralizing the setup and teardown logic that every single
// test case needs
public class BaseTest {
    protected WebDriver driver; // protected means this variable can be inhereiteid by your test classes

    @BeforeMethod // this tells TestNG: Run this code BEFORE every single @Test
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // makes the browser full screen so all the buttons are visible
        driver.get("https://parabank.parasoft.com/parabank/index.htm"); // tells the browser to navigate specifically to the ParaBank homepage
    }

    @AfterMethod // this tells TestNG to run this code after every single @Test
    public void tearDown()
    {
        // check if the browser is actually open before trying to close it
        if(driver != null)
        {
            driver.quit(); // safely closes all windows and kills the background processes
        }
    }
}
