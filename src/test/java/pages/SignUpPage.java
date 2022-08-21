package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class SignUpPage {
	
	WebDriver driver = BaseClass.driver;
	
	ExtentTest test = BaseClass.test;
	
	
	//***************Web Elements***************
	
	@FindBy (id = "signup")
	WebElement signUpLink;
	
	@FindBy(id = "firstName")
	WebElement fName;
	
	@FindBy(id = "lastName")
	WebElement lName;
	
	@FindBy(id = "email")
	WebElement eMail;
	
	@FindBy(id = "contactNumber")
	WebElement cNum;
	
	@FindBy(id = "password")
	WebElement psw;
	
	@FindBy(id = "confirmPassword")
	WebElement confPsw;
	
	@FindBy(id = "role1")
	WebElement userRole;
	
	@FindBy(name = "_eventId_billing")
	WebElement submit;
	
	public SignUpPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void SignUpFunction(String fNameVal, String lNameVal, String eMailVal, String cNumVal, String pswVal) {
		
		signUpLink.click();
		test.log(LogStatus.PASS, "SignUp link clicked successfully");
		
		fName.sendKeys(fNameVal);
		test.log(LogStatus.PASS, "Enter First Name", "First Name entered successfully");
		
		lName.sendKeys(lNameVal);
		test.log(LogStatus.PASS, "Enter Last Name", "Last Name entered successfully");
		
		eMail.sendKeys(eMailVal);
		test.log(LogStatus.PASS, "Enter email", "Email entered successfully");
		
		cNum.sendKeys(cNumVal);
		test.log(LogStatus.PASS, "Enter number", "Contact number entered successfully");
		
		psw.sendKeys(pswVal);
		test.log(LogStatus.PASS, "Enter password", "Password entered successfully");
		
		confPsw.sendKeys(pswVal);
		test.log(LogStatus.PASS, "Confirm password", "Password confirmed successfully");
		
		userRole.click();
		test.log(LogStatus.PASS, "User role chosen successfully");
		
		submit.click();
		test.log(LogStatus.PASS, "Submitted successfully");
		
}
}