package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Definition {
	WebDriver driver;
	@Given("^login application should be launched$")
	public void login_application_should_be_launched() throws Throwable {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\SOWJANYATHATIKONDA\\Documents\\EFMS - A\\Selenium\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://opensource-demo.orangehrmlive.com/");
	}

	@When("^test login with valid credentials$")
	public void test_login_with_valid_credentials() throws Throwable {
			  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
				driver.findElement(By.id("txtPassword")).sendKeys("admin123");
				driver.findElement(By.id("btnLogin")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='wrapper']/div/a[2]")).click();
				Thread.sleep(3000);
				WebDriverWait mywait=new WebDriverWait(driver,10);
				mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")));
				driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
	   
	}

	@Then("^Login should be succesfull\\.$")
	public void login_should_be_succesfull() throws Throwable {
	   String ExpectedTitle="OrangeHRM";
	   String ActualTitle=driver.getTitle();
	   Assert.assertEquals(ExpectedTitle, ActualTitle);
	  	   driver.close();
	    
	}

}
