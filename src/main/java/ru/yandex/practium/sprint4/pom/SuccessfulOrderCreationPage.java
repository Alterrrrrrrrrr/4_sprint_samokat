package ru.yandex.practium.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// класс окна с сообщением об успешном создании заказа
public class SuccessfulOrderCreationPage extends BasePage {

    // локатор сообщения об успешном создании заказа
    private static final By SUCCESSFUL_ORDER_CREATION_MESSAGE = By.xpath(".//div[text()='Заказ оформлен']");

    // конструктор SuccessfulOrderCreationPage
    public SuccessfulOrderCreationPage(WebDriver driver) {
        super(driver);
    }

    // проверка отображения сообщение об успешном создании заказа
    public boolean isOrderCreationSuccessfulMessageVisible() {
        return driver.findElement(SUCCESSFUL_ORDER_CREATION_MESSAGE).isDisplayed();
    }
}