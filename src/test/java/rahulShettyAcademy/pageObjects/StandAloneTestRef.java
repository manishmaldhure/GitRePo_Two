package rahulShettyAcademy.pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulShettyAcademy.testComponent.BaseTest;

public class StandAloneTestRef extends BaseTest{
	//String name = "ADIDAS ORIGINAL";
	
	@Test(dataProvider = "getData",priority = 1)
	public void submitOrder(HashMap<String, String> input) throws Exception {
		
		
		
		
		
		String countryName="British Indian Ocean Territory";
		String searchName="India";
	
		
	//	WebDriverWait wt = new WebDriverWait(driver,5);
		
	//	LandingPage lp=launchApplication();
		
		lp.loginApplication(input.get("email"),input.get("pwd"));

		
		
		
			//System.out.println(driver.findElement(By.id("toast-container")).getText());
			String actualsuccesmsg = driver.findElement(By.id("toast-container")).getText();
			Assert.assertEquals(actualsuccesmsg, "Login Successfully");
		
		
		//waitElementToAppear(findBy);
		Thread.sleep(2000);
		
		ProductCatalouge pc=new ProductCatalouge(driver);
		
		List<WebElement> products = pc.getProductList();
		System.out.println(products.size());

		pc.addProductToCart(input.get("name"));
		
			
		pc.goToCartPage();
						
		CartPage cp=new CartPage(driver);
		Boolean match=cp.verifyProductDisplay(input.get("name"));
		Assert.assertTrue(match);
		
		cp.goToCheckout();
		CheckOutPage ck=new CheckOutPage(driver);
		ck.selectCountry(countryName, searchName);
		ck.submitOrder();
		
		ConfirmationPage confp=new ConfirmationPage(driver);
		String successmsg=confp.getConfirmationMsg();
		
		if(successmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		//String successmsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
	/*	String bookmsg=driver.findElement(By.cssSelector("#toast-container")).getText();
		System.out.println("Book success msg.."+bookmsg);
		Assert.assertEquals(bookmsg, "Order Placed Successfully");
		
		if(successmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		*/
		
	}
	
	@Test(dataProvider = "getData",priority = 2)
	public void orderHistoryTest(HashMap<String, String> input) throws Exception
	{
		lp.loginApplication(input.get("email"),input.get("pwd"));
		
		OrdersPage op=new OrdersPage(driver);
		op.goToOrders();
		Thread.sleep(2000);
		assertTrue(op.verifyorderHistory(input.get("name")));
		
	}
	@DataProvider
	public Object[][] getData()
	{
	//	return new Object[][]{{"manish.maldhure2021@gmail.com","Asdf@1234","ADIDAS ORIGINAL"},{"manish.maldhure@rediffmail.com","Asdf@1234","zara coat 3"}};
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("email", "manish.maldhure2021@gmail.com");
		map.put("pwd", "Asdf@1234");
		map.put("name", "ADIDAS ORIGINAL");
		
		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("email", "manish.maldhure@rediffmail.com");
		map1.put("pwd", "Asdf@1234");
		map1.put("name", "ZARA COAT 3");
		
		return new Object[][]{{map1},{map}};
		
	}

}
