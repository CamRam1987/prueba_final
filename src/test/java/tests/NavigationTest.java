package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screens.*;
import util.screens.BaseScreen;
import util.tests.BaseMobileTest;

import static util.tests.Menus.*;
import static util.tests.Users.VALID_USER;

public class NavigationTest extends BaseMobileTest {
	@Test()
	public void navigateToHomePage() {
		log.info("Loads Home Page");
		HomePage home = loadHomePage();
		LoginPage login = home.goToLoginScreen();
		Assert.assertTrue(login.loginFormDisplayed(),"Form is not displayed");

		ProfilePage profile = login.as(VALID_USER);
		MyListsPage lists = profile.goTo(LISTAS);
		NewListPage newList = lists.goToCreateList();
		SpecificListPage specificList = newList.createNewList();
		Assert.assertTrue(specificList.editListDisplayed(), "Edit Option not displayed");
	}
	@Test
	public void AddMovie(){
		log.info("Loads Home Page");
		HomePage home = loadHomePage();
		LoginPage login = home.goToLoginScreen();
		Assert.assertTrue(login.loginFormDisplayed(),"Form is not displayed");

		ProfilePage profile = login.as(VALID_USER);
		MyListsPage lists = profile.goTo(LISTAS);
		ListsPage listpage = lists.clickOnList();
		SpecificListPage specificList=listpage.ClickOnAddElement();
		specificList.chooseNewMovie("Interstellar","Interstellar");
		Assert.assertTrue(specificList.isMoviePresent("Interstellar"),"movie is not present");

	}
	@Test
	public void deleteElement(){
		log.info("Loads Home Page");
		HomePage home = loadHomePage();
		LoginPage login = home.goToLoginScreen();
		Assert.assertTrue(login.loginFormDisplayed(),"Form is not displayed");

		ProfilePage profile = login.as(VALID_USER);
		MyListsPage lists = profile.goTo(LISTAS);
		ListsPage listpage = lists.clickOnList();
		SpecificListPage specificList=listpage.ClickOnAddElement();
		specificList.deleteMovie();
		Assert.assertFalse(specificList.isDeleteButtonPresent(),"the element was not deleted");
	}
	@Test
	public void justCreatedListAddMovie() {
		log.info("load list page");
		HomePage home = loadHomePage();
		LoginPage login = home.goToLoginScreen();
		Assert.assertTrue(login.loginFormDisplayed(),"Form is not displayed");

		ProfilePage profile = login.as(VALID_USER);
		MyListsPage lists = profile.goTo(LISTAS);
		NewListPage newList = lists.goToCreateList();
		SpecificListPage specificList = newList.createNewList();
		specificList.chooseNewMovie("The Batman","The Batman");
		Assert.assertTrue(specificList.addedmovieavailable(), "Added Option not displayed");
	}
	@Test
	public void deleteMovieJustAdded(){
		log.info("load list page");
		HomePage home = loadHomePage();
		LoginPage login = home.goToLoginScreen();
		Assert.assertTrue(login.loginFormDisplayed(),"Form is not displayed");

		ProfilePage profile = login.as(VALID_USER);
		MyListsPage lists = profile.goTo(LISTAS);
		NewListPage newList = lists.goToCreateList();
		SpecificListPage specificList = newList.createNewList();
		specificList.chooseNewMovie("The Batman","The Batman");
		specificList.deleteMovie();

	}

}