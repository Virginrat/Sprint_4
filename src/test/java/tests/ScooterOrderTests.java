package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.qascooter.praktikumservices.pageobjects.ScooterOrder;
import static com.codeborne.selenide.Selenide.open;
import org.junit.After;
import java.util.List;

@RunWith(Parameterized.class)
public class ScooterOrderTest {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String station;
    private final String phoneNumber;
    private final String date;
    private final String rentPeriod;
    private final String comment;

    // Конструктор для параметризованного теста
    public ScooterOrderTest(String firstName, String lastName, String address, String station, String phoneNumber, String date, String rentPeriod, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.comment = comment;
    }

    // Параметры для теста
    @Parameterized.Parameters
    public static List<Object[]> getTextData() {
        return List.of(
                new Object[]{"Дагон","ТожеХочетСамокат", "Марианская впадина", "Крылатское", "+79152042561", "10.06.2024", "сутки", "Возьмите акваланг!"},
                new Object[]{"Сэйлор","Мун", "Япония", "Щукинская", "11111111111", "15.06.2024", "двое суток", "Лунная призма, дай мне самокат!"}
        );
    }
    WebDriver driver;
    // Тестовый метод для верхней кнопки
    @Test

    public void testPassedScooterOrderByPageTopButton() {
        ScooterOrder mainPageOrderByPageTopButton = open(ScooterOrder.URL, ScooterOrder.class);
        mainPageOrderByPageTopButton.clickPageTopButton();
        mainPageOrderByPageTopButton.setOrderFields(firstName, lastName, address, phoneNumber);
        mainPageOrderByPageTopButton.clickStationInOrderForm();
        mainPageOrderByPageTopButton.clickSelectedStation(station);
        mainPageOrderByPageTopButton.clickButtonNext();
        mainPageOrderByPageTopButton.clickPeriodButtonOrderAboutRent();
        mainPageOrderByPageTopButton.selectPeriodInOrderAboutRent(rentPeriod);
        mainPageOrderByPageTopButton.setOrderFieldsAboutRent(date, comment);
        mainPageOrderByPageTopButton.clickButtonOrderAboutRent();
        mainPageOrderByPageTopButton.clickConfirmOrderButton();
        mainPageOrderByPageTopButton.orderTitleIsDisplayed();
    }

    // Тестовый метод для средней кнопки
    @Test

    public void testPassedScooterOrderByPageMiddleButton() {
        ScooterOrder mainPageOrderByPageMiddleButton = open(ScooterOrder.URL, ScooterOrder.class);
        mainPageOrderByPageMiddleButton.clickPageMiddleButton();
        mainPageOrderByPageMiddleButton.setOrderFields(firstName, lastName, address, phoneNumber);
        mainPageOrderByPageMiddleButton.clickStationInOrderForm();
        mainPageOrderByPageMiddleButton.clickSelectedStation(station);
        mainPageOrderByPageMiddleButton.clickButtonNext();
        mainPageOrderByPageMiddleButton.clickPeriodButtonOrderAboutRent();
        mainPageOrderByPageMiddleButton.selectPeriodInOrderAboutRent(rentPeriod);
        mainPageOrderByPageMiddleButton.setOrderFieldsAboutRent(date, comment);
        mainPageOrderByPageMiddleButton.clickButtonOrderAboutRent();
        mainPageOrderByPageMiddleButton.clickConfirmOrderButton();
        mainPageOrderByPageMiddleButton.orderTitleIsDisplayed();
    }

    @After
    public void tearDown() {

       if (driver != null) {
            driver.quit();
        }
    }
}
