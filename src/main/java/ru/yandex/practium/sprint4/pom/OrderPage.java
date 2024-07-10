package ru.yandex.practium.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

// класс страницы с формой заказа
public class OrderPage extends BasePage{
    
    // локатор заголовка формы заказа
    private static final By ORDER_FORM_HEADER = By.cssSelector("div.Order_Header__BZXOb");
    // локатор поля ввода имени
    private static final By NAME_FIELD = By.cssSelector("input[placeholder='* Имя']");
    // локатор поля ввода фамилии
    private static final By SURNAME_FIELD = By.cssSelector("input[placeholder='* Фамилия']");
    // локатор поля ввода адреса
    private static final By ADDRESS_FIELD = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // локатор поля выбора станции метро
    private static final By METRO_FIELD = By.cssSelector("input[placeholder='* Станция метро']");
    // локатор поля ввода номера телефона
    private static final By PHONE_NUMBER_FIELD =
            By.cssSelector(("input[placeholder='* Телефон: на него позвонит курьер']"));
    // локатор кнопки Далее
    private static final By CONTINUE_BUTTON = By.xpath(".//button[text()='Далее']");

    // конструктор класса OrderPage
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    // возвращение локатора поля ввода имени
    public By getNameLocator() {
        return NAME_FIELD;
    }

    // возвращение локатора поля ввода фамилии
    public By getSurnameLocator() {
        return SURNAME_FIELD;
    }


    // возвращение локатора поля ввода адреса
    public By getAddressLocator() {
        return ADDRESS_FIELD;
    }


    // возвращение локатора поля ввода номера телефона
    public By getPhoneNumberLocator() {
        return PHONE_NUMBER_FIELD;
    }


    // проверка отображения заголовка формы заказа
    public boolean isOrderFormHeaderVisible() {
        return driver.findElement(ORDER_FORM_HEADER).isDisplayed();
    }

    // заполнение поля c определенным локатором данными
    public void enterData(By locator, String data) {
        driver.findElement(locator).sendKeys(data);
    }

    // выбор станции метро
    public void chooseMetroStation() {
        driver.findElement(METRO_FIELD).click();
        driver.findElement(METRO_FIELD).sendKeys(Keys.DOWN);
        driver.findElement(METRO_FIELD).sendKeys(Keys.ENTER);
    }

    // клика по кнопке Далее
    public void clickOnContinueButton() {
        waitElementToBeClickable(CONTINUE_BUTTON);
        driver.findElement(CONTINUE_BUTTON).click();
    }


}