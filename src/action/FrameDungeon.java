package action;

import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class FrameDungeon {
	WebDriver driver;
	String colour,changecolour;
	
	public FrameDungeon(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToChild(String name) {
		driver.switchTo().frame(name);
	}
	
	public void switchToParent() {
		driver.switchTo().parentFrame();
	}
	
	public void findMatch() {
		while(!colour.equals(changecolour)) {
			switchToParent();
			driver.findElements(By.tagName("a")).get(0).click();
			switchToChild("child");
			changecolour = getBoxColour();
		}
	}
	
	public String getBoxColour() {
		return driver.findElement(By.id("answer")).getAttribute("class");
	}
	
	public void clickProceed() {
		switchToParent();
		driver.findElements(By.tagName("a")).get(1).click();
	}
	
	public void getSolution() {
		switchToChild("main");
		colour = getBoxColour();
		switchToChild("child");
		changecolour = getBoxColour();
		findMatch();
		clickProceed();
	}
	
	public void verifyColourChanged(String col1, String col2) {
		Assert.assertTrue(!col1.equals(col2));
	}
	
	public void verifyNextPageReached() {
		String title = driver.getTitle();
    	Assert.assertTrue(title.contains("Drag"));
	}
}
