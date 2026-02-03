package pages;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Homepage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "twotabsearchtextbox")WebElement search;

    @FindBy(id = "nav-hamburger-menu")WebElement allMenu;

    @FindBy(linkText = "Mobiles")WebElement mobiles;

    @FindBy(linkText = "About Us")WebElement aboutUs;

    @FindBy(linkText = "Help")WebElement help;
	public Homepage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public String getTitle() {
	    wait.until(ExpectedConditions.titleContains("Amazon"));
	    return driver.getTitle();
	}
	public void search(String text) {
        search.clear();
        search.sendKeys(text + Keys.ENTER);
    }
	public void captureAutoSuggestions() {
        search.clear();
        search.sendKeys("iphone");
        List<WebElement> sug = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='autocomplete-results-container']//div[@role='button']")));
        Assert.assertTrue(sug.size() > 0, "No auto-suggestions displayed");

        System.out.println("All suggestions:");
        for (WebElement s : sug) {
            System.out.println(s.getText());
        }
	}
	public void openMobilesCategory() {
        allMenu.click();
        mobiles.click();
    }

    public boolean footerLinksPresent() {
        return aboutUs.isDisplayed() && help.isDisplayed();
    }

}
