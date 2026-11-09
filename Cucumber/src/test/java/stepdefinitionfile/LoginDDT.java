package stepdefinitionfile;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPageObject;

public class LoginDDT {


	
	WebDriver driver;
	LoginPageObject obj;
	
	@Before
	public void browserSetup()
	{
		driver=new FirefoxDriver();
	}
	
	@Given("application was launched")
	public void application_login_page() {
	   
		driver.get("https://practicetestautomation.com/practice-test-login/");
		obj=new LoginPageObject(driver);
	}
	@When("enter credentials {string} and {string}")
	public void enter_credentials_and(String username, String password) {
	    obj.enterUsername(username);
	    obj.enterPassword(password);
	    obj.clickLogin();
	}
	@Then("I verify the result in {string}")
	public void verifyResult(String expected) {
		
		if(expected.contains("logged-in-successfully/"))
		{
			Assertions.assertEquals(expected, obj.geturl());
		}
		
		else
		{
		}
	   
	}
  @After
  public void tearDown()
  {
	   if(driver!=null)
	   {
		   driver.quit();
	   }
  }


}
