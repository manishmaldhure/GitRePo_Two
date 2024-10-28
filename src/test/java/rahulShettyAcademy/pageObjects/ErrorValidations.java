package rahulShettyAcademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulShettyAcademy.testComponent.BaseTest;

public class ErrorValidations extends BaseTest{

	//WebDriver driver;
	@Test
	public void submitOrderErr() throws Exception {
		
				
	
		lp.loginApplication("abcd@gmail.com","abcd");
		System.out.println(lp.getErrorMessage());
		
	//	lp.loginApplication();
		System.out.println("Browser launch..");
		
		String actualErrMessage=lp.getErrorMessage();
		System.out.println(actualErrMessage);
		String expeMessage="Incorrect email or password.";
		Assert.assertEquals(actualErrMessage,expeMessage);
	
		
		
		
		
		
	}

}
