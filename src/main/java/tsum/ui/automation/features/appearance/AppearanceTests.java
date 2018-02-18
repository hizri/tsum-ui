package tsum.ui.automation.features.appearance;

import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import tsum.ui.automation.basics.BaseTest;
import tsum.ui.automation.basics.BaseSteps;
import tsum.ui.automation.steps.RegistrationSteps;

public class AppearanceTests extends BaseTest {

    @Steps
    private BaseSteps baseSteps;
    private RegistrationSteps registrationSteps;

    @Before
    public void open_sign_up_popup() {
        baseSteps.open_home_page();
    }

    @Test
    public void switch_popup_views() {
        baseSteps.open_signup_popup();
        baseSteps.switch_to_registration_view();
        baseSteps.check_that_registration_view();
        baseSteps.switch_to_login_view();
        baseSteps.check_that_login_view();
    }

    @Test
    public void switch_page_views() {
        baseSteps.open_registration_page();
        baseSteps.switch_to_login_view();
        baseSteps.check_that_login_view();
        baseSteps.switch_to_registration_view();
        baseSteps.check_that_registration_view();
    }

}
