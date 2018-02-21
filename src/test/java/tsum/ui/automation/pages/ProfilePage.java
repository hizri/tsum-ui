package tsum.ui.automation.pages;

import org.openqa.selenium.By;
import tsum.ui.automation.basics.BasePage;
import tsum.ui.automation.models.RegistrationModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProfilePage extends BasePage {

    public boolean isProfilePage() {
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(By.cssSelector("a[href=\"/personal/?logout=yes\"]"));
        return this.getCurrentUrl().equalsIgnoreCase("https://www.tsum.ru/personal/profile/");
    }

    public void logout() {
        highlightClick(By.cssSelector("a[href=\"/personal/?logout=yes\"]"));
        waitForRenderedElementsToDisappear(By.cssSelector("a[href=\"/personal/?logout=yes\"]"));
    }


    public String getActiveProfileTitle() {
        return highlightFind(By.cssSelector(".header__private .header__link")).getText();
    }


    public RegistrationModel getSavedData() {
        RegistrationModel data = new RegistrationModel();
        data.setName(getProfileName());
        data.seteMail(getProfileEmail());
        data.setPhoneNumber(getProfilePhoneNumber());
        data.setBirthDate(getProfileBirthday());
        return data;
    }
    // region profile values getters

    private String getProfileName() {
        return highlightFind(By.cssSelector("input.js-input-name")).getAttribute("value");
    }

    public String getProfileSurname() {
        return highlightFind(By.cssSelector("input.js-input-surname")).getAttribute("value");
    }

    private String getProfileEmail() {
        return highlightFind(By.cssSelector(".field_type_email input")).getAttribute("value");
    }

    private String getProfilePhoneNumber() {
        return highlightFind(By.cssSelector(".field_type_tel input")).getAttribute("value").replaceAll("\\W", "");
    }

    private Date getProfileBirthday() {
        String profileBirthday = highlightFind(By.cssSelector(".field input[name=FIELDS\\[PERSONAL_BIRTHDAY\\]]")).getAttribute("value");
        Date profileBirthdayDate = null;
        if (!profileBirthday.isEmpty()) {
            try {
                profileBirthdayDate = new SimpleDateFormat("d/MM/yyyy").parse(profileBirthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return profileBirthdayDate;
    }

    // endregion

}
