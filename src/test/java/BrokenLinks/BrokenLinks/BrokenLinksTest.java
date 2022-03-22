package BrokenLinks.BrokenLinks;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class BrokenLinksTest extends TestBase{
	private WebDriver driver;
	String urlString=TestBase.prop.getProperty("URL");
	
	@BeforeTest
	public void init() {
		intialize();	
		driver=getDriver();	
		
		
		
		
	}
	
	@Test
	public void doTest() {
		driver.get(urlString);
		System.out.println("Test");
		 List<WebElement> links = driver.findElements(By.tagName("a"));

	        // This line will print the number of links and the count of links.
	        System.out.println("No of links are "+ links.size());  
	      
	        //checking the links fetched.
	        VerifyLinks vLink=new VerifyLinks();
	        for(int i=0;i<links.size();i++)
	        {
	            WebElement E1= links.get(i);
	            String url= E1.getAttribute("href");
	            vLink.verifyLinks(url);
	        }
	        
	      
	}
	
	@AfterTest
	public void tearDown() {
		
		  driver.quit();
	}

}
