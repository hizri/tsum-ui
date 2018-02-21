package tsum.ui.automation.steps;

import net.thucydides.core.annotations.Step;
import tsum.ui.automation.basics.BaseSteps;
import tsum.ui.automation.models.RegistrationModel;
import tsum.ui.automation.pages.ProfilePage;
import tsum.ui.automation.pages.RegistrationPage;
import tsum.ui.automation.pages.SignUpPopup;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationSteps extends BaseSteps {

    private SignUpPopup signUpPopup;
    private ProfilePage profilePage;
    private RegistrationPage registrationPage;

    @Step
    public void fill_registration_form(RegistrationModel data) {
        signUpPopup.fillRegistrationForm(data);
    }


    @Step
    public void check_saved_data_matches_profile(RegistrationModel data) {
        assertThat(profilePage.getActiveProfileTitle().equals(data.getName())).isTrue();
        RegistrationModel savedData = profilePage.getSavedData();
        assertThat(data.getName().equalsIgnoreCase(savedData.getName())).isTrue();
        assertThat(data.geteMail().equalsIgnoreCase(savedData.geteMail())).isTrue();
        assertThat(data.getPhoneNumber().equalsIgnoreCase(savedData.getPhoneNumber())).isTrue();
        assertThat(data.getBirthDate() == savedData.getBirthDate()).isTrue();
    }

    @Step
    public void register_new_user_on_page(RegistrationModel data) {
        registrationPage.fillRegistrationForm(data);
        registrationPage.submitRegistration();
    }

}
