package task15;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class LaunchGoogleAndSearchText {
	
	public static void main(String[] args)   {
		//set the path of a chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(); //instantiation
		driver.get("https://www.google.com/"); // launch google url
		WebElement element= driver.findElement(By.className("gLFyf"));
		element.sendKeys("Selenium Browser Driver"); //enter the value in the search bar		
		//element.submit();
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]//input[@class='gNO89b']")).click(); //click on search button
		driver.quit(); //close the browser
	}

}
