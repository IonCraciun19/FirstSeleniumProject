package registration.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import registration.fw.AddItemToCartHelper;
import registration.fw.RegisteredUserHelper;
import registration.fw.UserHelper;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;

    UserHelper user;
    RegisteredUserHelper registeredUser;
    AddItemToCartHelper addItemToCart;

    public void init() {
        driver=new ChromeDriver();
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
