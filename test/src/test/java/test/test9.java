package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class test9 {
public static void main(String[] args) throws InterruptedException {
      WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseURL = "https://www.techlistic.com/p/selenium-practice-form.html?m=1";
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement firstName = driver.findElement(By.name("firstname"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstName);
        firstName.sendKeys("Daniel");

        WebElement lastName = driver.findElement(By.name("lastname"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", lastName);
        lastName.sendKeys("Hajro");

        WebElement genderMale = driver.findElement(By.id("sex-0"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", genderMale);
        if(!genderMale.isSelected()){
            genderMale.click();
        }

        WebElement experienceYears = driver.findElement(By.id("exp-3"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", experienceYears);
        if(!experienceYears.isSelected()){
            experienceYears.click();
        }

        WebElement datepicker = driver.findElement(By.id("datepicker"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", datepicker);
        datepicker.sendKeys("12-09-2024");

        WebElement professionAutomation = driver.findElement(By.id("profession-1"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", professionAutomation);
        if(!professionAutomation.isSelected()){
            professionAutomation.click();
        }

        WebElement toolSelenium = driver.findElement(By.id("tool-2"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", toolSelenium);
        if(!toolSelenium.isSelected()){
            toolSelenium.click();
        }

        Select continents = new Select(driver.findElement(By.id("continents")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", continents);
        continents.selectByIndex(2);

        Select selenium_commands = new Select(driver.findElement(By.id("selenium_commands")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", selenium_commands);
        selenium_commands.selectByIndex(1);
        selenium_commands.selectByIndex(2);

        WebElement photo = driver.findElement(By.id("photo"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", photo);
        String filepath = "C://Users//daniel.hajro//Pictures//Saved Pictures//pexels-matthew-montrone-230847-1324803.jpg";
        photo.sendKeys(filepath);

        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click here to Download File")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", link);
        link.click();
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement button = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
        button.click();
        System.out.println("Button clicked");
}
}
