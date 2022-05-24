package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import util.screens.BaseScreen;


public class SpecificListPage extends BaseScreen {
	String listName ="";

	public SpecificListPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(linkText = "Borrar lista")
	private WebElement borrarListaLink;

	@FindBy(linkText = "Elegir imagen")
	private WebElement elegirImagenLink;

	@FindBy(linkText = "Editar lista")
	private WebElement editarListaLink;

	@FindBy(css = "input#list_item_search")
	private WebElement anadirElementoTxt;

	@FindBy(css = "li[data-media-type='movie']")
	private WebElement addedmovie;

	@FindBy(css = "p[class='name']")
	private WebElement ListOfMovies;
	String Listofmovies="p[class='name']";

	@FindBy(css = "h4")
	private WebElement moviesOnTheList;
	String moviesOnTheLists="h4";

	@FindBy(css = "span[class='glyphicons_v2 circle-remove']")
	private WebElement deleteMovie;

	public boolean editListDisplayed() {
		return isElementAvailable(editarListaLink);

	}public boolean addedmovieavailable(){
		return isElementAvailable(addedmovie);
	}

	public boolean chooseImageDisplayed() {
		return isElementAvailable(elegirImagenLink);
	}
	public void chooseNewMovie(String elementToAdd, String Compare) {
		sendKeys(anadirElementoTxt,elementToAdd);
		customWait.waitElementVisibility(driver,ListOfMovies,2);
		clickOnMovie(Listofmovies,Compare);
	}
	public void deleteMovie(){
		customWait.waitElementVisibility(driver,deleteMovie,2);
		click(deleteMovie);
	}

	public Boolean isMoviePresent(String recentlyAddedElement){
		return MoviesOnTheListSearch(moviesOnTheLists,recentlyAddedElement);
	}

	public Boolean isDeleteButtonPresent(){
		return isElementAvailable(deleteMovie);
	};

}
