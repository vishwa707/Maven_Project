package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    @FindBy(id = "productTitle")WebElement title;

    @FindBy(id = "add-to-cart-button")WebElement addToCart;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductTitle() {
        return title.getText();
    }

    public boolean isPriceDisplayed() {
        return driver.findElements(
            By.xpath("//span[contains(@class,'a-price-whole')]")
        ).size() > 0;
    }

    public void addToCart() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
    }
}

