package rahulShettyAcademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	public WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
	WebElement cart;
	
	@FindBy(css = "[routerlink*='/dashboard/myorders']")
	WebElement orders;

	public void goToCartPage() {
		cart.click();
	}
	public void goToOrders()
	{
		orders.click();
	}
	
	

	public void waitElementToAppear(By findBy) {
		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitElementToAppear(WebElement findByEle) {
		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.visibilityOf(findByEle));
	}

	public void waitElementToDisAppear(By findBy) throws Exception {
		Thread.sleep(2000);
		// WebDriverWait wt = new WebDriverWait(driver,5);
		// wt.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

}
