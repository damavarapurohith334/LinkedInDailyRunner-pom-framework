package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import base.BaseTest;  // Import BaseTest for accessing static test instance
import com.aventstack.extentreports.Status;

public class LinkedInProfilePage {
    WebDriver driver;

    public LinkedInProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password, String userLocator, String passLocator, String buttonLocator) {
        driver.findElement(By.xpath(userLocator)).sendKeys(username);
        BaseTest.test.log(Status.INFO, "Entered username");
        
        driver.findElement(By.xpath(passLocator)).sendKeys(password);
        BaseTest.test.log(Status.INFO, "Entered password");
        
        driver.findElement(By.xpath(buttonLocator)).click();
        BaseTest.test.log(Status.INFO, "Clicked login button");
    }

    public void updateHeadline(String editPageUrl, String textBoxLocator, String newHeadline, String saveButtonXpath) {
        driver.get(editPageUrl);
        BaseTest.test.log(Status.INFO, "Navigated to headline edit page: " + editPageUrl);
        
        WebElement textBox = driver.findElement(By.xpath(textBoxLocator));
        textBox.clear();
        BaseTest.test.log(Status.INFO, "Cleared headline textbox");
        
        textBox.sendKeys(newHeadline);
        BaseTest.test.log(Status.INFO, "Entered new headline: " + newHeadline);
        
        WebElement saveBtn = driver.findElement(By.xpath(saveButtonXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
        BaseTest.test.log(Status.INFO, "Clicked save button to update headline");
    }

    public void searchAndClickTab(String searchText, String tabXpath, String searchBoxXpath, String feedUrl) {
        driver.navigate().to(feedUrl);
        BaseTest.test.log(Status.INFO, "Navigated to feed URL: " + feedUrl);

        WebElement searchBox = driver.findElement(By.xpath(searchBoxXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);
        searchBox.sendKeys(searchText, Keys.ENTER);
        BaseTest.test.log(Status.INFO, "Performed search for text: " + searchText);

        driver.findElement(By.xpath(tabXpath)).click();
        BaseTest.test.log(Status.INFO, "Clicked on tab with XPath: " + tabXpath);
    }
}
