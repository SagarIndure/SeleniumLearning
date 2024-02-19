package devberry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	String userEmail = "sagarindurepatil@gmail.com";
	String userPass = "55@iPatil";
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement emailLocator;
	
	@FindBy(id = "userPassword")
	WebElement passLocator;
	
	@FindBy(id = "login")
	WebElement loginBtnLocator;
	
	
	By loginToast = By.id("toast-container");
	
	public ProductCatalogue LoginAction() {
		emailLocator.sendKeys(userEmail);
		passLocator.sendKeys(userPass);
		loginBtnLocator.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

}
