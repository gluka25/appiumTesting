import org.openqa.selenium.remote.DesiredCapabilities

class ProjectCapabilities {
    companion object {
        fun androidBaseCapabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()
            caps.setCapability("autoAcceptAlerts", true)
            caps.setCapability("platformName", "Android")
            caps.setCapability("automationName", "UiAutomator2")
            caps.setCapability("deviceName", "Pixel_4")
            caps.setCapability("appPackage", "co.craafted.done")
            caps.setCapability("appActivity", "co.craafted.done.MainActivity")
            return caps
        }
    }
}