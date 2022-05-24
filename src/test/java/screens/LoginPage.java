package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.screens.BaseScreen;
import util.tests.Users;


public class LoginPage extends BaseScreen {

	public LoginPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(css = "input#username")
	private WebElement userNameTxt;

	@FindBy(css = "input#password")
	private WebElement passwordTxt;

	@FindBy(css = "input#login_button")
	private WebElement loginBtn;

	public ProfilePage as(Users user) {
		sendKeys(userNameTxt, user.getUsername());
		sendKeys(passwordTxt, user.getPassword());
		click(loginBtn);
		return new ProfilePage(driver);
	}

	public boolean loginFormDisplayed() {
		return isElementAvailable(userNameTxt) && isElementAvailable(passwordTxt);
	}
}
