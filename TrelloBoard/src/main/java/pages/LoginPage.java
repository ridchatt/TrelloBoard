package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitHelper;

import pages.DashboardPage;

public class LoginPage {
	private WebDriver driver;
	WaitHelper waithelper;
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waithelper = new WaitHelper(driver);
    }

    private By loginLink = By.xpath("//div[contains(@class,'Buttonsstyles__ButtonGroup')]//a[text()='Log in']");
    private By emailField = By.id("username");
    private By continueButton = By.xpath("//button[@id=\"login-submit\"]");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-submit");
    private By logoutLink = By.cssSelector("button[data-testid='account-menu-logout']");
    private By userProfileLink = By.xpath("//button[contains(@class,\"js-open-header-member-menu\")]");

    

    public void enterEmail(String email) {
    	driver.findElement(loginLink).click();
    	waithelper.WaitForElement(emailField, 30);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(continueButton).click();
    }

    public void enterPassword(String password) {
    	waithelper.WaitForElement(passwordField, 30);
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLogin() {
    	waithelper.WaitForElement(loginButton, 30);
    	driver.findElement(loginButton).click();
    }
    
    public DashboardPage login(String email, String password){
    	driver.findElement(loginLink).click();
    	waithelper.WaitForElement(emailField, 30);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(continueButton).click();
        waithelper.WaitForElement(passwordField, 30);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
           
            return new DashboardPage(driver);
        }
    
    public void clickLogout(){
    	driver.findElement(userProfileLink).click();
    	waithelper.WaitForElement(logoutLink, 30);
    	driver.findElement(logoutLink).click();
    }

}
