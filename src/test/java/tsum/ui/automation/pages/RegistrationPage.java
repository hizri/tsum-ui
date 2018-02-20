package tsum.ui.automation.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import tsum.ui.automation.basics.RegistrationExtension;

import java.util.concurrent.TimeUnit;

@DefaultUrl("/registration/")
public class RegistrationPage extends RegistrationExtension {

    @Override
    public void submitRegistration() {
        highlightClick(By.cssSelector("[data-type=reg] .button__text"));
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(By.cssSelector("a[href=\"/personal/?logout=yes\"]"));
    }

}