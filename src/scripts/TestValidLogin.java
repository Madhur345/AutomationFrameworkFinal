package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generics.BaseTest;
import generics.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest {
	Logger log=LogManager.getLogger(TestValidLogin.class.getName());
	@Test
	public void validLogin() throws InterruptedException{
		log.debug("create the object of pom login page");
		LoginPage lp = new LoginPage(driver);
		log.info("object created successfully");
		log.debug("Fetching the details from Excel sheet");
		String username = Lib.getcellValue("ValidLogin",1,0);
		log.info("DataFetched successfully");
		lp.setUserName(username);
		Thread.sleep(2000);
		String password =Lib.getcellValue("ValidLogin",1,1);
		lp.setPassWord(password);
		Thread.sleep(2000);
		log.debug("Logging into the application");
		lp.clickLogin();
		log.info("Successfull Login");
		String expectedTitle =Lib.getcellValue("ProductVersion", 1, 0);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	}
}
