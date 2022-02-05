import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.openqa.selenium.remote.DesiredCapabilities


class ToDOTest: TestBase() {
    override var caps: DesiredCapabilities? = ProjectCapabilities.androidBaseCapabilities()


    @ParameterizedTest
    @ValueSource(strings = ["task 1", "  ", "task 2"])
    fun `create task`(taskText: String) {
        driver.findElementById("co.craafted.done:id/taskAdd").click()
        assertTrue(driver.findElementById("co.craafted.done:id/taskCheck").isDisplayed)
        driver.findElementById("co.craafted.done:id/taskText").sendKeys(taskText)
//        driver.pressKey(KeyEvent(AndroidKey.ENTER));
        driver.findElementById("co.craafted.done:id/taskAdd")?.click()
        assertEquals(driver.findElementById("co.craafted.done:id/taskText").text, taskText)
    }

    @Test
    fun `create tasks`() {
        driver.findElementById("co.craafted.done:id/taskAdd").click()
        assertTrue(driver.findElementById("co.craafted.done:id/taskCheck").isDisplayed)
        driver.findElementById("co.craafted.done:id/taskText").sendKeys("task 1")
        driver.findElementById("co.craafted.done:id/taskAdd").click()
        assertEquals(driver.findElementById("co.craafted.done:id/taskText").text, "task 1")
        driver.findElementByXPath("(//android.widget.EditText[@id, \"co.craafted.done:id/taskText\"])[2]").sendKeys("task 2")
        driver.findElementById("co.craafted.done:id/taskAdd").click()
        assertEquals(driver.findElementByXPath("(//android.widget.EditText[@id, \"co.craafted.done:id/taskText\"])[2]").text, "task 2")
    }

    @Test
    fun `delete task`() {
        driver.findElementById("co.craafted.done:id/taskAdd").click()
        assertTrue(driver.findElementById("co.craafted.done:id/taskCheck").isDisplayed)
        driver.findElementById("co.craafted.done:id/taskText").sendKeys("task 1")
        driver.findElementById("co.craafted.done:id/taskDelete").click()
        assertTrue(driver.findElementById("co.craafted.done:id/emptyIllustration").isDisplayed)
    }

    @Test
    fun `check task`() {
        driver.findElementById("co.craafted.done:id/taskAdd").click()
        assertTrue(driver.findElementById("co.craafted.done:id/taskCheck").isDisplayed)
        driver.findElementById("co.craafted.done:id/taskText").sendKeys("task 1")
        driver.findElementById("co.craafted.done:id/taskCheck").click()
        assertEquals(driver.findElementById("co.craafted.done:id/taskText").text, "task 1")
    }

    @Test
    fun `uncheck task`() {
        driver.findElementById("co.craafted.done:id/taskAdd")?.click()
        assertTrue(driver.findElementById("co.craafted.done:id/taskCheck").isDisplayed)
        driver.findElementById("co.craafted.done:id/taskText").sendKeys("task 1")
        driver.findElementById("co.craafted.done:id/taskCheck").click()
        assertEquals(driver.findElementById("co.craafted.done:id/taskText").text, "task 1")
        driver.findElementById("co.craafted.done:id/taskCheck").click()
        assertEquals(driver.findElementById("co.craafted.done:id/taskText").text, "task 1")
    }

    }