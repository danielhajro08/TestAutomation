package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
   public static void main(String[] args) {
      WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String baseURL="https://qbek.github.io/selenium-exercises/en/radio_buttons.html";
        driver.get(baseURL);

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         WebElement radio = driver.findElement(By.xpath("//input[@value='rmffm']"));
         radio.click();
         WebElement infos= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rmffm-details']//h5")));
         String infoText = infos.getText();
         System.out.println(infoText);
         if (infoText.equals("Radio RMF FM")) {
            System.out.println("Right");
         }else{
            System.out.println("Wrong");
         }
   }
}
