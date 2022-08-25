package ALCore;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.PropertiesFile;

public class ScreeningAndSummaryreation extends CaseCreation {
	public ScreeningAndSummaryreation(WebDriver driver) {
		this.driver = driver;
	}

	public void screeingTaskTrigger() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Random rand = new Random();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[4]/span/span[2]")).click();
		WebElement iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement documentsRequired = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_id_v_tasks.is_documents_required_1']"));
		Select dropDownList = new Select(documentsRequired);
		List<WebElement> select = dropDownList.getOptions();
		int index = 0;
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {

			System.out.println("Error Messga....");
		}
		dropDownList.selectByIndex(index);
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		Select nextState = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.next_state']")));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		nextState.selectByVisibleText("Screening");
		WebElement updateButn = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		js.executeScript("arguments[0].click()", updateButn);
	}

	public void screeingOwnersKEsClientTask() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Random rand = new Random();
		js.executeScript("window.scrollTo(2000,0)");
		WebElement Screen = driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[6]/span/span[2]"));
		js.executeScript("arguments[0].click()", Screen);
		WebElement screenTask = driver
				.findElement(By.xpath("//div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", screenTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_screening_tasks.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement taskType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.alc_task_type']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement screeningField = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.screening']"));
		Assert.assertTrue(screeningField.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement patching = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.patching']"));
		Assert.assertTrue(patching.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		Thread.sleep(120000);
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/////

		/*
		 * do { driver.navigate().refresh(); driver. driver.wait(1000); } while
		 * (driver.findElements(By.locator(element)).size() < 1);
		 */

		/*
		 * WebElement screenStatus = driver.findElement(By.xpath(
		 * "//div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[contains(text(),'Success')]"
		 * )); String status = screenStatus.getText(); System.out.println("status::" +
		 * status);
		 */
			
		
		try {
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(10)).withMessage("Fluentwait::")
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[contains(text(),'Success')]")));
		} catch (Exception e) {
			e.printStackTrace();
		}


		//////////////

		screenTask = driver
				.findElement(By.xpath("//div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", screenTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[2]/span/span[2]")).click();

		List<WebElement> list = driver.findElements(
				By.xpath("//div[2]/div[2]/div/div[2]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody"));
		System.out.println("list.size::" + list.size());

		if (list.size() != 0 || list.size() != 1 || list.size() != 2) {

			WebElement screeningNonIndOwners = driver.findElement(
					By.xpath("//div/div[2]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
			js.executeScript("arguments[0].click()", screeningNonIndOwners);
			js.executeScript("window.scrollTo(2000,0)");
			WebElement eventDetails = driver
					.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
			js.executeScript("arguments[0].click()", eventDetails);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement reputationAttribute = driver.findElement(
					By.xpath("//*[@name='sys_select.x_aukms_accenture_event_details.reputation_attribute_value']"));
			Select dropDownList = new Select(reputationAttribute);
			List<WebElement> select = dropDownList.getOptions();
			System.out.println("Select::" + select);
			int index = 0;
			if (select.size() > 1) {
				index = rand.nextInt(select.size() - 1);
			} else if (select.size() < 1) {
				System.out.println("Error Messga....");
			}
			dropDownList.selectByIndex(index);
			if (index == 0) {
				dropDownList.selectByIndex(1);
			}
			Select falsePositive = new Select(
					driver.findElement(By.xpath("//select[@id='x_aukms_accenture_event_details.status']")));
			falsePositive.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		} else {
			assertTrue(false);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div[1]/span[3]/span/span[2]")).click();
		list = driver.findElements(By.xpath("//div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr"));
		System.out.println("list.size::" + list.size());
		if (list.size() != 0 || list.size() != 1 || list.size() != 2) {
			WebElement screeningKeyExecutives = driver.findElement(By.xpath(
					"//div[2]/div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
			js.executeScript("arguments[0].click()", screeningKeyExecutives);
			js.executeScript("window.scrollTo(2000,0)");
			WebElement eventDetails = driver.findElement(
					By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]"));
			eventDetails.click();
			// js.executeScript("arguments[0].click()", eventDetails);
			WebElement reputationAttribute = driver.findElement(
					By.xpath("//*[@name='sys_select.x_aukms_accenture_event_details.reputation_attribute_value']"));
			Select dropDownList = new Select(reputationAttribute);
			List<WebElement> select = dropDownList.getOptions();
			System.out.println("Select::" + select);
			int index = 0;
			if (select.size() > 1) {
				index = rand.nextInt(select.size() - 1);
			} else if (select.size() < 1) {
				System.out.println("Error Messga....");
			}
			dropDownList.selectByIndex(index);
			if (index == 0) {
				dropDownList.selectByIndex(1);
			}
			Select falsePositive = new Select(
					driver.findElement(By.xpath("//select[@id='x_aukms_accenture_event_details.status']")));
			falsePositive.selectByVisibleText("No");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		} else {
			assertTrue(false);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*
		 * driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"))
		 * .click(); WebElement task2 = driver.findElement(By.xpath(
		 * "//div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a[@class='linked formlink']"
		 * )); js.executeScript("arguments[0].click()", task2); state = new
		 * Select(driver.findElement(By.xpath(
		 * "//select[@name='x_aukms_accenture_screening_tasks.state']")));
		 * System.out.println("State..." + state);
		 * state.selectByVisibleText("QC Ready"); driver.findElement(By.xpath(
		 * "//*[@id='label.ni.x_aukms_accenture_screening_tasks.activity_logs']")).click
		 * (); WebElement fra = driver .findElement(By.xpath(
		 * "//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.fra_result']"));
		 * Assert.assertTrue(fra.getAttribute("readOnly").equals("true"),
		 * "Element ReadOnly"); nextState = new Select( driver.findElement(By.xpath(
		 * "//select[@name='x_aukms_accenture_screening_tasks.next_state']")));
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * nextState.selectByVisibleText("Summary");
		 * driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"))
		 * .click();
		 */
	}

}
