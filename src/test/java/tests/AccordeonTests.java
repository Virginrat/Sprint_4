package tests;

import org.junit.Test;
import ru.qascooter.praktikumservices.pageobjects.ScooterOrder;
import ru.qascooter.praktikumservices.pageobjects.Accordeon;
import static com.codeborne.selenide.Selenide.open;
import org.junit.After;
import org.openqa.selenium.WebDriver;



public class AccordeonTests {
    WebDriver driver;
    @Test
    public void testPassedGetTextFromQuestionsOnMainPaige() {
        //открывается страница и создается экземпляр класса страницы
        Accordeon mainPageQuestions = open(ScooterOrder.URL,
                Accordeon.class);

        //метод для всех вопросов и получения текстов всех ответов
        mainPageQuestions.clickOnQuestionsAndHaveAnswersTexts();
    }
}

    @After
    public void tearDown() {
        driver.quit();
    }
}