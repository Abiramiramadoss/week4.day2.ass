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

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disableNotifications");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder =new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		builder.moveToElement(men).perform();
		driver.findElement(By.linkText("Jackets")).click();
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println(count);
	    String total = count.replaceAll("[^0-9]","");
	    int tot = Integer.parseInt(total);
	    System.out.println(total);
	    String count1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
	    System.out.println("Total.no.of.jackets:"+count1);
	    String jcount = count1.replaceAll("[^0-9]","");
	    int j = Integer.parseInt(jcount);
	    System.out.println(j);
	    String count2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
	    System.out.println("Total.no.of.raincoats:"+count2);
	    String rcount = count2.replaceAll("[^0-9]","");
	   int r = Integer.parseInt(rcount);
	    System.out.println(r);
	    int jac = j + r;
	     if (tot == jac) {
		  System.out.println("Both count are same");
		    }
	     else
	         {
	    	 System.out.println(" Both count are not same");
	    	 
	     }
	     driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).click();
	     driver.findElement(By.xpath("//div[@class='brand-more']")).click();
	     driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
	     driver.findElement(By.xpath("//ul[@class='FilterDirectory-list']/li[2]")).click();
	     Thread.sleep(2000);
         driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
         driver.switchTo().defaultContent();
          WebElement ele = driver.findElement(By.xpath("(//input[@value='Duke']/following::span)[1]"));
          String text = ele.getText();
          String dk = text.replaceAll("[^0-9]","");
          System.out.println(dk);
          int dukecount = Integer.parseInt(dk);
          List<WebElement> list = new ArrayList<WebElement>();
      	for (int i = 0; i < dukecount ; i++) {
      		
      		list.add(ele);
      	}	
      		
      	int size = list.size();
      		
      		if(size==dukecount) {
      			
      			System.out.println("All the coats are Duke");
      		}else {
      			
      			System.out.println("Not all are Duke");
      		}
     
      		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']/span"));
      		builder.moveToElement(sort).click(sort).perform();
      		String disprice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
      		System.out.println("1st item price is:"+disprice);
      		driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
      		
      		Set<String> windowHandles2 = driver.getWindowHandles();
      		
      		List<String> window2 = new ArrayList<String>(windowHandles2);
      		
      		driver.switchTo().window(window2.get(1));
      		
      		 File source = driver.getScreenshotAs(OutputType.FILE);
      		
      		File destination = new File("./images/DukeJacket.png");
      		
      		FileUtils.copyFile(source, destination);
      		
      		driver.findElement(By.xpath("//span[contains(text(),'WISHLIST')]")).click();
      		
      		driver.switchTo().defaultContent();
      		driver.close();
      		
		
		

	}

}
