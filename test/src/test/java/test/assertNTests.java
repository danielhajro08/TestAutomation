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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assertNTests {
        @Test
        public void testcase1(){
            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            String baseURL = "https://demoqa.com/buttons";
            driver.get(baseURL);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement doubleClickElement= driver.findElement(By.id("doubleClickBtn"));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", doubleClickElement);
            Assert.assertTrue(doubleClickElement.isEnabled());

            Actions doubleclick = new Actions(driver);
            doubleclick.doubleClick(doubleClickElement)
                        .build()
                        .perform();

            String doubleClickMessagString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage"))).getText();
            Assert.assertEquals(doubleClickMessagString, "You have done a double click");

            WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", rightClick);
            Actions rc = new Actions(driver);
            rc.contextClick(rightClick)
               .build()
               .perform();

            String rightClickString =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage"))).getText();
            Assert.assertEquals(rightClickString, "You have done a right click");

        }
       
        @Test
        public void testcase2(){
            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            String baseURL = "https://demoqa.com/date-picker";
            driver.get(baseURL);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", date);
            Actions dateact = new Actions(driver);
            dateact.click(date)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("05/20/2016")
                .build()
                .perform();

            date.click();
             
            WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", monthElement);  
            
            Select monthSelected = new Select(monthElement);
            String monthChoosen = monthSelected.getFirstSelectedOption().getText();
            Assert.assertEquals(monthChoosen, "May");

            WebElement yearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", yearElement);

            Select yearSelected = new Select(yearElement);
            String yearChoosen = yearSelected.getFirstSelectedOption().getText();
            Assert.assertEquals(yearChoosen, "2016");

            WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__day--selected")));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", dateElement);
            String dateChoosen = dateElement.getText();
            Assert.assertEquals(dateChoosen, "20");
        }

    }
    

