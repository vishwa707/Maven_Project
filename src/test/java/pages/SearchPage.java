package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProductTitles() {
        return driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2"));
    }

    public boolean keywordPresent(String keyword) {
        for (WebElement e : getProductTitles()) {
            if (e.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int pcount() {
        return getProductTitles().size();
    }
}
