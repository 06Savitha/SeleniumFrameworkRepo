package ALCore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class OutreachTask extends AccentureLegalCore {

	public OutreachTask(WebDriver driver) {
		this.driver = driver;
	}

	public void OutreachUserLogin() throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame("gsft_main");
		WebElement userName = driver.findElement(By.xpath("//input[@name='user_name']"));
		usernameO = PropertiesFile.getUserNameO();
		userName.sendKeys(usernameO);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		System.out.println("password..." + password);
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
		System.out.println("Outreach user logged in");
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement aLCore = driver.findElement(By.xpath(
				"//div/magellan-favorites-list/ul/li[3]/div/div[1]/a/div[2]/span[contains(text(),'Accenture Legal Core - Accenture Legal Cores')]"));
		action.moveToElement(aLCore).click().perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]//a[@class='linked formlink']"))
				.click();
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void OutreachUser() throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[5]/span/span[2]")).click();
		System.out.println("test2..");
		WebElement primaryOutreachTask = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div/div[5]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr//a[@class='linked formlink']"));
		primaryOutreachTask.click();
		System.out.println("test3..");
		System.out.println("Primary Outreach Task Opened");
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("Accenture Legal Attribute of Primary Outreach Task opened");
		WebElement sort = driver
				.findElement(By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/thead/tr[1]/th[4]/span/i"));
		sort.click();
		WebElement za = driver.findElement(By.xpath("//div[normalize-space()='Sort (z to a)']"));
		js.executeScript("arguments[0].click()", za);
		WebElement attributeField = driver.findElement(By.xpath(
				"//div[2]/div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", attributeField);
		answer = PropertiesFile.getComments();
		System.out.println("answer - " + answer);
		WebElement comments = driver
				.findElement(By.xpath("//div[2]/form/span[1]/span/div[5]/div[2]/div/div[3]/div[2]/textarea"));
		comments.sendKeys(answer);
		WebElement updateButn = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		js.executeScript("arguments[0].click()", updateButn);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		primaryOutreachTask = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div/div[5]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr//a[@class='linked formlink']"));
		primaryOutreachTask.click();
		driver.findElement(By.xpath("//*[@id='label.ni.x_aukms_accenture_outreach_task.activity_logs']")).click();
		WebElement markComplete = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		markComplete.click();
		primaryOutreachTask = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div/div[5]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr//a[@class='linked formlink']"));
		primaryOutreachTask.click();
		readOnlyFieldOutreach();
		markComplete = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		markComplete.click();
	}

	public void sessionExpire() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			Assert.assertTrue(alert.getText().contains("OK"));
		} catch (Exception e) {
			// exception handling
		}
	}
}
