package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.qascooter.praktikumservices.pageobjects.ScooterOrder;
import ru.qascooter.praktikumservices.pageobjects.Accordeon;
import static com.codeborne.selenide.Selenide.open;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;


    @RunWith(Parameterized.class)


    public class AccordeonTests {

        private SelenideElement questionLocator;
        private String expectedAnswer;

        // Конструктор для параметризованного теста
        public AccordeonTests(SelenideElement questionLocator, String expectedAnswer) {
            this.questionLocator = questionLocator;
            this.expectedAnswer = expectedAnswer;
        }

        // Провайдер данных для параметризованного теста
        @Parameterized.Parameters
        public Collection<Object[]> questionAnswerData() {
            Accordeon mainPage = open(ScooterOrder.URL, Accordeon.class);
            return Arrays.asList(new Object[][] {
                    {mainPage.questionOneAboutCost, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {mainPage.questionTwoAboutNumber, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    {mainPage.questionThreeAboutTime, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {mainPage.questionFourAboutScooterToday,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {mainPage.questionFiveAboutCharger, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    {mainPage.questionFiveAboutPeriodChange, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    {mainPage.questionSixAboutOrderCancel,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои." },
                    {mainPage.questionSevenAboutMoscowRegions, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},// Добавьте остальные вопросы и ответы здесь
            });

        @Test
        public void testQuestionAnswerMatch() {
            String actualAnswer = mainPage.getAnswerTextByQuestionLocator(questionLocator);
            assertEquals("Ответ не соответствует ожидаемому", expectedAnswer, actualAnswer);
        }
    }


        WebDriver driver;
    @After
    public void tearDown() {
        driver.quit();
    }
}