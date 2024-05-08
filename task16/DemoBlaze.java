package task16;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlaze {
	public DemoBlaze() {
		//set the path of a chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
	}
	
	String siteURL="https://www.demoblaze.com/";
	
	WebDriver driver=new ChromeDriver(); //instantiation
	
	public void launchDemoBlaze() {
		driver.get(siteURL); // launch demo blaze url
		driver.manage().window().maximize(); //maximize chrome browser
		String title=driver.getTitle(); // get the title of the page
		
		if(title.equals("STORE")) //comparing the title of the page matches with string
			System.out.println("Page landed on correct website");
		else 
			System.out.println("Page not landed on correct website");
		driver.quit(); //close the browser
		}
	
	
	public static void main(String[] args) {
		DemoBlaze demoBlaze=new DemoBlaze();
		demoBlaze.launchDemoBlaze();
			
	}

}
