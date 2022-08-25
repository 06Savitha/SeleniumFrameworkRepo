package ALCore;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.awaitility.Awaitility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PortalValidation extends CaseCreation {

	public PortalValidation(WebDriver driver) {
		this.driver = driver;
	}

	public void calUserLogin() throws InterruptedException, IOException {
		WebElement userNameC = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("find element");
		FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
		prop.load(in);
		usernameC = prop.getProperty("userNameC");
		System.out.println("userNameC..." + usernameC);
		userNameC.sendKeys(usernameC);
		password = prop.getProperty("password");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.xpath("//form/div/div[2]/button"));
		login.click();
	}
	public void smeUserLogin() throws InterruptedException, IOException {
		WebElement userNameS = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("find element");
		FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
		prop.load(in);
		usernameC = prop.getProperty("userNameS");
		System.out.println("userNameS..." + usernameS);
		userNameS.sendKeys(usernameS);
		password = prop.getProperty("password");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.xpath("//form/div/div[2]/button"));
		login.click();
	}

	public void initiateKYC() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement initatekyc = driver
				.findElement(By.xpath("//div[3]/div/sp-page-row[1]/div/div[1]/span/div/div/a/div[2]"));
		js.executeScript("arguments[0].click()", initatekyc);
		WebElement kycNumber = driver.findElement(By.xpath("//div//div[2]/table/tbody/tr[1]/td[2]"));
		kycNumber.click();
		WebElement removeDelegate = driver.findElement(By.xpath("//span[2]/div/div[1]/div/div[2]/div/button[2]"));
		js.executeScript("arguments[0].click()", removeDelegate);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement delegateButn = driver.findElement(By.xpath("//div/div/span[2]/div/div[1]/div/div[2]/button[2]"));
		delegateButn.click();
		WebElement search = driver.findElement(By.xpath("//div/div[1]/div/div[2]/div/div/div/a"));
		search.click();
		WebElement dropdown = driver.findElement(By.xpath("/html/body/div[3]/ul"));
		dropdown.click();
		dropdown.findElement(By.xpath("/html/body/div[3]/ul/li[5]/div")).click();
		WebElement assignButn = driver.findElement(By.xpath("//span[2]/div/div[1]/div/div[2]/div/button[1]"));
		js.executeScript("arguments[0].click()", assignButn);
		WebElement initateKycButn = driver.findElement(By.xpath("//span[2]/div/div[1]/div/div[2]/button[1]"));
		initateKycButn.click();
		

		try {
			Thread.sleep(60000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(10)).withMessage("Fluentwait::")
					.ignoring(NoSuchElementException.class);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]/table/tbody/tr[2]/td[1]/input")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement count = driver.findElement(By.xpath("//div/div/span/div/div/div[6]/nav/ul/li[3]/a"));
		String actualCount = count.getText();
		if (actualCount.equalsIgnoreCase("1")) {
			System.out.println("after wait::");
				js.executeScript("window.scrollBy(0,1000)");
				WebElement selection = driver.findElement(By.xpath("//div[6]/table/tbody/tr[2]/td[1]/input"));
				js.executeScript("arguments[0].click()", selection);
				WebElement comments = driver.findElement(By.xpath("//div/span/div/div/div[7]/div/textarea"));
				comments.sendKeys("Success Discrepancy Comments");
				WebElement continueButn = driver.findElement(By.xpath("//div/span/div/div/div[8]/button"));
				js.executeScript("arguments[0].click()", continueButn);
				js.executeScript("window.scrollBy(0,1000)");
				initiateKYCForm();
			
		} else {
			js.executeScript("window.scrollBy(0,1000)");
			WebElement comments = driver.findElement(By.xpath("//div/span/div/div/div[7]/div/textarea"));
			comments.sendKeys("Discrepancy Comments");
			WebElement continueButn = driver.findElement(By.xpath("//div/span/div/div/div[8]/button"));
			js.executeScript("arguments[0].click()", continueButn);
			js.executeScript("window.scrollBy(0,1000)");
			WebElement fullLegalName = driver.findElement(By.xpath("//form/div/div[1]/div/div[1]/div[1]/input"));
			fullLegalName.sendKeys("TATA Motors");
			initiateKYCForm();
		}
	}
	public void requestTPA() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement initatekyc = driver
				.findElement(By.xpath("//div[3]/div/sp-page-row[1]/div/div[1]/span/div/div/a/div[2]"));
		js.executeScript("arguments[0].click()", initatekyc);
		WebElement myCases=driver.findElement(By.xpath("//div[1]/div/sp-page-row/div/div/span[3]/div/div/form/div[1]/ul/li[1]/a"));
		myCases.click();
		WebElement kycNumber = driver.findElement(By.xpath("//div/div[1]/table/tbody/tr[1]/td[2]/span"));
		kycNumber.click();
		WebElement requestTPAButn=driver.findElement(By.xpath("//span[2]/div/div/div[1]/div[2]/button[1]"));
		requestTPAButn.click();
		WebElement checkBox=driver.findElement(By.xpath("//div/div/div[3]/div/div[1]/span/input"));
		checkBox.click();
		WebElement submit=driver.findElement(By.xpath("//span/div/div/div[3]/div/div[3]/button"));
		submit.click();
		alertMethod();
	}

	public void initiateKYCForm() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Random rand = new Random();
		js.executeScript("window.scrollBy(0,1000)");
		WebElement incorporated = driver.findElement(By.xpath("//*[@name='client_registered']"));
		Select dropDownList = new Select(incorporated);
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

		WebElement clientBusiness = driver.findElement(By.xpath("//*[@name='client_business']"));
		dropDownList = new Select(clientBusiness);
		select = dropDownList.getOptions();
		System.out.println("Select::" + select);
		index = 0;
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {
			System.out.println("Error Messga....");
		}
		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}

		WebElement corporateStructure = driver.findElement(By.xpath("//*[@name='corporate_structure']"));
		dropDownList = new Select(corporateStructure);
		select = dropDownList.getOptions();
		System.out.println("Select::" + select);
		index = 0;
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {
			System.out.println("Error Messga....");
		}
		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}

		WebElement mainIndustry = driver.findElement(By.xpath("//*[@name='main_industry']"));
		dropDownList = new Select(mainIndustry);
		select = dropDownList.getOptions();
		System.out.println("Select::" + select);
		index = 0;
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {
			System.out.println("Error Messga....");
		}
		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}

		Select clientPrincipleCountry = new Select(driver.findElement(By.xpath("//select[@name='client_principle_country']")));
		clientPrincipleCountry.selectByVisibleText("No");

		Select clientCriminal = new Select(driver.findElement(By.xpath("//select[@name='client_crimina']")));
		clientCriminal.selectByVisibleText("No");

		Select clientContracts = new Select(driver.findElement(By.xpath("//select[@name='client_contracts']")));
		clientContracts.selectByVisibleText("No");

		WebElement clientAccenture = driver.findElement(By.xpath("//*[@name='client_accenture']"));
		dropDownList = new Select(clientAccenture);
		select = dropDownList.getOptions();
		System.out.println("Select::" + select);
		index = 0;
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {
			System.out.println("Error Messga....");
		}
		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}
		String clientAcc = dropDownList.getFirstSelectedOption().getText();
		if (clientAcc.equalsIgnoreCase("Yes")) {
			WebElement thirdPN = driver.findElement(By.xpath("//*[@name='third_party_name']"));
			thirdPN.sendKeys("Testing@123");
			WebElement clientBusiness1 = driver.findElement(By.xpath(
					"//div[6]/form/div/div[3]/div/div[2]/div[7]/div//*[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']"));
			dropDownList = new Select(clientBusiness1);
			select = dropDownList.getOptions();
			System.out.println("Select::" + select);
			index = 0;
			if (select.size() > 1) {
				index = rand.nextInt(select.size() - 1);
			} else if (select.size() < 1) {
				System.out.println("Error Messga....");
			}
			dropDownList.selectByIndex(index);
			if (index == 0) {
				dropDownList.selectByIndex(1);
			}

		}

		WebElement servicesAccenture = driver.findElement(By.xpath("//*[@name='services_accenture']"));
		dropDownList = new Select(servicesAccenture);
		select = dropDownList.getOptions();
		System.out.println("Select::" + select);
		index = 0;
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {
			System.out.println("Error Messga....");
		}
		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}
		String serviceAcc = dropDownList.getFirstSelectedOption().getText();
		if (serviceAcc.equalsIgnoreCase("Yes")) {
			WebElement thirdPN = driver
					.findElement(By.xpath("//div[6]/form/div/div[3]/div/div[2]/div[11]/div[1]/input"));
			thirdPN.sendKeys("Testing@1234567890");
			WebElement clientBusiness1 = driver.findElement(By.xpath(
					"//div[6]/form/div/div[3]/div/div[2]/div[11]/div[2]/div//*[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']"));
			dropDownList = new Select(clientBusiness1);
			select = dropDownList.getOptions();
			System.out.println("Select::" + select);
			index = 0;
			if (select.size() > 1) {
				index = rand.nextInt(select.size() - 1);
			} else if (select.size() < 1) {
				System.out.println("Error Messga....");
			}
			dropDownList.selectByIndex(index);
			if (index == 0) {
				dropDownList.selectByIndex(1);
			}

			WebElement submit = driver.findElement(By.xpath("//div/span/div/div[6]/form/div/div[4]/button"));
			js.executeScript("arguments[0].click()", submit);
			WebElement close = driver.findElement(By.xpath("//div[6]/div/div/div[1]/button/span/img"));
			js.executeScript("arguments[0].click()", close);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement user = driver.findElement(By.xpath("//div/nav/div[3]/ul[2]/li[1]/a/span[1]/div/div/div"));
			js.executeScript("arguments[0].click()", user);
			WebElement logout = driver.findElement(By.xpath("//nav/div[3]/ul[2]/li[1]/ul/li[2]/a/span"));
			js.executeScript("arguments[0].click()", logout);
			/*
			 * WebElement
			 * successMsg=driver.findElement(By.xpath("//*[@id=\"successInfo\"]/div/div"));
			 * String actualsuccessMsg=successMsg.getText();
			 * System.out.println("actualsuccessMsg::"+actualsuccessMsg);
			 */

		}
	}

	public void alertMethod() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println("alert::"+alert.getText());
			alert.accept();
			Assert.assertTrue(alert.getText().contains("OK"));
		} catch (Exception e) {
			// exception handling
		}
}
}
