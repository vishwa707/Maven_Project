package testNGP;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pages.Homepage;
import pages.ProductPage;
import pages.SearchPage;

public class Amazon {
	Homepage hp;
	SearchPage s;
	ProductPage p;
	@BeforeSuite
	public void OpenBrowser() {
		BaseClass.OpenBrowser("https://amazon.in/");
	}
	@BeforeClass
	public void setup() {
		hp = new Homepage(BaseClass.driver); 
		s = new SearchPage(BaseClass.driver);
	}
	@BeforeMethod
	public void goToHome() {
	    BaseClass.driver.get("https://www.amazon.in/");
	}
	@Test(priority=1)
	public void homePageTitle() {
        Assert.assertTrue(hp.getTitle().contains("Amazon"));
    }
	@Test(priority=2)
	public void searchLaptopTest() {
		hp.search("Laptop");
	    Assert.assertTrue(s.keywordPresent("Laptop"));
	}
	 
	@Test(priority=3)
    public void autoSuggestionTest() {
		BaseClass.driver.get("https://www.amazon.in/");
        hp.captureAutoSuggestions();
    }

    @Test(priority=4)
    public void productCountTest() {
        hp.search("Headphones");
        System.out.println("Total Products: " + s.pcount());
        Assert.assertTrue(s.pcount() > 0);
    }

    @Test(priority=5)
    public void openProductTest() {
        hp.search("Washing Machine");
        s.getProductTitles().get(0).click();
        BaseClass.SwitchWindow();
        p = new ProductPage(BaseClass.driver);
        Assert.assertTrue(p.getProductTitle().length() > 0);
    }
	@AfterClass
	public void CloseBrowser() {
		BaseClass.CloseBrowser();
	}
	@AfterSuite
	public void Completed() {
		System.out.println("Test finished");
	}
}
