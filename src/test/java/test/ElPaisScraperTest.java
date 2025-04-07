package test;

import Base.BaseClass;
import Pages.ElPaisHomePage;
import Pages.ElPaisOpinionPage;
import Util.ImageDownloader;
import Util.TranslateUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static Util.TranslateUtil.isTextSpanish;

/**
 * Author: Sivaraman M
 * User:Sivaraman M
 */
public class ElPaisScraperTest extends BaseClass {

    @Test(priority = 1)
    public void translateSpanishTitle() throws IOException {
        ElPaisHomePage homePage = new ElPaisHomePage(driver);
        homePage.goToHomePage();
        homePage.clickOnAcceptAllCookies();
        String originalTitle = driver.getTitle();
        System.out.println("Original Title: " + originalTitle);
        try {
            String translatedTitle = TranslateUtil.translateToEnglish(originalTitle);
            System.out.println("Translated Title: " + translatedTitle);
        } catch (Exception e) {
            System.out.println("Translation failed: " + e.getMessage());
        }
    }
    @Test
    public void validateTitleIsInSpanish(){
        ElPaisHomePage homePage = new ElPaisHomePage(driver);
        homePage.goToHomePage();
        homePage.clickOnAcceptAllCookies();

        String originalTitle = driver.getTitle();
        System.out.println("Original Title: " + originalTitle);

        try {
            String translatedTitle = TranslateUtil.translateToEnglish(originalTitle);
            System.out.println("Translated Title: " + translatedTitle);
            Assert.assertTrue(isTextSpanish(originalTitle), "Title is not detected as Spanish.");
            Assert.assertNotEquals(originalTitle, translatedTitle,
                    "The title might already be in English or not translated properly");

        } catch (Exception e) {
            Assert.fail("Failed to validate translation: " + e.getMessage());
        }
    }

    }



