package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.openqa.selenium.By;


import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundSortable {

	public static void main(String[] args) {
		  WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("http://www.leafground.com/pages/sorttable.html");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			int rowCount = driver.findElements(By.xpath("//table[@id='table_id']//tr")).size();
			
			List<String> lt1 = new ArrayList<String>();
			
			for (int i = 1; i <rowCount; i++) {
					
			String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+ i +"]/td[1]")).getText();
			
			lt1.add(text);	
			
			}
			
			Collections.sort(lt1);
			
			System.out.println("List 1:" + lt1);
			
			driver.findElement(By.xpath("(//table[@id='table_id']//tr)[1]/th[2]")).click();
			
			int rowCount2 = driver.findElements(By.xpath("//table[@id='table_id']//tr")).size();
			
			List<String> lt2 = new ArrayList<String>();
			
			for (int i = 1; i < rowCount2; i++) {
				
		String text1 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+ i +"]/td[1]")).getText();
		
		lt2.add(text1);
				
			}
			
	      Collections.sort(lt2);
			
			System.out.println("List 2:"+ lt2);
			
			if(lt1.containsAll(lt2)) {
				
				System.out.println("Both the list has same values");
				
			}else {
				
				System.out.println("List 1 varies from list 2");
			}
		
			
			}		

	}


