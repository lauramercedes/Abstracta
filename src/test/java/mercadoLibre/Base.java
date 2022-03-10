package mercadoLibre;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    private WebDriver driver;
	File gecko = new File("src/test/resources/geckodriver/geckodriver.exe");
	File chrome = new File("src/test/resources/chromedriver/chromedriver.exe");
    
	

	public Base(WebDriver driver) {
		this.driver = driver;

	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver FirefoxDriverConnection() {
		System.setProperty("webdriver.gecko.driver", gecko.getAbsolutePath());
		driver = new FirefoxDriver();
		return driver;
	}
	
	public WebDriver ChromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
		
	}

	public List<WebElement> WebElements(By locator) {
		return driver.findElements(locator);
	}

	public String getText(WebElement element) {
		return element.getText();

	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);

	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void click(WebElement element) {
		element.click();
	}

	public void dobleClick(By locator) {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(locator);
		actions.doubleClick(elementLocator).perform();
	}

	public void dobleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void rightClick(By locator) {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(locator);
		actions.contextClick(elementLocator).perform();
	}

	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public Boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public Boolean equals(By locator, String cadena) {
		try {
			return driver.findElement(locator).getText().equals(cadena);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public Boolean equals(WebElement element, String cadena) {
		try {
			return element.getText().equals(cadena);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void getURL(String url) {
		driver.get(url);
	}

	public void clear(By locator) {
		driver.findElement(locator).clear();
	}
	

	public void waitForElement(By locator,int tiempo) {
		 WebDriverWait wait = new WebDriverWait(driver, tiempo);
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void waitForElementClickable(By locator,int tiempo) {
		 WebDriverWait wait = new WebDriverWait(driver, tiempo);
		 wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	
	public void esperaSleep(int tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}
	
	
	//scroll hasta el final de la pagina
	public void scrollDown() {		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		//js.executeScript("arguments[0].scrollIntoView();", findElement(btn));
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        				
	}
	
	//scroll hasta el inicio de la pagina
	public void scrollUP() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(document.body.scrollHeight,0 )");
        				
	}

}
