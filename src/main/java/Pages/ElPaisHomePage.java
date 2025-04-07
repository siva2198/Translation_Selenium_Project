package Pages;

import Base.BaseClass;
import Util.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Author: Sivaraman M
 * User:Sivaraman M
 */
public class ElPaisHomePage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    public ElPaisHomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='didomi-notice-agree-button']")
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = "(//a[@class='b_h_t _pr'])[1]")
    private WebElement opinionSectionLink;


    public void goToHomePage() {
        try {
            driver.get("https://elpais.com/");
        } catch (Exception e) {
            System.out.println("Error navigating to the homepage: " + e.getMessage());
        }
    }

    public void clickOnAcceptAllCookies() {
        try {
            WebElement acceptButton = waitUtils.waitForElementForClickable(acceptAllCookiesButton);
            acceptButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Accept cookies button not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for the Accept cookies button: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Accept cookies button not interactable: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error while clicking on Accept All Cookies: " + e.getMessage());
        }
    }

    public void clickOnOpinionSection() {
        try {
            WebElement opinionSection = waitUtils.waitForElementForClickable(opinionSectionLink);
            opinionSection.click();
        } catch (NoSuchElementException e) {
            System.out.println("Opinion section link not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for the Opinion section link: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Opinion section link not interactable: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error while clicking on Opinion section: " + e.getMessage());
        }
    }
}
