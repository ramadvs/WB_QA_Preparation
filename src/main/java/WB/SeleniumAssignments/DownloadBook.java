package WB.SeleniumAssignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class DownloadBook {
	
	WebDriver driver;
	
	@BeforeClass
	public void StartDR() 
	{
	System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
	
  driver = new ChromeDriver();
		
  driver.get("http://www.whiteboxqa.com/");
		
  driver.manage().window().maximize();
	
	}
	
	@Test
	public void bookDL() throws InterruptedException
	{
		
		
		driver.findElement(By.id("loginButton")).click();
		
		driver.findElement(By.id("username")).sendKeys("mailid@gmail.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		
		Actions act = new Actions(driver);
		
		WebElement resc = driver.findElement(By.xpath("(//A[@href='#'])[2]"));
		WebElement presc = driver.findElement(By.xpath("//A[@href='presentations.php']"));
		
		act.moveToElement(resc).build().perform();
		
		 act.moveToElement(presc).click().build().perform(); 
		
		 driver.findElement(By.linkText("Books")).click();
		 
		 driver.findElement(By.linkText("50 tricks for MongoDB developers")).click();
		 
		Set <String> s1 = driver.getWindowHandles();
		
		Iterator <String> it = s1.iterator();
		
		String parentwindowid = it.next();
		
		System.out.println("parentwindowid : "+ parentwindowid);
		
		String childwindowid = it.next();

		System.out.println("childwindowid : "+ childwindowid);
		
		driver.switchTo().window(childwindowid);
		
		System.out.println("the title of the book :"+ driver.getTitle());
		
		driver.findElement(By.xpath("//DIV[@class='ndfHFb-c4YZDc-Bz112c ndfHFb-c4YZDc-C7uZwb-LgbsSe-Bz112c ndfHFb-c4YZDc-nupQLb-Bz112c']")).click();
		
		Thread.sleep(10000);
		
		
		driver.switchTo().window(parentwindowid);
		
		driver.findElement(By.id("logout")).click();
	}

	@AfterClass
	
	public void closeDR()
	{
		driver.quit();
		
	}
	
	

}
