package helpers;

import java.util.Optional;

/**
 * Класс для получения переменных среды
 */
public class GetEnv {
    public static String getEnv(String envName){
        /**
         * Пытаемся получить переменную.
         * Если она null ( ofNullable() ), то возвращаем другое значение( orElse("default") )
         * В нашем случае будет "default"
         * Это убережет нас от того случая. когда переменная не была задана ( NPE  защита )
         */
        return Optional.ofNullable(System.getProperty(envName)).orElse("DEFAULT").toUpperCase().trim();
    }
}
