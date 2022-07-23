package gluecode;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class stepDefination {

	WebDriver driver;

	@Given("^Login page of zerobank open$")
	
	public void Openapp() {
		System.setProperty("Webdriver.Chrome.driver", "Chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^valid username \"(.*)\" and password \"(.*)\" enter$")
	public void EnterCredential(String LoginName , String LoginPassword) {
		driver.findElement(By.id("user_login")).sendKeys("LoginName");
		driver.findElement(By.id("user_password")).sendKeys("password");

	}

	@And("^enter login Button$")
	public void clicksignin() {

		driver.findElement(By.name("submit")).click();

	}

	@Then("^Login succeessful$")

	public void loginsuccessful() {

		driver.navigate().back();
		boolean tf = driver.findElement(By.linkText("Transfer Funds")).isDisplayed();
        Assert.assertTrue(tf);
	}
}
