package com.testinium.OtomasyonProjesi;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	WebDriver driver;
	public static String e_mail;
    public static String passw;

    public void pasw(String pass) {
        LoginPage.passw = pass;
    }
    
    public void e_mail(String email) {
        LoginPage.e_mail = email;
    }
    
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
    
	public void loginGG(){
		
		try {
			driver.get("https://www.gittigidiyor.com/uye-girisi");
			driver.findElement(By.id("L-UserNameField")).sendKeys("sahinarslantrk044@gmail.com");
			Thread.sleep(2 * 1000);
			driver.findElement(By.name("sifre")).sendKeys("testinium44");
			driver.findElement(By.xpath("//*[@id=\'gg-login-enter\']")).click();
			Thread.sleep(2 * 1000);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void login_Control() {
		
		if (driver.getPageSource().contains("Siparişlerim")) {
			System.out.println("Login işlemi doğrulandı.");
		} else {
			System.out.println("Login işlemi doğrulanmadı.");
		}
	}
}
