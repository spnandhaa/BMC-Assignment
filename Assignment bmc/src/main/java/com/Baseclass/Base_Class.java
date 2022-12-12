package com.Baseclass;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class{

	public static WebDriver driver;

	public static WebDriver setpro(String value) {
		if (value.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\shakt\\eclipse-workspace\\Ipt_TestNg\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (value.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\shakt\\eclipse-workspace\\Ipt_TestNg\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static WebDriver maxi() {
		driver.manage().window().maximize();
		return driver;
	}
public static void sleep() throws InterruptedException {
	Thread.sleep(2000);

}
	public static void geturl(String url) {
		driver.get(url);
	}

	public static void currenturl() {
		driver.getCurrentUrl();

	}

	public static void gettitle() {
		driver.getTitle();
	}

//******************************

	public static void screenshot(String screen) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\shakt\\eclipse-workspace\\ipt_Facebook\\screenshot\\" + screen + " .png");
		FileUtils.copyFile(source, destination);

	}

	// ***************************8

//	public static void sendkey(WebElement name, String value) {
//		name.sendKeys(value);
//	}
	public static void sendkey(WebElement name , String value) {
		name.sendKeys(value);

	}

	public static void getext(WebElement name) {
		name.getText();
	}

	public static void getsize(WebElement name) {
		name.getSize();
	}

	public static void getattribute(String value, WebElement name) {
		System.out.println(name.getAttribute(value));
	}

	public static void get_text(WebElement name) {

		System.out.println(name.getText());
	}

	public static void enable(WebElement name) {
		boolean ena = name.isEnabled();
		System.out.println(ena);

//		System.out.println(name.isEnabled());

	}

	public static void selected(WebElement name) {
		boolean sel = name.isSelected();
		System.out.println(sel);

//		System.out.println(name.isSelected());
	}

	public static void display(WebElement name) {

		boolean dis = name.isDisplayed();
		System.out.println(dis);
//		System.out.println(name.isDisplayed());
	}

	public static void click(WebElement name) {
		name.click();

	}

//****************
	public static void navito(String url) {
		driver.navigate().to(url);

	}

	public static void back() {
		driver.navigate().back();

	}

	public static void refresh() {
		driver.navigate().refresh();

	}

	public static void forward() {
		driver.navigate().forward();

	}

	// *****************************************8
	public static void quit() {
		driver.quit();

	}

	public static WebDriver close() {
		driver.close();
		return driver;

	}

	// ********************************
	public static void windowhandles() {
		int obj = driver.getWindowHandles().size();
		System.out.println("window count : " + obj);
	}

	public static void windowhandle() {
		System.out.println("Unique Id: " + driver.getWindowHandle());

	}

	// ****************************
	public static void scrollup(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(" + value + ",0)", "");
	}

	public static void scrolldown(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0," + value + ")", "");

	}

	// *****************************
	public static void selectbyindex(WebElement name, int index) {
		name.click();
		Select s = new Select(name);
		s.selectByIndex(index);

	}

	public static void selectbyvalue(WebElement name, String value) {
		name.click();
		Select s = new Select(name);
		s.selectByValue(value);

	}

	public static void selectbyvisibletext(WebElement name, String a) {
		name.click();
		Select s = new Select(name);
		s.selectByVisibleText("a");

	}

	public static void deselBytext(String text, WebElement name) {
		Select select = new Select(name);
		select.deselectByVisibleText(text);
	}

	public static void deselByIndex(WebElement name, int index) {
		Select select = new Select(name);
		select.deselectByIndex(index);
	}

	public static void deselByvalue(WebElement name, String value) {
		Select select = new Select(name);
		select.deselectByValue(value);
	}

	public static void desel_all(WebElement name) {
		Select select = new Select(name);
		select.deselectAll();
	}

	// ******************************
	public static void robot(String value) throws Throwable {
		Robot r = new Robot();
		if (value.equalsIgnoreCase("up")) {
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
		} else if (value.equalsIgnoreCase("down")) {
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} else if (value.equalsIgnoreCase("left")) {
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
		} else if (value.equalsIgnoreCase("right")) {
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
		} else if (value.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

	}

	// *******************
	public static void alertaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public static void alertdismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public static void alertsendkeys(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	// ********************

	public static void action(String action, WebElement element) {
		Actions a = new Actions(driver);
		if (action.equalsIgnoreCase("click")) {
			a.click(element).build().perform();
		} else if (action.equalsIgnoreCase("doubleClick")) {
			a.contextClick(element).build().perform();
		} else if (action.equalsIgnoreCase("contextclick")) {
			a.contextClick(element).build().perform();
		} else if (action.equalsIgnoreCase("movetoelement")) {
			a.moveToElement(element).release().build().perform();
		} else if (action.equalsIgnoreCase("clickandhold")) {
			a.clickAndHold(element).build().perform();
		}
	}

	// *************

	public static void frameindex(int index) {
		driver.switchTo().frame(index);
	}

	public static void frameid(String id) {
		driver.switchTo().frame(id);
	}

	public static void frameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void frame_exit() {
		driver.switchTo().defaultContent();
	}

	// **********************

	public static void draganddrop(WebElement start, WebElement stop) {
		Actions a = new Actions(driver);
		a.clickAndHold(start).moveToElement(stop).release().build().perform();

	}

	public static void rightclick(WebElement name) {
		Actions a = new Actions(driver);
		a.contextClick(name).build().perform();
	}

	// **********************

	public static void implicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void explicit(WebElement name) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(name));

	}

}
