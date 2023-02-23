package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.support.ui.ExpectedConditions;  
import org.openqa.selenium.support.ui.FluentWait;  
import org.openqa.selenium.support.ui.Wait;  
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;  
import java.util.concurrent.TimeUnit;  
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;  

public class CalorieIntakeCalculation {

	
	
WebDriver driver;
	
	public CalorieIntakeCalculation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='cage']")
	WebElement ageTextFIeld;
	
	@FindBy(xpath = "//td[contains(text(),'Gender')]//following-sibling::td//label[1]//span")
	WebElement genderMale;
	
	@FindBy(xpath = "//input[@id='cheightmeter']")
	WebElement heightTextField;
		
	
	@FindBy(xpath = "//input[@id='ckg']")
	WebElement weightTextField;
	
	@FindBy(xpath = "//select[@id='cactivity']")
	WebElement activityDropdown;
	
	@FindBy(xpath = "//input[@value='Calculate']")
	WebElement calculateButton;
	
	@FindBy(xpath = "//h2[contains(text(),'Result')]")
	WebElement result;
	
	
	static Logger logger = LogManager.getLogger(CalorieIntakeCalculation.class);
	
	
	public void enterAge(int age)
	{
		ageTextFIeld.sendKeys(String.valueOf(age));
		logger.info("Entered the age in age text field");
			
	}
	
	public void selectGender()
	{
		genderMale.click();
		logger.info("selected male radio button");
	}
	
	
	public void enterHeightAndWeight(int height, int weight)
	{
		heightTextField.sendKeys(String.valueOf(height), String.valueOf(weight));	
		logger.info("Entered height and weight");
	}
	
	
	public void activityDropdown(String activity)
	{
		Select select = new Select(activityDropdown);
		select.selectByVisibleText(activity);	
		logger.info("selected activity as " + activity);
	}
	
	
	public void clickCalculateButton()
	{
		calculateButton.click();
		logger.info("clicked calculate button");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   
	}
	

	public boolean verifyTheResult() throws IOException
	{
		if(result.isDisplayed())
		{
			logger.info("result generated");
			
			//taking snapshot of this result
			this.toTakeSnapshot(driver, "C:\\Users\\Home\\Desktop") ;
			
			for(int row=1;  row<7; row ++)
			{
				for (int column=1; column<7; column++)
				{
					WebElement printTheText = driver.findElement(By.xpath("//tbody[@xpath='1']//tr[" + row + "]//td["+column+"]"));
					System.out.print(printTheText+ "  |  ");
				}	
				System.out.println("-------------------------------------------------------------------------------------");	
			}
		}
		else
		{
			logger.info("results are not displayed on the page");
		}
		return result.isDisplayed();	
	}
	
	
	
	public static void toTakeSnapshot(WebDriver driver,String filePath) throws IOException
	{
		//we are gonna convert the webdriver object to screenshot 
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		//calling the method getScreenshotas so that it will create a file in form of an image
	
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		
		//providing a destination to move this image file
		File destinationFile =new File(filePath);
		
		//Copy file at destination
		FileUtils.copyFile(SrcFile, destinationFile);
		
	}
	
	
	
}
