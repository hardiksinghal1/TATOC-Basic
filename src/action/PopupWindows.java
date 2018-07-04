package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PopupWindows {
	WebDriver driver;
	String MainWindow;
	
	public PopupWindows(WebDriver driver) {
		this.driver = driver;
		MainWindow = driver.getWindowHandle();
	}
	
	public void switchWindows(String handle) {
		driver.switchTo().window(handle);
	}
	
	public void newWindowOperations() {
		for (String handle : driver.getWindowHandles()) {
			switchWindows(handle);
		}
		driver.findElement(By.id("name")).sendKeys("Hardik");
		driver.findElement(By.id("submit")).click();
		switchWindows(MainWindow);
	}
	
	public void performOperations() {
		driver.findElements(By.tagName("a")).get(0).click();
		newWindowOperations();
		driver.findElements(By.tagName("a")).get(1).click();
	}
	
	public void verifyNextPageReached() {
		String title = driver.getTitle();
    	Assert.assertTrue(title.contains("Cookie Handling"));
	}
	
	
}
