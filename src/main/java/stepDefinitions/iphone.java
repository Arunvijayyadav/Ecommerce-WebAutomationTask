package stepDefinitions;

import java.util.ArrayList;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class iphone {

	WebDriver driver;
	ArrayList <Object>fl;
	ArrayList <Object>al;
	int j;
	int i;
	String sitename;
	String sitenamea;



	@Given("User Opens the Browser")
	public void user_opens_the_browser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Desktop\\Automation Intrvie PDFs\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}


	@Given("User Enter the first URL\"amazon.in\"")
	public void user_enter_the_url_amazon_in() {
		driver.get("https://www.amazon.in");
		sitenamea = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@When("User enter {string} in first website search box")
	public void user_enter_in_search_box(String string) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		search.sendKeys("iphone 13");
		search.sendKeys(Keys.ENTER);

	}

	@When("User gets the product details from amazon")
	public void userGetsTheProductDetailsFromAmazon() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement iphoneEle = driver.findElement(By.xpath("(//span[contains(text(), 'Apple iPhone 13')])[1]"));
		String productName = iphoneEle.getText();

		WebElement iphonePrice = driver.findElement(By.xpath(
				"(//span[contains(text(), 'Apple iPhone 13')])[1]/parent::a/parent::h2/parent::div/parent::div/child::div[3]/child::div/child::div/child::div/child::div[2]/child::a/child::span/child::span[2]/child::span[2]"));
		String productPrice = iphonePrice.getText();
		productPrice = productPrice.replace(",","");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		i=Integer.parseInt(productPrice);

		iphoneEle.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();

		al= new ArrayList<Object>();
		al.add("Name of the Website -"+sitenamea);
		al.add("Name of the Product -"+productName);
		al.add("Price of the Product -"+i);
		al.add("Link to the Product -"+url);
	}

	@Given("User Opens second URL\"flipkart.com\"")
	public void user_opens_another_url_flipkart_com() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		driver.get("http://flipkart.com");
		sitename = driver.getCurrentUrl();
		WebElement btn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		btn.click();
	}

	@When("User enter {string} in second website search box")
	public void user_enter_in_second_website_search_box(String string) {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		search.sendKeys("iphone 13");
		search.sendKeys(Keys.ENTER);
	}

	@When("User gets the product details from flipkart")
	public void userGetsTheProductDetailsFromFlipkart() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		WebElement iphoneEle = driver.findElement(By.xpath("(//div[contains(text(), 'APPLE iPhone 13')])[3]"));
		String productName = iphoneEle.getText();

		WebElement iphonePrice = driver.findElement(By.xpath(
				"((//div[contains(text(), 'APPLE iPhone 13')])[3]/parent::div/parent::div/child::div[2]/child::div/child::div[1]/child::div[1])[1]"));
		String productPrice = iphonePrice.getText();
		productPrice = productPrice.replace(",","");

		productPrice = productPrice.replace("₹","");
		productPrice = productPrice.replace(",","");		

		j=Integer.parseInt(productPrice);  


		iphoneEle.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();

		fl = new ArrayList<Object>();
		fl.add("Name of the Website -"+sitename);
		fl.add("Name of the Product -"+productName);
		fl.add("Price of the Product -"+j);
		fl.add("Link to the Product -"+url);

	}

	@Then("User Validate the price on Amazon and Flipkart and prints in ascending order")
	public void user_validate_the_price() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(i>j) {
			System.out.println(al);
			System.out.println(fl);
		}
		else {
			System.out.println(fl);
			System.out.println(al);
		}

	}

}
