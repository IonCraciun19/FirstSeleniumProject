package registration.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import registration.core.BaseHelper;
import registration.models.RegisteredUser;

public class RegisteredUserHelper extends BaseHelper {
    public RegisteredUserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink(){
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLogOutLink(){
        click(By.cssSelector("[href='/logout']"));
    }

    public void clickOnLoginButton(){
        click(By.cssSelector(".buttons:nth-child(5)"));
    }

    public void fillLoginForm(RegisteredUser registeredUser){
        type(By.name("Email"), registeredUser.getEmail());
        type(By.name("Password"), registeredUser.getPassword());
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

   public void login(String email, String password) {
        clickOnLoginLink();
        fillLoginForm(new RegisteredUser().setEmail(email)
                .setPassword(password));
        clickOnLoginButton();
    }
}
