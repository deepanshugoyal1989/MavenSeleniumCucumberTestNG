package step_definitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageStepDefinition{
	
	
	
	
	LoginPage loginPage;
    HomePage homePage;
	
    
    @Given("^User is at login page$")
	public void user_is_at_login_page() {
//	   System.out.println("In Given Step Def"); 
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@When("^user enters valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enters_valid_username_and_password(String user, String pass) {
	     //Write code here that turns the phrase above into concrete actions
		loginPage.setUsername(user);
		loginPage.setPassword(pass);
		loginPage.clickSubmit();
//		System.out.println("When Step def");
	}

	@Then("^User should be directed to home page with title \"([^\"]*)\"$")
	public void user_should_be_directed_to_home_page_with_title(String title) {
	    // Write code here that turns the phrase above into concrete actions
		if(homePage.getTitle().contains(title)) {
			System.out.println("In  htbejrblwr wl");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false,"Actual title :"+homePage.getTitle()+" does not contains"+ title);
		
//		System.out.println("Then Step def");
	}

}