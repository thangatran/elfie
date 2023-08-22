package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class ElfiePage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='home']/android.widget.Image")
    private SelenideElement elfieLogo_img;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private SelenideElement hamburger_btn;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[2]/android.view.View/android.widget.TextView[1]")
    private SelenideElement centralText_txt;
    @AndroidFindBy(xpath = "//*[contains(@text,'2023 Elfie')]")
    private SelenideElement copyRightFooter_txt;

    public void verifyLogoDisplayed() {
        elfieLogo_img.should(visible, Duration.ofMillis(WAIT_TIME));
        takeScreenshot();
    }

    public void clickAcceptTnC() {
        tapAPosition(665, 2713);
    }

    public void verifyHamburgerCloseBtn() {
        hamburger_btn.should(exist, Duration.ofMillis(WAIT_TIME));
        String hamburgerImageBefore = hamburger_btn.getScreenshotAs(OutputType.BASE64);
        hamburger_btn.click();
        String hamburgerImageAfter = hamburger_btn.getScreenshotAs(OutputType.BASE64);
        Assert.assertNotEquals(hamburgerImageBefore, hamburgerImageAfter, "hamburger icon is not changed after clicked");
        takeScreenshot();
        hamburger_btn.click();
        centralText_txt.should(visible, Duration.ofMillis(WAIT_TIME));
        tapAPosition(665, 2713);
    }

    public void scrollToBottom() {
        for (int i = 1; i <= 3; ++i)
            scrollPage();
    }

    public void verifyCopyRightFooter() {
        copyRightFooter_txt.should(visible, Duration.ofMillis(WAIT_TIME));
        Assert.assertTrue(StringUtils.equalsAny(copyRightFooter_txt.getText(), "Bản quyền © 2023 Elfie Pte. Ltd.", "Copyright © 2023 Elfie Pte. Ltd."), "CopyRight text is not correct");
        takeScreenshot();
    }

}
