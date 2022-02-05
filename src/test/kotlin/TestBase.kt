import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.remote.DesiredCapabilities
import java.lang.Exception
import java.net.URL
import java.util.concurrent.TimeUnit

open class TestBase {
    protected lateinit var driver: AndroidDriver<MobileElement>
    protected open var caps: DesiredCapabilities? = null
    private val webDriverURL: URL = URL("http://127.0.0.1:4723/wd/hub")


    @BeforeEach
    fun setUp() {
        this.driver = AndroidDriver(webDriverURL, caps)
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    fun tearDown() {
        this.driver.quit() ?: throw Exception("Driver instance could not be quit.")
    }

}