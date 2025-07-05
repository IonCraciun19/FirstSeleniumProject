package registration.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import registration.core.BaseHelper;
import registration.models.RegisteredUser;
import registration.models.User;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void fillRegisterForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegisterButton() {
        click(By.name("register-button"));
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public boolean isLogInLinkPresent() {
        return isElementPresent(By.cssSelector("[href='login']"));
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }


}
