package rahulShettyAcademy.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {

	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By cartdata=By.cssSelector(".cartSection h3");
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> orderProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkout;
	
	By ordersList=By.xpath("//tbody/tr/td[2]");
	public boolean verifyorderHistory(String name)
	{
		waitElementToAppear(ordersList);
		boolean b=false;
		for( WebElement ordprod:orderProducts)
		{
			if(ordprod.getText().equalsIgnoreCase(name))
			{
				System.out.println("product found..");
				b=true;
				break;
			}			
		}
		return b;
		
	}
	

	

	

	

}
