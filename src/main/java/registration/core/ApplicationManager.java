package registration.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import registration.fw.AddItemToCartHelper;
import registration.fw.RegisteredUserHelper;
import registration.fw.UserHelper;

import java.time.Duration;

public class ApplicationManager {

    String browser;

    WebDriver driver;

    UserHelper user;
    RegisteredUserHelper registeredUser;
    AddItemToCartHelper addItemToCart;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user=new UserHelper(driver);
        registeredUser=new RegisteredUserHelper(driver);
        addItemToCart=new AddItemToCartHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public RegisteredUserHelper getRegisteredUser() {
        return registeredUser;
    }

    public AddItemToCartHelper getAddItemToCart() {
        return addItemToCart;
    }
}
