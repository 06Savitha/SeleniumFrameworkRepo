package ALCore;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PropertiesFile;

public class AMLCOAndCOELead extends CaseCreation{
	public AMLCOAndCOELead(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void AMLCOLogin() throws InterruptedException {
		driver.switchTo().frame("gsft_main");
		WebElement userNameB = driver.findElement(By.xpath("//input[@name='user_name']"));
		System.out.println("find element");
		usernameB = PropertiesFile.getUserNameB();
		System.out.println("usernameB..." + usernameB);
		userNameB.sendKeys(usernameB);
		WebElement pwd = driver.findElement(By.id("user_password"));
		password = PropertiesFile.getPassword();
		pwd.sendKeys(password);
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
	}
}
