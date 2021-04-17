package com.testinium.OtomasyonProjesi;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductProcess {

	WebDriver driver;

	public ProductProcess(WebDriver driver){
	        this.driver = driver;
	    }
	
	public void ProductSearch() {
		
		WebElement p = driver.findElement(By.name("k"));
		p.sendKeys("Bilgisayar");
		driver.findElement(By.xpath("//*[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[2]/button")).click();
		System.out.println("Bilgisayar kelimesi arandı.");
		
	}
	
	public void close_popup() { // Not : Bazen 2.Pop-Up çıkmayabiliyor.
		
		try {
			Thread.sleep(1 * 1000);
		driver.findElement(By.xpath("//img[@src='//dbfukofby5ycr.cloudfront.net/m13/0/9/d2101/19bb1-close-icon-13612.png']")).click();
			Thread.sleep(1 * 1000);
			driver.findElement(By.xpath("//span[@class='gg-icon gg-icon-close icon-close']")).click();
			System.out.println("Pop-up'lar kapandı.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void secondpage_process() {
		
		driver.findElement(By.linkText("2")).click();
		String expected_title1 = "Bilgisayar - GittiGidiyor - 2/100";
		System.out.println("2.Sayfaya giriş yapıldı.");
		String actual_title1 = driver.getTitle();

		if (expected_title1.equals(actual_title1)) {
			System.out.println("2.Sayfaya giriş doğrulandı");
		} else {
			System.out.println("2.Sayfaya giriş doğrulandı.");
		}

	}
	
	public void random_product_select() {
		
		try {
			Random random = new Random();
			int rand = random.nextInt(48) + 1; // ( 1 Sayfada = 48 Ürün )

			driver.findElement(By.xpath("//div[@class='clearfix']/ul[@class='catalog-view clearfix products-container']/li[" + rand+ "]/a[@class='product-link']")).click();
			Thread.sleep(2000);
			System.out.println("Rastgele bir ürün seçildi.");
			

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
