package Getr.test;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Getr.PageObjects.TimelinePage;
import Getr.testcomponents.BaseTest;
import Getr.testcomponents.Retry;

public class LogoutUsingDataProvider extends BaseTest{
	//static String username = "App452";
	@Test (dataProvider = "getData", groups = {"Fail"} , retryAnalyzer=Retry.class)
	public void Logout(HashMap<String, String> input) throws InterruptedException
	{
		TimelinePage timeline = ob.Login(input.get("username"), input.get("password"));
		String welcometext = timeline.loginsuccesstoast();
		timeline.assertion(welcometext, input.get("Displayname"));
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
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", "App452");
		map.put("password", "Indium@123");
		map.put("Displayname", "App452");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("username", "john0208");
		map1.put("password", "Indium1");
		map1.put("Displayname", "megzz1615");
		
		return new Object[][]  { {map}, {map1}};
		
	}

}
