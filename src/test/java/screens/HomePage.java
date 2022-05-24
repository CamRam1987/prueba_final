package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import util.screens.BaseScreen;


public class HomePage extends BaseScreen {

	public HomePage(WebDriver driver) {
		super(driver);
	}


	@FindAll({
			@FindBy(linkText = "Login"),
			@FindBy(xpath = "//a[contains(.,'Login')]"),
			@FindBy(css = "a:contains(\"Login\")")
	})
    private WebElement loginBtn;

	@FindAll({
			@FindBy(css = ".search.blue"),
			@FindBy(css = "a.search")
	})
	private WebElement searchBtn;

	public LoginPage goToLoginScreen() {
		click(loginBtn);
		return new LoginPage(driver);
	}

}
