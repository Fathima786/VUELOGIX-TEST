package pagePackage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass {
	
WebDriver driver;
	
	@FindBy(xpath="/html/body/header/nav/ul/li[5]/a")
	WebElement loginmainpage;
	
	@FindBy(xpath="/html/body/header/nav/ul/div/li/a")
	WebElement loginafterlogout;
	
	@FindBy(xpath="//*[@id=\"login_email\"]")
	WebElement emailsignin;
	
	@FindBy(xpath="//*[@id=\"login_password\"]")
	WebElement passwordsignin;
	
	@FindBy(xpath="//*[@id=\"sign_in_btn\"]")
	WebElement buttonsignin;
	
	@FindBy(xpath="//*[@id=\"profileMenu\"]")
	WebElement profile;
	
	@FindBy(xpath="//*[@id=\"profile-menu\"]/li[5]/b/a")
	WebElement logout;
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	
	public PageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//clicking login on the main page
	public void login()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginmainpage));
		loginmainpage.click();
	}
	
	//entering login details
	public void logindetails(String emailinput,String passwordinput) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(emailsignin));
		emailsignin.clear();
		emailsignin.sendKeys(emailinput);
		wait.until(ExpectedConditions.visibilityOf(passwordsignin));
		passwordsignin.clear();
		passwordsignin.sendKeys(passwordinput);
		wait.until(ExpectedConditions.elementToBeClickable(buttonsignin));
		buttonsignin.click();
		Thread.sleep(10000);
	}
	
	//checking whether the login is successful or not
	public String checkvalid(String emailinput,String passwordinput)
	{
		String s;
		String expected="https://www.tutorialspoint.com/market/student/dashboard.jsp?v=1.0";
		String actual=driver.getCurrentUrl();
		if(actual.equals(expected))
		{
			s="pass";
			System.out.println("---------------------------------------");
			System.out.println("EMAIL - "+emailinput);
			System.out.println("PASSWORD - "+passwordinput);
			System.out.println("LOGIN SUCCESSFUL WITH VALID CREDENTIALS");
			System.out.println("---------------------------------------");
		}
		
		else
		{
			s="fail";
			System.out.println("---------------------------------------");
			System.out.println("EMAIL - "+emailinput);
			System.out.println("PASSWORD - "+passwordinput);
			System.out.println("LOGIN UNSUCCESSFUL WITH INVALID CREDENTIALS");
			System.out.println("---------------------------------------");
		}
		return s;
	}
	
	//logout if login is successful
	public void logout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(profile));
		profile.click();
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}
	
	//redirecting to the login page after a successful login
	public void loginafterlogout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginafterlogout));
		loginafterlogout.click();
	}

}
