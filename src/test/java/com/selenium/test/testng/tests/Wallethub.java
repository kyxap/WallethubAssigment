package com.selenium.test.testng.tests;

import com.selenium.test.pages.WallethubLoginPage;
import com.selenium.test.pages.WallethubNewReviewPage;
import com.selenium.test.pages.WallethubTestCompanyPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 */
public class Wallethub {

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
        String login = ""; // TODO: add login/pass
        String pass = "";

        WallethubLoginPage loginPage = new WallethubLoginPage();
        loginPage.login(login, pass);

    }

    @Test
    public void canWriteReview() {
        WallethubTestCompanyPage testCompanyPage = new WallethubTestCompanyPage();
        testCompanyPage.hoverOver(0, 0);
        WallethubNewReviewPage reviewPage = new WallethubNewReviewPage();
        reviewPage.selectPolicy(null);
        reviewPage.rateNstart(5);
        String msg = "";
        for (int i = 0; i < 30; i++) {
            msg += " Hey, You!";
        }
        reviewPage.fillReviewInput(msg);
        reviewPage.setSubmitReview();
        reviewPage.goToReviewsPage();
        Assert.assertTrue(reviewPage.getPageSource().contains(msg), "Unable to find review on page");
    }

    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}
