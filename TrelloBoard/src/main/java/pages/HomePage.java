package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitHelper;

public class HomePage {
	
	private WebDriver driver;
	WaitHelper waithelper;

    private By createNewBoardButton = By.xpath("//span[text()='Create new board']");
    private By boardTitleField = By.cssSelector("input[data-testid='create-board-title-input']");
    private By createBoardButton = By.cssSelector("button[data-testid='create-board-submit-button']");
    
    private By boardDeleteConfirmMessage = By.className("YEctMXs9uZbttS");
    private By boardNameErrorMessage = By.className("lWu5grh2rIDIym");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waithelper = new WaitHelper(driver);
    }

    public void clickCreateNewBoard() {
    	waithelper.WaitForElement(createNewBoardButton, 30);
        driver.findElement(createNewBoardButton).click();
    }

    public void enterBoardTitle(String title) {
    	waithelper.WaitForElement(boardTitleField, 30);
        driver.findElement(boardTitleField).sendKeys(title);
    }

    public void clickCreateBoardButton() {
    	waithelper.WaitForElement(createBoardButton, 30);
        driver.findElement(createBoardButton).click();
    }
    
    public String getBoardDeleteConfirmMessage() {
        return driver.findElement(boardDeleteConfirmMessage).getText();
    }
    
    public String getBoardNameErrorMessage() {
        return driver.findElement(boardNameErrorMessage).getText();
    }
    
    public boolean isCreateBoardButtonDisabled() {
        WebElement createButton = driver.findElement(createBoardButton);
        return !createButton.isEnabled();
    }

}
