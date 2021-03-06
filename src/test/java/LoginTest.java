import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private ChromeDriver driver;
    @BeforeMethod
    public void setUp ()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void login()
    {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElementByCssSelector("#login button").click();
        assertTrue(driver.findElementByCssSelector(".subheader").isDisplayed());



    }
    @AfterMethod
    public void tearDown () {
        driver.close();
        driver.quit();

    }

}