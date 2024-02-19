package devberry;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".card-body")
	List<WebElement> productNamesLocator;
	
	public WebElement getDesiredProduct(String productName) {
		WebElement desiredProduct = productNamesLocator.stream().filter(product -> product.getText().equals(productName)).findFirst().orElse(null);
		desiredProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();;
		return desiredProduct;
	}
	
	public void addToCart(String productName) {
		getDesiredProduct(productName);
		
	}
	

}
