package config;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import ALCore.AccentureLegalCore;

public class PropertiesFile {
	static String contractingDetails;
	static String comments;
	static String password;
	static String passwordQ;
	static Properties prop = new Properties();
	static String Projectpath = System.getProperty("user.dir");
	static String url;
	static String PortalUrl;
	static String userNameT;
	static String userName;
	static String userNameB;
	static String userNameC;
	static String userNameE;
	static String userNameO;
	static String userNameQ;
	static String userNameS;
	static String thirdPartyName;
	static String thirdPartyAddress;
	static String thirdPartyContact;
	static String workNotes;

	public static void getProperties() {
		try {

			FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
			prop.load(in);
			prop.getProperty("browser");
			System.out.println("browser....::" + prop.getProperty("browser"));
			AccentureLegalCore.browserName = prop.getProperty("browser");
			System.out.println("CaseCreation.browserName "+AccentureLegalCore.browserName );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static String getUrl() {
try
{
		FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
		prop.load(in);
		prop.getProperty("url");
		System.out.println("browser....::" + prop.getProperty("url"));
		url = prop.getProperty("url");
	} 
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
return url;

	}
	
	public static String getPortalUrl() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("portalUrl");
				System.out.println("browser....::" + prop.getProperty("portalUrl"));
				PortalUrl = prop.getProperty("portalUrl");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return PortalUrl;

			}
	public static String getUserNameT() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("userNameT");
				System.out.println("browser....::" + prop.getProperty("userNameT"));
				userNameT = prop.getProperty("userNameT");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return userNameT;

			}
	public static String getUserNameB() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("userNameB");
				System.out.println("browser....::" + prop.getProperty("userNameB"));
				userNameB = prop.getProperty("userNameB");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return userNameB;

			}
	public static String getUserNameC() {
				try
				{
						FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
						prop.load(in);
						prop.getProperty("userNameC");
						System.out.println("browser....::" + prop.getProperty("userNameC"));
						userNameC = prop.getProperty("userNameC");
					} 
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
				return userNameC;

					}
	public static String getUserNameE() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("userNameE");
				System.out.println("browser....::" + prop.getProperty("userNameE"));
				userNameE = prop.getProperty("userNameE");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return userNameE;

			}
	public static String getUserNameO() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("userNameO");
				System.out.println("browser....::" + prop.getProperty("userNameO"));
				userNameO = prop.getProperty("userNameO");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return userNameO;

			}
	public static String getUserNameQ() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("userNameQ");
				System.out.println("browser....::" + prop.getProperty("userNameQ"));
				userNameQ = prop.getProperty("userNameQ");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return userNameQ;

			}
	public static String getUserNameS() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("userNameS");
				System.out.println("browser....::" + prop.getProperty("userNameS"));
				userNameS = prop.getProperty("userNameS");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return userNameS;

			}
	public static String getUserName() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("userName");
				System.out.println("browser....::" + prop.getProperty("userName"));
				userName = prop.getProperty("userName");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return userName;

			}
	public static String getPassword() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("password");
				System.out.println("browser....::" + prop.getProperty("password"));
				password = prop.getProperty("password");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return password;

			}
	public static String getPasswordQ() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("passwordQ");
				System.out.println("browser....::" + prop.getProperty("passwordQ"));
				passwordQ = prop.getProperty("passwordQ");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return passwordQ;

			}
	public static String getThirdPartName() {
		try
		{
				FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
				prop.load(in);
				prop.getProperty("thirdPartyName");
				System.out.println("thirdPartyAddress....::" + prop.getProperty("thirdPartyName"));
				thirdPartyName = prop.getProperty("thirdPartyName");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return thirdPartyName;

			}

public static String getThirdPartAddress() {
	try
	{
			FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
			prop.load(in);
			prop.getProperty("thirdPartyAddress");
			System.out.println("thirdPartyAddress....::" + prop.getProperty("thirdPartyAddress"));
			thirdPartyAddress = prop.getProperty("thirdPartyAddress");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	return thirdPartyAddress;

		}

public static String getThirdPartContact() {
	try
	{
			FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
			prop.load(in);
			prop.getProperty("thirdPartyContact");
			System.out.println("thirdPartyAddress....::" + prop.getProperty("thirdPartyContact"));
			thirdPartyContact = prop.getProperty("thirdPartyContact");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	return thirdPartyContact;

		}
public static String getContractingDetails() {
	try
	{
			FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
			prop.load(in);
			prop.getProperty("contractingDetails");
			System.out.println("contractingDetails....::" + prop.getProperty("contractingDetails"));
			contractingDetails = prop.getProperty("contractingDetails");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	return contractingDetails;

		}

public static String getworkNotes() {
	try
	{
			FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
			prop.load(in);
			prop.getProperty("workNotes");
			System.out.println("workNotes....::" + prop.getProperty("workNotes"));
			workNotes = prop.getProperty("workNotes");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	return workNotes;

		}
public static String getComments() {
	try
	{
			FileInputStream in = new FileInputStream(Projectpath + "\\src\\test\\java\\config\\config.properties");
			prop.load(in);
			prop.getProperty("comments");
			System.out.println("comments....::" + prop.getProperty("comments"));
			comments = prop.getProperty("comments");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	return comments;

		}
}
	/*
	 * public static void setProperties() { try { FileOutputStream out =new
	 * FileOutputStream(Projectpath +
	 * "\\src\\test\\java\\config\\config.properties");
	 * prop.setProperty("browser","chrome"); prop.store(out, null); } catch
	 * (Exception e) { System.out.println(e.getMessage()); }
	 */


