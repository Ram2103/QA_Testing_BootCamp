package DesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class RemoteBrowser implements BrowserInterface{
    WebDriver driver = null;
    @Override
    public WebDriver openBrowser() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            driver = new RemoteWebDriver(new URL("http://hub.com:4444/wd/hub"), capabilities);
            driver.get("http://juice-shop:3000/#/register");
        } catch (Exception e){

        }
        return driver;
    }
}
