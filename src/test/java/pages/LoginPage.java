package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// this class is like a dictionary. It tells your code: "When I say 'usernameField', I mean this specific box on the screen."
// its a helper class, it doesnt actually have its own browser going on
public class LoginPage {
    private WebDriver driver;

    // the locators
    // private By ... these variables store the address of the elements. We dont find them yet, we just define how to find them
    // if you just stored a string like String userBox = "username" then Selenium wouldn't know if that's the name, the id, or
    // a piece of text on the screen

    // By is a specific instruction that tells the Selenium engine to go to the HTML and look specifically for the attribute
    // private because of encapsulation. We don't want the test scripts to accidentally change the address of the login button

    private By usernameField = By.name("username"); // tells Selenium to look for an HTML tag where name="username"
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//input[@value='Log In']"); // tells Selenium to look for an <input> tag that has the
    // text "Log In" on it

    public LoginPage(WebDriver driver) // the constructor
    {
        // takes the active browser window from your BaseTest and hands it to this page class. Without this handshake
        // the LoginPage wouldn't know which browser window to type in
        this.driver = driver;
    }

    // this method combines multiple steps into one easy action
    public void login(String user, String pass)
    {
        // driver.findElement(..) this is where Selenium actually goes to the webpage and looks for the box
        // .sendKeys(user) this is the command to type text into a box
        // .click() this mimics a human mouse-click on the button

        // .findElement is like actually adding action to the shopping list, finding the item (from the By locator)
        // send keys sends a sequence of keyboard events to that specific HTML element
        // we dont use setText because sendKeys mimics a real keyboard. It triggers Key down and Key Up events in the browsers background
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

}
