package com.vtiger.stepdefination;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstepdefination {

	public WebDriver driver;
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() 
	{
		System.setProperty("webdriver.chrome.driver","C:/SOFTWARE/chromedriver.exe");
	     driver=new ChromeDriver();
	     driver.get("http://localhost:100/");
	     driver.manage().window().maximize();
	}
	@When("user enter valid credentials and click on login button")
	public void user_enter_valid_credentials_and_click_on_login_button() 
	{
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='Login']")).click();  
	}
	@Then("user should navigate to home page")
	public void user_should_navigate_to_home_page() 
	{
		driver.findElement(By.xpath("(//a[text()='Home'])[1]")).isDisplayed();
	}
	@Then("user click on logout link")
	public void user_click_on_logout_link() 
	{
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	@When("user enter Invalid credentials and click on login button")
	public void user_enter_invalid_credentials_and_click_on_login_button() 
	{
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@name='Login']")).click();     
	}
	
	@Then("user should navigate to login page")
	public void user_should_navigate_to_login_page() 
	{
		 driver.findElement(By.xpath("//input[@name='Login']")).isDisplayed();
	}
	
	@Then("user can see error message")
	public void user_can_see_error_message() 
	{
		driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();
	}
	
	@When("user enter Invalid userid {string} and password {string} credentials and click on login button")
	public void user_enter_invalid_userid_and_password_credentials_and_click_on_login_button(String string, String string2) 
	{
		driver.findElement(By.xpath("//input[@name='user_name']")).clear();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(string);
		driver.findElement(By.xpath("//input[@name='user_password']")).clear();
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(string2);
        driver.findElement(By.xpath("//input[@name='Login']")).click();
	}
	
	@When("user click on new lead link")
	public void user_click_on_new_lead_link() 
	{
		driver.findElement(By.xpath("//a[text()='New Lead']")).click();    
	}
	@When("fill mandatory field and click on save button")
	public void fill_mandatory_field_and_click_on_save_button() 
	{
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Modi");
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("BJP");
        driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	}
	@Then("lead should be created successfully")
	public void lead_should_be_created_successfully() 
	{
		driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals("Modi");
		driver.findElement(By.xpath("//td[text()='Company:']/following::td[1]")).getText().equals("BJP");
	}
	
	@When("user should create multiple link lastname {string} and company {string} and varified")
	public void user_should_create_multiple_link_lastname_and_company_and_varified(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		List<Map<String,String>> dt =dataTable.asMaps();
		
		for(Map<String,String> m:dt) 
		{
			driver.findElement(By.xpath("//a[text()='New Lead']")).click(); 
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(m.get(string));
	        driver.findElement(By.xpath("//input[@name='company']")).sendKeys(m.get(string2));
	        driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	        driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals(string);
			driver.findElement(By.xpath("//td[text()='Company:']/following::td[1]")).getText().equals(string2);
		}
		
		
	}
}
