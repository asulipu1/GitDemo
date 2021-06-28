package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By SignIn=By.cssSelector("a[href*=sign_in]");
	private By Titel=By.xpath("(//h2) [1]");
	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public WebElement getLogin() {
		return driver.findElement(SignIn);
	}
	public WebElement getTitel() {
		return driver.findElement(Titel);
	}
	public WebElement getNavigation() {
		return driver.findElement(NavBar);
	}


}
