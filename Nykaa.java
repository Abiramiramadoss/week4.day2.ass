package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa { 

	public static void main(String[] args) {
		
 WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder =new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();
    	WebElement cos = driver.findElement(By.xpath("//a[contains(text(),'Paris')]"));	
		builder.moveToElement(brands).pause(1000).click(cos).perform();
	    String text = driver.findElement(By.xpath("//div[@id='title']/h1")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'customer')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		WebElement sam = driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']"));
		String text2 = sam.getText();
		System.out.println(text2);
		sam.click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']")).click();
		String t1 = driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).getText();
		String t2 = driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).getText();
		if(t1.contains("Shampoo")&& t2.contains("Color Protection")){
			System.out.println("All filters applied");
		}
		else {
			System.out.println("Filters are not applied");
		}
		
		
		/*if(text2.contains("Shampoo")) {
			System.out.println("Filter is applied");
			
		}else {
			
			System.out.println("Not applied filter");
		}*/
		
       driver.findElement(By.xpath("(//div[@class='css-43m2vm']/img)[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		driver.findElement(By.xpath("//select[@class='css-1c1c89s']")).click();
	    driver.findElement(By.xpath("//option[contains(text(),'175')]")).click();
		WebElement mrp = driver.findElement(By.xpath("//span[@class='css-12x6n3h']"));
		String text3 = mrp.getText();
		String rs = text3.replaceAll("[^0-9]", "");
		int price = Integer.parseInt(rs);
		System.out.println("Price of shampoo is: Rs."+ price);
		mrp.click();
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		driver.findElement(By.xpath("//button[@class='css-5s18zx eoh7kvv0']")).click();
		driver.switchTo().frame(0);
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='value medium-strong']"));
		
		String text4 = ele.getText();
		
		String mrp1 = text4.replaceAll("[^0-9]", "");
		
		int price1 = Integer.parseInt(mrp1);
		
		System.out.println("Grand Total is:"+ price1);
		
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		
		driver.switchTo().defaultContent();
		
	   driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
       WebElement ele1 = driver.findElement(By.xpath("(//div[@class='value'])[2]"));
		
		String text5 = ele1.getText();
		
		String ele2 = text5.replaceAll("[^0-9]", "");
		
		int price2 = Integer.parseInt(ele2);
		
		System.out.println("Grand Total:"+ price2);
		
		if(price1==price2) {
			
			System.out.println("Grand total is same");
			
		}else {
			
			System.out.println("Grand total is not same");
		}
		
		driver.quit();
		

	}

}
