package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {
	public WebDriver driver;
	public Properties prop;
	private String Fpath=System.getProperty("user.dir");

	public WebDriver InitializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				Fpath+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		// String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					Fpath+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option =new ChromeOptions();
			if (browserName.contains("headless")){
			option.addArguments("headless");
			}
			driver=new ChromeDriver(option);
		} else if (browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					Fpath+"\\src\\main\\java\\resources\\geckodriver.exe");
			FirefoxOptions optio=new FirefoxOptions();
			if (browserName.contains("headless")){
				optio.addArguments("headless");
				}
			driver = new FirefoxDriver(optio);

		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public String getScreenshotPath(String testName, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = Fpath+"\\reports\\" + testName + ".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}
}
