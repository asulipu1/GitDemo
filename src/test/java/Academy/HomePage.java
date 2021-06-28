package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LogInPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@Test(dataProvider = "getdata")
	public void basePageNavigation(String email, String password, String text)
			throws IOException, InterruptedException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		
		WebElement alerrt = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
		if (alerrt.isDisplayed()) {
			alerrt.click();
		}
			LandingPage lp = new LandingPage(driver);
			lp.getLogin().click();
			LogInPage li = new LogInPage(driver);
			li.EmaiId().sendKeys(email);
			li.Password().sendKeys(password);
			Thread.sleep(1000);
			//System.out.println(text);
			log.info(text);
			li.Submit().click();
			driver.close();		
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = { { "asutoshdhalbisoi@gmail.com", "123475", "Resctrive user" },
				{ "dhalbisoiasutosh@gmail.com", "12345", "non Restrictive user" } };
		return data;
	}

}
