package task16;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWikipedia {
	public LaunchWikipedia() {
		//set the path of a chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
	}
	
	String searchIconClass_Xpath="//button[contains(@class,'pure-button')]";
	//WebDriver driver;
	WebDriver driver=new ChromeDriver(); //instantiation
	
	public void launchWikipediaSite() {
		//WebElement element=driver.findElement(By.id("searchInput"));
		//element.click();
		//driver.findElement(By.id("searchInput")).
		System.out.println(driver);
		driver.navigate().to("https://www.wikipedia.org/");	//launch the url
		driver.manage().window().maximize(); //maximize browser window
		driver.findElement(By.id("searchInput")).sendKeys("Artificial Intelligence"); // enter string in search box
		driver.findElement(By.xpath(searchIconClass_Xpath)).click();  //click search icon
		driver.findElement(By.linkText("History")).click(); //click History 
		//WebElement title=driver.findElement(By.id("History"));
		//System.out.println(title.getAttribute("id"));
		WebElement title=driver.findElement(By.xpath("//span[text()='History']")); //title is a ref variable called obj? Yes
		System.out.println(title);
		System.out.println("Title of the section is "+title.getText()); //print the text of the selected section
		driver.quit(); //close the browser
		}
	
	public static void main(String []args) {
		LaunchWikipedia obj=new LaunchWikipedia();
		obj.launchWikipediaSite();
	}

}
