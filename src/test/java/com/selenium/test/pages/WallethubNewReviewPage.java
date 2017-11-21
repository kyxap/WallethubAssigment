package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class WallethubNewReviewPage extends BasePage {

    @FindBy(css = ".dropdown-list-new")
    private WebElement policyDD;

    @FindBy(css = "[data-target='Health']")
    private WebElement healthFromDD;


    @FindBy(css = "[id='review-content']")
    private WebElement reviewInput;

    @FindBy(css = "input[value='Submit']")
    private WebElement submitBtn;

    @FindBy(css = "[class='big-title small']")
    private WebElement bitTitle;

    @FindBy(css = "[class='big-title small']  > h1 > span > a")
    private WebElement postedLink;

    @FindBy(css = "[class*='product']")
    private WebElement productLoading;

    @FindBy(xpath = "//*[@onmouseover=\"try{gRatingsHover(this)}catch(e){}\"][5]")
    private WebElement star;

    public WallethubNewReviewPage() {
        super(true);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return reviewInput.isDisplayed();
    }

    public void fillReviewInput(String msg) {
        reviewInput.clear();
        reviewInput.sendKeys(msg);
    }

    public void goToReviewsPage() {
        waitForElementVisible(postedLink);
        postedLink.click();
        waitForElementIsNotVisible(postedLink);
    }

    public void selectPolicy(Object policyType) {
        if (policyType == null) {
            policyDD.click();
            healthFromDD.click();
            waitForElementVisible(productLoading);
            waitForElementIsNotVisible(productLoading);
        }
    }

    public void rateNstart(int n) {
        waitForElementVisible(star);
        star.click();
    }

    public void setSubmitReview() {
        waitForElementVisible(submitBtn);
        submitBtn.click();
    }
}
