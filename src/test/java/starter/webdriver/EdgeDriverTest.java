package starter.webdriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class EdgeDriverTest {

    @Managed
    WebDriver driver;

    @Test
    @Title("When having 'webdriver.edge.driver' set in properties or conf, the test should execute on Edge browser.")
    public void edge_driver_serenity_property_test() {
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");
        driver.quit();
    }

    @Test
    @Title("When having 'webdriver.edge.driver' from the System.setProperty() method, the test should execute on Edge browser")
    public void edge_driver_set_system_property_test() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/windows/msedgedriver.exe");
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");
        driver.quit();
    }
}
