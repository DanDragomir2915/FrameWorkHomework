package utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Driver {
    public String url = ReadProperties.config.getProperty("url");
    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = initDriver();
        driver.get(url);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();

    }

}
