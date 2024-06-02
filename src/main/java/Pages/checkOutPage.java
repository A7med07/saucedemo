package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkOutPage {
    protected WebDriver driver;
    protected By continueBtn= By.name("continue");
    protected By back2Products= By.name("back-to-products");
    protected By cancel= By.name("cancel");
    protected By firstName= By.name("firstName");
    protected By lastName= By.name("lastName");
    protected By postalCode= By.name("postalCode");
    protected By orderSuccessMsg= By.xpath("//h2[@class=\"complete-header\"]");
    protected By finish= By.name("finish");

    public checkOutPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getURI( ) {
        return driver.getCurrentUrl();
    }
    public String getOrderSuccessMsg( ) {
        return driver.findElement(orderSuccessMsg).getText();
    }
    public void setFirstName(String fName) {
      driver.findElement(firstName).sendKeys(fName);

    }
    public void setPostalCode(String pCode) {
        driver.findElement(postalCode).sendKeys(pCode);

    }
    public void setLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);

    }

    public void clickCancel() {
        driver.findElement(cancel).click();
    }
    public void clickContinue() {

        driver.findElement(continueBtn).click();
    }
    public void clickBack2Products() {

        driver.findElement(back2Products).click();
    }
    public void clickFinish() {
        driver.findElement(finish).click();
    }
}
