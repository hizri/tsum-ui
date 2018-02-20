package tsum.ui.automation.features.login;

import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import tsum.ui.automation.factories.BaseFactory;
import tsum.ui.automation.basics.BaseTest;
import tsum.ui.automation.models.LoginModel;
import tsum.ui.automation.steps.LoginSteps;

public class LoginTestsNegative extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Before
    public void open_login_popup() {
        loginSteps.open_signup_popup();
    }

    @Test
    public void login_non_existing_user() {
        LoginModel data = BaseFactory.randomLoginData();
        loginSteps.fill_login_form(data);
        loginSteps.submit_login();
        loginSteps.check_wrong_login_password();
    }

}
