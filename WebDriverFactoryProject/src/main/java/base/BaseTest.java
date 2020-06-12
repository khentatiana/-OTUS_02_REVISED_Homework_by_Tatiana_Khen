package base;

import manager.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static helpers.GetEnv.getEnv;

// abstract make BaseTest to be inherited by outside classes, not make any changes.
public abstract class BaseTest {
    public static Logger logger = LogManager.getLogger(BaseTest.class);
    /**
     * переменная static одна на класс. Т.е. сколько бы не создавался класс BaseTest,
     * static будет одна (паттер singleton).
     * Возникает вопрос: что будет если запустить тексты в несколько потоков?
     */
    protected WebDriver driver;

    @BeforeMethod
    protected void oneTimeSetUp() {
        //Instantiation of driver object. To launch browser
        driver = WebDriverFactory.createNewDriver(getEnv("browser"));
        /**
         * null у нас не может быть, т.к. есть дефолтные значения
         */
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            String browserType = getEnv("browser");
            driver.quit();
            System.out.println("=========" + browserType + " browser is closed=====");
            logger.info("====={} browser is closed=====", browserType);
        }
    }
}