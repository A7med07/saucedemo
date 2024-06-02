package basePage;


import Pages.HomePage;
import Pages.shoppingCart;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BasePage {
    public WebDriver driver;
    protected HomePage homePage;
    protected shoppingCart shoppingCart;


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromiumdriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();


        homePage=new HomePage(driver);
        shoppingCart=new shoppingCart(driver);

    }
    @AfterClass
    public void tearDown( ) {
       driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot,
                        new File("C:\\Users\\A7med\\IdeaProjects\\LumaTask\\src\\test\\resources"+
                                result.getName()+ "  " +result.getName() + ".png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}