package helpers;

import base.BaseTest;
import manager.DriverType;
import org.xml.sax.SAXParseException;

import java.sql.Driver;

import static helpers.GetEnv.getEnv;

/**
 * Вспомогательный класс для получения переменной браузера.
 * If ---String browserName--- is not in enum list then it returns DriverType.DEFAULT
 */
public class BrowserEnv extends BaseTest {
    public static DriverType getBrowserName(String browserName){
        try{
            return DriverType.valueOf(browserName.toUpperCase().trim());

        } catch (Exception e) {
            /**
             * Так делать плохо, но иначе мы не будем использовать ENUM.
             * Тут идет вторая защита от сваливания тестов, когда переменную указали некорректно
             * P.S. ENUM. по-моему мнению, вообще тут не нужен.
             */
            return DriverType.DEFAULT;
        }
    }
}
