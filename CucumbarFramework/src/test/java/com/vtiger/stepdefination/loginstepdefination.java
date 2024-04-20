package com.vtiger.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstepdefination {

	public WebDriver driver;
	
	@Given("user should on login page")
	public void user_should_on_login_page() 
	{
	 driver=new ChromeDriver();   
	 driver.get("http://localhost:100/");
	}
	@When("user enter vaild crediential")
	public void user_enter_vaild_crediential() 
	{
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='Login']")).click();
	}
	@Then("user should be on home page")
	public void user_should_be_on_home_page() 
	{
	   driver.findElement(By.xpath("(//a[text()='Home'])[1]")).isDisplayed();
	}
	@Then("user can see logout link")
	public void user_can_see_logout_link() 
	{
		driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
	}
	
	@When("user enter Invaild crediential")
	public void user_enter_invaild_crediential() 
	{
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin12");
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@name='Login']")).click();
	}
	@Then("user should be on login page")
	public void user_should_be_on_login_page() 
	{
		driver.findElement(By.xpath("//input[@name='Login']")).isDisplayed();
	}
	@Then("user can see error message")
	public void user_can_see_error_message() 
	{
		driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();
	}


}
