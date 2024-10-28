package rahulShettyAcademy.testComponent;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulShettyAcademy.pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	
	public  WebDriver initializeBrowser() throws Exception
	{
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream("D:\\MVM\\Eclipse_WorkSpace\\UdemyMavenProject22092023\\src\\test\\java\\rahulShettyAcademy\\resources\\GlobalData.properties");
		pro.load(fis);
		
		String browserName=pro.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Skills\\Selenium WebDriver By Shammi Sir\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		 driver = new ChromeDriver();
		 
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Skills\\Selenium WebDriver By Shammi Sir\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			 driver = new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser input..");
		}
		 
		 driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		return driver;
	}
	@BeforeMethod
	public void launchApplication() throws Exception
	{
		initializeBrowser();
		
		 lp=new LandingPage(driver);
		// lp.goTo();
	//	 driver.get("https://rahulshettyacademy.com/client");
		
		// return lp;
	}
	

}
