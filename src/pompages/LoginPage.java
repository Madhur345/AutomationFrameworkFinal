package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="username")
	WebElement unTB;

	@FindBy(name ="pwd")
	WebElement pwTB;

	@FindBy(xpath="//div[text()='Login ']")
	WebElement loginButton;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String un){
		unTB.sendKeys(un);
	}
	public void setPassWord(String pwd){
		pwTB.sendKeys(pwd);
	}
	public void clickLogin(){
		loginButton.click();
	}
}
