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
        try {
            String browser = System.getProperty("Browser");
            //String browser = "Chrome";
            switch (browser) {
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.get("http://localhost:3000/#/register");
                    break;

                case "Remote":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("browserName", "chrome");
                    driver = new RemoteWebDriver(new URL("http://hub.com:4444/wd/hub"), capabilities);
                    driver.get("http://juice-shop:3000/#/register");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + browser);
            }

        CommonFunc.getInstance().clickElement(By.xpath("//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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
