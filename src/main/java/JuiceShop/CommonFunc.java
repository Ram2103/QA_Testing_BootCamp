package JuiceShop;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunc {
    WebDriverWait wait = new WebDriverWait(BrowserUtils.getInstance().driver, 10);

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
