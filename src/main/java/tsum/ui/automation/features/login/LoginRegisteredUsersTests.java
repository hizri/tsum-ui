package tsum.ui.automation.features.login;

import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import tsum.ui.automation.factories.BaseFactory;
import tsum.ui.automation.basics.BaseTest;
import tsum.ui.automation.models.RegistrationModel;
import tsum.ui.automation.steps.LoginSteps;
import tsum.ui.automation.steps.RegistrationSteps;

public class LoginRegisteredUsersTests extends BaseTest {

    private RegistrationModel createdAccount = BaseFactory.randomRegistrationData();

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private RegistrationSteps registrationSteps;

    @Before
    public void open_registration_form() {
        registrationSteps.open_registration_page();
        createdAccount.setBirthDate(null);
        registrationSteps.register_new_user_on_page(createdAccount);
        registrationSteps.profile_page_logout();
        loginSteps.open_login_page();
    }

    @Test
    public void login_registered_user() {
        loginSteps.fill_login_form(BaseFactory.toLoginModel(createdAccount));
        loginSteps.submit_login();
        loginSteps.check_that_redirected_to_profile_page();
    }

    @Test
    public void login_registered_user_wrong_password() {
        createdAccount.setPassword("1" + createdAccount.getPassword());
        createdAccount.setSubscribed(false);
        loginSteps.fill_login_form(BaseFactory.toLoginModel(createdAccount));
        loginSteps.submit_login();
        loginSteps.check_wrong_login_password();
    }

}
