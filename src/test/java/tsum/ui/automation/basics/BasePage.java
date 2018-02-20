package tsum.ui.automation.basics;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends PageObject{

    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    private static final EnvironmentVariables config = SystemEnvironmentVariables.createEnvironmentVariables();

    protected WebElement highlightFind(By by) {
        logger.info("Find   |   By: {}  |", by.toString());
        WebElement element = find(by);
        highlight(element);
        return element;
    }

    protected void highlightClick(By by) {
        logger.info("Click  |   By: {}  |", by.toString());
        WebElement element = find(by);
        highlight(element);
        element.click();
        waitUntilJSReady();
    }

    protected String getCurrentUrl() {
        return this.getDriver().getCurrentUrl();
    }

    private void waitUntilJSReady() {
        int waitJsPause = Integer.valueOf(config.getProperty("wait.js.pause", "100"));
        int waitJsTimeout = Integer.valueOf(config.getProperty("wait.js.timeout", "4000"));
        int times = waitJsTimeout / waitJsPause;
        for(int i = 0; i < times; i++) {
            boolean isJsReady = evaluateJavascript("return document.readyState").toString().equals("complete");
            waitPause(waitJsPause);
            if (isJsReady)
                return;
        }
    }

    private void setBorderStyle(WebElement element, String style) {
        evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", element, style);
    }


    private void highlight(WebElement element) {
        String borderStyle = "border: 2px dashed red";
        setBorderStyle(element, borderStyle);
        waitPause(250);
        setBorderStyle(element, "");
    }

    private void waitPause(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
