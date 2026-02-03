package testNGP;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePkg.BaseClass;

public class Hrm {
	WebDriverWait wait;
	WebElement user1;
	WebElement pass1;
	WebElement button;
	@BeforeClass
	public void setup() {
		BaseClass.OpenBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void login_page() {
		BaseClass.driver.manage().deleteAllCookies();
		BaseClass.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'orangehrm-login-container')]")));
		user1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		pass1 = BaseClass.driver.findElement(By.name("password"));
		button = BaseClass.driver.findElement(By.xpath("//button"));
	}
	@AfterClass
	public void CloseBrowser() {
		BaseClass.CloseBrowser();
	}
	@DataProvider
	public Object[][] success(){
		return new Object[][] {{"Admin", "admin123"}};
	}
	@Test(dataProvider = "success")
	public void Valid_login(String user, String pass) {
		user1.sendKeys(user);
	    BaseClass.driver.findElement(By.name("password")).sendKeys(pass);
	    button.click();
	    wait.until(ExpectedConditions.urlContains("dashboard"));
	}
	@DataProvider
	public Object[][] failure(){
		return new Object[][] {{"Admin", "admin"}};
	}
	@Test(dataProvider = "failure")
	public void Invalid_Login(String user, String pass) {
		user1.sendKeys(user);
	    pass1.sendKeys(pass);
	    button.click();
	}
	@Test
	public void empty_login() throws InterruptedException {
		Thread.sleep(5000);
		button.click();
		WebElement error =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Required']")));
	    Assert.assertTrue(error.getText().equals("Required"),"Error");
	}
	

}
