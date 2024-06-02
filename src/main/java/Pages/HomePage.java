package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HomePage  {
    protected WebDriver driver;
    public By userName =By.id("user-name");
    public By passW0rd =By.id("password");
    public By login =By.id("login-button");
    public By errorMsg =By.xpath("//div[@class=\"error-message-container error\"]");
    public By shoppingCartContainer =By.xpath("//*[@id=\"shopping_cart_container\"]");
    public HomePage (WebDriver driver){
        this.driver=driver;}
    public String UrlVerification( ) {
        return driver.getCurrentUrl();
    }


    public void setPassW0rd(String pW0rd) {
        driver.findElement(passW0rd).clear();
        driver.findElement(passW0rd).sendKeys(pW0rd);
    }

    public inventoryPage setLogin() {
        driver.findElement(login).click();
      return   new inventoryPage(driver);
    }
    public shoppingCart clickShoppingCart() {

        FluentWait wait=new FluentWait(driver);
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartContainer));

        driver.findElement(shoppingCartContainer).click();
      return   new shoppingCart(driver);
    }

    public String getErrorMsg() {
        FluentWait wait=new FluentWait(driver);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(errorMsg,"Epic sadface: Password is required\n"));

        return driver.findElement(errorMsg).getText() ;
    }

    public void setUserName(String Name) {
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(Name);
    }
}
