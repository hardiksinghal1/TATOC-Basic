package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import action.CookieHandling;
import action.DragAround;
import action.FrameDungeon;
import action.PopupWindows;
import action.GridGate;


public class AppTest
{
	WebDriver driver;
	String title;
	
    @Test(dependsOnMethods = { "firstPageRedBox" })
    public void firstPage() {
    	GridGate gridgate = new GridGate(driver);
    	gridgate.clickOnGreenBox();
    	gridgate.verifyGreenBoxClicked();
    }
    
    @Test()
    public void firstPageRedBox() {
    	GridGate gridgate = new GridGate(driver);
    	gridgate.clickOnRedBox();
    	gridgate.verifyRedBoxClicked();
    }
    
    @Test(dependsOnMethods = { "firstPage" })
    public void secondPage() {
    	FrameDungeon framedungeon = new FrameDungeon(driver);
    	framedungeon.getSolution();
    	framedungeon.verifyNextPageReached();
    }
    
    @Test(dependsOnMethods = { "secondPage" })
    public void thirdPage() {
    	DragAround dragaround = new DragAround(driver);
    	dragaround.dragTheBox();
    	dragaround.verifyNextPageReached();
    }
    
    @Test(dependsOnMethods = { "thirdPage" })
    public void fourthPage() {
    	PopupWindows popup = new PopupWindows(driver);
    	popup.performOperations();
    	popup.verifyNextPageReached();
    }
    
    @Test(dependsOnMethods = { "fourthPage" })
    public void fifthPage() {
    	CookieHandling cookiehandle = new CookieHandling(driver);
    	cookiehandle.resolve();
    	cookiehandle.verifyNextPageReached();
    }
    
    @BeforeClass()
    public void openHomePage() {
    	driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
    }
    
    @AfterClass()
    public void closeHomePage() {
    	driver.quit();
    } 

}
