package Getr.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Getr.AbstractComponents.AbstractComponents;

public class OnboardingPage extends AbstractComponents{
	
	WebDriver driver;
	public OnboardingPage(WebDriver driver)
	{
		super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	//We need to write in Page Factory format
	
	@FindBy (id="onetrust-accept-btn-handler")
	WebElement Cookies;
	
	@FindBy (css="a[class='text-link']")
	WebElement Loginlink;
	
	@FindBy (xpath = "//span[text()='Log in with email or username']")
	WebElement LoginwithErU;
	
	@FindBy (id="email")
	WebElement Email;
	
	@FindBy (id="password")
	WebElement Password;
	
	@FindBy (xpath="//span[text()='Log In']")
	WebElement Loginbtn;
	
	@FindBy (xpath = "//*[contains(text(),  'Welcome back')]")
	WebElement Welcometoast;
	
	/*@FindBy (css="div[id='gridAuth0Text']")
	WebElement OnboardingPageSignintext;*/
	
	By OnboardingPageLoginValidation = By.cssSelector("div[id='gridColumnTitle']");
	By cookiessection = By.id("onetrust-group-container");
	By Scrolltill = By.xpath("//span[text()='Log in with email or username']");
	By ToastMessage = By.xpath("//div[@class='Toastify__toast-body']");
	
	
	public TimelinePage Login(String email, String password)
	{
		visibilityOfElementLocated(cookiessection);
		Cookies.click();
		
		Loginlink.click();
		scroll(Scrolltill);
		LoginwithErU.click();
		Email.sendKeys(email);
		Password.sendKeys(password);
		Loginbtn.click();
		visibilityOfElementLocated(ToastMessage);
		TimelinePage timeline = new TimelinePage (driver);
		return timeline;
	}
	
	public void goTo() {
		driver.get("https://qa4.gettr-qa.com/");
	}
	
	public String loginsuccesstoast()
	{
		return Welcometoast.getText();
	}
	
	//driver.findElement(By.xpath("//*[contains(text(),  'Welcome back')]")).getText();

}
