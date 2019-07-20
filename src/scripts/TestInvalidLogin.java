package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generics.BaseTest;
import generics.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest {

	@Test
	public void testInvalidLogin() throws InterruptedException{
		Logger log =LogManager.getLogger(TestInvalidLogin.class.getName());
		LoginPage lp = new LoginPage(driver);
		int rowCount=Lib.getrowCount("InvalidLogin");
		for(int i=1;i<rowCount;i++)
		{
			log.debug("Fetching details for username");
			String username = Lib.getcellValue("InvalidLogin",i,0);
			log.info("username fetched");
			lp.setUserName(username);
			Thread.sleep(2000);
			String password =Lib.getcellValue("InvalidLogin",i,1);
			lp.setPassWord(password);
			Thread.sleep(2000);
			lp.clickLogin();
			Thread.sleep(3000);
			String expectedError=Lib.getcellValue("ExpectedText", 1, 0);
			String errorMessage ="//span[contains(text(),'invalid')]";
			log.debug("Checking if error message is dispalyed");
			WebElement errorObj=driver.findElement(By.xpath(errorMessage));
			log.info("Error Message is Displayed "+errorObj.isDisplayed());
			String actualError=errorObj.getText();
			log.info(actualError);
			SoftAssert s = new SoftAssert();
			s.assertEquals(actualError, expectedError);
			s.assertAll();
		}
	}

}
