package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getEditProfileBtn() {
		return this.driver.findElement(By.xpath("//*[@class='action-profile']/a[2]"));
	}
	
	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getEmail() {
		return this.driver.findElement(By.name("user_email"));
	}
	
	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhoneNo() {
		return this.driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}
	
	public Select getCountry() {
		WebElement selectCountry = this.driver.findElement(By.id("user_country_id"));
		return new Select(selectCountry);
	}
	
	public Select getState() {
		WebElement selectState = this.driver.findElement(By.id("user_state_id"));
		return new Select(selectState);
	}
	
	public Select getCity() {
		WebElement selectCity = this.driver.findElement(By.id("user_city_id"));
		return new Select(selectCity);
	}
	
	public WebElement getSaveProfileBtn() {
		List<WebElement> buttons = this.driver.findElements(By.name("btn_submit"));
		return buttons.get(0);
	}
	
	public WebElement getCurrentPassword() {
		return this.driver.findElement(By.name("current_password"));
	}
	
	public void getUploadPhotoBtn() {
		WebElement uploadBtn = this.driver.findElement(By.className("uploadFile-Js"));
		js.executeScript("arguments[0].click()", uploadBtn);
	}
	
	public void setProfilePhoto(String photoPath) {
		getUploadPhotoBtn();
	}
	
	public void removePhoto() {
		WebElement remove = this.driver.findElement(By.className("remove"));
		js.executeScript("arguments[0].click();", remove);
	}
	
	public void editProfileInfomations(String firstName, String LastName, String email, 
										String address, String phone, String zipCode,
										String country, String state, String city) throws InterruptedException {

		getFirstName().sendKeys(Keys.chord(Keys.CONTROL, "a", firstName));
		getLastName().sendKeys(Keys.chord(Keys.CONTROL, "a", LastName));
		getEmail().sendKeys(Keys.chord(Keys.CONTROL, "a", email));
		getAddress().sendKeys(Keys.chord(Keys.CONTROL, "a", address));
		getPhoneNo().sendKeys(Keys.chord(Keys.CONTROL, "a", phone));
		getZipCode().sendKeys(Keys.chord(Keys.CONTROL, "a", zipCode));
		getCountry().selectByValue(Keys.chord(Keys.CONTROL, "a", country));
		Thread.sleep(3000);
		getState().selectByValue(Keys.chord(Keys.CONTROL, "a", state));
		Thread.sleep(3000);
		getCity().selectByValue(Keys.chord(Keys.CONTROL, "a", city));
		getSaveProfileBtn().click();
	}
}
