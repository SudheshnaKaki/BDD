package RegistrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegPageFactory {

	WebDriver webDriver;
	

	public RegPageFactory(WebDriver webDriver) {

		this.webDriver = webDriver;
		PageFactory.initElements(webDriver,this);
	}

	public RegPageFactory() {
	}

	@FindBy(name = "name")
	@CacheLookup
	WebElement name;

	@FindBy(id = "txnPh")
	@CacheLookup
	WebElement mobilenumber;

	@FindBy(id="txnEmail")
	@CacheLookup
	WebElement mail;

	@FindBy(id = "mG")
	@CacheLookup
	WebElement mGender;
	

	public WebElement getmGender() {
		return mGender;
	}

	public void setmGender() {
		mGender.click();
	}

	public WebElement getfGender() {
		return fGender;
	}

	public void setfGender() {
		fGender.click();
	}

	@FindBy(id = "fG")
	@CacheLookup
	WebElement fGender;
	
	@FindBy(name = "address")
	@CacheLookup
	WebElement address;

	@FindBy(xpath = "/html/body/form/table/tbody/tr[6]/td/input")
	@CacheLookup
	WebElement button;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebElement getName() {
		return name;
	}

	public void setName(String nameTemp) {
		name.sendKeys(nameTemp);

	}

	public WebElement getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobileNumberTemp) {
		mobilenumber.sendKeys(mobileNumberTemp);
	}

	public WebElement getMail() {
		return mail;
	}

	public void setMail(String mailTemp) {
		mail.sendKeys(mailTemp);
	}


	public WebElement getAddress() {
		return address;
	}

	public void setAddress(String addressTemp) {
		address.sendKeys(addressTemp);
	}

	public WebElement getButton() {
		return button;
	}

	public void setButton() {
		button.click();
	}

}
