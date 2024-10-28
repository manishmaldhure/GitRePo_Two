package rahulShettyAcademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement pwd;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = ".toast-bottom-right")
	WebElement errorMessageLogin;

	By findBy = By.id("toast-container");
	By errmsg=By.cssSelector(".toast-bottom-right");
			
	public void loginApplication(String userid, String passpid) throws Exception {
		email.sendKeys(userid);
		pwd.sendKeys(passpid);
		Thread.sleep(3000);
		submit.click();
		
		waitElementToAppear(findBy);
		
	}
	
	public String getErrorMessage()
	{
		
		waitElementToAppear(errorMessageLogin);
	return	errorMessageLogin.getText();
	}
	

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}


}
