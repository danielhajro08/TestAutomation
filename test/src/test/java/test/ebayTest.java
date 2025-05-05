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

public class ebayTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseURL = "https://www.ebay.com/";
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Select categories = new Select(driver.findElement(By.name("_sacat")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", categories);
        categories.selectByValue("58058");

        WebElement searchButton = driver.findElement(By.id("gh-search-btn"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", searchButton);
        searchButton.click();

        WebElement desktopAndAIO = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Desktops & All-In-Ones")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", desktopAndAIO);
        desktopAndAIO.click();

        WebElement brandMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='filter-button filter-button--unselected filter-menu-button__button'])[1]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", brandMenu);
        brandMenu.click();

        WebElement rPIbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='brwr__inputs--label'][contains(text(),'Raspberry')]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", rPIbutton);
        rPIbutton.click();

        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='brwrvr__item-card__wrapper'])[1]")));
        WebElement firstElementText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='brwrvr__item-card__wrapper'])[1]//h3")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstElement);
        String text1=firstElementText.getText();
        System.out.println(text1);
        firstElement.click();

        WebElement afterClickTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='x-item-title__mainTitle']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", afterClickTitle);
        String text2 = afterClickTitle.getText();
        System.out.println(text2);
        if (text1.equals(text2)) {
            System.out.println("Match");
        }else{
            System.out.println("Error");
        }

        WebElement buy= driver.findElement(By.id("binBtn_btn_1"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", buy);
        buy.click();

        WebElement guestBuy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ux-call-to-action__text'][contains(text(),'guest')]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", guestBuy);
        guestBuy.click();

        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstname);
        firstname.sendKeys("Daniel");

        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", lastName);
        lastName.sendKeys("Hajro");

        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressLine1")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", address);
        address.sendKeys("21 Dhjetori");

        WebElement city = driver.findElement(By.id("city"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", city);
        city.sendKeys("Tirana");

        WebElement stateOrProvince = driver.findElement(By.id("stateOrProvince"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", stateOrProvince);
        stateOrProvince.sendKeys("Albania");

        WebElement email = driver.findElement(By.id("email"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", email);
        email.sendKeys("daniel@gmail.com");

        
        WebElement emailConfirm = driver.findElement(By.id("emailConfirm"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", emailConfirm);
        emailConfirm.sendKeys("daniel@gmail.com");

        WebElement phone = driver.findElement(By.id("phoneNumber"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", phone);
        phone.sendKeys("681234567");

        WebElement submit = driver.findElement(By.xpath("//button[@data-test-id = 'ADD_ADDRESS_SUBMIT']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submit);
        submit.click();
    }

   

}
