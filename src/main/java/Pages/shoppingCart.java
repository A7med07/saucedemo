package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

public class shoppingCart {
    protected WebDriver driver;
    protected By checkOut= By.name("checkout");
    protected By continue_shopping= By.name("continue-shopping");
    protected By rmTheThingsShirt= By.name("remove-test.allthethings()-t-shirt-(red)");
    protected By rmBoltShirt= By.name("remove-sauce-labs-bolt-t-shirt");



    public shoppingCart(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl() {
       return driver.getCurrentUrl();
    }

    public checkOutPage clickCheckOut() {

        driver.findElement(checkOut).click();
        return new checkOutPage(driver);

    }
    public inventoryPage clickContinue_shopping() {
        driver.findElement(continue_shopping).click();
       return new inventoryPage(driver);
    }
    public void clickRemoveBoltShirtAdd() {
        WebElement blShirt= driver.findElement(rmBoltShirt);

        Actions actions=new Actions(driver);
        actions.scrollToElement(blShirt).click(blShirt).perform();
    }
    public void clickRemoveAllTheThingsShirt() {
        WebElement rmATTShirt= driver.findElement(rmTheThingsShirt);
        Actions actions=new Actions(driver);
        actions.scrollToElement(rmATTShirt).click(rmATTShirt).perform();
    }

}
