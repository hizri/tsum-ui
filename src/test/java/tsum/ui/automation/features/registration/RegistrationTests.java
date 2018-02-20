package tsum.ui.automation.features.registration;

import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import tsum.ui.automation.basics.BaseTest;
import tsum.ui.automation.factories.BaseFactory;
import tsum.ui.automation.models.RegistrationModel;
import tsum.ui.automation.steps.LoginSteps;
import tsum.ui.automation.steps.RegistrationSteps;

public class RegistrationTests extends BaseTest {

    @Steps
    private RegistrationSteps registrationSteps;

    @Steps
    private LoginSteps loginSteps;

    @Before
    public void open_registration_form() {
        registrationSteps.open_registration_form();
    }

    @Test
    public void user_registration() {
        RegistrationModel data = BaseFactory.randomRegistrationData();
        registrationSteps.fill_registration_form(data);
        registrationSteps.submit_registration();
        registrationSteps.check_that_redirected_to_profile_page();
        registrationSteps.check_saved_data_matches_profile(data);
    }

}
