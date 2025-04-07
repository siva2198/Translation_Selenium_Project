package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Author: Sivaraman M
 * User:Sivaraman M
 */
public class ElPaisOpinionPage {
    private WebDriver driver;

    public ElPaisOpinionPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getTop5Articles() {
        return driver.findElements(By.xpath("//article[@class='c c-o c-d c--m-n   ']")).subList(0, 5);
    }

    public String getArticleTitle() {
        return driver.findElement(By.xpath("//h2/a")).getText();
    }

    public String getArticleContent() {
        List<WebElement> paragraphs = driver.findElements(By.xpath("//p[@class='c_d']"));
        StringBuilder sb = new StringBuilder();
        for (WebElement p : paragraphs) {
            sb.append(p.getText()).append("\n");
        }
        return sb.toString();
    }
    public List<String> getTop5ArticleLinks() {
        List<WebElement> articles = driver.findElements(By.xpath("//article[@class='c c-o c-d c--m-n   ']//a"));
        return articles.stream()
                .map(el -> el.getAttribute("href"))
                .distinct()
                .limit(5)
                .toList();
    }


    public String getCoverImageUrl() {
        try {
            WebElement img = driver.findElement(By.xpath("(//span[@class='a_m_w _db'])[1]"));
            return img.getAttribute("src");
        } catch (Exception e) {
            return null;
        }

    }
}
