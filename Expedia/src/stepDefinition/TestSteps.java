package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import POM.ExpediaPage;

public class TestSteps {
	public static String DriverPath = System.getProperty("user.dir") + "\\src\\Driver\\";
	private static WebDriver driver = null;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", DriverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.expedia.com");
		driver.manage().window().maximize();
	}

	@When("^User Look For Flights Round Trip$")
	public void user_Look_For_Flights_Round_Trip() throws Throwable {
		Thread.sleep(3000);
		ExpediaPage.FlightTab(driver).click();
	}

	@When("^User Enters Source as \"(.*?)\"$")
	public void user_Enters_Source_as(String arg1) throws Throwable {
		ExpediaPage.FlightSource(driver).click();
		ExpediaPage.FlightSource(driver).clear();
		ExpediaPage.FlightSource(driver).sendKeys(arg1);
		Thread.sleep(3000);
		driver.switchTo().activeElement().sendKeys(Keys.DOWN, Keys.ENTER);

	}

	@When("^User Enters Destination as \"(.*?)\"$")
	public void user_Enters_Destination_as(String arg1) throws Throwable {
		ExpediaPage.FlightDestination(driver).click();
		ExpediaPage.FlightDestination(driver).clear();
		ExpediaPage.FlightDestination(driver).sendKeys(arg1);
		Thread.sleep(3000);
		driver.switchTo().activeElement().sendKeys(Keys.DOWN, Keys.ENTER);

	}

	@When("^User Enters Departing date$")
	public void user_Enters_Departing_date() throws Throwable {
		ExpediaPage.FlightDepartingDate(driver).click();
		ExpediaPage.FlightDepartingDate(driver).clear();
		String date = getDate(1);
		ExpediaPage.FlightDepartingDate(driver).sendKeys(date);
		Thread.sleep(2000);

	}

	@When("^User Enters Returning date$")
	public void user_Enters_Returning_date() throws Throwable {
		String date = getDate(6);
		ExpediaPage.FlightReturningDate(driver).click();
		ExpediaPage.FlightReturningDate(driver).clear();
		// clear not working as date picker auto fill it so hard code for clear
		for (int i = 0; i < 12; i++) {
			ExpediaPage.FlightReturningDate(driver).sendKeys(Keys.BACK_SPACE);
		}
		ExpediaPage.FlightReturningDate(driver).sendKeys(date);
		Thread.sleep(2000);

	}

	@Then("^User Click On Search Button$")
	public void user_Click_On_Search_Button() throws Throwable {

		ExpediaPage.FlightSearch(driver).click();
	}

	@Then("^User Displayed Successfully Search$")
	public void user_Displayed_Successfully_Search() throws Throwable {
		Thread.sleep(5000);
		if (ExpediaPage.FlightSort(driver).isEnabled()) {
			System.out.println("Flights searched successfully.");
		} else {
			System.out.println("Flights are not available.");
			throw new RuntimeException("Flights are not available.");
		}
	}

	@Then("^User Sort by Departure Earliest flight$")
	public void user_Sort_by_Departure_Earliest_flight() throws Throwable {
		
		ExpediaPage.FlightSort(driver).click();
		new Select(ExpediaPage.FlightSort(driver)).selectByVisibleText("Departure (Earliest)");

	}

	@Then("^User Select an early departing flight\\.$")
	public void user_Select_an_early_departing_flight() throws Throwable {
		Thread.sleep(3000);
		WebElement element = ExpediaPage.FlightSelect(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		try {
			ExpediaPage.FlightSelectFair(driver).click();
		} catch (Exception e) {
		}

	}

	@Then("^User Sort by an Arrival Earliest for selecting return flight$")
	public void user_Sort_by_an_Arrival_Earliest_for_selecting_return_flight() throws Throwable {
		Thread.sleep(3000);
		ExpediaPage.FlightSort(driver).click();
		new Select(ExpediaPage.FlightSort(driver)).selectByVisibleText("Arrival (Earliest)");

	}

	@Then("^User Select an Arrival Earliest flight$")
	public void user_Select_an_Arrival_Earliest_flight() throws Throwable {
		Thread.sleep(3000);
		WebElement element = ExpediaPage.FlightSelect(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);

		Thread.sleep(3000);
		try {
			ExpediaPage.FlightSelectFair(driver).click();
		} catch (Exception e) {
		}

		Thread.sleep(3000);
		try {
			ExpediaPage.Nothanks(driver).click();
		} catch (Exception e) {
		}

	}

	@Then("^User Continue as Guest for booking$")
	public void user_Continue_as_Guest_for_booking() throws Throwable {

		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		ExpediaPage.FlightBook(driver).click();
	}

	public String getDate(int addDaystoToday) {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, addDaystoToday);
		dt = c.getTime();

		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(dt);
		return date;
	}

}
