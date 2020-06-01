package JuiceShop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserUtils {

    static WebDriver driver = null;
    public WebDriver openBrowser() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.get("http://localhost:3000/#/register");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        try {
            driver = new RemoteWebDriver(new URL("http://hub.com:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("http://juice-shop:3000/#/register");
        CommonFunc.getInstance().clickElement(By.xpath("//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']"));
       // driver.findElement(By.xpath("//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")).click();
        return driver;
    }

    /*
    Singleton pattern
     */
    private static BrowserUtils brws = null;
    private BrowserUtils(){}
    public static BrowserUtils getInstance() {
        if(brws == null){
            brws = new BrowserUtils();
        }
        return brws;
    }
}
