package rahulShettyAcademy.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulShettyAcademy.testComponent.BaseTest;

public class ErrorProductValidation extends BaseTest{

	@Test
	public void submitOrder() throws Exception {
		
		
		
		
		String name = "ADIDAS ORIGINAL";
		String verifyName = "ADIDAS ORIGINALADI";
		String countryName="British Indian Ocean Territory";
		String searchName="India";
	
		
	//	WebDriverWait wt = new WebDriverWait(driver,5);
		
	//	LandingPage lp=launchApplication();
		
		lp.loginApplication("manish.maldhure2021@gmail.com","Asdf@1234");

		
		
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		String actualsuccesmsg = driver.findElement(By.id("toast-container")).getText();
		Assert.assertEquals(actualsuccesmsg, "Login Successfully");
		
		//waitElementToAppear(findBy);
		Thread.sleep(2000);
		
		ProductCatalouge pc=new ProductCatalouge(driver);
		
		List<WebElement> products = pc.getProductList();
		System.out.println(products.size());

		pc.addProductToCart(name);
		
			
		pc.goToCartPage();
						
		CartPage cp=new CartPage(driver);
		Boolean match=cp.verifyProductDisplay(verifyName);
		Assert.assertFalse(match);
		
		
		
	}

}
