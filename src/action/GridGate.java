package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GridGate {
	WebDriver driver;
	
	public GridGate(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnGreenBox() {
		driver.findElement(By.className("greenbox")).click();
	}
	
	public void clickOnRedBox() {
		driver.findElement(By.className("redbox")).click();
	}
	
	public void verifyGreenBoxClicked() {
		String title = driver.getTitle();
    	Assert.assertTrue(title.contains("Frame Dungeon"));
	}
	
	public void verifyRedBoxClicked() {
		String title = driver.getTitle();
		driver.navigate().back();
    	Assert.assertTrue(title.contains("Error"));
	}
	
}
