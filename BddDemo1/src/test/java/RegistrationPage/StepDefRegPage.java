package RegistrationPage;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefRegPage {
	
	WebDriver webDriver=null;
	RegPageFactory regPageFactory=null;
	
	
	
	@Given("^User is on RegistrationPage$")
	public void user_is_on_RegistrationPage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Lib\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("http://localhost:8080/Sample/Registration.html");
		regPageFactory = new RegPageFactory(webDriver);
		
	}

	@Then("^Check the title of the page$")
	public void check_the_title_of_the_page() throws Throwable {
		String title=webDriver.getTitle();
		String title1="Registration Form";
		assertEquals(title1,title);
	   
	}

	@When("^User enters all valid details$")
	public void user_enters_all_valid_details() throws Throwable {
		regPageFactory.setName("anu");
		Thread.sleep(500);
		regPageFactory.setMobilenumber("9874563210");
		Thread.sleep(500);
		regPageFactory.setMail("anu@gmail.com");
		Thread.sleep(500);
		regPageFactory.setfGender();
		Thread.sleep(500);
		regPageFactory.setAddress("chennai");
		Thread.sleep(500);
		regPageFactory.setButton();

	}

	@Then("^navigate to next page$")
	public void navigate_to_next_page() throws Throwable {
	   System.out.println("Registered successfull");
	  
	}

	@When("^User enters Invalid firstname$")
	public void user_enters_Invalid_firstname() throws Throwable {
		regPageFactory.setName("#123");
		Thread.sleep(500);
		regPageFactory.setButton();
	         
	}

	@Then("^generate  error message$")
	public void generate_error_message() throws Throwable {
		String alertMessage = webDriver.switchTo().alert().getText();
		Thread.sleep(1000);
		webDriver.switchTo().alert().accept();
		System.err.println("not matched" + alertMessage);
	}

	@When("^User enters Invalid MobileNumber$")
	public void user_enters_Invalid_MobileNumber(DataTable arg1) throws Throwable {
		regPageFactory.setName("prasanna");
		Thread.sleep(700);
		List<String> mobileList = arg1.asList(String.class);
		String data = null;
		for (String phone : mobileList) {
			data = phone;
			regPageFactory.getMobilenumber().clear();
			Thread.sleep(500);
			regPageFactory.setMobilenumber(phone);
			regPageFactory.setButton();

			if (Pattern.matches("[7-9]{1}[0-9]{9}", data)) {
				System.out.println("matching");
			} else {
				System.out.println("not matched");
				String alertMessage = webDriver.switchTo().alert().getText();
				Thread.sleep(1000);
				webDriver.switchTo().alert().accept();
				System.err.println("not matched" + alertMessage);
			}
			
		}
		/*regPageFactory.setMail("lakshmi@gmail.com");
		Thread.sleep(700);
		regPageFactory.setfGender();
		Thread.sleep(500);
		regPageFactory.setAddress("chennai");*/
		regPageFactory.setButton();
        
		    
	}

	
	@When("^User enters Invalid MailId$")
	public void user_enters_Invalid_MailId(DataTable arg1) throws Throwable {
		regPageFactory.setName("prasanna");
		Thread.sleep(1000);
		regPageFactory.setMobilenumber("9874563210");
		Thread.sleep(500);
		List<String> emailList = arg1.asList(String.class);
		String data = null;
		for (String email : emailList) {
			data = email;
			regPageFactory.getMail().clear();
			regPageFactory.setMail(email);
			Thread.sleep(1000);
			regPageFactory.setButton();

			if (data.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$")) {
				System.out.println("matching");
			} else {
				String alertMessage = webDriver.switchTo().alert().getText();
				Thread.sleep(1000);
				webDriver.switchTo().alert().accept();
				System.err.println("not matched" + alertMessage);
			}
		}
		/*regPageFactory.setfGender();
		Thread.sleep(500);
		regPageFactory.setAddress("chennai");*/
		regPageFactory.setButton();
		
	    
	}

	@When("^User enters Invalid adresss$")
	public void user_enters_Invalid_adresss(DataTable arg1) throws Throwable {
		regPageFactory.setName("mahalakshmi");
		Thread.sleep(1000);
		regPageFactory.setMobilenumber("9087654321");
		Thread.sleep(1000);
		regPageFactory.setMail("maha@gmail.com");
		Thread.sleep(1000);
		regPageFactory.setfGender();
		Thread.sleep(500);
		regPageFactory.setAddress("");
		Thread.sleep(1000);
		regPageFactory.setButton();
		
	}


	@When("^User doesnot enters any details$")
	public void user_doesnot_enters_any_details() throws Throwable {
		regPageFactory.setName(" ");
		Thread.sleep(500);
		regPageFactory.setMobilenumber(" ");
		Thread.sleep(500);
		regPageFactory.setMail(" ");
		Thread.sleep(500);
		regPageFactory.getmGender();
		Thread.sleep(500);
		regPageFactory.setAddress(" ");
		Thread.sleep(500);
		
		
	   
	}

	@When("^Clicks submit button$")
	public void clicks_submit_button() throws Throwable {
		regPageFactory.setButton();
		
	}

	
	@After
	public void destroy() {
		webDriver.close();
	}
	

}
