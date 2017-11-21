package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class WallethubLoginPage extends BasePage {

    private static final String PAGE_URL = "https://wallethub.com/join/login";

    @FindBy(css ="[ng-model=\"fields.email\"]")
    private WebElement userInput;

    @FindBy(css ="[ng-model=\"fields.password\"]")
    private WebElement passInput;

    @FindBy(css = "[data-hm-tap=\"doLogin($event);\"]")
    private WebElement loginBtn;

    @FindBy(css = "[class='cover-photo cover-photo-default']")
    WebElement coverPhoto;

    public WallethubLoginPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return userInput.isDisplayed();
    }

    public void login(String login, String pass) {
        userInput.sendKeys(login);
        passInput.sendKeys(pass);
        loginBtn.click();
        waitForElementVisible(coverPhoto);
    }
}
