import java.sql.DriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlightBooking {

	public static void main(String[] args) throws InterruptedException {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); 
		
	    WebDriver driver = new ChromeDriver();
		
	    driver.manage().window().maximize();
		
	    driver.get("https://www.phptravels.net/home");
	    
	    //Flights Click Code
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[2]/a")).click(); 
		Thread.sleep(1000);
		
		//Round Trip Code
		driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[1]/div[1]/div/div[2]/label")).click(); 
		
		//code to select Business from dropdown
		
		WebElement dropdown  = driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[1]/div[2]/div/div/a/span")); 
		dropdown.click();
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).moveToElement(driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[1]/div[2]/div/div/div/ul/li[2]"))).click().build().perform();
		Thread.sleep(5000);
		
		//Code for From
		
		driver.findElement(By.id("s2id_location_from")).click();       
		WebElement From = driver.findElement(By.id("location_from"));
		From.sendKeys("Pun");
		Thread.sleep(2000);
		From.sendKeys(Keys.ENTER,Keys.TAB);
		
		//Code for To
		
		driver.findElement(By.id("s2id_location_to")).click();        
		WebElement To = driver.findElement(By.id("location_to"));
		To.sendKeys("Del");
		Thread.sleep(2000);
		To.sendKeys(Keys.ENTER,Keys.TAB);
		
		//Depart Click
		
		driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[8]/div/div/div[2]/div[12]")).click();
		
		Thread.sleep(3000);
		
		//Code for Return
		
		WebElement Return= driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[9]/div/div/div[2]/div[25]"));   
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", Return);
		
		
	    //Adults
		
		for(int i=1; i<4; i++)                
		{
		  driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/span/button[1]")).click();
		}
		
		Thread.sleep(3000);    
		
		 //Child
		
		driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/span/button[1]")).click();
		
		Thread.sleep(3000);                
		
		 //Infants
		
		driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[3]/div/div/div[3]/div/div[2]/div/span/button[1]")).click();
		
		Thread.sleep(3000); 
		
		// Search Click
		
		driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[4]/button")).click();
		
		//Verify
		
		List<WebElement> list=driver.findElements(By.xpath("//div[starts-with(@href,'#searchResultsItem')]"));

		if(list.size() > 0) 
		{
		   System.out.println(" The Available flight list displayed");
		}
		
		else
		{
			 System.out.println(" No flight list available");
		}
		
		Thread.sleep(5000);
		
		driver.close();
		
	}
	
	
}
