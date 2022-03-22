package BrokenLinks.BrokenLinks;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class BrokenImageTest extends TestBase{
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


		  List<WebElement> images = driver.findElements(By.tagName("img"));
	        System.out.println("Total number of Images on the Page are " + images.size());


	        //checking the links fetched.
	        for(int index=0;index<images.size();index++)
	        {
	            WebElement image= images.get(index);
	            String imageURL= image.getAttribute("src");
	            System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
	            VerifyLinks vLink=new VerifyLinks();
	            vLink.verifyLinks(imageURL);
	          
	            //Validate image display using JavaScript executor
	            try {
	                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
	                if (imageDisplayed) {
	                    System.out.println("DISPLAY - OK");
	                }else {
	                     System.out.println("DISPLAY - BROKEN");
	                }
	            } 
	            catch (Exception e) {
	            	System.out.println("Error Occured");
	            }
	        }
	      
	       
	        
	      
	}
	
	@AfterTest
	public void tearDown() {
		
		  driver.quit();
	}

}
