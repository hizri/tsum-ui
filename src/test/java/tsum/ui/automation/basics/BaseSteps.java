package tsum.ui.automation.basics;

import net.thucydides.core.annotations.Step;
import tsum.ui.automation.pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseSteps {

    private HomePage homePage;
    private SignUpPopup signUpPopup;
    private ProfilePage profilePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Step
    public void open_home_page() {
        homePage.open();
    }

    @Step
    public void open_registration_page() {
        registrationPage.open();
    }

    @Step
    public void open_login_page() {
        loginPage.open();
    }

    @Step
    public void open_signup_popup() {
        open_home_page();
        homePage.openSignUpPopup();
    }

    @Step
    public void open_registration_form() {
        open_signup_popup();
        switch_to_registration_view();
    }

    @Step
    public void submit_registration() {
        signUpPopup.submitRegistration();
    }

    @Step
    public void submit_login() {
        signUpPopup.submitLogin();
    }

    @Step
    public void switch_to_registration_view() {
        signUpPopup.switchToRegistrationForm();
    }

    @Step
    public void switch_to_login_view() {
        signUpPopup.switchToLoginForm();
    }

    @Step
    public void profile_page_logout() {
        profilePage.logout();
    }

    @Step
    public void check_that_registration_view() {
        assertThat(signUpPopup.isRegistrationView()).isTrue();
    }

    @Step
    public void check_that_login_view() {
        assertThat(signUpPopup.isLoginView()).isTrue();
    }

    @Step
    public void check_that_redirected_to_profile_page() {
        assertThat(profilePage.isProfilePage()).isTrue();
    }
}
