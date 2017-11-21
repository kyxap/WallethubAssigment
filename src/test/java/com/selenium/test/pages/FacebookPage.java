package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.Set;

/**
 *
 */
public class FacebookPage extends BasePage {

    private static final String PAGE_URL = "https://www.facebook.com";

    @FindBy(css = "input[type='email']")
    private WebElement emailInput;

    @FindBy(css = "input[type='password']")
    private WebElement passInput;

    @FindBy(css = "input[value='Log In']")
    private WebElement loginBtn;

    @FindBy(css = "textarea[title*='on your mind']")
    private WebElement postInput;

    @FindBy(css = "[data-testid='react-composer-post-button'] > span")
    private WebElement postBtn;

    public FacebookPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return emailInput.isDisplayed();
    }

    public void fbLogin(String login, String pass) {
        emailInput.sendKeys(login);
        passInput.sendKeys(pass);
        loginBtn.click();
    }

    public void postNewStatus(String msg) {
        waitForElementVisible(postInput);
        postInput.sendKeys(msg);
        waitForElementVisible(postBtn);
        Actions builder = new Actions(getDriver());
        builder.moveToElement(postBtn).click().perform();
        postBtn.click();
        waitForElementIsNotVisible(postBtn);
        waitForElementVisible(getDriver().findElement(By.xpath("//div/p[contains(text(),'" + msg + "')]")));
    }
}
