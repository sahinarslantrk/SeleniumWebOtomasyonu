package com.testinium.OtomasyonProjesi;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ProjectTests {
	
		WebDriver driver;
		
		@Before
	    public void setup(){
	        System.setProperty("webdriver.chrome.driver","C:/Users/sahin/Selenium/ChromeDriver/chromedriver.exe");
	        this.driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }
		
		@Test
		public void start() {
			
			GGHome GGApp = new GGHome(driver);
	        /* www.gittigidiyor.com sitesi açılır. */
	        GGApp.gotoGG();
	        
	        //Anasayfa Kontrolü 
	        Assert.assertEquals(driver.getCurrentUrl(), "https://www.gittigidiyor.com/");
			System.out.println("Anasayfa kontrolü yapıldı."); 
			
			//Login Girişi
			LoginPage loginPage = new LoginPage(driver);
			loginPage.e_mail("sahinarslantrk@icloud.com");
			loginPage.pasw("xxxxxxxx");
		    loginPage.loginGG();
		    
		    /* kullanıcı ismi ile Login işlemi kontrol edilir. */
		    loginPage.login_Control();
		    
	        /* Arama kutucuğuna 'bilgisayar' kelimesi girilir. */
		    
		    ProductProcess p_process= new ProductProcess(driver);
		    p_process.ProductSearch();
		    
		    /*Pop-up Reklamları Kapatma*/
		    
		    ProductProcess cpop=new ProductProcess(driver);
		    cpop.close_popup();
		    
		    /*İkinci Sayfaya Giriş Yapma ve Kontrolü*/
		    
		    ProductProcess s_page=new ProductProcess(driver);
		    s_page.secondpage_process();
		    
			/*Rastgele Ürün Seçmek*/
		    
		    ProductProcess random_select=new ProductProcess(driver);
		    random_select.random_product_select();
		    
		    /*Sepete Ekleme*/
		    
		    BasketProcess addbas=new BasketProcess(driver);
		    addbas.add_basket();
		    
		    /*Ürün sayfasındaki fiyat ile sepetteki ürün fiyatının doğruluğu*/
		    
		    BasketProcess bcontrol=new BasketProcess(driver);
		    bcontrol.basket_control();
		    
		    /*Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.*/
		    
		    BasketProcess tcontrol=new BasketProcess(driver);
		    tcontrol.totalproduct_add_control();
		    
		    /*Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.*/
		    		   
		    BasketProcess p_remove=new BasketProcess(driver);
		    p_remove.product_remove();
		    
		    System.out.println("Test başarıyla tamamlandı..");
		    
		    
		}
		
		
		
		
		
}
