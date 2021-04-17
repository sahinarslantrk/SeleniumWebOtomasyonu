package com.testinium.OtomasyonProjesi;
import org.openqa.selenium.WebDriver;

public class GGHome {

	WebDriver driver;
	
	public GGHome(WebDriver driver){
        this.driver = driver;
    }
	
	public void gotoGG(){
        driver.get("https://www.gittigidiyor.com/");
        System.out.println("www.gittigidiyor.com sitesi açıldı .");
    }
}
