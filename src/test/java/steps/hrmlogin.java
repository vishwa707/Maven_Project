package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePkg.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class hrmlogin {
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
	@Given("user is on the login page")
	public void user_is_on_the_login_page(){
	    System.out.println("login page opened");
	}
	@When("^user enters valid (.*) and valid (.*)$")
	public void user_enters_valid_username_and_valid_passoword(String user, String pass) {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(user);
	    BaseClass.driver.findElement(By.name("password")).sendKeys(pass);
	}

	@When("Click on Login button")
	public void click_on_login_button() throws InterruptedException{
		Thread.sleep(5000);
		BaseClass.driver.findElement(By.xpath("//button")).click();
		Thread.sleep(5000);
	}

	@Then("User should be in dashboard")
	public void user_should_be_in_dashboard(){
	    System.out.println("user logged in");
	}

	@Then("close the browser")
	public void close_the_browser() {
	   System.out.println("Browser closed");
	}

	@When("^user enters invalid (.*) and invalid (.*)$")
	public void user_enters_invalid_username_and_invalid_passoword(String user, String pass) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(user);
		 BaseClass.driver.findElement(By.name("password")).sendKeys(pass);
	}

	@Then("Show error msg {string}")
	public void show_error_msg(String string) {
	    System.out.println("Invalid credentials");
	}
}
