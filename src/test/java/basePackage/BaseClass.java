package basePackage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;
		
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		String baseurl="https://www.tutorialspoint.com";
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
}


