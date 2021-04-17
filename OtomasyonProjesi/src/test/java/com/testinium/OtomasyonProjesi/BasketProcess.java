package com.testinium.OtomasyonProjesi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketProcess {

	WebDriver driver;

	public BasketProcess(WebDriver driver) {
		this.driver = driver;
	}

	public void add_basket() {
		driver.findElement(By.cssSelector("[id='purchaseSoldInfoActionButtons'] [id='add-to-basket']")).click();
		System.out.println("Ürün sepete eklendi.");
	}

	public void basket_control() {
		
		String price1=driver.findElement(By.xpath("//*[@id=\"sp-price-discountPrice\"]")).getText();
		driver.get("https://www.gittigidiyor.com/sepetim");
		String price1Control=driver.findElement(By.xpath("//*[@id=\"cart-price-container\"]/div[3]/p")).getText(); //ödenecek tutar sipariş sayfasında
		if (price1Control.equals(price1)) { 
			System.out.println("Ürün sayfasındaki fiyat ile sepetteki fiyat eşit.");
		} else {
			System.out.println("Ürün sayfasındaki fiyat ile sepetteki fiyat eşit değil!");
		}

	}

	public void totalproduct_add_control() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("option[value='2']")).click();
			Thread.sleep(2000);
			String totalProduct = driver
					.findElement(By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-child(1)"))
					.getText();
			String totalProductControl = "Ürün Toplamı (2 Adet)";
			Thread.sleep(2000);
			if (totalProduct.equals(totalProductControl)) {
				System.out.println("Sipariş Özeti : " + totalProduct);
			} else {
				System.out.println("Ürün adedi farklı.");
				}
			} catch (

					InterruptedException e) {
							e.printStackTrace();
												}
		}

	public void product_remove() {
		try {
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//i[@class='gg-icon gg-icon-bin-medium']")).click();
			System.out.println("Ürün(ler) silindi.");
			String sepet = driver.findElement(By.xpath("//*[@id=\"empty-cart-container\"]/div[1]/div[1]/div/div[2]/h2")).getText();
	        String sepetControl = "Sepetinizde ürün bulunmamaktadır.";
			
			if (sepet.equals(sepetControl)) {
				System.out.println("Sepetiniz boş ");
			} else {
				System.out.println("Sepetiniz boş değil ");
			}
		} catch (

		InterruptedException e) {
			e.printStackTrace();
		}
			
	}
	
	
}
