package tsum.ui.automation.pages;

import org.openqa.selenium.By;
import tsum.ui.automation.basics.BasePage;
import tsum.ui.automation.models.RegistrationModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProfilePage extends BasePage {

    public boolean isProfilePage() {
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(By.cssSelector("a[href=\"/personal/?logout=yes\"]"));
        return this.getCurrentUrl().equalsIgnoreCase("https://www.tsum.ru/personal/profile/");
    }

    public boolean matchModelData(RegistrationModel data) {
        List<Boolean> matchResult = new ArrayList<>();
        matchResult.add(getCurrentUser().equalsIgnoreCase(data.getName()));
        matchResult.add(getProfileName().equalsIgnoreCase(data.getName()));
        matchResult.add(getProfileEmail().equalsIgnoreCase(data.geteMail()));
        matchResult.add(getProfilePhoneNumber().equalsIgnoreCase(data.getPhoneNumber()));
        String modelBirthday = new SimpleDateFormat("dd/MM/YYYY").format(data.getBirthDate());
        matchResult.add(getProfileBirthday().equals(modelBirthday));
        return matchResult.stream().allMatch(p -> p);
    }

    public void logout() {
        highlightClick(By.cssSelector("a[href=\"/personal/?logout=yes\"]"));
        waitForRenderedElementsToDisappear(By.cssSelector("a[href=\"/personal/?logout=yes\"]"));
    }

    // region profile values getters

    private String getCurrentUser() {
        return highlightFind(By.cssSelector(".header__private")).getText();
    }

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

    private String getProfileBirthday() {
        return highlightFind(By.cssSelector(".field input[name=FIELDS\\[PERSONAL_BIRTHDAY\\]]")).getAttribute("value");
    }

    // endregion

}
