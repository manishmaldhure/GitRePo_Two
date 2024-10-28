package rahulShettyAcademy.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By cartdata=By.cssSelector(".cartSection h3");
	
	@FindBy(css = ".hero-primary")
	WebElement succesmsgEle;
	
	// driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	public String getConfirmationMsg()
	{
		return succesmsgEle.getText();
	}
	

	

	

	

}
