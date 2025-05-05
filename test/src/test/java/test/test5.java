package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseURL = "https://www.allbirds.com/";
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement linkForMen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Men's Shoes")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", linkForMen);
        linkForMen.click();

        WebElement linkForSneakers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Everyday Sneakers")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", linkForSneakers);
        linkForSneakers.click();

        WebElement everydayCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label//input[@aria-label='Everyday']//..")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", everydayCheckbox);
        everydayCheckbox.click();

        WebElement activeCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label//input[@aria-label='Active']//..")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", activeCheckbox);
        activeCheckbox.click();

        WebElement treeFiberCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label//input[@aria-label='Tree Fiber Blend']//..")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", treeFiberCheckbox);
        treeFiberCheckbox.click();

        WebElement canvasCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label//input[@aria-label='Canvas']//..")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", canvasCheckbox);
        canvasCheckbox.click();

        WebElement whiteColorCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='White']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", whiteColorCheckbox);
        whiteColorCheckbox.click();

        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='jsx-3384491654 jsx-2360697138 Grid__row']/div/div[1])[1]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstElement);
        firstElement.click();

        WebElement colorSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@aria-label,'Medium Grey (Blizzard Sole)')]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", colorSelect);
        colorSelect.click();

        WebElement colorCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'Overview__name')]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", colorCheck);
        String colorName = colorCheck.getText();
        if (colorName.equals("Medium Grey (Blizzard Sole)")) {
            System.out.println("Color Matches");
        } else {
            System.out.println("Color doesn't match");
        }

        WebElement sizeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@aria-label, 'Add Size 8.5')]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", sizeSelect);
        sizeSelect.click();

        WebElement sizeCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SizeButton--selected")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", sizeCheck);
        String size = sizeCheck.getText();
        if (size.equals("8.5")) {
            System.out.println("Size matches");
        } else {
            System.out.println("Size doesn't match");
        }

        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCart);
        if (!addToCart.isEnabled()) {
            System.out.println("Button is disabled");
        } else {
            addToCart.click();
        }
        Thread.sleep(2000);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='jsx-3350912383 FreeShippingIndicator__messaging-container']//div//span")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", successMessage);
        String success = successMessage.getText();
        System.out.println(success);
        if (success.equals("Congrats! You get free standard shipping.")) {
            System.out.println("Success");
        } else {
            System.out.println("Error getting success message");
        }

        driver.quit();
    }
}
