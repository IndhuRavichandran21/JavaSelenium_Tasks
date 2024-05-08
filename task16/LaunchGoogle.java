package task16;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchGoogle {
	
	public LaunchGoogle() {
		//set the path of a gecko driver
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
	}
	
	WebDriver driver=new FirefoxDriver(); //instantiation
	
	public void launchGoogleSite() {
		driver.manage().window().maximize(); //maximize the window
		driver.navigate().to("http://google.com"); // navigate to the url
		String currentURL=driver.getCurrentUrl(); //get url of the current page
	    System.out.println("The current url is "+currentURL);//print the url of the current page
	    driver.navigate().refresh(); // reloads the page
	    driver.quit(); //close the browser window
	    
		
	}

	public static void main(String[] args) {
		LaunchGoogle launchGoogle=new LaunchGoogle();
		launchGoogle.launchGoogleSite();
		

	}

}
