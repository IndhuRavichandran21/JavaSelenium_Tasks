package task15;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverScript {

	public static void main(String[] args) throws InterruptedException {
		//set the path of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //create instance
		driver.get("https://in.bookmyshow.com/"); //launch the url
		Thread.sleep(10000); 
		driver.quit(); //close the browser

	}

}
