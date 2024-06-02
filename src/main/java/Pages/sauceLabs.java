package Pages;

import com.github.dockerjava.api.model.Image;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class sauceLabs {
    protected WebDriver driver;
    public sauceLabs(WebDriver driver){
        this.driver=driver;
    }
    public String getWindUrl( ) {
        return driver.getCurrentUrl();
    }
    public String getTitle( ) {
        return driver.getTitle();
    }




}
