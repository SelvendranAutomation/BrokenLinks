package BrokenLinks.BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;

public class VerifyLinks {
	 public static void verifyLinks(String linkUrl)
	    {
	        try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	            if(httpURLConnect.getResponseCode()>=400)
	            {
	            	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	        }catch (Exception e) {
	      }
	   }

}
