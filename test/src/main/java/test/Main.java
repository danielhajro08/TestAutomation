package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
    WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String baseURL="https://qbek.github.io/selenium-exercises/en/check_boxes.html";
        driver.get(baseURL);

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement text = driver.findElement(By.id("text"));
        if (text.isEnabled()) {
            System.out.println("Enabled");
        }else{
            System.out.println("Isnt enabled");
        }
        Thread.sleep(3000);
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='switch']")));
        checkbox.click();
        if (text.isEnabled()) {
            System.out.println("Enabled");
        }else{
            System.out.println("Isnt enabled");
        }

        WebElement redcheck = driver.findElement(By.name("red"));
        redcheck.click();
        if (redcheck.isSelected()) {
            System.out.println("Red clicked");
        }
        WebElement bluecheck = driver.findElement(By.name("blue"));
        bluecheck.click();
        if(bluecheck.isSelected()){
            System.out.println("Blue clicked");
        }

        WebElement pinkColor = driver.findElement(By.id("light"));
        if(pinkColor.getAttribute("data-color").equals("#FF00FF")){
            System.out.println("Color is pink");
        }else{
            System.out.println("Color no pink");
        }

    }
}