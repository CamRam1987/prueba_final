package util.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import util.CustomWait;

import java.lang.reflect.Array;
import java.util.List;


public abstract class BaseScreen{

	protected CustomWait customWait = new CustomWait();
	protected final WebDriver driver;
	public Logger log = Logger.getLogger(BaseScreen.class);


	public BaseScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void tapBack() {
		driver.navigate()
		.back();
	}

	public void click(WebElement element) {
		if (customWait.waitElementVisibility(driver, element,30)) {
			element.click();
		} else {
			log.error("Error: Element " + element.getAccessibleName() + " was not clicked!");
		}
	}

	public void sendKeys(WebElement element, String sequence) {
		if (customWait.waitElementVisibility(driver, element,30)) {
			element.sendKeys(sequence);
		} else {
			log.error("Error: Element " + element.getAccessibleName() + " not able to write !");
		}
	}

	public boolean isElementAvailable(WebElement element) {
		if (customWait.waitElementVisibility(driver, element,30)) {
			return true;
		} else {
			return false;
		}
	}
	public void clickOnMovie(String ListOfMovies, String Compare){
	List<WebElement> movies= driver.findElements(By.cssSelector(ListOfMovies));
		for(WebElement movie:movies){
			if(movie.getText().equalsIgnoreCase(Compare)){
			movie.click();
			break;
			}
		}
	}

	public void clickOnExistingList(String existing,String listName){
		List<WebElement> listExisting= driver.findElements(By.cssSelector(existing));
		for(WebElement listExistings:listExisting){
			if(listExistings.getText().equalsIgnoreCase(listName)){
				click(listExistings);
			}

		}

	}
	public Boolean MoviesOnTheListSearch(String moviesOnTheLists,String recentlyAddedElement){
		List<WebElement> ExistingMovie= driver.findElements(By.cssSelector(moviesOnTheLists));
		//Array<String> array=ExistingMovie.toArray();
		for(WebElement ExistingMovies:ExistingMovie){
			//if(ExistingMovies.)

		}
		return true;
	}
	
}
