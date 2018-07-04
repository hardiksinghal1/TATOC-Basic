package action;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CookieHandling {
	WebDriver driver;
	
	public CookieHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getToken() {
		String token = driver.findElement(By.id("token")).getText();
		token = token.substring(7);
		return token;
	}
	
	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		driver.manage().addCookie(cookie);
	}
	
	public void resolve() {
		driver.findElements(By.tagName("a")).get(0).click();
		addCookie("Token", getToken());
		driver.findElements(By.tagName("a")).get(1).click();
	}
	
	public void verifyNextPageReached() {
		String title = driver.getTitle();
    	Assert.assertTrue(title.contains("End"));
	}
	
	
}
