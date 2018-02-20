package tsum.ui.automation.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import tsum.ui.automation.basics.BasePage;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("/")
public class HomePage extends BasePage {

    public void openSignUpPopup() {
        highlightClick(By.cssSelector(".header__link.js-show-popup"));
        assertThat(highlightFind(By.cssSelector("[data-type=login] .js-popup-container")).isDisplayed()).isTrue();
    }
}