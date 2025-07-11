
package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LinkedInProfilePage;

public class UpdateProfileTest extends BaseTest {

    @Test
    public void updateHeadlineAndSearch() {
        LinkedInProfilePage profile = new LinkedInProfilePage(driver);

        profile.login(
            configProp.getProperty("username").trim(),
            configProp.getProperty("password").trim(),
            locatorsProp.getProperty("username_locator"),
            locatorsProp.getProperty("password_locator"),
            locatorsProp.getProperty("signIn_Button")
        );

        profile.updateHeadline(
            "https://www.linkedin.com/in/rohith-damavarapu-72290b215/edit/forms/intro/new/?profileFormEntryPoint=PROFILE_SECTION",
            locatorsProp.getProperty("text_box"),
            configProp.getProperty("update_message"),
            "//button[@class='artdeco-button artdeco-button--2 artdeco-button--primary ember-view']"
        );

        String feedUrl = "https://www.linkedin.com/feed/";
        String searchText = locatorsProp.getProperty("search_job_title");

        profile.searchAndClickTab(searchText, locatorsProp.getProperty("select_jobs"), locatorsProp.getProperty("search_space"), feedUrl);
        profile.searchAndClickTab(searchText, locatorsProp.getProperty("select_groups"), locatorsProp.getProperty("search_space"), feedUrl);
        profile.searchAndClickTab(searchText, locatorsProp.getProperty("select_people"), locatorsProp.getProperty("search_space"), feedUrl);
    }
}
