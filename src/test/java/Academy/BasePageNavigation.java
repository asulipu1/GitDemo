package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LogInPage;
import resources.Base;

public class BasePageNavigation extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@Test
	public void basePageNavigation()
			throws IOException, InterruptedException {
		WebElement alerrt = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
		if (alerrt.isDisplayed()) {
			alerrt.click();
		}
			LandingPage lp = new LandingPage(driver);
			Assert.assertTrue(lp.getNavigation().isDisplayed());
			log.info("Navigation bar is Displayed");
			
		
	
	}
	@BeforeTest
	public void Initializedriver() throws IOException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@AfterTest
	public void clseBrowser() {
		driver.close();
	}
	@Test 
	public void bhjadbj() {
		System.out.println("dchsk");
	
	}

	

}
