package ALCore;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import config.PropertiesFile;

public class CaseCreation {
	// WebDriver driver =null;
	public static String answer = null;
	public static String assignedTo = null;

	public static String accountFCName = null;
	public static String browserName = null;
	public static String contractingDetails = null;
	public static String comments = null;
	public static String url = null;
	public static String username = null;
	public static String usernameC = null;
	public static String usernameE = null;
	public static String usernameO = null;
	public static String usernameQ = null;
	public static String usernameA = null;
	public static String usernameB = null;
	public static String usernameS = null;
	public static String usernameT = null;
	public static String password = null;
	public static String portalUrl = null;
	public static String thirdPartName = null;
	public static String thirdPartyAddress = null;
	public static String thirdPartyContact = null;
	public static String workNotes = null;
	public WebDriver driver;
	public WebDriver childdriver;
	public static String favorite = "//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]";
	Properties prop = new Properties();
	String Projectpath = System.getProperty("user.dir");
	String mainWindow;
	String childWindow;

	// 61. Verify that the al.team_lead user is able to login 02Test instance

	@BeforeClass
	public void loginSetup() throws InterruptedException {
		String Projectpath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		System.out.println("check");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Projectpath + "\\Drivers\\chromedriver1\\chromedriver.exe");
			System.out.println("path...::" + Projectpath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			// driver.manage().window().setPosition(new Point(0, -100000)); -> Minimize a
			// browser
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Login Page
			url = PropertiesFile.getUrl();
			portalUrl = PropertiesFile.getPortalUrl();
			driver.get(url);
			mainWindow = driver.getWindowHandle();
			System.out.println("mainWindow::" + mainWindow);
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

		}
	}

	/*
	 * @DataProvider(name = "testData") public Object[][] tData() { return new
	 * Object[][] { { "cts", "687676" }, {"tata","68436"}};
	 * 
	 * }
	 */

	// 1. Verify that the user is able to navigate to the Accenture Legal Cores
	// 2. Verify that the user is able to see New button
	// 3. Verify that the user is able to click on New button
	// 4. Verify that the user is able to enter mandatory fields in Case Initiation
	// 5. Verify that the user is able to enter mandatory fields in Initial Risk
	// 6. Verify that the user is able to create new case in accenture legal core
	// 8. Verify that the user is able to navigate allocation task
	// 9. Verify that the user is able to change the state as In Progress to
	// Complete
	// 62. Verify that the user is able to allow the TPA request

	// @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "fcData",priority
	// = 0, enabled = true, description = "NewCaseCreation")
	@Test(priority = 0, enabled = true, description = "NewCaseCreationAndCaseInitiation")
	public void NewCaseCreationAndCaseInitiation() throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		PortalValidation portal = new PortalValidation(driver);
		TeamLead tl = new TeamLead(driver);
		// portal.calUserLogin();
		// portal.initiateKYC();
		System.out.println("favorite::");

		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement aLCore = driver
				.findElement(By.xpath("//div/magellan-favorites-list/ul/li[2]/div/ul/li[6]/div/a/div[2]/div"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		Random rand = new Random();
		WebElement newCase = driver.findElement(By.xpath("//button[@type='submit' and @value='sysverb_new']"));
		String expectedNewButn = newCase.getText();
		System.out.println("New Button::" + expectedNewButn);
		String actaulNewButn = "New";
		assertEquals(actaulNewButn, expectedNewButn);
		newCase.click();
		/*
		 * // Upload document in Main stage
		 * 
		 * driver.findElement(By.cssSelector("#header_add_attachment")).click();
		 * WebElement uploadFile = driver.findElement(By.cssSelector("#attachFile"));
		 * System.out.println("upload document");
		 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 * uploadFile.sendKeys(getFile1()); Assert.assertTrue(true,
		 * "document uploaded successfully"); WebElement close =
		 * driver.findElement(By.cssSelector("#attachment_closemodal"));
		 * action.moveToElement(close).click().perform();
		 * System.out.println("After click");
		 */
		// qc.sessionExpire();

		// Contact tab
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement contact = driver.findElement(By.xpath("//span[2]/span[1]/span[2]"));
		contact.click();
		/*
		 * WebElement kycAnalyst = driver .findElement(By.xpath(
		 * "//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.assigned_to']"
		 * )); kycAnalyst.sendKeys("AL_Test Analyst");
		 */
		WebElement qualityChecker = driver
				.findElement(By.xpath("//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.qc']"));
		qualityChecker.sendKeys("Quality checker");
		WebElement ClientSponsor = driver.findElement(
				By.xpath("//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.outreach_contact']"));
		ClientSponsor.sendKeys("AL CAL");
		WebElement ClientSponsorDelegate = driver
				.findElement(By.xpath("//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.delegate']"));
		ClientSponsorDelegate.sendKeys("AL SME");

		// Info tab
		WebElement caseInfo = driver.findElement(By.xpath("//span[normalize-space()='Case Initiation Info']"));
		caseInfo.click();
		FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
		prop.load(in);
		accountFCName = prop.getProperty("accountFCName");
		WebElement aFCName = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_legal_core.account_fc_name']"));
		aFCName.sendKeys(accountFCName);
		int randomInt = rand.nextInt(100000);
		WebElement aFCNumber = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_legal_core.account_fc_number']"));
		aFCNumber.sendKeys("0" + randomInt);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement aFCCountry = driver.findElement(
				By.xpath("//*[@name='sys_select.x_aukms_accenture_accenture_legal_core.account_fc_countries']"));
		Select dropDownList = new Select(aFCCountry);
		List<WebElement> select = dropDownList.getOptions();
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
		WebElement companyCode = driver.findElement(
				By.xpath("//*[@name='sys_select.x_aukms_accenture_accenture_legal_core.regulated_company_code']"));
		dropDownList = new Select(companyCode);
		select = dropDownList.getOptions();
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
		// Assessment tabs
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement initialRisk = driver.findElement(By.xpath("//span[normalize-space()='Initial Risk Assessment']"));
		initialRisk.click();
		WebElement inCorporation = driver.findElement(
				By.xpath("//*[@name='sys_select.x_aukms_accenture_accenture_legal_core.country_of_incorporations']"));
		dropDownList = new Select(inCorporation);
		select = dropDownList.getOptions();
		index = 0;
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {
			System.out.println("Error Messga index...." + index);
		}
		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement countryOfBusiness = driver.findElement(
				By.xpath("//*[@name='sys_select.x_aukms_accenture_accenture_legal_core.client_country_of_business']"));
		dropDownList = new Select(countryOfBusiness);
		select = dropDownList.getOptions();
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement corporateStructure = driver.findElement(
				By.xpath("//*[@name='sys_select.x_aukms_accenture_accenture_legal_core.corporate_structures']"));
		dropDownList = new Select(corporateStructure);
		select = dropDownList.getOptions();
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		WebElement mainIndustry = driver
				.findElement(By.xpath("//*[@name='sys_select.x_aukms_accenture_accenture_legal_core.main_industrys']"));
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

		// Opportunity Info
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement oppprtunityInfo = driver.findElement(By.xpath("//div[1]/span[5]/span[1]/span[2]"));
		js.executeScript("arguments[0].click()", oppprtunityInfo);
		WebElement opportunityId = driver
				.findElement(By.xpath("/html/body/div[2]/form/span[6]/span/div/div/div[1]/div[1]/div[2]/input"));
		opportunityId.sendKeys("0" + randomInt);
		WebElement opportunityStage = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_legal_core.opportunity_stage']"));
		dropDownList = new Select(opportunityStage);
		select = dropDownList.getOptions();
		System.out.println("Select::" + select);
		index = 0;
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else {
			System.out.println("Error Messga....");
		}

		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}

		WebElement opportunityDirector = driver.findElement(
				By.xpath("//*[@name='lookup.x_aukms_accenture_accenture_legal_core.opportunity_director']"));
		opportunityDirector.click();
		System.out.println("assigned to::");

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));

		driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div/table/tbody/tr[11]/td[3]/a")).click();
		System.out.println("Child window::");
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		WebElement serviceGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.service_group_unlock']"));
		serviceGroup.click();
		WebElement lookup = driver
				.findElement(By.xpath("//*[@name='lookup.x_aukms_accenture_accenture_legal_core.service_group']"));
		lookup.click();
		windowHandles = driver.getWindowHandles();
		windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("//div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")).click();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");

		WebElement subServiceGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.sub_service_group_unlock']"));
		subServiceGroup.click();
		lookup = driver
				.findElement(By.xpath("//*[@name='lookup.x_aukms_accenture_accenture_legal_core.sub_service_group']"));
		js.executeScript("arguments[0].click()", lookup);
		windowHandles = driver.getWindowHandles();
		windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("//div/div[5]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a")).click();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		WebElement kycFQuestions = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_legal_core.kyc_core_finance_question']"));
		dropDownList = new Select(kycFQuestions);
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

		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		System.out.println("modifiedDate::" + modifiedDate);
		WebElement expectedSigningDate = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_legal_core.close_date']"));
		expectedSigningDate.sendKeys(modifiedDate);
		driver.findElement(By.xpath("//button[@type='submit' and @onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		contact = driver.findElement(By.xpath("//span[2]/span[1]/span[2]"));
		contact.click();
		ClientSponsorDelegate = driver
				.findElement(By.xpath("//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.delegate']"));
		String smeUser = ClientSponsorDelegate.getText();
		if (!(smeUser.equalsIgnoreCase("AL SME"))) {
			ClientSponsorDelegate.clear();
			ClientSponsorDelegate.sendKeys("AL SME");
			driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
			driver.findElement(By.xpath("//div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")).click();
		}
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(portalUrl);
		System.out.println("new Window" + driver.getTitle());
		windowHandles = driver.getWindowHandles();
		windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println("before allocation::");
		portal.calUserLogin();
		portal.initiateKYC();
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tl.Allocation();
	}

	// 7. Verify that the below field are read only modeCase Data ,Contact , Case
	// 10. Verify that the user is able to navigate ID&V task
	// 11. Verify that the user is able to change the state as In Progress to QC
	// Ready
	// 12. Verify that the user is able to Modify the Type of Due Diligence value
	// under ID&V task
	@Test(priority = 1, enabled = true, description = "IDVTaskCreationAndEscalationTaskTrigger")
	public void IDVTaskCreationAndEscalationTaskTrigger() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		Random rand = new Random();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[4]/span/span[2]")).click();
		WebElement sort = driver.findElement(By
				.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/thead/tr[1]/th[3]/span/i"));
		sort.click();
		WebElement az = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]"));
		js.executeScript("arguments[0].click()", az);
		System.out.println("Short Description::");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Accenture Information
		WebElement iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		System.out.println("ID&V..." + iDVTask);
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		WebElement clientIdentified = driver.findElement(
				By.xpath("//*[@name='x_aukms_accenture_accenture_id_v_tasks.client_identified_as_bi_bda']"));
		Select dropDownList = new Select(clientIdentified);
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
		WebElement uboIdentified = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_id_v_tasks.ubo_identified_as_bi_bda']"));
		dropDownList = new Select(uboIdentified);
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
		WebElement keyExecutivesIdentified = driver.findElement(
				By.xpath("//*[@name='x_aukms_accenture_accenture_id_v_tasks.key_executives_identified_as_bi_bda']"));
		dropDownList = new Select(keyExecutivesIdentified);
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
		WebElement ap966Status = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_id_v_tasks.ap966_status']"));
		dropDownList = new Select(ap966Status);
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
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Address & Registration

		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		Thread.sleep(10000);
		WebElement mandatory = driver.findElement(By.xpath("//div[1]/span/div[2]/div[4]//tr[1]/td[7]"));
		String option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[5]"));
		String value = attributeValue.getText();
		System.out.println("value::" + value + "::");
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//tr/td[2]/h1/label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver.findElement(By
				.xpath("//div[2]/div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver.findElement(By.xpath("//div[1]/span/div[2]/div[4]//tr[3]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver.findElement(By.xpath("//div[1]/span/div[2]/div[4]//tr[4]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver.findElement(By.xpath("//div[1]/span/div[2]/div[4]//tr[5]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver.findElement(By.xpath("//div[1]/span/div[2]/div[4]//tr[6]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver.findElement(By.xpath("//div[1]/span/div[2]/div[4]//tr[7]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver.findElement(By.xpath("//div[1]/span/div[2]/div[4]//tr[8]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver.findElement(By.xpath("//div[1]/span/div[2]/div[4]//tr[9]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[9]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement parent = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_id_v_tasks.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement taskType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.alc_task_type']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement outreach = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.outreach']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		Thread.sleep(20000);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();

		// Listing & Regulation
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[5]"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[9]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[9]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[10]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[10]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[11]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[11]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[12]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[12]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[13]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[13]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[14]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[14]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[15]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[15]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[16]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[16]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[17]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[17]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_id_v_tasks.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		taskType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.alc_task_type']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		outreach = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.outreach']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		Thread.sleep(20000);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		// Ownership & Key Executives
		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		// Individual Owners
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div[1]/span[2]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[2]/span/div[2]/div[1]/div/div[1]/button[2]")).click();
		WebElement legalName = driver.findElement(By.xpath("//*[@name='x_aukms_accenture_individual.legal_names']"));
		legalName.sendKeys("Donald Trump");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		// Non Individual Owners
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div[1]/span[4]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[4]/span/div[2]/div[1]/div/div[1]/button[2]")).click();
		legalName = driver.findElement(By.xpath("//*[@name='x_aukms_accenture_non_individual.legal_names']"));
		legalName.sendKeys("Jio");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		// Key Executives
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div[1]/span[6]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[6]/span/div[2]/div[1]/div/div[1]/button[2]")).click();
		legalName = driver.findElement(By.xpath("//*[@name='x_aukms_accenture_key_executives.legal_names']"));
		legalName.sendKeys("Barack Obama");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Nature of Business
		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mandatory = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[9]/td[7]"));
		option = mandatory.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		attributeValue = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[9]/td[5]"));
		value = attributeValue.getText();
		if (option.equalsIgnoreCase("Yes")) {
			if (value.equalsIgnoreCase("")) {
				action.doubleClick(attributeValue).perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement text = driver.findElement(By.xpath("//div[2]/div[4]//label/div/textarea"));
				text.sendKeys("No");
				WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
				js.executeScript("arguments[0].click()", ok);
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_id_v_tasks.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		taskType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.alc_task_type']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		outreach = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_id_v_tasks.outreach']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		Thread.sleep(20000);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();

		// Validated Type of Due Diligence
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		WebElement dueDiligence = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		dueDiligence.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement attributeField = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_legal_attributes.value']"));
		String attriValue = attributeField.getText();
		System.out.println("attributeValue:" + attriValue);
		if (attriValue.equalsIgnoreCase("CDD") || attriValue.equalsIgnoreCase("SDD")) {
			attributeField.clear();
			attributeField.sendKeys("EDD");
		}
		if (attriValue.equalsIgnoreCase("SDD") || attriValue.equalsIgnoreCase("EDD")) {
			attributeField.clear();
			attributeField.sendKeys("CDD");
		}
		if (attriValue.equals("EDD") || attriValue.equalsIgnoreCase("CDD")) {
			attributeField.clear();
			attributeField.sendKeys("SDD");
		}
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();

	}

	// 13. Verify that the escalation task is generated under Escalation Task Tab
	// 14. Verify that the escalation user is able to navigate to the Escalation
	// task
	// 15. Verify that the user is able to complete the Escalation task
	// 20. Verify that the escalation user is able to complete the rejected
	// Escalation task
	// 16. Verify that the Escalation task is read only mode
	// 17. The user should be able to see Accept and Re-escalate button in ID&V task
	// 18. Verify that the user is able to Re-escalate the task
	// 19. Verify that the user is able to see User Rejected the escalation response
	// message under Activity Logs
	@Test(priority = 2, enabled = true, description = "IDVEscalationReEscalateAndAccept")
	public void IDVEscalationReEscalateAndAccept() throws InterruptedException, IOException {
		EscalationTask esc = new EscalationTask(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		TeamLead tl = new TeamLead(driver);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("new Window" + driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		esc.ecalationUserLogin();
		esc.ecalationUserReject();
		System.out.println("main Window" + driver.getTitle() + "Main ::" + mainWindow);
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		WebElement iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement dueDiligence = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		dueDiligence.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement attributeField = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_accenture_legal_attributes.value']"));
		String attriValue = attributeField.getText();
		System.out.println("attributeValue:" + attriValue);
		if (attriValue.equalsIgnoreCase("CDD") || attriValue.equalsIgnoreCase("SDD")) {
			attributeField.clear();
			attributeField.sendKeys("EDD");
		}
		if (attriValue.equalsIgnoreCase("SDD") || attriValue.equalsIgnoreCase("EDD")) {
			attributeField.clear();
			attributeField.sendKeys("CDD");
		}
		if (attriValue.equals("EDD") || attriValue.equalsIgnoreCase("CDD")) {
			attributeField.clear();
			attributeField.sendKeys("SDD");
		}
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		WebElement user = driver.findElement(By.xpath("//div/div/header/div[1]/div/div[2]/div/div[2]/div/button"));
		user.click();
		WebElement logout = driver
				.findElement(By.xpath("//div/div/header/div[1]/div/div[2]/div/div[2]/div/ul/li[2]/a"));
		logout.click();
		esc.sessionExpire();
		driver.switchTo().window(windowHandlesList.get(1));
		driver.switchTo().frame("gsft_main");
		esc.ecalationUserApprove();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window(windowHandlesList.get(0));
		esc.analystUserLogin();
		esc.analystUserReEscalate();
		driver.switchTo().window(windowHandlesList.get(1));
		driver.switchTo().frame("gsft_main");
		esc.ecalationUserApprove();
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		esc.analystUserAccept();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		user = driver.findElement(By.xpath("//div/div/header/div[1]/div/div[2]/div/div[2]/div/button"));
		user.click();
		logout = driver.findElement(By.xpath("//div/div/header/div[1]/div/div[2]/div/div[2]/div/ul/li[2]/a"));
		logout.click();
		esc.sessionExpire();
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tl.TeamLeadLogin();

	}

	// 63. Verify that the Request TPA button is visible for al_cal user
	// 64. Verify that the user is able navigate to Temporary Pre Approval page
	// 65. Verify that the user is able to submit the TPA request with
	// acknowledgement
	// 66. Verify that the al test analyst user is able to see Update, Escalate and
	// Send to AML CO buttons under TPA
	// 67. Verify that the user is able to send the TPA request to aml co with
	// mandatory checkbox
	// 68. Verify that the user is able to Approve the TPA request with
	// acknowledgement
	// 69. Verify that the user is able to Reject the TPA request with
	// acknowledgement
	// 70. Verify that the user is able to escalate the TPA request with mandatory
	// checkbox
	// 71. The user is able to be navigate to Additional Escalation page
	// 72. Verify that the al team lead user is able to approve the additional
	// escalation task

	@Test(priority = 3, enabled = true, description = "screeningTaskTiggerAndTpaRequestViaPortal")
	public void screeningTaskTiggerAndTpaRequestViaPortal() throws InterruptedException, IOException {
		ScreeningAndSummaryreation screeingAndsummary = new ScreeningAndSummaryreation(driver);
		AMLCOAndCOELead lead = new AMLCOAndCOELead(driver);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		PortalValidation portal = new PortalValidation(driver);
		screeingAndsummary.screeingTaskTrigger();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(portalUrl);
		System.out.println("new Window" + driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
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
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		portal.requestTPA();
		portal.alertMethod();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement user = driver.findElement(By.xpath("//div/nav/div[3]/ul[2]/li[1]/a/span[1]/div/div/div"));
		js.executeScript("arguments[0].click()", user);
		WebElement logout = driver.findElement(By.xpath("//nav/div[3]/ul[2]/li[1]/ul/li[2]/a/span"));
		js.executeScript("arguments[0].click()", logout);
		driver.close();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window(windowHandlesList.get(0));
	}

	// 22. Verify that the user is able to change the state as QC Ready in Next
	// Review Stage Task
	// 23. Verify that the user is able to change the Next State as Screening
	// 24. Verify that the screening task is generated under Screening Task Tab
	// 25. Verify that the al test analyst user is able to navigate to the Screenig
	// task
	// 26. Verify that the user is able to change the state as QC Ready
	// 27. Verify that the user is able to change the Next State as FRA Summary
	// under Screening task
	// 28. Verify that the Screening task fields are read only mode under Screening
	// 29. Verify that the user is able to see FRA Task is Generated messages
	// 30. Verify that the FRA task is generated under FRA Summary Creation Task Tab
	// 31. Verify that the al test analyst user is able to navigate to the FRA task
	// 32. Verify that the user is able to click on Mark QC button under FRA Summary
	// Creation
	// 33. Verify that the user is able to see QC Task is Generated message
	// 73. Verify that the user is able to enter the question under Question field
	// 74. Verify that the user is able to enable the Client Sponsor Review

	@Test(priority = 4, enabled = true, description = "ScreeningTaskAndSanctionEscalations")
	public void ScreeningTaskAndSanctionEscalations() throws InterruptedException, IOException {
		ScreeningAndSummaryreation screeingAndsummary = new ScreeningAndSummaryreation(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		TeamLead tl = new TeamLead(driver);
		ReviewTask review = new ReviewTask(driver);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[4]/span/span[2]")).click();
		WebElement iDVTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td[3]/a"));
		js.executeScript("arguments[0].click()", iDVTask);
		WebElement ValidateTypeofDueDiligence = driver
				.findElement(By.xpath("//div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[5]"));
		String validateTypeofDD = ValidateTypeofDueDiligence.getText();
		System.out.println("TypeOfDD::" + validateTypeofDD);
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();

		screeingAndsummary.screeingOwnersKEsClientTask();

		WebElement fraResult = driver.findElement(By
				.xpath("//div[2]/div[2]/div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[6]"));
		String fra = fraResult.getText();
		System.out.println("FRA::" + fra);
		if (validateTypeofDD.equalsIgnoreCase("SDD") && fra.equalsIgnoreCase("High")) {
			tl.ReopenedIDVTasks();

		} else if (validateTypeofDD.equalsIgnoreCase("SDD") && fra.equalsIgnoreCase("Medium")) {
			tl.ReopenedIDVTasks();
		} else if (validateTypeofDD.equalsIgnoreCase("CDD") && fra.equalsIgnoreCase("High")) {
			tl.ReopenedIDVTasks();
		} else {
			assertTrue(true);
		}

		WebElement screenTask = driver.findElement(
				By.xpath("//div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", screenTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div[1]/span[2]/span/span[2]")).click();
		WebElement sanctionNonIndOwners = driver
				.findElement(By.xpath("//div/div[2]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[7]"));
		String sanctionStatusNonInd = sanctionNonIndOwners.getText();
		System.out.println("sanctionStatus::" + sanctionStatusNonInd);
		driver.findElement(By.xpath("//div[2]/div[1]/span[3]/span/span[2]")).click();
		WebElement sanctionKeyExecutive = driver.findElement(
				By.xpath("//div[2]/div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[7]"));
		String sanctionStatusKey = sanctionKeyExecutive.getText();
		System.out.println("sanctionStatus::" + sanctionStatusKey);
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();

		if (sanctionStatusNonInd.equalsIgnoreCase("true") || sanctionStatusKey.equalsIgnoreCase("true")) {
			WebElement screeningResultsPreview = driver.findElement(
					By.xpath("//div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			screeningResultsPreview.click();
			Select state = new Select(
					driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.state']")));
			System.out.println("State..." + state);
			state.selectByVisibleText("QC Ready");
			Select NextState = new Select(
					driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.next_state']")));
			System.out.println("State..." + NextState);
			NextState.selectByVisibleText("Sanction Escalation");
			driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			tl.screenSanctionEscalations();

		} else {

			WebElement screeningResultsPreview = driver.findElement(
					By.xpath("//div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
			screeningResultsPreview.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement overallPEP = driver
					.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.overall_pep_risk']"));
			Assert.assertTrue(overallPEP.getAttribute("readOnly").equals("true"), "Element ReadOnly");
			WebElement overallReputation = driver
					.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_screening_tasks.overall_reputation_risk']"));
			Assert.assertTrue(overallReputation.getAttribute("readOnly").equals("true"), "Element ReadOnly");
			Select state = new Select(
					driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.state']")));
			System.out.println("State..." + state);
			state.selectByVisibleText("QC Ready");
			Select NextState = new Select(
					driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.next_state']")));
			System.out.println("State..." + NextState);
			NextState.selectByVisibleText("Summary");
		}
	}

	@Test(priority = 5, enabled = true, description = "SummaryTaskAndReviewsSelect")

	public void SummaryTaskAndReviewsSelect() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		TeamLead tl = new TeamLead(driver);
		ReviewTask review = new ReviewTask(driver);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[6]/span/span[2]")).click();
		WebElement fraResult = driver.findElement(By
				.xpath("//div[2]/div[2]/div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[6]"));
		String fra = fraResult.getText();
		System.out.println("FRA::" + fra);

		if (fra.equalsIgnoreCase("High") || fra.equalsIgnoreCase("Medium")) {
			review.SummaryCreationReview();
		}

		else {
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[10]/span/span[2]")).click();
			js.executeScript("window.scrollTo(2000,0)");
			WebElement summaryTask = driver
					.findElement(By.xpath("//div[10]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
			js.executeScript("arguments[0].click()", summaryTask);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement markQC = driver.findElement(By.xpath("//span/button[text()='Mark For QC'][1]"));
			markQC.click();
		}
	}

	// 63. Verify that the Request TPA button is visible for al_cal user
	// 64. Verify that the user is able navigate to Temporary Pre Approval page
	// 65. Verify that the user is able to submit the TPA request with
	// acknowledgement
	// 66. Verify that the al test analyst user is able to see Update, Escalate and
	// Send to AML CO buttons under TPA
	// 67. Verify that the user is able to send the TPA request to aml co with
	// mandatory checkbox
	// 68. Verify that the user is able to Approve the TPA request with
	// acknowledgement
	// 69. Verify that the user is able to Reject the TPA request with
	// acknowledgement
	// 70. Verify that the user is able to escalate the TPA request with mandatory
	// checkbox
	// 71. The user is able to be navigate to Additional Escalation page
	// 72. Verify that the al team lead user is able to approve the additional
	// escalation task

	@Test(priority = 7, enabled = false, description = "SanctionEscalations")
	public void SanctionEscalations() throws InterruptedException, IOException {
		AMLCOAndCOELead lead = new AMLCOAndCOELead(driver);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		PortalValidation portal = new PortalValidation(driver);
		TeamLead tl = new TeamLead(driver);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(portalUrl);
		System.out.println("new Window" + driver.getTitle());
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
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		portal.requestTPA();
		//portal.alertMethod();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement user = driver.findElement(By.xpath("//div/nav/div[3]/ul[2]/li[1]/a/span[1]/div/div/div"));
		js.executeScript("arguments[0].click()", user);
		WebElement logout = driver.findElement(By.xpath("//nav/div[3]/ul[2]/li[1]/ul/li[2]/a/span"));
		js.executeScript("arguments[0].click()", logout);
		// driver.findElement(By.xpath(
		// "/html/body/div[5]/div/div/nav/div/div[2]/div/div/a[3]")).click();
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement aLCore = driver.findElement(
				By.xpath("//div[@class='sn-widget-list-title ng-binding'][normalize-space()='Accenture Legal Cores']"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		WebElement openMainTask = driver
				.findElement(By.xpath("//div[1]/table[1]/tbody[1]/tr[1]//a[@class='linked formlink']"));
		openMainTask.click();
		WebElement requesttpa = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		requesttpa.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[5]/div/div/div[7]/div[2]/span/label")).click();
		driver.findElement(By.xpath("//span[1]/span/div[5]/div/div/div[8]/div[2]/span/label")).click();
		WebElement submit = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		submit.click();
		driver.findElement(By.xpath("//div[2]/div[1]/span[7]/span/span[2]")).click();
		WebElement tpatask = driver
				.findElement(By.xpath("//div/div[7]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", tpatask);
		WebElement updateButn = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		updateButn.click();
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().defaultContent();
		tl.TPAEscalateAndSendToAMLCO();
		WebElement escalte = driver.findElement(By.xpath("//button[contains(text(),'Escalate')]"));
		js.executeScript("arguments[0].click()", escalte);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("new Window" + driver.getTitle());
		tl.TeamLeadLogin();
		favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		aLCore = driver.findElement(
				By.xpath("//div[@class='sn-widget-list-title ng-binding'][normalize-space()='Accenture Legal Cores']"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a[@class='linked formlink']"))
				.click();
		WebElement Screen = driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[6]/span/span[2]"));
		js.executeScript("arguments[0].click()", Screen);
		WebElement fraResult = driver.findElement(By
				.xpath("//div[2]/div[2]/div/div[6]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[4]"));
		String resultValue = fraResult.getText();
		System.out.println("resultvalues::" + resultValue);
		driver.switchTo().defaultContent();
		WebElement addescalation = driver.findElement(By
				.xpath("//div/nav/div/div[3]/div/div/magellan-favorites-list/ul/li[3]/div/ul/li[2]/div/a/div[2]/div"));
		action.doubleClick(addescalation).perform();
		driver.switchTo().frame("gsft_main");
		WebElement escalateTask = driver
				.findElement(By.xpath("//div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", escalateTask);
		WebElement approve = driver.findElement(By.xpath("//button[contains(text(),'Approve')]"));
		approve.click();
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //
		favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		WebElement tparequest = driver.findElement(
				By.xpath("//div/div[3]/div/div/magellan-favorites-list/ul/li[2]/div/ul/li[3]/div/a/div[2]/div"));
		action.doubleClick(tparequest).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"))
				.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement sendtoamlco = driver.findElement(By.xpath("//*[@id='send_to_amlco']"));
		js.executeScript("arguments[0].click()", sendtoamlco);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("new Window" + driver.getTitle());
		lead.AMLCOLogin();
		favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		tparequest = driver.findElement(By
				.xpath("//div/nav/div/div[3]/div/div/magellan-favorites-list/ul/li[4]/div/ul/li[4]/div/a/div[2]/div"));
		action.doubleClick(tparequest).perform();
		driver.switchTo().frame("gsft_main");
		openMainTask = driver.findElement(By.xpath("//div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		openMainTask.click();
		approve = driver.findElement(By.xpath("//button[contains(text(),'Approve')]"));
		String approveButn = approve.getText();
		String actualButn = "Approve";
		assertEquals(actualButn, approveButn);
		WebElement reject = driver.findElement(By.xpath("//button[contains(text(),'Reject')]"));
		String rejectButn = reject.getText();
		actualButn = "Reject";
		assertEquals(actualButn, rejectButn);
		if (resultValue.equalsIgnoreCase("Low") || resultValue.equalsIgnoreCase("Medium")) {
			approve = driver.findElement(By.xpath("//button[contains(text(),'Approve')]"));
			js.executeScript("arguments[0].click()", approve);
		} else {
			reject = driver.findElement(By.xpath("//button[contains(text(),'Reject')]"));
			js.executeScript("arguments[0].click()", reject);
		}
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().defaultContent();
		favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		aLCore = driver.findElement(
				By.xpath("//div[@class='sn-widget-list-title ng-binding'][normalize-space()='Accenture Legal Cores']"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a[@class='linked formlink']"))
				.click();
	}
	// 34. Verify that the QC task fields are read only mode for al test analyst
	// 35. Verify that the QC task is generated under QC Task Tab
	// 36. Verify that the al qc user is able to navigate to the QC task
	// 37. Verify that the user is able to See Reject and Approve button under QC
	// task
	// 38. Verify that the user is able to select the ID&V task as Rejected phase
	// 39. Verify that the user is able to see ID&V Task has been Reopened for QC
	// rejection message
	// 40. Verify that the al test analyst user is able to see rejected phase task
	// state as In Progress under ID&V
	// 41. Verify that the user is able to change the state as QC ready under ID&V
	// 43. Verify that the user is able to see QC Task has been Reopened Message

	@Test(priority = 6, enabled = true, description = "IDVAndScreeningAndSummaryQCRejectPhaseAndApproveQCTask")
	public void IDVAndScreeningAndSummaryQCRejectPhaseAndApproveQCTask() throws InterruptedException, IOException {
		System.out.println("QCIDVRejectPhase::" + mainWindow);
		QCTask qc = new QCTask(driver);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("new Window" + driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		// qc.sessionExpire();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		WebElement userNameQ = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element.....");
		usernameQ = PropertiesFile.getUserNameQ();
		System.out.println("usernameQ..." + usernameQ);
		userNameQ.sendKeys(usernameQ);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPasswordQ();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
		// qc.sessionExpire();
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		Thread.sleep(2000);
		WebElement aLCore = driver.findElement(By
				.xpath("//div/nav/div/div[3]/div/div/magellan-favorites-list/ul/li[3]/div/ul/li[1]/div/a/div[2]/div"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[11]/span/span[2]")).click();
		WebElement qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div[1]/span[1]/span/span[2]")).click();
		WebElement attributevalue = driver.findElement(
				By.xpath("//div[2]/div/div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		attributevalue.click();
		Select approval = new Select(driver
				.findElement(By.xpath("//select[@id='x_aukms_accenture_accenture_legal_attributes.alc_approval']")));
		approval.selectByVisibleText("Fail");
		WebElement comments = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_attributes.comments']"));
		comments.sendKeys("Fail ID&V Task");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		Select rejectPhase = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_qc_task.rejection_task']")));
		System.out.println("State..." + rejectPhase);
		rejectPhase.selectByVisibleText("ID&V Task");
		WebElement reject = driver.findElement(By.xpath("//button[contains(text(),'Reject')]"));
		reject.click();
		System.out.println("main Window" + driver.getTitle() + "Main ::" + mainWindow);
		driver.switchTo().window(windowHandlesList.get(0));
		qc.IDVMarkComplete();
		driver.switchTo().window(windowHandlesList.get(1));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[11]/span/span[2]")).click();
		qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[1]/span/span[2]")).click();
		WebElement approvalField = driver
				.findElement(By.xpath("//div[1]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[5]"));
		action.doubleClick(approvalField).perform();
		Select value = new Select(driver.findElement(By.xpath("//select[@id='cell_edit_value']")));
		value.selectByVisibleText("Pass");
		WebElement ok = driver.findElement(By.xpath("//a[@id='cell_edit_ok']"));
		ok.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div[1]/span[3]/span/span[2]")).click();
		WebElement screenTask = driver.findElement(
				By.xpath("//div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		screenTask.click();
		Select state = new Select(
				driver.findElement(By.xpath("//select[@id='x_aukms_accenture_screening_tasks.state']")));
		state.selectByVisibleText("In Progress");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		rejectPhase = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_qc_task.rejection_task']")));
		System.out.println("State..." + rejectPhase);
		rejectPhase.selectByVisibleText("Screening Task");
		reject = driver.findElement(By.xpath("//button[contains(text(),'Reject')]"));
		reject.click();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		qc.ScreeningComplete();
		driver.switchTo().window(windowHandlesList.get(1));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[11]/span/span[2]")).click();
		qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[4]/span/span[2]")).click();
		WebElement summaryTask = driver.findElement(
				By.xpath("//div[2]/div/div[4]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		summaryTask.click();
		state = new Select(
				driver.findElement(By.xpath("//select[@id='x_aukms_accenture_fra_summary_creation.state']")));
		state.selectByVisibleText("In Progress");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		qcTask = driver
				.findElement(By.xpath("//div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		js.executeScript("arguments[0].click()", qcTask);
		rejectPhase = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_qc_task.rejection_task']")));
		System.out.println("State..." + rejectPhase);
		rejectPhase.selectByVisibleText("Summary Task");
		reject = driver.findElement(By.xpath("//button[contains(text(),'Reject')]"));
		reject.click();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		qc.FRAComplete();
		driver.switchTo().window(windowHandlesList.get(1));
		driver.switchTo().frame("gsft_main");
		qc.approveQCTasks();
		driver.switchTo().window(windowHandlesList.get(0));
	}

	// 44. Verify that the al qc user is able to change state as QC Ready to In
	// Progress under Screening
	// 45. Verify that the user is able to select the Screening task as Rejected
	// phase
	// 46. Verify that the user is able to see Screening Task has been Reopened for
	// QC rejection message
	// 47. Verify that the al test analyst user is able to see rejected phase task
	// state as In Progress under Screening
	// 48. Verify that the user is able to change the state as QC ready under
	// Screening
	// 49. Verify that the user is able to change the Next State as QC Task under
	// Screening
	// 50. Verify that the user is able to see QC Task has been Reopened Message
	// 51. Verify that the al qc user is able to change state as QC Ready to In
	// Progress under FRA
	// 52. Verify that the user is able to select the FRA task as Rejected phase
	// 53. Verify that the user is able to see FRA Task has been Reopened for QC
	// rejection message
	// 54. Verify that the al test analyst user is able to see rejected phase task
	// state as In Progress under FRA
	// 55. Verify that the user is able to click on Mark QC button under FRA Summary
	// Creation
	// 56. Verify that the user is able to see QC Task has been Reopened Messages
	// 57. Verify that the user is able to change the Approval as 'Fail' under ID&V
	// 58. Verify that the al qc user is able to change state as QC Ready to
	// Complete under Screening
	// 59. Verify that the al qc user is able to change state as QC Ready to
	// Complete under FRA
	// 60. Verify that the al qc user is approve the QC task
	@Test(priority = 8, enabled = false, description = "QCScreeningAndFRARejectAndApprovePhase")
	public void QCScreeningAndFRARejectAndApprovePhase() throws InterruptedException, IOException {
		System.out.println("QCScreeningAndFRARejectAndApprovePhase::" + mainWindow);
		QCTask qc = new QCTask(driver);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("new Window" + driver.getTitle());
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.switchTo().frame("gsft_main");
		qc.qcLogin();

		/*
		 * WebElement sort = driver.findElement(By.xpath(
		 * "//table[@id='x_aukms_accenture_accenture_legal_core_table']//i[@aria-label='Customer KYC Number column options']"
		 * )); sort.click(); WebElement za =
		 * driver.findElement(By.xpath("/html/body/div[4]/div[4]"));
		 * js.executeScript("arguments[0].click()", za);
		 */

		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[9]/span/span[2]")).click();
		WebElement qcTask = driver.findElement(By.xpath("//div[9]//table/tbody/tr/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[2]/span/span[2]")).click();
		js.executeScript("window.scrollBy(0,1000)");
		/*
		 * WebElement sort = driver.findElement(By.xpath("\r\n" + "\r\n" +
		 * "//th[@glide_field='x_aukms_accenture_screening_tasks.number']//i[@aria-label='Request Number column options']"
		 * )); sort.click(); WebElement az =
		 * driver.findElement(By.xpath("//div[normalize-space()='Sort (a to z)']"));
		 * js.executeScript("arguments[0].click()", az);
		 * System.out.println("Short Description::");
		 */
		driver.findElement(By.xpath("//div[2]/span/div[2]/div[4]//table/tbody/tr[2]/td[3]/a[@class='linked formlink']"))
				.click();
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_screening_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("In Progress");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		qcTask = driver.findElement(By.xpath("//div[9]//table/tbody/tr/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", qcTask);
		Select rejectPhase = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_qc_task.rejection_task']")));
		System.out.println("State..." + rejectPhase);
		rejectPhase.selectByVisibleText("Screening Task");
		driver.findElement(By.xpath("//button[@type='submit' and @id='reject_qc']")).click();
		driver.switchTo().alert().accept();
		WebElement Pop = driver.findElement(
				By.xpath("//div[2]//*[contains(text(),'Screening Task has been Reopened for QC rejection')]"));
		String qcMsg = Pop.getText();
		String qcPop = "Screening Task has been Reopened for QC rejection";
		assertEquals(qcPop, qcMsg);
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		qc.ScreeningComplete();
		driver.switchTo().window(windowHandlesList.get(1));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[9]/span/span[2]")).click();
		qcTask = driver.findElement(By.xpath("//div[9]//table/tbody/tr/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", qcTask);
		driver.findElement(By.xpath("//div[2]/div[1]/span[3]/span/span[2]")).click();
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"))
				.click();
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_fra_summary_creation.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("In Progress");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		qcTask = driver.findElement(By.xpath("//div[9]//table/tbody/tr/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", qcTask);
		rejectPhase = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_qc_task.rejection_task']")));
		System.out.println("State..." + rejectPhase);
		rejectPhase.selectByVisibleText("Summary Task");
		driver.findElement(By.xpath("//button[@type='submit' and @id='reject_qc']")).click();
		WebElement Pop1 = driver.findElement(
				By.xpath("//div[2]//*[contains(text(),'Summary Task has been Reopened for QC rejection')]"));
		String qcMsg1 = Pop1.getText();
		String qcPop1 = "Summary Task has been Reopened for QC rejection";
		assertEquals(qcPop1, qcMsg1);
		driver.switchTo().alert().accept();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		qc.FRAComplete();
		driver.switchTo().window(windowHandlesList.get(1));
		driver.switchTo().frame("gsft_main");
		qc.approveQCTasks();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.navigate().refresh();
	}

	// 75. Verify that user is able to provide answer in the 'Answer' field

	@Test(priority = 7, enabled = false, description = "SMEReview")
	public void SMEReview() throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		PortalValidation portal = new PortalValidation(driver);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(portalUrl);
		System.out.println("new Window" + driver.getTitle());
		portal.smeUserLogin();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement pendingReview=driver.findElement(By.xpath("//div/div[3]/span/div/div/a/div[2]"));
		pendingReview.click();
		WebElement caseNumber=driver.findElement(By.xpath("//div[1]/div/div[4]/table/tbody/tr/td[2]/span"));
		caseNumber.click();
		//Tmrw 
		WebElement pendingReviewButn=driver.findElement(By.xpath("//div/div/span[2]/div/div/div[1]/div[2]/button"));
		pendingReviewButn.click();
		
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement aLCore = driver
				.findElement(By.xpath("//div/div/magellan-favorites-list/ul/li[4]/div/ul/li[1]/div/a/div[2]/div"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		WebElement openMainTask = driver
				.findElement(By.xpath("//div[1]/table[1]/tbody[1]/tr[1]//a[@class='linked formlink']"));
		openMainTask.click();
		driver.findElement(By.xpath("//div[2]/div[1]/span[10]/span/span[2]")).click();
		WebElement task = driver.findElement(By.xpath("//div[10]/span/div[2]/div[4]//tr[1]/td[3]/a"));
		action.doubleClick(task).perform();
		WebElement answer = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_sme_review.alc_answer']"));
		answer.sendKeys("SME Review2");
		WebElement summary = driver.findElement(By.xpath("//tr/td/div/table/tbody/tr/td[3]/a"));
		String summaryTask = summary.getText();
		System.out.println("summaryTask::" + summaryTask);
		String actualSummary = "Summary Task Creation";
		assertEquals(actualSummary, summaryTask);
		WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		js.executeScript("arguments[0].click()", submit);
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[2]/div[1]/span[10]/span/span[2]")).click();
		driver.findElement(By.xpath("//div/div[10]/span/div[2]/div[3]/div[1]/span/button/b")).click();
		/*
		 * WebElement sort = driver.findElement(By.xpath(
		 * "//div[10]/span/div[2]/div[4]/table//tr[1]/th[3]/span/i")); sort.click();
		 * WebElement az =
		 * driver.findElement(By.xpath("//div[normalize-space()='Sort (a to z)']"));
		 * js.executeScript("arguments[0].click()", az);
		 */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		task = driver.findElement(
				By.xpath("//div[2]/div/div[10]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
		js.executeScript("arguments[0].click()", task);
		answer = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_sme_review.alc_answer']"));
		answer.sendKeys("SME Review1");
		summary = driver.findElement(By.xpath("//tr/td/div/table/tbody/tr/td[3]/a"));
		summaryTask = summary.getText();
		System.out.println("summaryTask::" + summaryTask);
		actualSummary = "Summary Task Creation";
		assertEquals(actualSummary, summaryTask);
		System.out.println("Before Sme Review");
		submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		js.executeScript("arguments[0].click()", submit);
		System.out.println("Submit SME Review");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		task = driver.findElement(
				By.xpath("//div[2]/div/div[10]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a"));
		js.executeScript("arguments[0].click()", task);
		answer = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_sme_review.alc_answer']"));
		Assert.assertTrue(answer.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement updateButn = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		js.executeScript("arguments[0].click()", updateButn);

		/*
		 * WebElement sPop = driver.findElement(By.
		 * xpath("//div//*[contains(text(),'FRA Task has been Reopened')]")); String pop
		 * = sPop.getText(); String smePop = "FRA Task has been Reopened";
		 * assertEquals(smePop, pop);
		 */
	}

	@Test(priority = 10, enabled = false, description = "ClientSponsorReviewAndCompleteReopenedSummaryAndQCTask")
	public void ClientSponsorReviewAndCompleteReopenedSummaryAndQCTask() throws InterruptedException, IOException {
		QCTask qc = new QCTask(driver);
		ReviewTask review = new ReviewTask(driver);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("new Window" + driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().frame("gsft_main");
		review.ClientSponsorLogin();
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement aLCore = driver
				.findElement(By.xpath("//div/magellan-favorites-list/ul/li[4]/div/ul/li[1]/div/a/div[2]/div"));
		action.doubleClick(aLCore).perform();
		driver.switchTo().frame("gsft_main");
		WebElement openMainTask = driver
				.findElement(By.xpath("//div[1]/table[1]/tbody[1]/tr[1]//a[@class='linked formlink']"));
		openMainTask.click();
		driver.findElement(By.xpath("//div[2]/div[1]/span[11]/span/span[2]")).click();
		js.executeScript("window.scrollBy(0,1000)");
		WebElement task = driver.findElement(
				By.xpath("//div[2]/div[2]/div/div[11]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]"));
		action.doubleClick(task).perform();
		System.out.println("Opened CS Review Task");
		WebElement summary = driver.findElement(By.xpath("//tr/td/div/table/tbody/tr/td[3]/a"));
		String summaryTask = summary.getText();
		System.out.println("summaryTask::" + summaryTask);
		String actualSummary = "Summary Task Creation";
		assertEquals(actualSummary, summaryTask);
		WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		js.executeScript("arguments[0].click()", submit);
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		qc.FRAComplete();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("new Window" + driver.getTitle());
		driver.switchTo().frame("gsft_main");
		qc.qcLogin();
		qc.approveQCTasks();
		driver.switchTo().window(windowHandlesList.get(0));
	}

	@Test(priority = 11, enabled = false, description = "TeamLeadUpdate")
	public void TeamLeadUpdate() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		QCTask qc = new QCTask(driver);
		ScreeningAndSummaryreation screensummary = new ScreeningAndSummaryreation(driver);
		TeamLead lead = new TeamLead(driver);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("new Window" + driver.getTitle());
		lead.TeamLeadLogin();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[12]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[12]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"))
				.click();
		WebElement NextState = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_additional_approval_task.alc_next_state']"));
		Select dropDownList = new Select(NextState);
		List<WebElement> select = dropDownList.getOptions();
		System.out.println("Select::" + select);
		int index = 0;
		Random rand = new Random();
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {
			System.out.println("Error Messga....");
		}
		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}

		WebElement updateButn = driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']"));
		js.executeScript("arguments[0].click()", updateButn);
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[3]/span/span[2]")).click();
		WebElement iDVTask = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", iDVTask);
		System.out.println("ID&V..." + iDVTask);
		Select state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		iDVTask = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", iDVTask);
		System.out.println("ID&V..." + iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		iDVTask = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", iDVTask);
		System.out.println("ID&V..." + iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		iDVTask = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", iDVTask);
		System.out.println("ID&V..." + iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		iDVTask = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div/div[3]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td[3]/a[@class='linked formlink']"));
		js.executeScript("arguments[0].click()", iDVTask);
		System.out.println("ID&V..." + iDVTask);
		state = new Select(
				driver.findElement(By.xpath("//select[@name='x_aukms_accenture_accenture_id_v_tasks.state']")));
		System.out.println("State..." + state);
		state.selectByVisibleText("QC Ready");
		driver.findElement(By.xpath("//button[@onclick='return gsftSubmit(this);']")).click();
		// screensummary.ScreeningTaskAndSummaryCreationTask();
		qc.FRAComplete();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		driver.switchTo().frame("gsft_main");
		qc.qcLogin();
		qc.approveQCTasks();
		driver.switchTo().window(windowHandlesList.get(0));

	}

	@Test(priority = 12, enabled = false, description = "DocumentRepository")
	public void UpdateRiskRating() throws InterruptedException, IOException {
		AMLCOAndCOELead amlco = new AMLCOAndCOELead(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		amlco.AMLCOLogin();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement favorites = driver.findElement(By.xpath("//body/div[5]/div/div/nav/div/div[2]/div/div/a[2]"));
		action.moveToElement(favorites).click().perform();
		WebElement aLCore = driver.findElement(
				By.xpath("//div[@class='sn-widget-list-title ng-binding'][normalize-space()='Accenture Legal Cores']"));
		action.doubleClick(aLCore).perform();
		// String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		// alcore.sendKeys(selectLinkOpeninNewTab);
		driver.switchTo().frame("gsft_main");
		WebElement mainTask = driver
				.findElement(By.xpath("//div/div[5]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/a"));
		mainTask.click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[12]/span/span[2]")).click();
		driver.findElement(By.xpath("//div/div[12]/span/div[2]/div[4]/table/tbody/tr/td/div/table/tbody/tr/td[3]/a"))
				.click();
		WebElement checkBox = driver.findElement(
				By.xpath("//label[@id='label.ni.x_aukms_accenture_additional_approval_task.update_the_risk_rating']"));
		js.executeScript("arguments[0].click()", checkBox);
		WebElement riskrating = driver
				.findElement(By.xpath("//*[@name='x_aukms_accenture_additional_approval_task.revised_rating']"));
		Select dropDownList = new Select(riskrating);
		List<WebElement> select = dropDownList.getOptions();
		System.out.println("Select::" + select);
		int index = 0;
		Random rand = new Random();
		if (select.size() > 1) {
			index = rand.nextInt(select.size() - 1);
		} else if (select.size() < 1) {
			System.out.println("Error Messga....");
		}
		dropDownList.selectByIndex(index);
		if (index == 0) {
			dropDownList.selectByIndex(1);
		}
		WebElement riskRatingButn = driver.findElement(By.xpath(
				"//button[@onclick='var update_risk_rating=window.update_risk_rating;riskratingvisbility();return false;']"));
		js.executeScript("arguments[0].click()", riskRatingButn);
	}

	@Test(priority = 19, enabled = false, description = "DocumentRepository")
	public void DocumentRepository() throws InterruptedException, IOException {
		System.out.println("DocumentRepository:;");
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[14]/span/span[2]")).click();
		// .image file
		// driver.findElement(By.xpath("//div[13]//tr[1]/td[3]/a[@class='linked
		// formlink']")).click();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.xpath("//div[14]//tr[1]/td[3]/a[@class='linked formlink']"))
				.sendKeys(selectLinkOpeninNewTab);
		selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.xpath("//div[14]//tr[2]/td[3]/a[@class='linked formlink']"))
				.sendKeys(selectLinkOpeninNewTab);
		selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.xpath("//div[14]//tr[3]/td[3]/a[@class='linked formlink']"))
				.sendKeys(selectLinkOpeninNewTab);
		selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.xpath("//div[14]//tr[4]/td[3]/a[@class='linked formlink']"))
				.sendKeys(selectLinkOpeninNewTab);
		/*
		 * selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		 * driver.findElement(By.
		 * xpath("//div[14]//tr[5]/td[3]/a[@class='linked formlink']"))
		 * .sendKeys(selectLinkOpeninNewTab); selectLinkOpeninNewTab =
		 * Keys.chord(Keys.CONTROL, Keys.RETURN); driver.findElement(By.
		 * xpath("//div[14]//tr[6]/td[3]/a[@class='linked formlink']"))
		 * .sendKeys(selectLinkOpeninNewTab);
		 */
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//div[2]//li[2]/span/a[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(2));
		driver.findElement(By.xpath("//div[2]//li[2]/span/a[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(3));
		driver.findElement(By.xpath("//div[2]//li[2]/span/a[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(4));
		driver.findElement(By.xpath("//div[2]//li[2]/span/a[3]")).click();
		Thread.sleep(2000);
		/*
		 * driver.switchTo().window(tabs.get(5));
		 * driver.findElement(By.xpath("//div[2]//li[2]/span/a[3]")).click();
		 * Thread.sleep(2000); driver.switchTo().window(tabs.get(6));
		 * driver.findElement(By.xpath("//div[2]//li[2]/span/a[3]")).click();
		 * Thread.sleep(2000);
		 */
		driver.quit();

	}

	String getFile() {
		return new File("./files/doc.txt").getAbsolutePath();

	}

	String getFile1() {
		return new File("./files/download.png").getAbsolutePath();

	}

	String getFile2() {
		return new File("./files/New folder.zip").getAbsolutePath();

	}

	String getFile3() {
		return new File("./files/Rent Receipt.pdf").getAbsolutePath();

	}

	String getFile4() {
		return new File("./files/Testing Workflow Document2.docx").getAbsolutePath();

	}

	String getFile5() {
		return new File("./files/universal-viewer.jpg").getAbsolutePath();

	}

	public void window() {
		for (String windowHandle : driver.getWindowHandles()) {
			if (mainWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(mainWindow);
				System.out.println("parent window...." + mainWindow);
				break;
			}
		}

	}

	public void readOnlyFieldEscalation() {
		System.out.println("readOnlyFieldEscalation:");
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_escalation_task.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_escalation_task.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_escalation_task.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_escalation_task.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_escalation_task.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyFieldOutreach() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_outreach_task.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_outreach_task.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_outreach_task.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement taskType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.alc_task_type']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement outreachType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.outreach_type']"));
		Assert.assertTrue(outreachType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyFieldAllocation() {
		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_allocation.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_allocation.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_allocation.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyFieldScreening() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_outreach_task.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_outreach_task.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_outreach_task.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement idvTaskNumber = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_outreach_task.id_v_task_number_label']"));
		Assert.assertTrue(idvTaskNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement taskType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.alc_task_type']"));
		Assert.assertTrue(taskType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement outreachType = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.outreach_type']"));
		Assert.assertTrue(outreachType.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement shortDescription = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_outreach_task.short_description']"));
		Assert.assertTrue(shortDescription.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyFieldQc() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_qc_task.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_qc_task.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_qc_task.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_qc_task.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_qc_task.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement rejectPhase = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_qc_task.rejection_task']"));
		Assert.assertTrue(rejectPhase.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement shortDescription = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_qc_task.short_description']"));
		Assert.assertTrue(shortDescription.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyFieldSme() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_sme_review.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_sme_review.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_sme_review.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_sme_review.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_sme_review.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement shortDescription = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_sme_review.short_description']"));
		Assert.assertTrue(shortDescription.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyFieldApprover() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_approval_task.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_approval_task.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_approval_task.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_approval_task.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_approval_task.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement shortDescription = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_approval_task.short_description']"));
		Assert.assertTrue(shortDescription.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyFieldAdditionalApprover() {
		WebElement requestNumber = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_additional_approval_task.number']"));
		Assert.assertTrue(requestNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignmentGroup = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_additional_approval_task.assignment_group_label']"));
		Assert.assertTrue(assignmentGroup.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement parent = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_additional_approval_task.parent_label']"));
		Assert.assertTrue(parent.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement assignedTo = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_additional_approval_task.assigned_to_label']"));
		Assert.assertTrue(assignedTo.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement state = driver
				.findElement(By.xpath("//*[@id='sys_readonly.x_aukms_accenture_additional_approval_task.state']"));
		Assert.assertTrue(state.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		WebElement shortDescription = driver.findElement(
				By.xpath("//*[@id='sys_readonly.x_aukms_accenture_additional_approval_task.short_description']"));
		Assert.assertTrue(shortDescription.getAttribute("readOnly").equals("true"), "Element ReadOnly");
	}

	public void readOnlyField() {
		WebElement caseData = driver.findElement(By.xpath("//span[normalize-space()='Case Data']"));
		caseData.click();
		WebElement cKYCNumber = driver
				.findElement(By.xpath("//input[@id='sys_readonly.x_aukms_accenture_accenture_legal_core.number']"));
		Assert.assertTrue(cKYCNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("1");
		WebElement startDate = driver
				.findElement(By.xpath("//input[@id='sys_readonly.x_aukms_accenture_accenture_legal_core.start_date']"));
		Assert.assertTrue(startDate.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("2");
		WebElement endDate = driver
				.findElement(By.xpath("//input[@id='sys_readonly.x_aukms_accenture_accenture_legal_core.end_date']"));
		Assert.assertTrue(endDate.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("3");
		WebElement workFlowStage = driver.findElement(
				By.xpath("//select[@id='sys_readonly.x_aukms_accenture_accenture_legal_core.workflow_stage']"));
		Assert.assertTrue(workFlowStage.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("4");
		WebElement workFlowSubStage = driver.findElement(
				By.xpath("//select[@id='sys_readonly.x_aukms_accenture_accenture_legal_core.workflow_substage']"));
		Assert.assertTrue(workFlowSubStage.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("5");
		WebElement status = driver
				.findElement(By.xpath("//select[@id='sys_readonly.x_aukms_accenture_accenture_legal_core.status']"));
		Assert.assertTrue(status.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("6");
		WebElement contact = driver.findElement(By.xpath("//span[normalize-space()='Contact']"));
		contact.click();
		WebElement teamLead = driver
				.findElement(By.xpath("//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.team_lead']"));
		Assert.assertTrue(teamLead.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("7");
		WebElement analyst = driver
				.findElement(By.xpath("//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.analyst']"));
		Assert.assertTrue(analyst.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("8");
		WebElement qc = driver
				.findElement(By.xpath("//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.qc']"));
		Assert.assertTrue(qc.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("9");
		WebElement approver = driver
				.findElement(By.xpath("//input[@id='sys_display.x_aukms_accenture_accenture_legal_core.approver']"));
		Assert.assertTrue(approver.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("10");
		WebElement caseInfo = driver.findElement(By.xpath("//span[normalize-space()='Case Initiation Info']"));
		caseInfo.click();
		WebElement aFName = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.account_fc_name']"));
		Assert.assertTrue(aFName.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("11");
		WebElement aFNumber = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.account_fc_number']"));
		Assert.assertTrue(aFNumber.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("12");
		WebElement aFCCountry = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.account_fc_country']"));
		Assert.assertTrue(aFCCountry.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("15");
		WebElement aFCState = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.account_fc_state']"));
		Assert.assertTrue(aFCState.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("16");
		WebElement companyCode = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.company_code']"));
		Assert.assertTrue(companyCode.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("17");
		WebElement initialRisk = driver.findElement(By.xpath("//span[normalize-space()='Initial Risk Assessment']"));
		initialRisk.click();
		WebElement inCorporation = driver.findElement(
				By.xpath("//*[@id='sys_select.x_aukms_accenture_accenture_legal_core.country_of_incorporations']"));
		Assert.assertTrue(inCorporation.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("23");
		WebElement pPService = driver.findElement(
				By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.third_party_paying_for_services']"));
		Assert.assertTrue(pPService.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("24");
		WebElement cStructure = driver.findElement(
				By.xpath("//*[@id='sys_select.x_aukms_accenture_accenture_legal_core.corporate_structures']"));
		Assert.assertTrue(cStructure.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("25");
		WebElement uContracting = driver
				.findElement(By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.unusual_contracting']"));
		Assert.assertTrue(uContracting.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("26");
		WebElement industry = driver
				.findElement(By.xpath("//*[@id='sys_select.x_aukms_accenture_accenture_legal_core.main_industrys']"));
		Assert.assertTrue(industry.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("27");
		WebElement thirdParty = driver.findElement(
				By.xpath("//*[@id='x_aukms_accenture_accenture_legal_core.client_acting_on_behalf_of_third_party']"));
		Assert.assertTrue(thirdParty.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("28");
		WebElement dueDiligence = driver.findElement(
				By.xpath("//*[@id='sys_readonly.x_aukms_accenture_accenture_legal_core.type_of_due_diligence']"));
		Assert.assertTrue(dueDiligence.getAttribute("readOnly").equals("true"), "Element ReadOnly");
		System.out.println("29");
	}

	public void SMEApproveAccept() throws InterruptedException, IOException {
		System.out.println("SMEApproveAccept::" + mainWindow);
		QCTask qc = new QCTask(driver);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		qc.sessionExpire();
		driver.switchTo().frame("gsft_main");
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
		// qc.sessionExpire();
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
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[10]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[10]//table/tbody/tr/td[3]/a[@class='linked formlink']")).click();
		WebElement notes = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_sme_review.work_notes']"));
		workNotes = PropertiesFile.getworkNotes();
		notes.sendKeys(workNotes);
		WebElement approve = driver.findElement(By.xpath("//div[1]//span//*[contains(text(),'Approve')]"));
		js.executeScript("arguments[0].click()", approve);

		/*
		 * driver.findElement(By.xpath("//div[1]//span//*[contains(text(),'Approve')]"))
		 * .click(); WebElement aPop = driver.findElement(By.
		 * xpath("//div//*[contains(text(),'Approval Task is Generated')]")); String pop
		 * = aPop.getText(); String approvalPop = "Approval Task is Generated";
		 * assertEquals(approvalPop, pop);
		 */
		SoftAssert assert1 = new SoftAssert();

	}

	public void ApprovalApproveAccept() throws InterruptedException, IOException {
		System.out.println("ApprovalApproveAccept::" + mainWindow);
		Actions action = new Actions(driver);
		QCTask qc = new QCTask(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		qc.sessionExpire();
		driver.switchTo().frame("gsft_main");
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
		// qc.sessionExpire();
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

		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[11]/span/span[2]")).click();
		driver.findElement(By.xpath("//div[11]//table/tbody/tr/td[3]/a[@class='linked formlink']")).click();
		WebElement notes = driver.findElement(By.xpath("//*[@id='x_aukms_accenture_approval_task.work_notes']"));
		workNotes = PropertiesFile.getworkNotes();
		notes.sendKeys(workNotes);
		WebElement approve = driver.findElement(By.xpath("//div[1]//span//*[contains(text(),'Approve')]"));
		js.executeScript("arguments[0].click()", approve);
		Thread.sleep(2000);
		System.out.println("test2");
		driver.findElement(By.xpath("//div[11]//table/tbody/tr/td[3]/a[@class='linked formlink']")).click();
		readOnlyFieldApprover();
		// driver.navigate().refresh();
		/*
		 * WebElement aPop = driver .findElement(By.
		 * xpath("//div//*[contains(text(),'Additional Approval Task is Generated')]"));
		 * String pop = aPop.getText(); String approvalPop =
		 * "Additional Approval Task is Generated"; assertEquals(approvalPop, pop);
		 */
		driver.findElement(By.xpath("//button[@onclick='gsftSubmitBack()']")).click();

	}

	public void uploadAllFiles(List<File> files) {
		WebElement uploadElement = driver.findElement(By.cssSelector("#loadFileXml"));
		for (File file : files)
			uploadElement.sendKeys(file.getPath());
		System.out.println("file path::");
	}
}