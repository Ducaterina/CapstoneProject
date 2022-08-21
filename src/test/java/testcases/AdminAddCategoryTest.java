package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class AdminAddCategoryTest extends BaseClass{
	
	//@Ignore
	 @Test (priority=2)
	 @Parameters({"Param8","Param9"}) 
	 public void ParameterizedTest(String UserNameVal, String PasswordVal) throws InterruptedException {
		 LoginPage login = new LoginPage();
		 login.LoginFunction(UserNameVal, PasswordVal);
		 test.log(LogStatus.PASS, "Login", "Logged in as admin successfully");
		 
		 Thread.sleep(3000);
		 
		 WebElement manage = driver.findElement(By.xpath("//*[@href='/medicare/manage/product']"));
		 manage.click();
		 test.log(LogStatus.PASS, "Manage Products", "Manage Products clicked successfully");
		 
		 Thread.sleep(3000);
		 
		 WebElement addCategory = driver.findElement(By.xpath("//*[@class='btn btn-warning btn-xs']"));
		 addCategory.click();
		 test.log(LogStatus.PASS, "Add", "Add New Category clicked successfully");
		 Thread.sleep(3000);
		 
		 WebElement nameCat = driver.findElement(By.xpath("//*[@id='categoryForm']//*[@id='name']"));
		 nameCat.sendKeys("Vitamins");
		 test.log(LogStatus.PASS, "name", "Category name entered successfully");
		 
		 WebElement descriptionCat = driver.findElement(By.xpath("//*[@id='categoryForm']//*[@id='description']"));
		 descriptionCat.sendKeys("A dietary supplement containing all or most of the vitamins that may not be readily available in the diet. Vitamins may be classified according to their solubility either in lipids (vitamins A, D, E, K, F) or in water (vitamins C, B-complex).");
		 test.log(LogStatus.PASS, "Description", "Category description entered successfully");
		 
		 WebElement save = driver.findElement(By.xpath("//*[@id='categoryForm']//*[@name='submit']"));
		 save.click();
		 test.log(LogStatus.PASS, "Save", "Save category clicked successfully");
		 
}
}