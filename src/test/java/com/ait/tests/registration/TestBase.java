package com.ait.tests.registration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled=false)
    public void tearDown(){
        driver.quit();
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void type(By locator, String text){
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void clickOnRegistrationLink(){
        click(By.cssSelector("[href='/register']"));
    }

    public void fillRegisterForm(User user){
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegisterButton(){
        click(By.name("register-button"));
    }

    public boolean isLogOutLinkPresent(){
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickOnLoginLink(){
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton(){
        click(By.cssSelector(".buttons:nth-child(5)"));
    }

    public void clickOnProductLink(){
        click(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[1]/a[1]"));
    }

    public void addToCard(){
        click(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));
    }

    public void clickOnShoppingCart(){
        click(By.xpath("//body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]/span[1]"));
    }

    public boolean isItemAddedByText(){
       return isElementPresent(By.linkText("Computing and Internet"));
    }

    public void fillLoginForm(RegisteredUser registeredUser){
        type(By.name("Email"), registeredUser.getEmail());
        type(By.name("Password"), registeredUser.getPassword());
    }

    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());

        if (alert==null){
            return false;
        }else {
            return true;
        }
    }
}
