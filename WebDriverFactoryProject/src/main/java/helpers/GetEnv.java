package helpers;

import java.util.Optional;

/**
 * Класс для получения переменных среды  -Dbrowser=ChroME,  -Dbrowser=fireFOX,  -Dbrowser=headless
 * Received ----String envName--- from this class will be modified from ChroME to CHROME, from fireFOX to FIREFOX
 * This ----String envName--- will be used as ----String browserType--- in WebDriverFactory class, in method
 * ---createNewDriver---- to create WebDriver accordingly.
 */
public class GetEnv {
    public static String getEnv(String envName){
        /**
         * Пытаемся получить переменную -Dbrowser.
         * Если она null ( ofNullable() ), то возвращаем другое значение( orElse("default") )
         * В нашем случае будет "default". Convert it to Upper Case and remove(trim) from front and back the white
         spaces.
         * Это убережет нас от того случая. когда переменная не была задана ( NPE  защита )
         */
        return Optional.ofNullable(System.getProperty(envName)).orElse("DeFaULt").toUpperCase().trim();
    }
}
