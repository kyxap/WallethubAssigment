package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class WallethubTestCompanyPage extends BasePage {

    private static final String PAGE_URL = "https://wallethub.com/profile/test_insurance_company/";

    @FindBy(css = "[class='wh-rating rating_5']")
    WebElement fiveStars;

    @FindBy(xpath = "//*[@class=\"wh-rating-choices-holder\"]/a[5]")
    private WebElement nStar;

    public WallethubTestCompanyPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return fiveStars.isDisplayed();
    }

    public void hoverOver(int hoverStart, int clickStar) {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(fiveStars).moveToElement(nStar).click().perform();
    }
}
