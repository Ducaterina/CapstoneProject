package testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class ViewProductsTest extends BaseClass {
	//@Ignore
	 @Test (priority=0)
	 @Parameters({"Param1","Param2"}) 
	 public void ParameterizedTest(String UserNameVal, String PasswordVal) throws InterruptedException {
		 LoginPage login = new LoginPage();
		 login.LoginFunction(UserNameVal, PasswordVal);
		 
		 Thread.sleep(3000);
	 
	 
		 WebElement allProducts = driver.findElement(By.xpath("//*[@href='/medicare/show/all/products']"));
		 allProducts.click();
		 test.log(LogStatus.PASS, "View Products", "View Products clicked successfully");
		 
		 WebElement allOption = driver.findElement(By.xpath("//*[@id=\"productListTable_length\"]/label/select/option[4]"));
		 allOption.click();
		 test.log(LogStatus.PASS, "View all Products", "View ALL Products clicked successfully");
		 test.log(LogStatus.PASS, "Products displayed on the page:");
		 
		 List<WebElement> drugs = driver.findElements(By.xpath("//*[@id=\"productListTable\"]/tbody/tr/td[2]"));
			
			int i = 1;
			for (WebElement drgs : drugs) {
				System.out.print(i++);
				System.out.println("\t" + drgs.getText());
				
				test.log(LogStatus.PASS, "\t" + drgs.getText());
			}
			
			
	 }
	 
}
