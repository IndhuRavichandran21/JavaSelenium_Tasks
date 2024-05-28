package task22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravelsSubmission {
	public PhpTravelsSubmission() {
		//set the driver name and path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
	}
	
	WebDriver driver = new ChromeDriver(); //chrome driver instantiation
	
	
	public void launchSite() throws IOException {
		driver.navigate().to("https://phptravels.com/demo/"); //launch url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait time to load elements in a page
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Indhu");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("R");
		driver.findElement(By.xpath("//input[@name='business_name']")).sendKeys("xxx Business");
		driver.findElement(By.xpath("//div[@class='form']//input[@name='email']")).sendKeys("xxx@gmail.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("demo"))); //scroll to the submit btn
		
		int num1 = Integer.parseInt(driver.findElement(By.id("numb1")).getText()); //get the number and convert to integer
		int num2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());        
		int result = num1+num2; //add 2 numbers
		driver.findElement(By.id("number")).sendKeys(Integer.toString(result)); //convert int to String
		driver.findElement(By.id("demo")).click();
		
		//wait till message appears after form submission
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean textAvailable = wait.until(ExpectedConditions.textToBePresentInElement
				(driver.findElement(By.cssSelector(".completed>p")), "sent your demo credentials to your email"));
		
		if(textAvailable) //print the respective message based on the text appears
			System.out.println("Form is submitted successfully");
		else 
			System.out.println("Form is not submitted");
		
		//scroll to the element to take screenshot 
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.cssSelector("div[class^=demo_form]")));
	
		//take screenshot and store in source file then copy it to the destination path
		TakesScreenshot scr = ((TakesScreenshot)driver);
		File sourceFile = scr.getScreenshotAs(OutputType.FILE); //take screenshot
		File destinationFile = new File("C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\Task\\src\\task22\\SubmissionScreenshot.jpg"); //path of the file where screenshot to be stored
		FileUtils.copyFile(sourceFile, destinationFile);  //copy the source file to the destination
	}

	public static void main(String[] args) throws IOException {
		PhpTravelsSubmission obj = new PhpTravelsSubmission(); //object creation
		obj.launchSite(); //method call

	}

}
