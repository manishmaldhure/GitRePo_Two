package rahulShettyAcademy.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By cartdata=By.cssSelector(".cartSection h3");
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countrytextEle;
	
	@FindBy(css = ".ta-results button")
	List<WebElement> lists;
	
	@FindBy(css = ".btnn.action__submit")
	WebElement submitEle;
	
	@FindBy(css = ".hero-primary")
	WebElement successmsgEle;
	
	
	//driver.findElement(By.cssSelector(".hero-primary")).getText();
	//driver.findElement(By.cssSelector(".btnn.action__submit")).click();
	// driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
	//List<WebElement> lists=driver.findElements(By.cssSelector(".ta-results button"));

	public void selectCountry(String countryName,String searchName)
	{
		countrytextEle.sendKeys(searchName);
		
		for(WebElement listele:lists)
		{
			if(listele.getText().equalsIgnoreCase(countryName))
			{
				listele.click();
				break;
			}
		}
		
				
	}
	
	public void submitOrder()
	{
		submitEle.click();
	}
	
	
	

	

}
