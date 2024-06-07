package ru.qascooter.praktikumservices.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class ScooterOrder {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //локаторы формы "Для кого самокат"
    //локатор кнопки "Заказать" наверху страницы
    @FindBy(className = "Button_Button__ra12g")
    private SelenideElement makeOrderByPageTopButton;
    //локатор кнопки "Заказать" в середине страницы
    @FindBy(className = "Button_Middle__1CSJM")
    private SelenideElement makeOrderByPageMiddleButton;
    //локатор поля "Имя"
    @FindBy(xpath = ".//input[@placeholder='* Имя']")
    private SelenideElement nameField;
    //локатор поля "Фамилия"
    @FindBy(xpath = ".//input[@placeholder='* Фамилия']")
    private SelenideElement surnameField;
    //локатор поля Адрес
    @FindBy(xpath = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private SelenideElement addressField;
    //локатор поля Телефон
    @FindBy(xpath = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private SelenideElement phoneField;
    //локатор поля Станция метро
    @FindBy(xpath = ".//input[@placeholder='* Станция метро']")
    private SelenideElement stationField;
    //локатор выбора станции
    @FindBy(className = "select-search")
    private SelenideElement selectedStation;
    //локатор кнопки "Далее"
    @FindBy(className = "Button_Middle__1CSJM")
    private SelenideElement buttonNext;

    //Локаторы формы "Про аренду"
    //локатор поля срока аренды
    @FindBy(xpath = ".//div[@class='Dropdown-placeholder']")
    private SelenideElement buttonPeriodList;
    //локатор выпадающего списка
    @FindBy(className = "Dropdown-option")
    private SelenideElement dropdownPeriodList;
    //локатор черного цвета самоката
    @FindBy(id = "black")
    private SelenideElement colorBlackField;
    //локатор серого цвета самоката
    @FindBy(id = "grey")
    private SelenideElement colorGreyField;
    //локатор поля "Когда привезти"
    @FindBy(xpath = ".//input[@placeholder='* Когда привезти самокат']")
    private SelenideElement dataField;
    //локатор поля "Комментарий для курьера"
    @FindBy(xpath = ".//input[@placeholder='Комментарий для курьера']")
    private SelenideElement commentField;
    //локатор кнопки Заказать на экране "Про аренду"
    @FindBy(xpath = ".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")
    private SelenideElement buttonOrderAboutRent;

    //локатор кнопки подтверждения заказа
    @FindBy(xpath = ".//button[text()='Да']")
    private SelenideElement buttonConfirmOrder;
    //локатор заголовка подтверждения заказа
    @FindBy(className = "Order_ModalHeader__3FDaJ")
    private SelenideElement orderTitle;



    //методы формы "Для кого самокат"
    //метод клика по верхней кнопке "Заказать"
    public void clickPageTopButton() {
        makeOrderByPageTopButton.click();
    }
    //метод клика на кнопку "Заказать" в середине экрана
    public void clickPageMiddleButton() {
        makeOrderByPageMiddleButton.click();
    }
    //метод заполнения полей формы
    public void setOrderFields(String name, String surname, String address, String phone) {
        nameField.setValue(name);
        surnameField.setValue(surname);
        addressField.setValue(address);
        phoneField.setValue(phone);
    }
    //метод клика на поле "Станция"
    public void clickStationInOrderForm() {
        stationField.click();
    }
    //метод клика на выбранную станцию
    public void clickSelectedStation(String station) {
        selectedStation.find(byText(station)).click();
    }
    //метод клика по кнопке "Далее"
    public void clickButtonNext() {
        buttonNext.click();
    }

    //методы для формы "Про аренду"
    //метод клика по кнопке срока
    public void clickPeriodButtonOrderAboutRent() {
        buttonPeriodList.click();
    }
    //метод выбора срока аренды
    public void selectPeriodInOrderAboutRent(String period) {
        dropdownPeriodList.findAll(byText(period));
        dropdownPeriodList.click();
    }
    //метод выбора черного цвета самоката
    public void selectBlackColorOrderAboutRent() {
        colorBlackField.click();
    }
    //метод выбора серого цвета самоката
    public void selectGreyColorOrderAboutRent() {
        colorGreyField.click();
    }
    //метод заполнения полей формы аренды
    public void setOrderFieldsAboutRent (String data, String comment) {
        dataField.setValue(data).pressEnter();
        commentField.setValue(comment);
    }
    //метод клика на кнопку Заказать на форме аренды
    public void clickButtonOrderAboutRent() {
        buttonOrderAboutRent.click();
    }

    //методы для подтверждения заказа
    //метод клика по кнопке подтверждения заказа
    public void clickConfirmOrderButton() {
        buttonConfirmOrder.click();
    }
    //метод проверки заголовка "Заказ оформлен"
    public void orderTitleIsDisplayed() {
        orderTitle.shouldHave(text("Заказ оформлен"));
    }
}


