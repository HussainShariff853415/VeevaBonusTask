package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import basePack.BaseClass;
import cucumber.api.java.en.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.*;
import pages.CalorieIntakeCalculation;

public class StepDefinitionCalorieIntakeCalculation {
	
	
	 WebDriver driver;
	 CalorieIntakeCalculation obj = new CalorieIntakeCalculation(driver);
	 
	 @Given("^Launch the application in a browser$")
	 public void launch_the_application_in_a_browser() throws IOException, InterruptedException {
		 BaseClass bs=new BaseClass(driver);
		 bs.toIntialize();
 
	 }
	
	

	@When("^user enters the age ([^\"]*)$")
	 public void user_enters_the_age(Integer age) {

		obj.enterAge(age);
	 
	 }

	 @When("^clicks male radio button for geneder selection$")
	 public void clicks_male_radio_button_for_geneder_selection() {

		 obj.selectGender();
	 
	 }

	 @When("^Enters Height ([^\"]*) weight ([^\"]*) in respective text fields$")
	 public void enters_Height_weight_in_respective_text_fields(Integer height, Integer weight) 
	 {
		obj.enterHeightAndWeight(height, weight); 
	 }

	 @When("^selects activity ([^\"]*) from the dropdown box and clicks calcutlate button$")
	 public void selects_activity_Moderate_from_the_dropdown_box_and_clicks_calcutlate_button(String activity) {
	     
		 obj.activityDropdown(activity);
		 obj.clickCalculateButton();
	 }

	 @Then("^user should see calorie intake per day under results$")
	 public void user_should_see_calorie_intake_per_day_under_results() throws IOException {
		 
		 obj.verifyTheResult();
	 } 
	 
	 
	 
	
	
	

}
