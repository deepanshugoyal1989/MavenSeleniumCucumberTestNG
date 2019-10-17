package pages;

import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle(); 
	}
}
