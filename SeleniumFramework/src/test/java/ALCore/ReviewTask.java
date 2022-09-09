package ALCore;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import config.PropertiesFile;

public class ReviewTask extends AccentureLegalCore {

	public ReviewTask(WebDriver driver) {
		this.driver = driver;
	}

	public void SMELogin() throws InterruptedException {
		WebElement userNameS = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element");
		usernameS = PropertiesFile.getUserNameS();
		System.out.println("usernameS..." + usernameS);
		userNameS.sendKeys(usernameS);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
	}

	public void ClientSponsorLogin() throws InterruptedException {
		WebElement userNameA = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element");
		usernameA = PropertiesFile.getUserName();
		System.out.println("usernameA..." + usernameA);
		userNameA.sendKeys(usernameA);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
	}

	public void SummaryCreationReview() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[10]/span/span[2]")).click();
		js.executeScript("window.scrollTo(2000,0)");
		WebElement summaryTask = driver
				.findElement(By.xpath("//div[10]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", summaryTask);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div[1]/span[3]/span/span[2]")).click();
		WebElement riskStatus = driver.findElement(
				By.xpath("//div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[7]"));
		String expectedRiskStatus = riskStatus.getText();
		System.out.println("expectedRiskStatus::"+expectedRiskStatus);
		if(expectedRiskStatus.equalsIgnoreCase("High") || expectedRiskStatus.equalsIgnoreCase("Medium") || expectedRiskStatus.equalsIgnoreCase("low"))
		{
			WebElement caseStatus = driver
					.findElement(By.xpath("//div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[6]"));
			String expectedStatus = caseStatus.getText();
			System.out.println("expectedStatus::"+expectedStatus);
			String actualStatus = "KYC In Progress";
			assertEquals(expectedStatus, actualStatus);
		}
		driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/ul/li/a")).click();
		WebElement sort = driver.findElement(By
				.xpath("//div[4]/table/tbody/tr/td/div/table/thead/tr[1]/th[7]/span/i"));
		sort.click();
		WebElement az = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]"));
		js.executeScript("arguments[0].click()", az);
		driver.findElement(By.xpath("//div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td[5]/a")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='label.ni.x_aukms_accenture_risk_mitigation_related_list.risk_value']")).click();
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		summaryTask = driver
				.findElement(By.xpath("//div[10]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", summaryTask);
		
		WebElement smeReview = driver.findElement(By.xpath("//div[5]/div[1]/div[2]/div[1]/div[2]/button[1]/span"));
		smeReview.click();
		WebElement search = driver.findElement(By.xpath("//div[1]/div[2]/span[2]/div[2]/span/button/span[1]"));
		search.click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		WebElement sme = driver
				.findElement(By.xpath("//span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", sme);
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		
		/*
		 * driver.findElement(By.xpath(
		 * "/html/body/div[2]/form/span[1]/span/div[5]/div[1]/div[2]/div[1]/div[2]/span[2]/div[1]/div/button[4]/span[1]"
		 * )) .click(); driver.switchTo().frame("add_or_remove_multiple_iframe");
		 * System.out.println("Iframe"); Select options = new
		 * Select(driver.findElement(By.xpath("//select[@id='select_0']")));
		 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 * options.selectByVisibleText("AL SME6"); WebElement fwd =
		 * driver.findElement(By.xpath("//*[@id='add_to_collection_button']"));
		 * System.out.println("fwd::" + fwd.getText());
		 * js.executeScript("arguments[0].click()", fwd); WebElement save =
		 * driver.findElement(By.xpath("//*[@id='select_0_sysverb_save']"));
		 * System.out.println("Documents::" + save.getText());
		 * js.executeScript("arguments[0].click()", save);
		 * driver.switchTo().defaultContent(); driver.switchTo().frame("gsft_main");
		 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 */

		WebElement markQC = driver.findElement(By.xpath("//button[text()='Mark For QC'][1]"));
		markQC.click();
		driver.findElement(By.xpath("//div[2]/div[1]/span[1]/span/span[2]")).click();
		WebElement smes=driver.findElement(By.xpath("//div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", smes);
		WebElement question = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_analyst_question_to_cs_and_sme.alc_question']"));
		question.sendKeys("Testing01");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		summaryTask = driver
				.findElement(By.xpath("//div[10]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", summaryTask);
		WebElement csReview = driver.findElement(
				By.xpath("//*[@id='label.ni.x_aukms_accenture_fra_summary_creation.alc_client_sponsor_review']"));
		csReview.click();
		markQC = driver.findElement(By.xpath("//button[text()='Mark For QC'][1]"));
		markQC.click();

	}
}
