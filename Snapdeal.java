package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		 WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disableNotifications");
			
			driver.get(" https://www.snapdeal.com/");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Actions builder = new Actions(driver);
			

			
			
			WebElement s1 = driver.findElement(By.xpath("//li[@navindex='1']"));
			
			WebElement s2 = driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]"));   
		    builder.clickAndHold(s1).moveToElement(s2).click(s2).perform();
			
	         WebElement s3 = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div"));
	                String text = s3.getText();
                    System.out.println(text);
	      
              driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
   
        
      	
    driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
			
      driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
      
  WebElement s4 = driver.findElement(By.xpath("//div[@class='sort-selected']"));
      
      String text1 = s4.getText();
      System.out.println(text1);
      
      
    if(text1.contains("Low To High")) {
    	  
    	  System.out.println("Sorted Low to High");
      }else {
    	  
    	  System.out.println("Sorted improperly");
      }
      
    Thread.sleep(5000);
      
  WebElement s5 = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
  
     s5.clear();
     s5.sendKeys("900");
     
  WebElement s6 = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
  
     s6.clear();
     s6.sendKeys("1200");
 
  driver.findElement(By.xpath("//input[@name='toVal']/following::div[1]")).click();
  
  Thread.sleep(5000);
   driver.findElement(By.xpath("//button[@data-filtername='Color_s']")).click();

    driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
  
 
   
 WebElement s7 = driver.findElement(By.xpath("//div[@class='filters-top-selected']/div[@class='filters']//a[contains(text(),'Navy')]"));
  
  String text2 = s7.getText();
  System.out.println(text2);
  
  WebElement s8 = driver.findElement(By.xpath("//div[@class='filters-top-selected']/div[@class='filters']//a[@data-key='Price|Price']"));
  
    String text3 = s8.getText();
    System.out.println(text3);
    
    
   if(text2.contains("Navy") && text3.contains("1200")) {
  
		   System.out.println("All filters applied");
	  
	}else {
		
		System.out.println("Filters not applied");
		
	}
   
  		
  WebElement s9 = driver.findElement(By.xpath("(//picture[@class='picture-elem']/img)[1]"));
   
   Thread.sleep(7000);
   
   WebElement s10 = driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]"));
   
   builder.moveToElement(s9).moveToElement(s10).click(s10).perform();
   
  Set<String> windowHandles = driver.getWindowHandles();
   
   List<String> window1 = new ArrayList<String>(windowHandles);
   
   driver.switchTo().window(window1.get(0));
   
   WebElement s11 = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
   
   String text4 = s11.getText();
   
   String text5 =text4.replaceAll("[^0-9]","");
   
   int price = Integer.parseInt(text5);
  
   System.out.println("Shoe Price: Rs." + price);
   
   Thread.sleep(2000);
   
  WebElement s12 = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
  
  Thread.sleep(2000);
   
   String text6 = s12.getText();
   
   System.out.println("Discount:" + text6);
   
 //take screenshot
 	File source = driver.getScreenshotAs(OutputType.FILE);
 	
 	File destination = new File("./images/TrainingShoes.png");
 	
 	FileUtils.copyFile(source, destination);
 	
 	// driver.switchTo().window(window1.get(0));
 			
 driver.switchTo().defaultContent();
 	
 	driver.close();

	}

}
