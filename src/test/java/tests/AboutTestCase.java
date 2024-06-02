package tests;

import Pages.sauceLabs;
import basePage.BasePage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AboutTestCase extends BasePage {
    String s1,s2;
    Pages.inventoryPage invent;
@Test
    @Description("Shopping Cart")
    public void TestAbout() {
        homePage.setUserName("standard_user");
        homePage.setPassW0rd("secret_sauce");
        invent = homePage.setLogin();
        invent.clickMenu();
        s1=invent.getTitle();
        sauceLabs sLabs = invent.clickAbout();
        s2=sLabs.getTitle();
        Assert.assertEquals(sLabs.getWindUrl(),"https://saucelabs.com/");
        Assert.assertNotSame(s1,s2);


    }
}

