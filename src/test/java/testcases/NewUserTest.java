package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.SignUpPage;



public class NewUserTest extends BaseClass{
	//@Ignore
	@Test (priority=3)
	 @Parameters({"Param3","Param4","Param5","Param6","Param7"}) 
	 public void ParameterizedTest(String fNameVal, String lNameVal, String eMailVal, String cNumVal, String pswVal) throws InterruptedException {
		 SignUpPage login = new SignUpPage();
		 login.SignUpFunction(fNameVal,lNameVal,eMailVal,cNumVal,pswVal);
		 
		 Thread.sleep(5000);
		 
		 WebElement addressOne = driver.findElement(By.xpath("//*[@id='addressLineOne']"));
		 addressOne.sendKeys("13 Halloween Road");
		 test.log(LogStatus.PASS, "Address line one", "Address line one entered successfully");
		 
		 WebElement addressTwo = driver.findElement(By.xpath("//*[@id='addressLineTwo']"));
		 addressTwo.sendKeys("Near Blood river");
		 test.log(LogStatus.PASS, "Address line two", "Address line two entered successfully");
		 
		 WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
		 city.sendKeys("Hell for Certain");
		 test.log(LogStatus.PASS, "City", "City name entered successfully");
		 
		 WebElement pc = driver.findElement(By.xpath("//*[@id='postalCode']"));
		 pc.sendKeys("131313");
		 test.log(LogStatus.PASS, "PC", "Postal code entered successfully");
		 
		 WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
		 state.sendKeys("Kentucky");
		 test.log(LogStatus.PASS, "State", "Name of the state entered successfully");
		 
		 WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
		 country.sendKeys("USA");
		 test.log(LogStatus.PASS, "Country", "Country name entered successfully");
		 
		 Thread.sleep(3000);
		 WebElement submit = driver.findElement(By.xpath("//*[@name='_eventId_confirm']"));
		 submit.click();
		 
		 Thread.sleep(5000);
		 
		 WebElement confirm = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary']"));
		 confirm.click();
		 
		 Thread.sleep(5000);
		 
		 WebElement confirmation = driver.findElement(By.xpath("//*[@class='text-center']/h6")); 
		 String confText = confirmation.getText();
		 String ExpMsg = "You can use your email address as username to login!";
		 Assert.assertEquals(confText, ExpMsg);
		 test.log(LogStatus.PASS, "sign up", "New user signed up successfully");
		 
		 Thread.sleep(3000);
		 WebElement loginBtn = driver.findElement(By.xpath("//*[@href='/medicare/login']"));
		 loginBtn.click();
		 
		 Thread.sleep(3000);
		 
		 
		 WebElement email = driver.findElement(By.xpath("//*[@id='username']"));
		 email.sendKeys(eMailVal);
		 test.log(LogStatus.PASS, "Email", "Email entered successfully");
		 
		 WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		 password.sendKeys(pswVal);
		 test.log(LogStatus.PASS, "Password", "Password entered successfully");
		 
		 WebElement lgnBtn = driver.findElement(By.xpath("//*[@type='submit']"));
		 lgnBtn.click();
		 		 
		 
		 WebElement confirmLogin = driver.findElement(By.xpath("//*[@id='dropdownMenu1']")); 
		 String confirmText = confirmLogin.getText();
		 String ExpMsg1 = "Mary Campbell";
		 Assert.assertEquals(confText, ExpMsg);
		 test.log(LogStatus.PASS, "sign up", "New user logged in successfully");
		 
		
}
}
