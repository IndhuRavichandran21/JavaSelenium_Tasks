package task18;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookSignUp {

	public FacebookSignUp() {
		//sets the property name and path of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
	}
	
	String firstName = "Alice";
	String lastName = "R";
	String emailID = "qaautomationtest111@gmail.com";
	String password = "Automation@123";
	String facebook_HomePage="https://www.facebook.com/";
	
	WebDriver driver = new ChromeDriver(); //chrome driver instantiation
	
	public void facebookSignUp() throws InterruptedException {
		
		driver.navigate().to("https://www.facebook.com/"); //launch url
		driver.manage().window().maximize(); //maximize the browser window
		
		if(driver.getCurrentUrl().equals(facebook_HomePage)) //checks the given url is facebook url
			System.out.println("Website redirected to HomePage");
		else 
			System.out.println("Not landed in Homepage");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //10sec wait is applied to load each element in a page
		
		driver.findElement(By.name("firstname")).sendKeys(firstName);  //entering firstname
		driver.findElement(By.name("lastname")).sendKeys(lastName);    //entering lastname
		driver.findElement(By.name("reg_email__")).sendKeys(emailID);

        //pass the email id only if re-enter email textbox(hidden sometimes) appears
        if(driver.findElement(By.name("reg_email_confirmation__")).isDisplayed()) {
	       driver.findElement(By.name("reg_email_confirmation__")).sendKeys(emailID);
	       System.out.println("The textbox Re-enter email is displayed");
        }
	
       else
	      System.out.println("The element Re-enter email is not displayed");

		driver.findElement(By.id("password_step_input")).sendKeys(password); //entering password
		
		WebElement dateDropdown = driver.findElement(By.id("day"));
		Select dateSelect=new Select(dateDropdown);
		dateSelect.selectByVisibleText("11");  //select day as 11 from drop down
		
		WebElement monthDropdown = driver.findElement(By.id("month"));
		Select monthSelect=new Select(monthDropdown);
		monthSelect.selectByVisibleText("May"); //select month as May from drop down
		
		WebElement yearDropdown = driver.findElement(By.id("year"));
		Select yearSelect=new Select(yearDropdown);
		yearSelect.selectByVisibleText("1985"); //select year as 1985 from drop down
		
		driver.findElement(By.xpath("//input[@value='1']")).click(); //select the radio button as Female
		
		driver.findElement(By.name("websubmit")).click();  //select signup button
		
		//able to get the url of the second page only after interacting with the page2 element
		driver.findElement(By.name("phone"));
		
		System.out.println("Page url is "+driver.getCurrentUrl());
		if(driver.getCurrentUrl().equals(facebook_HomePage))  //checks for the successful registration
			System.out.println("Registration is successful and Website redirected to HomePage");
		else
			System.out.println("Registration is not yet completed");
	}
	public static void main(String[] args) throws InterruptedException {
		FacebookSignUp obj = new FacebookSignUp();
		obj.facebookSignUp(); //method call

	}

}
