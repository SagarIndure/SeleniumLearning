package devberry;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class StandAloneTest extends AbstractComponent {

	public StandAloneTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

	public static void main(String[] args){

		String productName = "ZARA COAT 3";

		// OBJECT CREATION FOR CHROMEDRIVER
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		// Login Action
		driver.findElement(By.id("userEmail")).sendKeys("indurepatil@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("55@iPatil");
		driver.findElement(By.id("login")).click();

		// Product Catalog
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
		WebElement desiredProduct = productList.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		desiredProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//Handle the loading after product is added to cart
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[routerlink*='cart']")));
		//Click on Cart Button to goto cart page
		
		WebElement cartButton = driver.findElement(By.cssSelector("[routerlink*='cart']"));
		cartButton.click();
		
		
		
		
		//driver.quit();
	}

}
