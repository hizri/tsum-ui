package tsum.ui.automation.steps;

import net.thucydides.core.annotations.Step;
import tsum.ui.automation.basics.BaseSteps;
import tsum.ui.automation.models.RegistrationModel;
import tsum.ui.automation.pages.HomePage;
import tsum.ui.automation.pages.ProfilePage;
import tsum.ui.automation.pages.RegistrationPage;
import tsum.ui.automation.pages.SignUpPopup;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationSteps extends BaseSteps {

    private HomePage homePage;
    private SignUpPopup signUpPopup;
    private ProfilePage profilePage;
    private RegistrationPage registrationPage;

    @Step
    public void fill_registration_form(RegistrationModel data) {
        signUpPopup.fillRegistrationForm(data);
    }


    @Step
    public void check_saved_data_matches_profile(RegistrationModel data) {
        assertThat(profilePage.matchModelData(data)).isTrue();
    }

    @Step
    public void register_new_user_on_page(RegistrationModel data) {
        registrationPage.fillRegistrationForm(data);
        registrationPage.submitRegistration();
    }

}
