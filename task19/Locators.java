package task19;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	public Locators() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	public void launchSite() {
		driver.navigate().to("https://www.guvi.in/register");
			
		//By ID
		driver.findElement(By.id("name"));
		driver.findElement(By.id("email"));
		driver.findElement(By.id("password"));
		driver.findElement(By.id("togglePassword"));
		driver.findElement(By.id("mobileNumber"));
		driver.findElement(By.id("signup-btn"));
		
		//By Class Name
		driver.findElement(By.className("login"));
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='Sign in with Google Button']"));
		driver.switchTo().frame(frameElement);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.className("haAclf"))));
		//element.click();		
		driver.switchTo().parentFrame();
		
		driver.findElement(By.className("password-err"));
		driver.findElement(By.className("passToggle"));
		driver.findElement(By.className("iti__flag-container"));
		driver.findElement(By.className("countrycode-left"));
		driver.findElement(By.className("logo"));
		
		//By tagname
		
		
		
		//By Xpath
		driver.findElement(By.xpath("//p/a"));
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@title='Sign in with Google Button']"));
		driver.switchTo().frame(frameElement1);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.id("container"))));
		//element1.click();		
		driver.switchTo().parentFrame();
			
		driver.findElement(By.xpath("//form/div/input[@id='name']"));
		driver.findElement(By.xpath("//form/div[1]/input[@class='form-control']"));
		driver.findElement(By.xpath("//form/div/input[@id='email']"));
		driver.findElement(By.xpath("//form/div[2]/input[@class='form-control']"));
		driver.findElement(By.xpath("//form/div/input[@id='password']"));
		driver.findElement(By.xpath("//form/div[3]/input[contains(@class,'form-control')]")).sendKeys("email,cc");
		driver.findElement(By.xpath("//div//span[@id='togglePassword']")).click();
	}
	public static void main(String[] args) {
		Locators obj = new Locators();
		obj.launchSite();

	}

}
