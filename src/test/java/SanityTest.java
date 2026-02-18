import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SanityTest {
    @Test // testNG annotation that tells the compiler to treat this method as a test case that can be run and reported on
    public void testBrowserOpens(){
        WebDriver driver = new ChromeDriver(); // WebDriver is an interface (set of rules for how a browser should behave)
        // chrom driver is the implementation. We are telling selenium to use the Chrome engine to follow those WebDriver rules
        driver.get("https://www.google.com"); // this command tells the browser to navigate to a specific URL.
        // it waits for the page to finish loading before moving to the next line of code
        System.out.println("Title is: " + driver.getTitle());
        // fetches the text found in the <title> tag of the website's HTML.
        driver.quit(); // closes all browser windows and safely ends the WebDriver session.
        // without this your computer's memory would eventually clog up with ghost browser processes
    }
}
