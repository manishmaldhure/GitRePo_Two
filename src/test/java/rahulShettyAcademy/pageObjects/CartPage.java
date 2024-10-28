package rahulShettyAcademy.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By cartdata=By.cssSelector(".cartSection h3");
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkout;
	
	
	public boolean verifyProductDisplay(String name)
	{
		waitElementToAppear(cartdata);
		boolean b=false;
		for( WebElement cartProd:cartProducts)
		{
			if(cartProd.getText().equalsIgnoreCase(name))
			{
				System.out.println("product found..");
				b=true;
			}			
		}
		return b;
		
	}
	public void goToCheckout()
	{
		checkout.click();
	}

	

	

	

}
