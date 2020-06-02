package JuiceShop;

import DesignPattern.BrowserFactory;
import DesignPattern.BrowserInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunc {
    public WebDriver driver;
    WebDriverWait wait = null;
    public void launchBrowser(){
        String browser = System.getenv("Browser");
        //String browser = "Chrome";
        BrowserInterface inter = new BrowserFactory().getBrowser(browser.toUpperCase());
        driver = inter.openBrowser();
        wait = new WebDriverWait(driver, 10);
    }


    public void clickElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void enterText(By by, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
    }

    public void verifyElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /*
    Singleton pattern
     */
    private static CommonFunc cFunc = null;
    private CommonFunc(){}
    public static CommonFunc getInstance(){
        if(cFunc == null){
            cFunc = new CommonFunc();
        }
        return cFunc;
    }
}
