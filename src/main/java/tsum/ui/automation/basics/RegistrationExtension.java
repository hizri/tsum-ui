package tsum.ui.automation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tsum.ui.automation.models.LoginModel;
import tsum.ui.automation.models.RegistrationModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationExtension extends BasePage {

    public void fillRegistrationForm(RegistrationModel data) {
        fillNameField(data.getName());
        chooseGender(data.getGender());
        fillBirthDate(data.getBirthDate());
        fillEmail(data.geteMail());
        fillPhoneNumber(data.getPhoneNumber());
        fillPassword(data.getPassword());
        setSubscription(data.isSubscribed());
    }

    public void switchToRegistrationForm() {
        highlightClick(By.cssSelector("[data-type=login] [href=\"/registration/\"]"));
        waitForRenderedElementsToDisappear(By.cssSelector("[data-type=login] .js-popup-container"));
    }

    public void switchToLoginForm() {
        highlightClick(By.cssSelector("[data-type=reg] [href=\"/login/\"]"));
        waitForRenderedElementsToDisappear(By.cssSelector("[data-type=reg] .js-popup-container"));
    }


    public void fillLoginForm(LoginModel data) {
        fillLoginEmail(data.getEmail());
        fillLoginPassword(data.getPassword());
    }

    public void submitRegistration() {
        highlightClick(By.cssSelector("[data-type=reg] .button__text"));
    }


    public void submitLogin() {
        highlightClick(By.cssSelector("[data-type=login] .button__text"));
    }


    public boolean isWrongLoginPassword() {
        return highlightFind(By.cssSelector("[data-error=\"Неверный логин или пароль\"]")).isDisplayed();
    }

    public boolean isRegistrationView() {
        if (!highlightFind(By.cssSelector("[data-type=reg]")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=reg] [pattern=\"^[a-zа-яёії]+[a-zа-яёії' -]*[a-zа-яёії]+$\"]")).isDisplayed()) {
            return false;
        }
        if (!highlightFind(By.cssSelector("[data-type=reg] .popup__radio")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=reg] .js-inputmask-date")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=reg] [type=email]")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=reg] [type=tel]")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=reg] [type=password]")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=reg] [href=\"/login/\"]")).isDisplayed()) return false;
        return true;

    }

    public boolean isLoginView() {
        if (!highlightFind(By.cssSelector("[data-type=login]")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=login] [type=email]")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=login] [type=password]")).isDisplayed()) return false;
        if (!highlightFind(By.cssSelector("[data-type=login] [href=\"/registration/\"]")).isDisplayed()) return false;
        return true;
    }

    // region fill methods

    private void fillLoginEmail(String email) {
        highlightFind(By.cssSelector("[data-type=login] [type=email]")).sendKeys(email);
    }

    private void fillLoginPassword(String password) {
        highlightFind(By.cssSelector("[data-type=login] [type=password]")).sendKeys(password);
    }

    private void fillNameField(String name) {
        if (name != null) {
            WebElement nameField = highlightFind(By.cssSelector("[pattern=\"^[a-zа-яёії]+[a-zа-яёії' -]*[a-zа-яёії]+$\"]"));
            nameField.sendKeys(name);
        }
    }

    private void chooseGender(String gender) {
        String selector = String.format("label[for=reg-%s]", gender);
        highlightClick(By.cssSelector(selector));
    }

    private void fillBirthDate(Date birthDate) {
        if (birthDate != null) {
            DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");
            WebElement birthDateField = highlightFind(By.cssSelector(".js-inputmask-date"));
            birthDateField.sendKeys(dateFormat.format(birthDate));
        }
    }

    private void fillEmail(String email) {
        if (email != null) {
            WebElement emailField = highlightFind(By.cssSelector("[data-type=reg] [type=email]"));
            emailField.sendKeys(email);
        }
    }

    private void fillPhoneNumber(String phoneNumber) {
        if (phoneNumber != null) {
            WebElement phoneNumberField = highlightFind(By.cssSelector("[type=tel]"));
            phoneNumberField.sendKeys(phoneNumber);
        }
    }

    private void fillPassword(String password) {
        if (password != null) {
            WebElement pwdField = highlightFind(By.cssSelector(".field__value_type_pass [type]"));
            pwdField.sendKeys(password);
        }
    }

    private void setSubscription(boolean isSubscribed) {
        if (!isSubscribed) {
            highlightClick(By.cssSelector("[for=reg-subscribe]"));
        }
    }

    // endregion
}
