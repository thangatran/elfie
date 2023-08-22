package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

public class BasePage {

    protected final int WAIT_TIME = 10000;
    private final AppiumDriver driver = ((AppiumDriver) WebDriverRunner.getWebDriver());

    protected void tapAPosition(int x, int y) {
        PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
        Sequence swipeDown = new Sequence(finger, 1);
        swipeDown.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(0))
                .addAction(finger.createPointerUp(0));
        driver.perform(Arrays.asList(swipeDown));
    }

    protected void scrollPage() {
        try {
            PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
            Sequence swipeDown = new Sequence(finger, 1);
            swipeDown.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 665, 2713))
                    .addAction(finger.createPointerDown(0))
                    .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), 740, 515))
                    .addAction(finger.createPointerUp(0));
            driver.perform(Arrays.asList(swipeDown));
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException("Cannot scroll a page: " + e);
        }
    }

    public void takeScreenshot() {
        try {
            File srcFile = driver.getScreenshotAs(OutputType.FILE);
            String filename = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            File targetFile = new File("target/screenshots/" + filename + ".jpg");
            FileUtils.copyFile(srcFile, targetFile);
            Allure.addAttachment(filename, FileUtils.openInputStream(srcFile));
        } catch (Exception e) {
            throw new RuntimeException("Cannot take screenshot: " + e);
        }
    }
}
