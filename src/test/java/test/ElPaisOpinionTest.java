package test;

import Base.BaseClass;
import Pages.ElPaisHomePage;
import Pages.ElPaisOpinionPage;
import Util.ImageDownloader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Author: Sivaraman M
 * User:Sivaraman M
 */
public class ElPaisOpinionTest extends BaseClass {
    @Test()
    public void scrapeOpinionArticles() throws IOException{
        ElPaisHomePage homePage = new ElPaisHomePage(driver);
        homePage.goToHomePage();
        homePage.clickOnAcceptAllCookies();
        homePage.clickOnOpinionSection();

        ElPaisOpinionPage opinionPage = new ElPaisOpinionPage(driver);

        List<WebElement> articles = opinionPage.getTop5Articles();
        int articleCount = 1;

        for (WebElement article : articles) {
            try {
                // Open article link in same tab
                String articleUrl = article.findElement(By.tagName("a")).getAttribute("href");
                driver.get(articleUrl);

                String title = opinionPage.getArticleTitle();
                String content = opinionPage.getArticleContent();
              String imageUrl = opinionPage.getCoverImageUrl();

                System.out.println("📄 Article #" + articleCount++);
                System.out.println("Title: " + title);
                System.out.println("Content: " + (content.length() > 300 ? content.substring(0, 300) + "..." : content));

                if (imageUrl != null && !imageUrl.isEmpty()) {
                    String fileName = "Article_" + articleCount + ".jpg";
                    ImageDownloader.downloadImage(imageUrl, "images/" + fileName);
                    System.out.println("dImage downloaded: " + fileName);
                }
                else {
                    System.out.println("No image found for this article.");
                }

                System.out.println("-----------------------------------------------------");

                // Go back to opinion list after each article
                homePage.clickOnOpinionSection();

            } catch (Exception e) {
                System.out.println("Error processing article #" + articleCount + ": " + e.getMessage());
            }
        }
    }

}
