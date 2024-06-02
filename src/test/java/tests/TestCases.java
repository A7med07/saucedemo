package tests;

import basePage.BasePage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCases extends BasePage {
    String s1,s2;
    Pages.inventoryPage invent;
    @Test (description = "verify that user can sorts products and adding product when user is logged in")
    @Description("verify login")

    public void loginTc() {
        homePage.setUserName("standard_user");
        homePage.setPassW0rd("secret_sauce");
       invent= homePage.setLogin();
       Assert.assertTrue(invent.getUrl().endsWith("inventory.html"));
       Assert.assertTrue(invent.getUrl().endsWith("inventory.html"));
        System.out.println(invent.getUrl());
        invent.selectFromSortingBy("hilo");
        System.out.println(invent.getOptionText());
        Assert.assertTrue(invent.getOptionText().startsWith("Price"));
        invent.getFleeceJacket();
        System.out.println(invent.getGetProductDetails());
        Assert.assertNotNull(invent.getGetProductDetails());
        Assert.assertEquals(invent.getGetProductDetails(),"Sauce Labs Fleece Jacket");
        invent.clickAddFleeceJacket();
         s1=invent.getImg_containerForFleeceJacket();
        invent.clickRemoveFleeceJacket();
        invent.clickBack();
        Assert.assertTrue(invent.getUrl().endsWith("inventory.html"));
        invent.selectFromSortingBy("za");
        System.out.println(invent.getOptionText());
        Assert.assertFalse(invent.getOptionText().startsWith("Price"));
        invent.clickLabsOnsie();
         s2=invent.getImg_containerForOnsie();
       //
        Assert.assertNotEquals(s1,s2);
        System.out.println(s1);
        System.out.println(s2);



    }
    @Test (priority = 1,dependsOnMethods = "loginTc")
    public void completeOder(){
        Pages.shoppingCart cart= homePage.clickShoppingCart();
        homePage.clickShoppingCart();
        Pages.checkOutPage checkOut=cart.clickCheckOut();
        Assert.assertTrue(checkOut.getURI().endsWith("checkout-step-one.html"));
        System.out.println(checkOut.getURI());
        checkOut.setFirstName("ahmed");
        checkOut.setLastName("abdo");
        checkOut.setPostalCode("71111");
        checkOut.clickContinue();
        System.out.println(checkOut.getURI());
        Assert.assertTrue(checkOut.getURI().endsWith("two.html"));
        checkOut.clickFinish();
        System.out.println(checkOut.getOrderSuccessMsg());
        Assert.assertEquals(checkOut.getOrderSuccessMsg(),"Thank you for your order!");
        Assert.assertTrue(checkOut.getURI().endsWith("complete.html"));
        System.out.println(checkOut.getURI());
        checkOut.clickBack2Products();



    }

    @Test(priority = 3,description = "asserts on pages url & user logout")
    public void clickLogout(){
        Assert.assertTrue(invent.getUrl().endsWith("inventory.html"));
        invent.clickMenu();
        invent.clickLogOut();
        System.out.println(invent.getUrl());
        Assert.assertFalse(invent.getUrl().endsWith("inventory.html"));

    }


}
