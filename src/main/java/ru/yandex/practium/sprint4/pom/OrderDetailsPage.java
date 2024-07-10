package ru.yandex.practium.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// класс страницы подробностей аренды OrderDetailsPage
public class OrderDetailsPage extends BasePage {
    
    // локатор заголовка страницы
    private static final By RENT_DETAILS_HEADER = By.cssSelector("div.Order_Header__BZXOb");
    // локатор поля выбора даты доставки
    private static final By DELIVERY_DATE_FIELD = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // локатор поля выбора срока аренды
    private static final By RENTAL_PERIOD_FIELD = By.cssSelector("div.Dropdown-root");
    private By rentalPeriodDropdownOption; // локатор пункта выпадающего меню о сроке аренды
    private By colorCheckBox; // локатор чек-бокса c цветом самоката
    // локатор поля для комментария
    private static final By COMMENT_FIELD = By.cssSelector("input[placeholder='Комментарий для курьера']");
    // локатор кнопки подтверждения заказа
    private static final By ORDER_CONFIRM_BUTTON =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");


    // Конструктор класса RentPage
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }


    // локатор поля ввода комментария
    public By getCommentLocator() {
        return COMMENT_FIELD;
    }


    // проверка доступности заголовка страницы
    public boolean isRentHeaderVisible() {
        return driver.findElement(RENT_DETAILS_HEADER).isDisplayed();
    }

    // ввод даты доставки
    public void enterDeliveryDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // установка формата даты на дд.мм.гггг
        // получение текущей даты и прибавляем к ней 1 дня
        String date = LocalDate.now().plusDays(1).format(formatter);
        driver.findElement(DELIVERY_DATE_FIELD).sendKeys(date); // ввод полученной даты
        driver.findElement(DELIVERY_DATE_FIELD).sendKeys(Keys.ENTER); // энтер
    }

    // выбор срока аренды
    public void chooseRentalPeriod(String rentalPeriod) {
        driver.findElement(RENTAL_PERIOD_FIELD).click(); // клик по полю выбора срока аренды
        // выбор и клик по сроку аренды из выпадающего списка
        String rentalPeriodLocator = String.format(".//div[text()='%s']", rentalPeriod);
        this.rentalPeriodDropdownOption = By.xpath(rentalPeriodLocator);
        driver.findElement(rentalPeriodDropdownOption).click();
    }

    // выбор цвета самоката
    public void chooseColor(String color) {
        this.colorCheckBox = By.id(color);
        driver.findElement(colorCheckBox).click();
    }

    // клик по кнопке подтверждения заказа
    public void clickOnOrderButton() {
        waitElementToBeClickable(ORDER_CONFIRM_BUTTON);
        driver.findElement(ORDER_CONFIRM_BUTTON).click();
    }

}