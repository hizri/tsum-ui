package tsum.ui.automation.steps;

import tsum.ui.automation.basics.BaseSteps;
import tsum.ui.automation.models.LoginModel;
import tsum.ui.automation.pages.HomePage;
import tsum.ui.automation.pages.LoginPage;
import tsum.ui.automation.pages.ProfilePage;
import tsum.ui.automation.pages.SignUpPopup;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends BaseSteps {

    private SignUpPopup signUpPopup;

    @Step
    public void fill_login_form(LoginModel data) {
        signUpPopup.fillLoginForm(data);
    }

    @Step
    public void check_wrong_login_password() {
        assertThat(signUpPopup.isWrongLoginPassword()).isTrue();
    }
}
