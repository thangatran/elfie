import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.JsonHelper;

import java.net.URL;
import java.util.Map;

public class Device {

    private AppiumDriver driver;
    private AppiumDriverLocalService service;

    public Device() {
        try {
            startAppiumServer();
            Map<String, Object> caps = JsonHelper.jsonFileToMap(CONSTANT.DEVICE_CAPABILITIES_JSON);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            caps.forEach(capabilities::setCapability);
            driver = new AndroidDriver(new URL(CONSTANT.APPIUM_LOCALHOST), capabilities);
            WebDriverRunner.setWebDriver(driver);
        } catch (Exception e) {
            throw new RuntimeException("Could not init android device. " + e);
        }
    }

    public void tearDown() {
        driver.quit();
        service.stop();
    }

    private void startAppiumServer() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }
}
