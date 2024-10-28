package rahulShettyAcademy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Skills\\Selenium WebDriver By Shammi Sir\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String name = "ADIDAS ORIGINAL";

		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);

		driver.findElement(By.id("userEmail")).sendKeys("manish.maldhure2021@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Asdf@1234");
		Thread.sleep(1000);
		driver.findElement(By.id("login")).click();
		WebDriverWait wt = new WebDriverWait(driver,5);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	

		System.out.println(driver.findElement(By.id("toast-container")).getText());
		String actualsuccesmsg = driver.findElement(By.id("toast-container")).getText();
		Assert.assertEquals(actualsuccesmsg, "Login Successfully");
		
		Thread.sleep(2000);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='col-lg']")));
		List<WebElement> products = driver.findElements(By.cssSelector("div[class*='col-lg']"));
		System.out.println(products.size());

		List<WebElement> productsnames = driver.findElements(By.cssSelector("div[class*='col-lg'] h5"));
		System.out.println(productsnames.size());
		//// div[@class='card-body']/button[2]
		List<WebElement> productButtons = driver.findElements(By.xpath("//div[@class='card-body']/button[2]"));
		System.out.println(productButtons.size());
		Thread.sleep(1000);
		
		for (int i = 0; i < products.size(); i++) {
			System.out.println("inside  for loop..");
			if (products.get(i).getText().contains(name)) {
				System.out.println("inside  if block..");
				productButtons.get(i).click();
				break;
			}
		}
		//Thread.sleep(3000);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wt.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		
		for( WebElement cartProd:cartProducts)
		{
			if(cartProd.getText().equalsIgnoreCase(name))
			{
				System.out.println("product found..");
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			
		}
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		
		List<WebElement> lists=driver.findElements(By.cssSelector(".ta-results button"));
		
		for(WebElement listele:lists)
		{
			if(listele.getText().equalsIgnoreCase("British Indian Ocean Territory"))
			{
				listele.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector(".btnn.action__submit")).click();
		String successmsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		String bookmsg=driver.findElement(By.cssSelector("#toast-container")).getText();
		System.out.println("Book success msg.."+bookmsg);
		Assert.assertEquals(bookmsg, "Order Placed Successfully");
		
		if(successmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	
	public void print() 
	{
		System.out.println("updating the line of code..");
		System.out.println("One line line is updated for git test");
	}

}
