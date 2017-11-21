package com.selenium.test.testng.tests;

import com.selenium.test.pages.FacebookPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class Facebook {

    private FacebookPage fbPage;

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
        String fbLogin = ""; // TODO: add login/pass
        String fbPass = "";

        fbPage = new FacebookPage();
        fbPage.fbLogin(fbLogin, fbPass);
    }

    @Test
    public void userCanPostNewStatus() {
        String status = "Hello World";
        fbPage.postNewStatus(status);
        Assert.assertTrue(fbPage.getPageSource().contains(status));
    }

    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}
