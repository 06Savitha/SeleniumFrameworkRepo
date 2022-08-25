package ALCore;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class EscalationTask extends CaseCreation {
	public EscalationTask(WebDriver driver) {// initialize objects and no void method and return type -constructor
		this.driver = driver;
	}

	public void ecalationUserLogin() throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		sessionExpire();
		driver.switchTo().frame("gsft_main");
		WebElement userNameE = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element");
		usernameE = PropertiesFile.getUserNameE();
		System.out.println("usernameE..." + usernameE);
		userNameE.sendKeys(usernameE);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement aLCore = driver
				.findElement(By.xpath("//div/magellan-favorites-list/ul/li[3]/div/ul/li[1]/div/a/div[2]/div"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")).click();

	}

	public void ecalationUserReject() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[5]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[5]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"))
				.click();
		driver.findElement(By.xpath("//div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a")).click();
		WebElement commentFiled = driver.findElement(
				By.xpath("//span[1]/span/div[5]/div[2]/div/div/div[2]/textarea"));
		comments = PropertiesFile.getComments();
		System.out.println("Comments::" + comments);
		commentFiled.sendKeys(comments);
		WebElement update=driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		js.executeScript("arguments[0].click()", update);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[5]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"))
		.click();
		WebElement Reject =driver.findElement(By.xpath("//button[contains(text(),'Reject')]"));
		js.executeScript("arguments[0].click()", Reject);

	}

	public void ecalationUserApprove() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[5]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[5]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"))
				.click();
		driver.findElement(By.xpath("//div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a")).click();
		WebElement commentFiled = driver.findElement(
				By.xpath("//span[1]/span/div[5]/div[2]/div/div/div[2]/textarea"));
		comments = PropertiesFile.getComments();
		System.out.println("Comments::" + comments);
		commentFiled.sendKeys(comments);
		WebElement update=driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		js.executeScript("arguments[0].click()", update);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[5]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"))
		.click();
		WebElement approve=driver.findElement(By.xpath("//button[contains(text(),'Approve')]"));
		js.executeScript("arguments[0].click()", approve);

	}
	public void analystUserLogin() throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame("gsft_main");
		WebElement userName = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element");
		username = PropertiesFile.getUserName();
		System.out.println("username..." + username);
		userName.sendKeys(username);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement aLCore = driver.findElement(
				By.xpath("//div[3]/div/div/magellan-favorites-list/ul/li[2]/div/ul/li[4]/div/a/div[2]/div"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")).click();
	}
	public void analystUserReEscalate() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//div[2]/div[1]/span[4]/span/span[2]")).click();
		WebElement sort = driver.findElement(By
				.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/thead/tr[1]/th[3]/span/i"));
		sort.click();
		WebElement az = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]"));
		js.executeScript("arguments[0].click()", az);
		System.out.println("Short Description::");
		js.executeScript("window.scrollBy(0,1000)");
		WebElement iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		WebElement dueDiligence = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		dueDiligence.click();
		driver.findElement(By.xpath("//button[contains(text(),'Re-Escalate')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void analystUserAccept() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		WebElement dueDiligence = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		dueDiligence.click();
		driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
	}
	
	public void sessionExpire() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println("sessionExpire::" + alert.getText());
			alert.accept();
			Assert.assertTrue(alert.getText().contains("OK"));
		} catch (Exception e) {
			// exception handling
		}
	}

}
