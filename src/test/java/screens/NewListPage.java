package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.screens.BaseScreen;


public class NewListPage extends BaseScreen {
	String listName ="";

	public NewListPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(css = "input#name")
	private WebElement nameTxt;

	@FindBy(css = "textarea#description")
	private WebElement descriptionTxt;

	@FindBy(css = "input#step_1_submit")
	private WebElement continuarBtn;

	public SpecificListPage createNewList() {
		addListName();
		addDescription();
		click(continuarBtn);
		return new SpecificListPage(driver);
	}

	public void addListName() {
		listName = "test_" + getRandomNumber();
		sendKeys(nameTxt, listName);
	}

	public void addDescription() {
		sendKeys(descriptionTxt, "Description_" + getRandomNumber());
	}

	public int getRandomNumber(){
		int min = 10; int max = 1000;
		return (int)Math.random()*(max-min+1)+min;
	}

	
}
