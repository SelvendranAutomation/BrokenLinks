package BrokenLinks.BrokenLinks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static  WebDriver  driver;
	

	public WebDriver getDriver() {
		return driver;
	}

		public static Properties prop;

		
		public TestBase(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/Config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		
		
		}
		
		
	
		
		
		
		public static void intialize() {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			//Maximize the screen
			driver.manage().window().maximize();
			//Delete all the cookies
			driver.manage().deleteAllCookies();
			//Implicit TimeOuts
			driver.manage().timeouts().implicitlyWait
			(30,TimeUnit.SECONDS);
			//PageLoad TimeOuts
			driver.manage().timeouts().pageLoadTimeout
			(30,TimeUnit.SECONDS);

		}

}
