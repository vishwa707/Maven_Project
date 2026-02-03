package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
   
	WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean productDisplayed() {
        return driver.findElements(By.xpath("//span[@class='a-truncate-cut']")).size()>0;
    }

    public String getQuantity() {
        return driver.findElement(By.name("quantity")).getAttribute("value");
    }
}
