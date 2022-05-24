package util.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import screens.HomePage;
import screens.MyListsPage;


public abstract class BaseMobileTest {

	WebDriver driver;
	protected MyListsPage homePage;
	public Logger log = Logger.getLogger(BaseMobileTest.class);

	public void goHome() {
		driver.get("https://www.themoviedb.org");
		homePage = new MyListsPage(getDriver());
		driver.manage().window().maximize();
	}

	@BeforeSuite
	public void initialSetup() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod(alwaysRun = true)
	public void environmentSetUp() {
		driver = new ChromeDriver();
		goHome();
	}

	@AfterMethod(alwaysRun = true)
	public void mobileApplicationEnd() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	protected HomePage loadHomePage() {
		return new HomePage(driver);
	}

}
