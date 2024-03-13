package Getr.test;

import java.io.IOException;
import org.testng.annotations.Test;

import Getr.PageObjects.SearchResultsPage;
import Getr.PageObjects.TimelinePage;
import Getr.testcomponents.BaseTest;
import Getr.testcomponents.Retry;

public class SearchUser extends BaseTest{
	static String username = "App452";

	@Test (retryAnalyzer=Retry.class)
public void SearchUser() throws IOException, InterruptedException
{
		
		TimelinePage timeline =ob.Login(username, "Indium@123");
		String welcometext = timeline.loginsuccesstoast();
		SearchResultsPage sr =timeline.assertion(welcometext, username);
		Thread.sleep(5000);
		sr.clicksearchicon();
		sr.Searchresults();
		sr.searchuser("Gettr");
		sr.searchresults();
		
	}
}
