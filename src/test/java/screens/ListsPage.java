package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.screens.BaseScreen;

public class ListsPage extends BaseScreen {

    public ListsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Añadir elemento")
    private WebElement AnadirElemento;
    @FindBy(xpath = "//a[contains(.,'Añadir elemento')]")
    private WebElement anadirxpath;

    public SpecificListPage ClickOnAddElement(){
        customWait.waitElementVisibility(driver,AnadirElemento,2);
        click(anadirxpath);
        return new SpecificListPage(driver);
    }
    //public SpecificListPage addElement() {
        //sendKeys();
        //clickOnMovie();
        //return new SpecificListPage(driver);
    //}

}
