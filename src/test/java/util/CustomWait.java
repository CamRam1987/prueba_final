package util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWait {
	// time in seconds for waits methods.
	public final long MIN_WAIT_SECONDS = 1;
	public final long SHORT_WAIT_SECONDS = 5;
	public final long NORMAL_WAIT_SECONDS = 15;
	public final long MEDIUM_WAIT_SECONDS = 40;
	public final long LARGE_WAIT_SECONDS = 60;
	private static final int SECONDS_CONVERSION = 1000;

	public boolean waitElementVisibility(WebDriver driver, WebElement element,
									  int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (NoSuchElementException | TimeoutException e){
			return false;
		}
	}


	public void waitElementInvisibility(WebDriver driver, WebElement Element,
			int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.invisibilityOf(Element));
	}

	public void waitElementToBeClickable(WebDriver driver, WebElement Element,
			int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
}
