package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void setUpTest(){
        /**
         * В тесте только тест. Все приготовления ведутся в до или после теста
         */
        driver.get("https://otus.ru/");
        /**
         * Считаю излишним создавать переменную для урла
         */
        System.out.println("The HOME page URL is:" + driver.getCurrentUrl());
        logger.info("Opened url {}", driver.getCurrentUrl() );
    }

    @Test
    public void openHomePage(){
        String title = driver.getTitle();
        System.out.println("The HOME page title is:");
        System.out.println("======" + title + "======");
        System.out.println();
        logger.info("Title of opened url {}", title );
    }
}