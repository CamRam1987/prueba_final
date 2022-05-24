package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.screens.BaseScreen;
import util.tests.Menus;

public class ProfilePage extends BaseScreen {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".avatar")
	private WebElement avatarImg;


	public MyListsPage goTo(Menus menu) {
		WebElement element = driver.findElement(By.linkText(menu.getMenu()));
		click(element);
		return new MyListsPage(driver);
	}

	public boolean avatarIsDisplayed() {
		return isElementAvailable(avatarImg);
	}

}
