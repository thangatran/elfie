import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ElfiePage;
import pages.GooglePage;

import static com.codeborne.selenide.Selenide.page;

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

    @Test
    public void navigateToElfie() {
        googlePage.clickSignInDismiss();
        googlePage.enterURL("https://www.google.com/");
        googlePage.searchString("elfie");
        googlePage.clickOnFirstResult();
    }

    @Test(dependsOnMethods = {"navigateToElfie"})
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
