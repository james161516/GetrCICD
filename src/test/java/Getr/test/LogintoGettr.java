package Getr.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Getr.PageObjects.TimelinePage;
import Getr.testcomponents.BaseTest;
import Getr.testcomponents.Retry;

public class LogintoGettr extends BaseTest {
	static String username = "App452";
	
	WebDriver driver;

	@Test (retryAnalyzer=Retry.class)
	public void LoginToApplication() throws InterruptedException, IOException
	{
		TimelinePage timeline = ob.Login(username, "Indium@123");
		String welcometext = timeline.loginsuccesstoast();
		timeline.assertion(welcometext, username);

	}

}
