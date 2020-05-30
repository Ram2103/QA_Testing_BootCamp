package JuiceShop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login_Checkout {

    WebDriver driver = null;

    @Before
    public void start() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/Users/ramanathan.mthoughtworks.com/Documents/untitled folder/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")).click();
    }

    @Test
    public void testMethod() throws InterruptedException {
        driver.findElement(By.id("navbarAccount")).click();
        driver.findElement(By.id("navbarLoginButton")).click();
        driver.findElement(By.id("newCustomerLink")).click();
        driver.findElement(By.id("emailControl")).sendKeys("ram123456@gmail.com");
        driver.findElement(By.id("passwordControl")).sendKeys("abcdefg");
        driver.findElement(By.id("repeatPasswordControl")).sendKeys("abcdefg");
        driver.findElement(By.name("securityQuestion")).click();
        driver.findElement(By.xpath("//span[@class='mat-option-text']")).click();
        driver.findElement(By.id("securityAnswerControl")).sendKeys("abcdefgh");
        Thread.sleep(2000);
        driver.findElement(By.id("registerButton")).click();
        driver.quit();
    }

}
