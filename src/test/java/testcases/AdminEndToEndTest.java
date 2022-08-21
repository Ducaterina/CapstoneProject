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

public class AdminEndToEndTest extends BaseClass{

	//@Ignore
	 @Test (priority=4)
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
		 
		 WebElement name = driver.findElement(By.xpath("//*[@id='name']"));
		 name.sendKeys("Multi Active");
		 test.log(LogStatus.PASS, "name", "Product name entered successfully");
		 
		 WebElement brand = driver.findElement(By.xpath("//*[@id='brand']"));
		 brand.sendKeys("BLACKMORES");
		 test.log(LogStatus.PASS, "Brand", "Product brand entered successfully");
		 
		 WebElement description = driver.findElement(By.xpath("//*[@id='description']"));
		 description.sendKeys("BLACKMORES Multi Active contains 20 amino acids, vitamins and minerals plus Artichoke leaf extract & Lutein");
		 test.log(LogStatus.PASS, "Description", "Product description entered successfully");
		 
		 WebElement price = driver.findElement(By.xpath("//*[@id='unitPrice']"));
		 price.clear();
		 price.sendKeys("897.0");
		 test.log(LogStatus.PASS, "Price", "Product price entered successfully");
		 
		 WebElement quantity = driver.findElement(By.xpath("//*[@id='quantity']"));
		 quantity.clear();
		 quantity.sendKeys("17");
		 test.log(LogStatus.PASS, "Quantity", "Product quantity entered successfully");
		 
		 WebElement file = driver.findElement(By.xpath("//*[@id='file']"));
		 test.log(LogStatus.PASS, "File", "Choose File clicked successfully");
		 Thread.sleep(3000);
		 file.sendKeys("C:\\Users\\thund\\eclipse-workspace-EE\\CapstoneProject\\Multivits.jfif");
		 
		 WebElement category = driver.findElement(By.xpath("//*[@id=\"categoryId\"]/option[4]"));
		 category.click();
		 test.log(LogStatus.PASS, "Category", "Product category chosen successfully");
		 
		 WebElement saveProduct = driver.findElement(By.xpath("//*[@id='product']//input[@name='submit']"));
		 saveProduct.click();
		 test.log(LogStatus.PASS, "Save", "Save product button clicked successfully");
		 
		 Thread.sleep(3000);
		 WebElement products = driver.findElement(By.xpath("//*[@href='/medicare/show/all/products']"));
		 products.click();
		 test.log(LogStatus.PASS, "View Products", "View Products clicked successfully");
		 Thread.sleep(3000);
		 WebElement allOption = driver.findElement(By.xpath("//*[@id=\"productListTable_length\"]/label/select/option[4]"));
		 allOption.click();
		 test.log(LogStatus.PASS, "View all Products", "View ALL Products clicked successfully");
		 
		 int a=1;
			
		 List<WebElement> drugs = driver.findElements(By.xpath("//*[@id=\"productListTable\"]/tbody/tr/td[2]"));
		 
		 a = drugs.size();
		 WebElement newDrug = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr["+a+"]/td[2]"));
		 
		 assertEquals(newDrug.getText(), "Multi Active");
		 
		 WebElement priceNew = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr["+a+"]/td[4]"));
		 assertEquals(priceNew.getText(), "₹ 897");		 
		 
		 
}
}