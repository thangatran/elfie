import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ElfiePage;
import pages.GooglePage;

import static com.codeborne.selenide.Selenide.page;

@Feature("Elfie Test")
public class elfieTest {

    private Device device;
    private GooglePage googlePage;
    private ElfiePage elfiePage;

    @BeforeTest
    public void setup() {
        device = new Device();
        googlePage = page(GooglePage.class);
        elfiePage = page(ElfiePage.class);
    }

    @Test(description = "Navigate to Elfie site")
    @Description("Use google chrome to navigate to Elfie site")
    public void navigateToElfie() {
        googlePage.clickSignInDismiss();
        googlePage.enterURL("https://www.google.com/");
        googlePage.searchString("elfie");
        googlePage.clickOnFirstResult();
    }

    @Test(dependsOnMethods = {"navigateToElfie"}, description = "verify Elfie site")
    @Description("Go through Elfie site and do verification")
    public void checkElfiePage() {
        elfiePage.verifyLogoDisplayed();
        elfiePage.clickAcceptTnC();
        elfiePage.verifyHamburgerCloseBtn();
        elfiePage.scrollToBottom();
        elfiePage.verifyCopyRightFooter();
    }

    @AfterTest
    public void tearDown() {
        device.tearDown();
    }
}
