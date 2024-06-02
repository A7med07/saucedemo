package tests;

import basePage.BasePage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class shoppingScenario extends BasePage {
    Pages.inventoryPage invent;
    String s1 ,s2 ;
    @Test( description = "verify that user can add items to shopping cart when user is logged in")
    @Description("Shopping Cart")
    public void addingProductsToShoppingCart() {
        homePage.setUserName("standard_user");
        homePage.setPassW0rd("secret_sauce");
        invent= homePage.setLogin();
        invent.clickAddAllTheThingsShirt();
        invent.clickBoltShirtAdd();
        invent.getFleeceJacket();
        invent.clickAddFleeceJacket();
        invent.clickBack();
        System.out.println(invent.getCartCounter());
        Assert.assertNotNull(invent.getCartCounter());
        Assert.assertTrue(invent.getUrl().endsWith("inventory.html"));


        

    }
    @Test(dependsOnMethods = "addingProductsToShoppingCart",description = "verify that user remove items from shopping cart then assert it")
    public void removeProductsFromShoppingCart() {
        Pages.shoppingCart cart=invent.clickShoppingCart();
        Assert.assertTrue(cart.getUrl().endsWith("cart.html"));
        s1=invent.getCartCounter();
        cart.clickRemoveAllTheThingsShirt();
        cart.clickRemoveBoltShirtAdd();
        s2=invent.getCartCounter();
        Assert.assertNotEquals(s1,s2);
        cart.clickContinue_shopping();
        invent.clickMenu();
        invent.clickLogOut();
    }
}
