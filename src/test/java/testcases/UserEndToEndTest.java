package testcases;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;


public class UserEndToEndTest extends BaseClass {
	
	//@Ignore
	 @Test (priority=1)
	 @Parameters({"Param1","Param2"}) 
	 public void ParameterizedTest(String UserNameVal, String PasswordVal) throws InterruptedException {
		 LoginPage login = new LoginPage();
		 login.LoginFunction(UserNameVal, PasswordVal);
		 
		 Thread.sleep(3000);
		 
		 WebElement analgesics = driver.findElement(By.xpath("//*[@id='a_Analgesics']"));
		 analgesics.click();
		 
		 Thread.sleep(3000);
		 
		 WebElement diclofenac = driver.findElement(By.xpath("//*[@href='/medicare/show/3/product']"));
		 diclofenac.click();
		 Thread.sleep(3000);
		 
		 WebElement diclofenacAdd = driver.findElement(By.xpath("//*[@href='/medicare/cart/add/3/product']"));
		 diclofenacAdd.click();
		 test.log(LogStatus.PASS, "Add Diclofenac to cart", "1 Diclofenac added successfully");
		 Thread.sleep(3000);
		 
		 WebElement contShopping = driver.findElement(By.xpath("//*[@class='btn btn-warning']"));
		 contShopping.click();
		 
		 Thread.sleep(3000);
		 WebElement antibiotics = driver.findElement(By.id("a_Antibiotics"));
		 antibiotics.click();
		 
		 Thread.sleep(3000);
		 WebElement amoxicillin = driver.findElement(By.xpath("//*[@href='/medicare/show/5/product']"));
		 amoxicillin.click();
		 
		 Thread.sleep(3000);
		 WebElement amoxicillinAdd = driver.findElement(By.xpath("//*[@href='/medicare/cart/add/5/product']"));
		 amoxicillinAdd.click();
		 test.log(LogStatus.PASS, "Add Amoxicillin to cart", "1 Amoxicillin added successfully");
		 Thread.sleep(3000);
		 
		 WebElement total = driver.findElement(By.xpath("//*[@class='hidden-xs text-center']")); 
		 String totalText = total.getText();
		 String ExpMsg = "Total ₹ 84.0/-";
		 Assert.assertEquals(totalText, ExpMsg);
		 test.log(LogStatus.PASS, "Check the total", "Total ₹ 84.0/-");
				
		 Thread.sleep(3000);
		 WebElement checkOut = driver.findElement(By.xpath("//*[@href='/medicare/cart/validate']"));
		 checkOut.click();
		 test.log(LogStatus.PASS, "Checkout", "Successfully proceeded to checkout");
		 
		 WebElement addressOne = driver.findElement(By.xpath("//*[@id='addressLineOne']"));
		 addressOne.sendKeys("102 Sabarmati Society, Mahatma Gandhi Road");
		 test.log(LogStatus.PASS, "Address line one", "Address line one entered successfully");
		 
		 WebElement addressTwo = driver.findElement(By.xpath("//*[@id='addressLineTwo']"));
		 addressTwo.sendKeys("Near Salt Lake, Gandhi Nagar");
		 test.log(LogStatus.PASS, "Address line two", "Address line two entered successfully");
		 
		 WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
		 city.sendKeys("Ahmedabad");
		 test.log(LogStatus.PASS, "City", "City name entered successfully");
		 
		 WebElement pc = driver.findElement(By.xpath("//*[@id='postalCode']"));
		 pc.sendKeys("111111");
		 test.log(LogStatus.PASS, "PC", "Postal code entered successfully");
		 
		 WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
		 state.sendKeys("Gujarat");
		 test.log(LogStatus.PASS, "State", "Name of the state entered successfully");
		 
		 WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
		 country.sendKeys("India");
		 test.log(LogStatus.PASS, "Country", "Country name entered successfully");
		 
		 Thread.sleep(3000);
		 WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		 submit.click();
		 
		 Thread.sleep(3000);
		 
		 WebElement finalPayment = driver.findElement(By.xpath("//*[@class='badge pull-right']")); 
		 String fPText = finalPayment.getText();
		 String ExpMsg1 = "₹ 84.0/-";
		 Assert.assertEquals(fPText, ExpMsg1);
		 test.log(LogStatus.PASS, "Final payment", "Final payment ₹ 84.0/-");
		 
	 }
	 
}
