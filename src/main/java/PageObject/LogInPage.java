package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	public WebDriver driver;
	
	public LogInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By EmailId=By.cssSelector("#user_email");
	private By Password=By.xpath("//*[@id='user_password']");
	private 
	By Submit=By.cssSelector("[value='Log In']");
	
	public WebElement EmaiId() {
		return driver.findElement(EmailId);
	}
	public WebElement Password() {
		return driver.findElement(Password);
	}
	public WebElement Submit() {
		return driver.findElement(Submit);
	}

}
