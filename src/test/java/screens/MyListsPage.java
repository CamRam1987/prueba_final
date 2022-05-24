package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.screens.BaseScreen;


public class MyListsPage extends BaseScreen {

	public MyListsPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(linkText = "Crear lista")
	private WebElement crearListaBtn;

	@FindBy(css = "a[href='/list/8203821']")
	private WebElement existingLists;
	String existing="div[class='card v4 list']";


	public NewListPage goToCreateList() {
		click(crearListaBtn);
		return new NewListPage(driver);
	}
	public ListsPage clickOnList(){
		click(existingLists);
		return new ListsPage(driver);
	}


}
