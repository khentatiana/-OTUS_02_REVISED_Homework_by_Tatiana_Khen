package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static base.BaseTest.logger;
import static helpers.BrowserEnv.getBrowserName;

/**
 * Вся работа с инициализацией драйвера в одном классе. Логи в том числе
 */

public class WebDriverFactory {
    public static WebDriver createNewDriver(String browserType) {
        logger.info("Browser name is {}", browserType);
        System.out.println("======Browser name is " + browserType + "======");
        switch (getBrowserName(browserType)) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                logger.info("FF created");
                return new FirefoxDriver();
            case CHROME:
                WebDriverManager.chromedriver().setup();
                logger.info("Chrome created");
                return new ChromeDriver();
            case HEADLESS: //Странный тип браузера =)
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                logger.info("Headless created");
                return new ChromeDriver(options);
            case INCOGNITO: //Странный тип браузера =)
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--incognito");
                logger.info("Incognito created");
                return new ChromeDriver(options);

            default:
                WebDriverManager.chromedriver().setup();
                logger.info("======UNKNOWN browser name. CHROME driver is created instead======");
                return new ChromeDriver();
        }
    }
    public static WebDriver createNewDriver(DriverType browserType ) {
        logger.info("Browser name is {}", browserType);
        System.out.println("======Browser name is " + browserType + "======");
        switch (browserType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                logger.info("FF created");
                return new FirefoxDriver();
            case CHROME:
                WebDriverManager.chromedriver().setup();
                logger.info("Chrome created");
                return new ChromeDriver();
            case HEADLESS: //Странный тип браузера =)
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                logger.info("Headless created");
                return new ChromeDriver(options);
            case INCOGNITO: //Странный тип браузера =)
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--incognito");
                logger.info("Incognito created");
                return new ChromeDriver(options);
            default:
                WebDriverManager.chromedriver().setup();
                logger.info("======UNKNOWN browser name. CHROME driver is created instead======");
                return new ChromeDriver();
        }
    }
}

