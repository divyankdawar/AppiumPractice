package AppiumPractice.AppiumPractice;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.remote.MobileCapabilityType;


public class Base {
    static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        openMobileApp();
    }

    @SuppressWarnings("deprecation")
	public static void openMobileApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
try {
        // Set Desired Capabilities
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "DivyankF23"); // Avoid apostrophes
        caps.setCapability(MobileCapabilityType.UDID, "RZCT419B1TV"); // Ensure this matches your device
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "com.ubercab");
        caps.setCapability("appActivity", "com.ubercab.presidio.app.core.root.RootActivity");

        // Initialize Appium Driver
        URL url = new URL("http://127.0.0.1:4723"); // Correct endpoint for Appium server
        driver = new AndroidDriver(url, caps); // Use AndroidDriver for Android-specific capabilities

        System.out.println("Application Started");
}
catch(Exception e) {
	e.printStackTrace();
}
driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")")).click();
Thread.sleep(3000);
driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.ubercab:id/welcome_screen_continue\")")).click();
driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Continue\")")).isDisplayed();
driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")")).isDisplayed();
driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Continue with Google\")")).isDisplayed();

System.out.println("Application Started");

       
    }
}

