package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
	
	//Page Factory - OR
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement submit;
	
	//Initializing WebElements
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	public void setUsername(String user){
		username.sendKeys(user);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	public void doLogin(String user, String pass) {
		this.setUsername(user);
		this.setPassword(pass);
		this.submit.click();

	}
}
