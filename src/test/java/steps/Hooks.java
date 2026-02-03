package steps;


import basePkg.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void OpenBrowser() {
		BaseClass.OpenBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@After
	public void CloseBrowser() {
		BaseClass.CloseBrowser();
	}
}
