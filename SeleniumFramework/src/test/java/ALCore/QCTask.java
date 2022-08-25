package ALCore;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.PropertiesFile;

public class QCTask extends CaseCreation {

	public QCTask(WebDriver driver) {
		this.driver = driver;
	}

	public void qcLogin() throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement userNameQ = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element");
		usernameQ = PropertiesFile.getUserNameQ();
		System.out.println("usernameQ..." + usernameQ);
		userNameQ.sendKeys(usernameQ);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement aLCore = driver.findElement(By.xpath(
				"//div/magellan-favorites-list/ul/li[3]/div/div[1]/a/div[2]/span[contains(text(),'Accenture Legal Core - Accenture Legal Cores')]"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a[@class='linked formlink']"))
				.click();
	}

	public void IDVMarkComplete() throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[4]/span/span[2]")).click();
		WebElement iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);

		WebElement outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[6]"));
		String value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {
			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		
		outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[6]"));
		value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {
			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		
		outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[6]"));
		value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {
			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		
		outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[6]"));
		value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {

			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		
		outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[6]"));
		value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {

			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[6]"));
		value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {

			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		
		
		outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[6]"));
		value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {

			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		
		outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td[6]"));
		value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {
			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		
		outreach = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[9]/td[6]"));
		value = outreach.getText();
		System.out.println("value::" + value + "::");
		if (value.equalsIgnoreCase("Yes")) {

			WebElement task = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[9]/td[3]/a"));
			task.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Select outreachField = new Select( driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.primary_outreach']")));
			outreachField.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			iDVTask = driver.findElement(
					By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			js.executeScript("arguments[0].click()", iDVTask);
		}
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		Select nextState = new Select(
				driver.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_id_v_tasks.next_state']")));
		nextState.selectByVisibleText("Quality Check");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void ScreeningComplete() throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[6]/span/span[2]")).click();
		WebElement screenTask = driver.findElement(
				By.xpath("//div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", screenTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		screenTask = driver.findElement(
				By.xpath("//div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
		js.executeScript("arguments[0].click()", screenTask);
		state = new Select(driver.findElement(By.xpath("//select[@id='x_aukms_accenture_screening_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		Select nextState = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.next_state']")));
		System.out.println("nextState..." + nextState);
		nextState.selectByVisibleText("Quality Check");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
	}

	public void FRAComplete() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[10]/span/span[2]")).click();
		js.executeScript("window.scrollTo(2000,0)");
		WebElement task = driver
				.findElement(By.xpath("//div/div[10]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", task);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement markQC = driver.findElement(By.xpath("//button[text()='Mark For QC'][1]"));
		markQC.click();
	}

	public void approveQCTasks() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[11]/span/span[2]")).click();
		WebElement qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[3]/span/span[2]")).click();
		driver.findElement(By.xpath("//div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"))
				.click();
		Select state = new Select(
				driver.findElement(By.xpath("//select[@id='x_aukms_accenture_screening_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("Complete");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[3]/span/span[2]")).click();
		driver.findElement(By.xpath("//div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"))
				.click();
		Select fra = new Select(driver
				.findElement(By.xpath("//select[@id='sys_readonly.x_aukms_accenture_screening_tasks.fra_result']")));
		WebElement result = fra.getFirstSelectedOption();
		String fraResult = result.getText();
		System.out.println("fra Result::" + fraResult);
		state = new Select(driver.findElement(By.xpath("//select[@id='x_aukms_accenture_screening_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("Complete");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[4]/span/span[2]")).click();
		WebElement summaryTask = driver
				.findElement(By.xpath("//div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		summaryTask.click();
		state = new Select(
				driver.findElement(By.xpath("//select[@id='x_aukms_accenture_fra_summary_creation.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("Complete");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);

		if (fraResult.equalsIgnoreCase("High") || fraResult.equalsIgnoreCase("Medium")) {

			WebElement approve = driver.findElement(By.xpath("//button[contains(text(),'Approve')]"));
			js.executeScript("arguments[0].click()", approve);
			driver.close();

		} else {

			WebElement approve = driver.findElement(By.xpath("//button[contains(text(),'Approve')]"));
			js.executeScript("arguments[0].click()", approve);
			System.out.println("final ::");
			driver.quit();
		}
	}

	public void readOnlyIdvTasks() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_id_v_tasks.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_id_v_tasks.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_id_v_tasks.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement taskType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.alc_task_type']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement outReach = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.outreach']"));
		Assert.assertTrue(outReach.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_id_v_tasks.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement shortDescription = driver.findElement(
				By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.short_description']"));
		Assert.assertTrue(shortDescription.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyScreeningTasks() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement taskType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.alc_task_type']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_screening_tasks.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_screening_tasks.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement SIdvTaskNumber = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_screening_tasks.scr_idv_task_number_label']"));
		Assert.assertTrue(SIdvTaskNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_screening_tasks.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement outReach = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.outreach']"));
		Assert.assertTrue(outReach.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_screening_tasks.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement shortDescription = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.short_description']"));
		Assert.assertTrue(shortDescription.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyFraTasks() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_fra_summary_creation.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_fra_summary_creation.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_fra_summary_creation.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_fra_summary_creation.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_fra_summary_creation.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement shortDescription = driver.findElement(
				By.xpath("//*[@id='sys_readonly.x_aukms_accenture_fra_summary_creation.short_description']"));
		Assert.assertTrue(shortDescription.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void completeQCTasksForSME() throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		sessionExpire();
		driver.switchTo().frame("gsft_main");
		WebElement userNameQ = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element");
		usernameQ = PropertiesFile.getUserNameQ();
		System.out.println("usernameQ..." + usernameQ);
		userNameQ.sendKeys(usernameQ);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
		Thread.sleep(2000);
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement aLCore = driver.findElement(By.xpath(
				"//div/magellan-favorites-list/ul/li[3]/div/div[1]/a/div[2]/span[contains(text(),'Accenture Legal Core - Accenture Legal Cores')]"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a[@class='linked formlink']"))
				.click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[9]/span/span[2]")).click();
		WebElement qcTask = driver.findElement(By.xpath("//div[9]//table/tbody/tr/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[3]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[2]//div[3]//div[4]//table/tbody/tr/td[3]/a[@class='linked formlink']"))
				.click();
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_fra_summary_creation.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("Complete");
		WebElement rightclk = driver.findElement(By.xpath("//nav[@role='navigation']//div[@class='container-fluid']"));
		action.contextClick(rightclk).perform();
		driver.findElement(By.xpath("/html/body/div[7]/div[2]")).click();
		driver.findElement(By.xpath("//button[@onclick='gsftSubmitBack()']")).click();
		// driver.findElement(By.xpath("//button[@type='submit' and
		// @value='sysverb_update']")).click();
		driver.findElement(By.xpath("//button[@type='submit' and @id='approve_qc']")).click();
		/*
		 * WebElement sPop = driver.findElement(By.
		 * xpath("//div//*[contains(text(),'//div//*[contains(text(),'SME Task has been Reopened')]')]"
		 * )); String pop = sPop.getText(); String smePop =
		 * "SME Task has been Reopened"; assertEquals(smePop, pop);
		 */
		// newWindow.close();

	}

	public void sessionExpire() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println("alert::" + alert.getText());
			alert.accept();
			Assert.assertTrue(alert.getText().contains("OK"));
		} catch (Exception e) {
			// exception handling
		}
	}
}
