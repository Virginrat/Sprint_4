package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.qascooter.praktikumservices.pageobjects.ScooterOrder;
import static com.codeborne.selenide.Selenide.open;
import org.junit.After;

public class ScooterOrderTests {
    WebDriver driver;

    @Test
    public void testPassedScooterOrderByPageTopButton() {
        //сделать заказ по верхней кнопке
        //открывается страница и создается экземпляр класса страницы
        ScooterOrder mainPageOrderByPageTopButton = open(ScooterOrder.URL,
                ScooterOrder.class);

        //форма "Для кого самокат"
        mainPageOrderByPageTopButton.clickPageTopButton(); //клик по кнопке Заказать наверху главной страницы
        mainPageOrderByPageTopButton.setOrderFields("Дагон", "ТожеХочетСамокат",
                "Марианская впадина", "+79152042561"); //заполнение полей формы "Для кого самокат"
        mainPageOrderByPageTopButton.clickStationInOrderForm(); //клик по кнопке выбора станции метро
        mainPageOrderByPageTopButton.clickSelectedStation("Крылатское"); //выбор станции
        mainPageOrderByPageTopButton.clickButtonNext();//клик по кнопке Далее
        //форма "Про аренду"
        mainPageOrderByPageTopButton.clickPeriodButtonOrderAboutRent(); //клик на поле выбора срока аренды
        mainPageOrderByPageTopButton.selectPeriodInOrderAboutRent("сутки"); //выбор срока "сутки"
        mainPageOrderByPageTopButton.selectGreyColorOrderAboutRent(); //выбор серого цвета самоката
        mainPageOrderByPageTopButton.setOrderFieldsAboutRent("10.06.2024",
                "Возьмите акваланг!"); //заполнение полей даты и комментария
        mainPageOrderByPageTopButton.clickButtonOrderAboutRent(); //клик по кнопке Заказать на форме "Про аренду"
        //подтверждение
        mainPageOrderByPageTopButton.clickConfirmOrderButton(); //клик по кнопке подтверждения заказа
        mainPageOrderByPageTopButton.orderTitleIsDisplayed(); //поиск заголовка "Заказ оформлен"
    }
   @Test
    public void tesPassedScooterOrderByPageMiddleButton() {
        //открывается страница и создается экземпляр класса страницы
        ScooterOrder mainPageOrderByPageMiddleButton = open(ScooterOrder.URL,
                ScooterOrder.class);

        //сделать заказ по кнопке в середине экрана
        //форма "Для кого самокат"
       mainPageOrderByPageMiddleButton.clickPageMiddleButton(); //клик по кнопке Заказать в середине главной страницы
       mainPageOrderByPageMiddleButton.setOrderFields("Сэйлор", "Мун",
                "Япония", "11111111111"); //заполнение полей формы "Для кого самокат"
       mainPageOrderByPageMiddleButton.clickStationInOrderForm(); //клик по кнопке выбора станции метро
       mainPageOrderByPageMiddleButton.clickSelectedStation("Щукинская"); //выбор станции
       mainPageOrderByPageMiddleButton.clickButtonNext();//клик по кнопке Далее
       //форма "Про аренду"
       mainPageOrderByPageMiddleButton.clickPeriodButtonOrderAboutRent(); //клик на поле выбора срока аренды
       mainPageOrderByPageMiddleButton.selectPeriodInOrderAboutRent("двое суток"); //выбор срока "двое суток"
       mainPageOrderByPageMiddleButton.selectBlackColorOrderAboutRent(); //выбор черного цвета самоката
       mainPageOrderByPageMiddleButton.setOrderFieldsAboutRent("15.06.2024",
               "Лунная призма, дай мне самокат!"); //заполнение полей даты и комментария
       mainPageOrderByPageMiddleButton.clickButtonOrderAboutRent(); //клик по кнопке Заказать на форме "Про аренду"
       //подтверждение
       mainPageOrderByPageMiddleButton.clickConfirmOrderButton(); //клик по кнопке подтверждения заказа
       mainPageOrderByPageMiddleButton.orderTitleIsDisplayed(); //поиск заголовка "Заказ оформлен"
    }
}
    @After
    public void tearDown() {
        driver.quit();
    }
}
