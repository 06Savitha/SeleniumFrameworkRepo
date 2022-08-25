package ALCore;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import config.PropertiesFile;

public class TeamLead extends CaseCreation {

	public TeamLead(WebDriver driver) {
		this.driver = driver;
	}

	public void TeamLeadLogin() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		driver.switchTo().frame("gsft_main");
		WebElement userName = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element");
		usernameT = PropertiesFile.getUserNameT();
		System.out.println("username..." + usernameT);
		userName.sendKeys(usernameT);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement aLCore = driver
				.findElement(By.xpath("//div/magellan-favorites-list/ul/li[2]/div/ul/li[6]/div/a/div[2]/div"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")).click();
	}

	public void Allocation() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame("gsft_main");
		System.out.println("readOnlyField");
		WebElement allowtpaButn = driver.findElement(By.xpath("//*[contains(text(),'Allow TPA')]"));
		js.executeScript("arguments[0].click()", allowtpaButn);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[3]/span/span[2]")).click();
		WebElement allocation = driver
				.findElement(By.xpath("//div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", allocation);
		WebElement assignedToField = driver
				.findElement(By.xpath("//*[@name='lookup.x_aukms_accenture_allocation.assigned_to']"));
		assignedToField.click();
		System.out.println("assigned to::");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"))
				.click();
		System.out.println("Child window::");
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		System.out.println("Mani Window");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement markComplete = driver.findElement(By.xpath("//*[contains(text(),'Mark Complete')]"));
		js.executeScript("arguments[0].click()", markComplete);
	}

	public void ReopenedIDVTasks() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[4]/span/span[2]")).click();
		WebElement iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement Screen = driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[6]/span/span[2]"));
		js.executeScript("arguments[0].click()", Screen);
		WebElement screenTask = driver
				.findElement(By.xpath("//div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", screenTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		state = new Select(driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	public void screenSanctionEscalations () throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.xpath("//div[2]/div[1]/span[7]/span/span[2]")).click();
		WebElement sanctionTask=driver.findElement(By.xpath("//div/div[7]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		sanctionTask.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement approve =driver.findElement(By.xpath("//button[contains(text(),'AESC Approve')]"));
		js.executeScript("arguments[0].click()", approve);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}

	public void TPAEscalateAndSendToAMLCO() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		WebElement tparequest = driver.findElement(
				By.xpath("//div/div[3]/div/div/magellan-favorites-list/ul/li[2]/div/ul/li[3]/div/a/div[2]/div"));
		action.doubleClick(tparequest).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"))
				.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement escalte = driver.findElement(By.xpath("//button[contains(text(),'Escalate')]"));
		String escalteButn = escalte.getText();
		String actualescalteButn = "Escalate";
		System.out.println("escalate::" + escalteButn);
		assertEquals(actualescalteButn, escalteButn);
		WebElement sendtoamlco = driver.findElement(By.xpath("//*[@id='send_to_amlco']"));
		String amlcoButn = sendtoamlco.getText();
		String actualAmlco = "Send to AML CO";
		System.out.println("amlco::" + amlcoButn);
		assertEquals(actualAmlco, amlcoButn);
		driver.findElement(By.xpath("//div[2]/form/div[1]/span[2]/span[1]/span[2]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement question = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_tpa_review_form.file_summary']"));
		question.sendKeys("Test");
		WebElement checkBox = driver.findElement(By.xpath(
				"//label[@id='label.ni.x_aukms_accenture_tpa_review_form.is_the_prospective_client_a_sanctioned_entity']"));
		// checkBox.isSelected();
		js.executeScript("arguments[0].click()", checkBox);
		checkBox = driver.findElement(
				By.xpath("//label[@id='label.ni.x_aukms_accenture_tpa_review_form.are_the_prospective_client_s']"));
		js.executeScript("arguments[0].click()", checkBox);
		System.out.println("CheckBox:::");
	}
}
