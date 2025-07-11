
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class LinkedInProfilePage {
    WebDriver driver;

    public LinkedInProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password, String userLocator, String passLocator, String buttonLocator) {
        driver.findElement(By.xpath(userLocator)).sendKeys(username);
        driver.findElement(By.xpath(passLocator)).sendKeys(password);
        driver.findElement(By.xpath(buttonLocator)).click();
    }

    public void updateHeadline(String editPageUrl, String textBoxLocator, String newHeadline, String saveButtonXpath) {
        driver.get(editPageUrl);
        WebElement textBox = driver.findElement(By.xpath(textBoxLocator));
        textBox.clear();
        textBox.sendKeys(newHeadline);
        WebElement saveBtn = driver.findElement(By.xpath(saveButtonXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
    }

    public void searchAndClickTab(String searchText, String tabXpath, String searchBoxXpath, String feedUrl) {
        driver.navigate().to(feedUrl);
        WebElement searchBox = driver.findElement(By.xpath(searchBoxXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);
        searchBox.sendKeys(searchText, Keys.ENTER);
        driver.findElement(By.xpath(tabXpath)).click();
    }
}
