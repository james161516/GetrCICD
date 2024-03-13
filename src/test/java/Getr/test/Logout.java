package Getr.test;

import org.testng.annotations.Test;

import Getr.PageObjects.TimelinePage;
import Getr.testcomponents.BaseTest;
import Getr.testcomponents.Retry;

public class Logout extends BaseTest{
	static String username = "App452";
	@Test(retryAnalyzer=Retry.class)
	public void Logout() throws InterruptedException
	{
		TimelinePage timeline = ob.Login(username, "Indium@123");
		String welcometext = timeline.loginsuccesstoast();
		timeline.assertion(welcometext, username);
		Thread.sleep(3000);
		TimelinePage tp = new TimelinePage(driver);
		tp.Profileicons();
		TimelinePage tp1 = new TimelinePage(driver);
		tp1.Sidemenu();
		TimelinePage tp2 = new TimelinePage(driver);
		tp2.Logutbutton();
		TimelinePage tp3 = new TimelinePage(driver);
		tp3.afterlogout();
	}

}
