package registration.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import registration.core.BaseHelper;

import java.util.List;

public class AddItemToCartHelper extends BaseHelper {

    public AddItemToCartHelper(WebDriver driver) {
        super(driver);
    }

    public void addToCard() {
        click(By.cssSelector(".item-box:nth-child(3) .button-2"));
    }

    public void clickOnShoppingCart() {
        click(By.cssSelector(".ico-cart > .cart-label"));
    }

    public boolean isItemAddedByText(String text) {
        List<WebElement> elements=driver.findElements(By.cssSelector(".product > a.product-name"));
        for (WebElement el : elements) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
}
