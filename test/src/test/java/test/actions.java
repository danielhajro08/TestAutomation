package test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actions {
    public static void main(String[] args) {
         WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseURL = "https://demoqa.com/text-box";
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("AA BB ");

        WebElement email = driver.findElement(By.id("userEmail"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", email);
        email.sendKeys("a@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));

        new Actions(driver)
        .sendKeys(currentAddress, "aaa")
            .keyDown(Keys.CONTROL)
            .sendKeys("a")
            .sendKeys("c")
            .keyUp(Keys.CONTROL)
            .perform();
            

        WebElement perma = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", perma);
        new Actions(driver)
        .click(perma)
        .keyDown(Keys.CONTROL)
        .sendKeys("v")
        .keyUp(Keys.CONTROL)
        .perform();

    }
}
