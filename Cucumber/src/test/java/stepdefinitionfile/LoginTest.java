package stepdefinitionfile;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPageObject;

public class LoginTest {
	protected WebDriver driver;
	LoginPageObject obj;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  obj=new LoginPageObject(driver);
	  driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
	    obj.enterUsername(username);
	    obj.enterPassword(password);
	}

	@When("clicks on submit  button")
	public void clicks_on_submit_button() {
	    obj.clickLogin();
	}


	@Then("user navigated to next page")
	public void user_navigated_to_next_page() {
		String actual=obj.geturl();
		String expected="https://practicetestautomation.com/logged-in-successfully/";
		Assertions.assertEquals(actual, expected);
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
