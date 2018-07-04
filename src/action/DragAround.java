package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAround {
	WebDriver driver;
	Actions act;
	
	public DragAround(WebDriver driver) {
		this.driver = driver;
	}
	
	public void dragTheBox() {
		WebElement From = driver.findElement(By.id("dragbox"));
		WebElement To = driver.findElement(By.id("dropbox"));
		act = new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
		clickProceed();
	}
	
	public void clickProceed() {
		driver.findElement(By.tagName("a")).click();
	}
	
	public void verifyNextPageReached() {
		String title = driver.getTitle();
    	Assert.assertTrue(title.contains("Windows"));
	}
	
	
}
