package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class GooglePage extends BasePage {
    @AndroidFindBy(id = "com.android.chrome:id/signin_fre_dismiss_button")
    private SelenideElement signinDismiss_btn;
    @AndroidFindBy(id = "com.android.chrome:id/search_box_text")
    private SelenideElement searchBox_txt;
    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private SelenideElement urlBar_txt;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private SelenideElement urlResult_lnk;
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.EditText")
    private SelenideElement googleSearchBar_txt;
    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")
    private SelenideElement googleSearchBack_btn;
    @AndroidFindBy(xpath = "//android.view.View[@text='Elfie']")
    private SelenideElement elfieResult_lnk;

    public void clickSignInDismiss() {
        signinDismiss_btn.should(exist, Duration.ofMillis(WAIT_TIME)).click();
    }

    public void enterURL(String url) {
        searchBox_txt.should(exist, Duration.ofMillis(WAIT_TIME)).click();
        urlBar_txt.should(exist, Duration.ofMillis(WAIT_TIME)).sendKeys(url);
        urlResult_lnk.should(exist, Duration.ofMillis(WAIT_TIME)).click();
    }

    public void searchString(String text) {
        googleSearchBar_txt.should(exist, Duration.ofMillis(WAIT_TIME)).sendKeys(text);
        googleSearchBar_txt.click();
        googleSearchBack_btn.should(visible, Duration.ofMillis(WAIT_TIME));
        tapAPosition(1335, 2831);
    }

    public void clickOnFirstResult() {
        elfieResult_lnk.should(exist, Duration.ofMillis(WAIT_TIME)).click();
    }
}
