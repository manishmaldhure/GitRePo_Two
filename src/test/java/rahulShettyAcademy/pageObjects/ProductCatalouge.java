package rahulShettyAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class ProductCatalouge extends AbstractComponent{
	
	
	

	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			}
	
	@FindBy(css="div[class*='col-lg']")
	List<WebElement> productList;
	
	@FindBy(css="div[class*='col-lg']")
	List<WebElement> productNames;
	

	@FindBy(xpath="//div[@class='card-body']/button[2]")
	List<WebElement> productButtons;
	
	By findBy=By.cssSelector("div[class*='col-lg']");
	By toastmsg=By.cssSelector("#toast-container");
	By animatingmsg=By.cssSelector(".ng-animating");
	//By findBy1 = By.id("toast-container");
	
	public List<WebElement> getProductList()
	{
		//waitElementToAppear(findBy1);
		waitElementToAppear(findBy);
		
		return productList;
	
	}
	public List<WebElement> getproductNames()
	{
		return productNames;
	}
	
	public List<WebElement> getProductButtons()
	{
		return productButtons;
	}
	public void addProductToCart(String name) throws Exception
	{
		for (int i = 0; i < getproductNames().size(); i++) {
			System.out.println("inside  for loop..");
			if (getproductNames().get(i).getText().contains(name)) {
				System.out.println("inside  if block..");
				productButtons.get(i).click();
				break;
			}
		}
		waitElementToAppear(toastmsg);
		waitElementToDisAppear(animatingmsg);
	}
	
	
	
	
	//wt.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//	wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//	driver.findElements(By.cssSelector("div[class*='col-lg'] h5"));
	//List<WebElement> products = driver.findElements(By.cssSelector("div[class*='col-lg']"));
	

}
