package DesignPattern;

public class BrowserFactory {

    public BrowserInterface getBrowser(String name) {
        if(name.equalsIgnoreCase("CHROME")) {
            return new chromeBrowser();
        } else if(name.equalsIgnoreCase("REMOTE")){
            return new RemoteBrowser();
        }
        return null;
    }
}
