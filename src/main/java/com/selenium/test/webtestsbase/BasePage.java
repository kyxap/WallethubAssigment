package com.selenium.test.webtestsbase;

import com.selenium.test.utils.TimeUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 */
public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 15;

    /**
     *
     */
    protected abstract void openPage();

    /**
     * checks is page opened
     *
     * @return true if opened
     */
    public abstract boolean isPageOpened();

    public BasePage(boolean openPageByUrl) {
        if (openPageByUrl) {
            openPage();
        }
        PageFactory.initElements(getDriver(), this);
        waitForOpen();
    }

    /**
     * Waiting for page opening
     */
    protected void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS) {
            TimeUtils.waitForSeconds(1);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }

    /**
     * getting webdriver instance
     *
     * @return initialized in tests webdriver instance
     */
    protected WebDriver getDriver() {
        return WebDriverFactory.getDriver();
    }

    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_FOR_PAGE_LOAD_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementIsNotVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {

        }
    }

    public String getPageSource() {
        return getDriver().getPageSource();
    }
}
