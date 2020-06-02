package JuiceShopRunner;

import JuiceShop.CommonFunc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;

public class JuiceShopTest {
    Double number = (Math.random()) * 1000 *10000;
    String random = Double.toString(number);
    String userName = "juice" +random.substring(0,4) +"@gmail.com";
    String password = "abcdefg";

    @BeforeAll
    public static void start() {
        CommonFunc.getInstance().launchBrowser();
        CommonFunc.getInstance().clickElement(By.xpath("//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']"));
        // driver = BrowserUtils.getInstance().openBrowser();
    }

    @Test
    public void testMethod() throws InterruptedException {
        try {
            CommonFunc.getInstance().enterText(By.id("emailControl"), userName);
            CommonFunc.getInstance().enterText(By.id("passwordControl"), password);
            CommonFunc.getInstance().enterText(By.id("repeatPasswordControl"),password);
            CommonFunc.getInstance().clickElement(By.name("securityQuestion"));
            CommonFunc.getInstance().clickElement(By.xpath("//span[@class='mat-option-text']"));
            CommonFunc.getInstance().enterText(By.id("securityAnswerControl"),password);
            CommonFunc.getInstance().clickElement(By.id("registerButton"));
            System.out.println("Registration Successful");
            CommonFunc.getInstance().enterText(By.id("email"), userName);
            CommonFunc.getInstance().enterText(By.id("password"), password);
            CommonFunc.getInstance().clickElement(By.id("loginButton"));
            System.out.println("Login Successful");
            CommonFunc.getInstance().clickElement(By.xpath("//button[@aria-label='Add to Basket']"));
            CommonFunc.getInstance().clickElement(By.xpath("//span[text()=' Your Basket']"));
            CommonFunc.getInstance().clickElement(By.cssSelector("button[class='mat-focus-indicator mat-icon-button mat-button-base']"));
            CommonFunc.getInstance().verifyElement(By.xpath("//button[@id='checkoutButton' and @disabled='true']"));
            System.out.println("Item in the basket removed successfully");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown() {
        CommonFunc.getInstance().driver.quit();
    }
}
