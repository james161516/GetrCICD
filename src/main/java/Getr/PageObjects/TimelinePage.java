package Getr.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Getr.AbstractComponents.AbstractComponents;

public class TimelinePage extends AbstractComponents{
	
	WebDriver driver;
	
	public TimelinePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//*[contains(text(),  'Welcome back')]")
	WebElement Welcometoast;
	
	@FindBy (xpath = "//div[@class='username']")
	WebElement Profileicon;
	
	@FindBy (xpath = "//div[contains(@class, 'MuiPaper-root MuiPopover-paper')]/div/button [2]")
	WebElement settingsOption;
	
	@FindBy (xpath ="//span[text() = 'Log out']")
	WebElement LogoutButton;
	
	@FindBy(xpath ="//p[text()='Log out']")
	WebElement ClickLogoutButton;
	
	
	By Sidemenu = By.xpath("//div[contains(@class, 'MuiPaper-root MuiPopover-paper')]/div/button [2]");
	
	By settingsPage = By.xpath("//h1[text() = 'Account Information']");
	
	By LogoutPopup = By.cssSelector("div[class='MuiDialogContent-root']");
	
	By OnboardingPageLoginValidation1 = By.cssSelector("svg[aria-controls='more-menu']");
	
	public String loginsuccesstoast()
	{
		return Welcometoast.getText();
	}
	
	public SearchResultsPage assertion( String Welcometext , String username) {
		Assert.assertEquals(Welcometext,"Welcome back @"+username);
		SearchResultsPage sr = new SearchResultsPage(driver);
		
		System.out.println("Assertion Pass");
		return sr;
	}
	
	public void Profileicons()
	{
		Profileicon.click();
		visibilityOfElementLocated(Sidemenu);
	}
	
	public void Sidemenu()
	{
		settingsOption.click();
		visibilityOfElementLocated(settingsPage);
	}
	
	public void Logutbutton()
	{
		LogoutButton.click();
		visibilityOfElementLocated(LogoutPopup);
		ClickLogoutButton.click();
	}
	
	public void afterlogout()
	{
		//OnboardingPage on = new OnboardingPage(driver);
		visibilityOfElementLocated(OnboardingPageLoginValidation1);
		Assert.assertTrue(true);
		
	}
		
		
		
		
		
		
		
	}
 
	

