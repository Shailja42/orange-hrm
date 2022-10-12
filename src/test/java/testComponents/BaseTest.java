package testComponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
//import io.cucumber.core.cli.Main

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static WebDriver driver;
	static Map<String, String> xpaths;

	public void loadData() throws IOException {
		xpaths = new HashMap<>();
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(
				"C:\\work-stuff\\workspace\\OrangeHRM\\src\\test\\java\\com\\objectrepository\\orangehrm\\application.properties");
		obj.load(objfile);
		for (String key : obj.stringPropertyNames()) {
			String value = obj.getProperty(key);
			xpaths.put(key, (value));
		}

	}

	@BeforeMethod(alwaysRun = true)
	public void launch() throws IOException {
		loadData();
		ChromeOptions options = new ChromeOptions();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(xpaths.get("AppUrl"));

	}

	public void login(String username, String password) throws InterruptedException {

		driver.manage().window().maximize();
		driver.findElement(By.xpath(xpaths.get("UserName_xpath"))).sendKeys(username);
		driver.findElement(By.xpath(xpaths.get("Password_xpath"))).sendKeys(password);
		driver.findElement(By.xpath(xpaths.get("Login_xpath"))).click();
	}

	public void add_employee(String fname, String lname) throws AWTException {
		Robot robot = new Robot();
		driver.findElement(By.xpath(xpaths.get("add_employee_xpath"))).click();
		driver.findElement(By.xpath(xpaths.get("fname_xpath"))).sendKeys(fname);
		driver.findElement(By.xpath(xpaths.get("lname_xpath"))).sendKeys(lname);
		// driver.findElement(By.xpath(xpaths.get("toggle_xpath"))).click();
		WebElement upload_file = driver.findElement(By.xpath(xpaths.get("pictureUpload_xpath")));
		upload_file.click();
		robot.delay(2000);
		StringSelection stringselection = new StringSelection(
				"C:\\Users\\akumar94\\OneDrive - Capgemini\\Desktop\\ProfilePic.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath(xpaths.get("submit_xpath"))).click();
	}

	public void edit_employee() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		 driver.findElement(By.xpath(xpaths.get("date_picker_xpath"))).sendKeys("2022-08-02");
		Thread.sleep(5000);
		driver.findElement(By.xpath(xpaths.get("nationality_xpath"))).click();
		List<WebElement> nationality = driver.findElements(By.xpath(xpaths.get("nationality_dropdown_xpath")));

		for (WebElement ele : nationality) {

			if (ele.getText().equals("Indian")) {

				ele.click();
			}
		}
//		driver.findElement(By.xpath(xpaths.get("maritalstatus_dropdown_xpath"))).click();
//		List<WebElement> martial_status = driver.findElements(By.xpath(xpaths.get("maritalstatus_dropdown_xpath")));
//
//		for (WebElement ele1 : martial_status) {
//
//			if (ele1.getText().equals("Single")) {
//
//				ele1.click();
//			}
//		}

//		driver.findElement(By.xpath(xpaths.get("gender_xpath"))).click();
//		driver.findElement(By.xpath(xpaths.get("add_file_xpath"))).click();
//		driver.findElement(By.xpath(xpaths.get("browse_xpath"))).click();
//		StringSelection file = new StringSelection("C:\\Users\\akumar94\\Downloads\\Kde-ticket.pdf");
//		robot.delay(1000);
//		
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
//		robot.delay(2000);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
