package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class inventoryPage {
    protected  WebDriver driver;
    protected By po_Sorting= By.className("product_sort_container");
    protected By fleeceJacket= By.linkText("Sauce Labs Fleece Jacket");
    protected By labsOnesie= By.linkText("Sauce Labs Onesie");
    protected By boltShirt= By.name("add-to-cart-sauce-labs-bolt-t-shirt");
    protected By allTheThingsShirt= By.name("add-to-cart-test.allthethings()-t-shirt-(red)");
    protected By back2Product= By.name("back-to-products");
    protected By addFleeceJacket= By.id("add-to-cart-sauce-labs-fleece-jacket");
    protected By addOnsie= By.id("id=\"add-to-cart-sauce-labs-onesie\"");
    protected By getProductDetails= By.cssSelector(".inventory_details_name.large_size");
    protected By removeFleeceJacket= By.id("remove-sauce-labs-fleece-jacket");
    protected By menuBtn= By.id("react-burger-menu-btn");
    protected By logOut= By.xpath("//a[@id='logout_sidebar_link']");
    protected By resetSidebarLink= By.id("reset_sidebar_link");
    protected By about_sidebar_link= By.id("about_sidebar_link");
    protected By bmMenu= By.cssSelector(".bm-menu");
    protected By nav= By.xpath("//*[@class='bm-menu-wrap']");
    protected By img_container= By.cssSelector("div.inventory_details_desc.large_size");
    public By shoppingCartContainer =By.id("shopping_cart_container");
    public By cartBadge =By.xpath("//span[@class=\"shopping_cart_badge\"]");
    public inventoryPage(WebDriver driver){
        this.driver=driver;
    }

    public String getUrl( ) {
        return driver.getCurrentUrl();
    }
    public String getTitle( ) {
        return driver.getTitle();
    }

    public Select sorting(){
        return new Select(driver.findElement(po_Sorting));
    }

    public void getFleeceJacket() {
        driver.findElement(fleeceJacket).click();
    }

    public void clickBack() {
        driver.findElement(back2Product).click();
    }
    public void clickAddFleeceJacket() {
        driver.findElement(addFleeceJacket).click();
    }
    public void clickAddOnsie() {
        driver.findElement(addOnsie).click();
    }
    public void clickLabsOnsie() {
        driver.findElement(labsOnesie).click();
    }
    public void clickRemoveFleeceJacket() {
        driver.findElement(removeFleeceJacket).click();
    }
    public void clickMenu() {
        driver.findElement(menuBtn).click();
    }
    public void clickLogOut() {
        WebElement logout= driver.findElement(logOut);
        WebElement nav1= driver.findElement(nav);
        Actions actions=new Actions(driver);
        actions.moveToElement(nav1).click(logout).perform();
    }
    public void clickReset() {
        WebElement reset= driver.findElement(resetSidebarLink);
        WebElement nav1= driver.findElement(nav);
        Actions actions=new Actions(driver);
        actions.moveToElement(nav1).click(reset).perform();

    }
    public sauceLabs clickAbout() {
        WebElement about= driver.findElement(about_sidebar_link);
        WebElement nav1= driver.findElement(nav);
        Actions actions=new Actions(driver);
        actions.moveToElement(nav1).click(about).perform();
        return new sauceLabs(driver);
    }

    public String getGetProductDetails() {
        return driver.findElement(getProductDetails).getText();
    }


    public void selectFromSortingBy(String option){
        sorting().selectByValue(option);

    }
    public String getOptionText(){
        WebElement element=sorting().getFirstSelectedOption();
        return element.getText();

    }
    public String getCartCounter(){
        WebElement element= driver.findElement(cartBadge);
        return element.getText();

    }
    public void clickAddAllTheThingsShirt() {
        WebElement ATTShirt= driver.findElement(allTheThingsShirt);
        Actions actions=new Actions(driver);
        actions.scrollToElement(ATTShirt).click(ATTShirt).perform();
    }

    public void clickBoltShirtAdd() {
        WebElement blShirt= driver.findElement(boltShirt);
        Actions actions=new Actions(driver);
        actions.scrollToElement(blShirt).click(blShirt).perform();
    }


    public String getImg_containerForFleeceJacket() {
       return driver.findElement(img_container).getText();
    }
    public String getImg_containerForOnsie() {
        return driver.findElement(img_container).getText();
    }
    public shoppingCart clickShoppingCart() {
        driver.findElement(shoppingCartContainer).click();
        return   new shoppingCart(driver);
    }

    }

