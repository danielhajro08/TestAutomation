package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseURL = "https://ecommerce.tealiumdemo.com/";
        driver.get(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    @AfterClass
    public void endTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void closePopUp(){
        if (!driver.findElements(By.className("close_btn_thick")).isEmpty()) {
            WebElement closePopUp = driver.findElement(By.className("close_btn_thick"));
            if (closePopUp.isDisplayed()) {
                closePopUp.click();
            }
        }
    }
    
    String emailString = "aabb108787203@gmail.com";
    String passwordString = "asdqwe123";

    @Test
    public void registerTest(){
        
        closePopUp();

        WebElement accountImage = driver.findElement(By.linkText("ACCOUNT"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", accountImage);
        accountImage.click();
        
        WebElement registerElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", registerElement);
        registerElement.click();

        closePopUp();

        WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", fname);
        fname.sendKeys("aa");

        WebElement lname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
        lname.sendKeys("bb");

        WebElement email = driver.findElement(By.id("email_address"));
        email.sendKeys(emailString);

        WebElement pass = driver.findElement(By.id("password"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", pass);
        pass.sendKeys(passwordString);

        WebElement confirmation = driver.findElement(By.id("confirmation"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", confirmation);
        confirmation.sendKeys(passwordString);

        WebElement submit = driver.findElement(By.xpath("//button[@title='Register']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submit);
        submit.click();

        closePopUp();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-msg")));
        String success = successMessage.getText();
        Assert.assertEquals(success, "Thank you for registering with Tealium Ecommerce.");

        WebElement acc = driver.findElement(By.className("skip-account"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", acc);
        acc.click();

        WebElement logoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", logoutElement);
        logoutElement.click();

    }

    @Test
    public void loginTest(){
        closePopUp();

        WebElement accountImage = driver.findElement(By.linkText("ACCOUNT"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", accountImage);
        accountImage.click();

        WebElement loginElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log In")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", loginElement);
        loginElement.click();

        WebElement logInEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", logInEmail);
        logInEmail.sendKeys(emailString);

        WebElement logInPassword = driver.findElement(By.id("pass"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", logInPassword);
        logInPassword.sendKeys(passwordString);

        WebElement submit = driver.findElement(By.id("send2"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submit);
        submit.click();

        WebElement helloMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hello")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", helloMessage);
        String helloString = helloMessage.getText();
        Assert.assertEquals(helloString, "Hello, aa bb!");

        WebElement womanTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='level0 has-children'][contains(text(),'Women')]")));
        Actions wt = new Actions(driver);
        wt.moveToElement(womanTag).perform();
        
        WebElement viewAllWomen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='level1'][contains(text(),'All Women')]")));
        viewAllWomen.click();

        WebElement ratedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='rating-box'])[1]/../..//a)[1]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ratedElement);
        ratedElement.click();

        WebElement reviewSectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='last']//span[contains(text(),'Reviews')]/..")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", reviewSectionButton);
        reviewSectionButton.click();

        WebElement customerReview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("review-heading")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", customerReview);
        String reviews = customerReview.getText();
        String reviewNumber = reviews.replaceAll("\\D+", "");
        int reviewCount = Integer.parseInt(reviewNumber);
        Assert.assertTrue(reviewCount > 0, "Review count should be greater than 0");

        
        WebElement acc = driver.findElement(By.className("skip-account"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", acc);
        acc.click();

        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Log Out']")));
        logout.click();

    }
}
