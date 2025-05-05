package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseURL = "https://demoqa.com/select-menu";
        driver.get(baseURL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement groupOpt = driver.findElement(By.id("withOptGroup"));
        groupOpt.click();
        
        WebElement groupTitle= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-group-0-heading")));
        System.out.println(groupTitle.getText());

        WebElement groupOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-option-0-0")));
        groupOption.click();

        WebElement titleMenu = driver.findElement(By.id("selectOne"));
        titleMenu.click();

        WebElement titlefirst = driver.findElement(By.id("react-select-3-option-0-0"));
        System.out.println(titlefirst.getText());
        titlefirst.click();

        Select oldMenu = new Select(driver.findElement(By.id("oldSelectMenu")));
        List<WebElement> allOptions = oldMenu.getOptions();
        for (WebElement option : allOptions) {
           System.out.println(option.getText()); 
        }
        oldMenu.selectByValue("1");


        WebElement multiSelect = driver.findElement(By.xpath("//*[@id=\'selectMenuContainer\']/div[7]/div/div/div/div[1]/div[1]"));
        multiSelect.click();

        WebElement multiSelect1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-4-option-2"))) ;
        multiSelect1.click();
        Thread.sleep(1000);
        WebElement multiSelect2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-4-option-1"))) ;
        multiSelect2.click();
        Thread.sleep(1000);
        WebElement multiSelect3= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-4-option-0"))) ;
        multiSelect3.click();

        Select cars = new Select(driver.findElement(By.id("cars")));
        cars.selectByValue("volvo");
        cars.selectByValue("opel");
        Thread.sleep(2000);
        List<WebElement> selectedOptions = cars.getAllSelectedOptions();
        for( WebElement optionSelected : selectedOptions){
            System.out.println(optionSelected.getText());
        }
        cars.deselectAll();
    }

}
