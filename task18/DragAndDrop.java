package task18;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.Color;

public class DragAndDrop {
	
		public DragAndDrop() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
		}
		
		String background_Color="rgba(255, 250, 144, 1)";
		WebDriver driver = new ChromeDriver();
		
		public void dragAndDrop() {
			driver.navigate().to("https://jqueryui.com/droppable/");
			driver.manage().window().maximize();
			WebElement frameElement = driver.findElement(By.className("demo-frame"));
			driver.switchTo().frame(frameElement);
			WebElement source = driver.findElement(By.id("draggable"));
			WebElement target = driver.findElement(By.id("droppable"));
			String color_BeforeDrop = driver.findElement(By.id("droppable")).getCssValue("background-color");
			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, target).build().perform();
			String color_AfterDrop = driver.findElement(By.id("droppable")).getCssValue("background-color");
			//String hexadecimalFromat=Color.fromString(color_AfterDrop).asHex();
			//System.out.println(hexadecimalFromat);
			if(color_AfterDrop.equals(background_Color))
				System.out.println("The background color of target element is modified from "+color_BeforeDrop+" to "+color_AfterDrop);
			else 
				System.out.println("The background color is not modified to "+color_AfterDrop);
			String text = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
			if(text.equals("Dropped!"))
				System.out.println("The target element has changed to Dropped!");
			else 
				System.out.println("The target element has not changed to Dropped!");
		}
		
	public static void main(String[] args) {
		DragAndDrop obj = new DragAndDrop();
		obj.dragAndDrop();

	}

}
