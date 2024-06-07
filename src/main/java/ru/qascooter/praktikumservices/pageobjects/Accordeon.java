package ru.qascooter.praktikumservices.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;


public class Accordeon {


    //локатор вопроса 1 про стоимость
    @FindBy(id = "accordion__heading-72")
    public SelenideElement questionOneAboutCost;
    //локатор текста ответа на вопрос 1
    @FindBy(id = "accordion__panel-72")
    public SelenideElement answerOneAboutCost;
    //локатор вопроса 2 про кол-во
    @FindBy(id = "accordion__heading-73")
    public SelenideElement questionTwoAboutNumber;
    //локатор текста ответа на вопрос 2
    @FindBy(id = "accordion__panel-73")
    public SelenideElement answerTwoAboutNumber;
    //локатор вопроса 3 про расчет времени
    @FindBy(id = "accordion__heading-74")
    public SelenideElement questionThreeAboutTime;
    //локатор текста ответа 3 про расчет времени
    @FindBy(id = "accordion__panel-74")
    public SelenideElement answerThreeAboutTime;
    //локатор вопроса 4 про заказ на сегодня
    @FindBy(id = "accordion__heading-75")
    public SelenideElement questionFourAboutScooterToday;
    //локатор текста ответа 4 про заказ на сегодня
    @FindBy(id = "accordion__panel-75")
    public SelenideElement answerFourAboutScooterToday;
    //локатор вопроса 5 про изменение периода
    @FindBy(id = "accordion__heading-76")
    public SelenideElement questionFiveAboutPeriodChange;
    //локатор текста ответа 5 про изменение периода
    @FindBy(id = "accordion__panel-76")
    public SelenideElement answerFiveAboutPeriodChange;
    //локатор вопроса 6 про зарядку
    @FindBy(id = "accordion__heading-77")
    public SelenideElement questionFiveAboutCharger;
    //локатор текста ответа 6 про зарядку
    @FindBy(id = "accordion__panel-77")
    public SelenideElement answerFiveAboutCharger;
    //локатор вопроса 7 про отмену заказа
    @FindBy(id = "accordion__heading-78")
    public SelenideElement questionSixAboutOrderCancel;
    //локатор текста ответа 7 про отмену заказа
    @FindBy(id = "accordion__panel-78")
    public SelenideElement answerSixAboutOrderCancel;
    //локатор вопроса 8 про заказ за МКАД
    @FindBy(id = "accordion__heading-79")
    public SelenideElement questionSevenAboutMoscowRegions;
    //локатор текста ответа 8 про заказ за МКАД
    @FindBy(id = "accordion__panel-79")
    public SelenideElement answerSevenAboutMoscowRegions;



   //все методы клика на вопросы и получения текста ответов

    public void clickOnQuestionsAndHaveAnswersTexts() {
        questionOneAboutCost.scrollTo().click();
        answerOneAboutCost.shouldHave(text("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
        questionTwoAboutNumber.click();
        answerTwoAboutNumber.shouldHave(text("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
        questionThreeAboutTime.click();
        answerThreeAboutTime.shouldHave(text("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));
        questionFourAboutScooterToday.click();
        answerFourAboutScooterToday.shouldHave(text("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
        questionFiveAboutPeriodChange.click();
        answerFiveAboutPeriodChange.shouldHave(text("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));
        questionFiveAboutCharger.click();
        answerFiveAboutCharger.shouldHave(text("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));
        questionSixAboutOrderCancel.click();
        answerSixAboutOrderCancel.shouldHave(text("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));
        questionSevenAboutMoscowRegions.click();
        answerSevenAboutMoscowRegions.shouldHave(text("Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }
    public String getAnswerTextByQuestionLocator(SelenideElement questionLocator) {
        // Открываем вопрос, чтобы увидеть ответ
        questionLocator.click();
        // Получаем текст ответа, который является следующим элементом после вопроса
        SelenideElement answer = questionLocator.sibling(0);
        return answer.text();
    }
}
