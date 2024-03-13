package Getr.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Getr.AbstractComponents.AbstractComponents;

public class SearchResultsPage extends AbstractComponents {

	WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[@class ='MuiIconButton-label']")
	List<WebElement> searchfieldclick;
	
	@FindBy (id="searchInput")
	WebElement Peopletab;
	
	@FindBy (id="tab-people")
	WebElement searchfield;
	
	@FindBy (css="div[class='user-main']  div[class='username']")
	List<WebElement> listofpeoples;

	By EnableSearch = By.xpath("//button[contains(@class,  'forYou-tab')] ");
	
	By enablesearchfield = By.id("searchInput");
	
	By Searchresults =By.id("tab-people");
	//By searchclickable = By.xpath("//span[@class ='MuiIconButton-label']");

	
	
	public void clicksearchicon()
	{
		//ClickabilityOfElementLocated(searchclickable);
		searchfieldclick.get(2).click();
	}
	
	public void searchuser(String entersearchkeyword)
	{
		visibilityOfElementLocated(enablesearchfield);
		Peopletab.sendKeys(entersearchkeyword, Keys.ENTER);
	}
	public void Searchresults ()
	{
		visibilityOfElementLocated(EnableSearch);
	}
	
	public void searchresults()
	{
		visibilityOfElementLocated(Searchresults);

		searchfield.click();
		List<WebElement> users = listofpeoples;
		for (int i=0; i<users.size(); i++)
		{
		String usernames =users.get(i).getText();
		System.out.println(usernames);
		}
		
		
	}
}
