package tests;

import basePage.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class negativeScenario extends BasePage {
    Pages.inventoryPage invent;
    @Test(description = "verify that user can not login when password is empty")
    public void loginWithBlankPassTc() {
        homePage.setUserName("standard_user");
        invent= homePage.setLogin();
        System.out.println(homePage.getErrorMsg());
        Assert.assertEquals(homePage.getErrorMsg(), "Epic sadface: Password is required");
        Assert.assertEquals(homePage.UrlVerification(), "https://www.saucedemo.com/");
}
    @Test(priority = 2 ,description = "verify that user can not login when email is incorrect")
    public void loginWithIncorrectEmailTc() {
        homePage.setUserName("null");
        homePage.setPassW0rd("null");
        invent= homePage.setLogin();
        System.out.println(homePage.getErrorMsg());
        Assert.assertTrue(homePage.getErrorMsg().equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
        System.out.println(homePage.UrlVerification());
        Assert.assertTrue(homePage.UrlVerification().endsWith("com/"));
    }
    @Test(priority = 3 ,description = "verify that user can not login when email is blocked")
    public void loginWithBlockedUserTc() {
        String errorMsg="Epic sadface: Sorry, this user has been locked out.";
        homePage.setUserName("locked_out_user");
        homePage.setPassW0rd("secret_sauce");
        invent= homePage.setLogin();
        System.out.println(homePage.getErrorMsg());
        Assert.assertEquals(homePage.getErrorMsg(),errorMsg);
        System.out.println(homePage.UrlVerification());
        Assert.assertTrue(homePage.UrlVerification().endsWith("com/"));
    }
}
