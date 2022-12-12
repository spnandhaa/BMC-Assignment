package com.Project.Assignment;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.Data_Driven.Readerclass;

public class Amazon {
	static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mobile Programming\\eclipse-workspace\\Assignment bmc\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("amazon");

		List<WebElement> list = driver
				.findElements(By.xpath("(//*[@class='OBMEnb'])[1]//descendant::li[@role='presentation']"));

		for (WebElement sugg : list) {
			System.out.println(sugg.getText());
		}
		driver.findElement(By.xpath("(//*[@class='OBMEnb'])[1]//descendant::li[@role='presentation'][1]")).click();

		driver.findElement(By.xpath("//*[text()='Amazon.in']")).click();

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("dell computers");

		driver.findElement(By.id("nav-search-submit-button")).click();

		Thread.sleep(2000);
		driver.findElement(By.name("low-price")).sendKeys("30000");
		driver.findElement(By.name("high-price")).sendKeys("50000");
		driver.findElement(By.className("a-button-input")).click();
		Thread.sleep(2000);

		List<WebElement> page1 = driver.findElements(By.className("a-price-whole"));
		Thread.sleep(2000);
		for (WebElement price1 : page1) {
			System.out.println(price1.getText());
		}
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,9000)","");
		WebElement pa2 = driver.findElement(By.id("//*[@aria-label='Go to page 2']"));
		js.executeScript("arguments[0].click();", pa2);

		List<WebElement> page2 = driver.findElements(By.className("a-price-whole"));
		for (WebElement price2 : page2) {
			System.out.println(price2.getText());
		}
		Thread.sleep(2000);

	}
}
