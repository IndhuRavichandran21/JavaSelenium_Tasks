package task17;
import java.util.Scanner;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDealLogin {
	public SnapDealLogin() {
		//set the property name of the driver and path of the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
	}
	
	String successLogin_url="https://www.snapdeal.com/?loginSuccess=success&";
	
	WebDriver driver=new ChromeDriver(); //Chrome Driver instatiation

	public void launchSnapDeal() throws InterruptedException {
		driver.navigate().to("http://www.snapdeal.com"); //launch the snapdeal website
		
		Actions actions=new Actions(driver); //instatiate Actions class and pass the control from driver to actions object
		WebElement element=driver.findElement(By.xpath("//div[contains(@class,'myAccountTab')]"));
		actions.moveToElement(element).build().perform(); //move the cursor to the sigin button
		
		driver.findElement(By.xpath("//a[text()='login']")).click(); //click the LogIn button
		
		WebElement frameElement=driver.findElement(By.id("loginIframe")); 
		driver.switchTo().frame(frameElement); //switch to iframe
		Thread.sleep(3000);
		
		driver.findElement(By.id("userName")).sendKeys("indhuravi21@gmail.com"); //sending the value to email id field
		driver.findElement(By.xpath("//div[@class='userAuth-card']//button[@id='checkUser']")).click(); // click continue button
		Thread.sleep(3000); //wait time

		System.out.println("Enter OTP");
		Scanner scan=new Scanner(System.in); //enter the OTP in console since it cannot be automated
		String OTP=scan.nextLine();
		driver.findElement(By.xpath("//div[@class='screen2']//input[@class='otpValueCode']")).sendKeys(OTP); //sending value of OTP in the field	
		
		driver.findElement(By.id("loginUsingOtp")).click(); // click on continue button
		Thread.sleep(3000);
		System.out.println("Url after logged in "+driver.getCurrentUrl());
		
		if(driver.getCurrentUrl().equals(successLogin_url))
			System.out.println("User Logged in successfully"); //display msg of successful login
		else
			System.out.println("Login failed");
		
		scan.close();
	}
	
	public static void main(String []args) throws InterruptedException {
		SnapDealLogin obj=new SnapDealLogin();
		obj.launchSnapDeal();
	}

}
