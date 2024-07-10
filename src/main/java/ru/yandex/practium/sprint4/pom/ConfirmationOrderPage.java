package ru.yandex.practium.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// класс окна подтверждения заказа
public class ConfirmationOrderPage extends BasePage {

    // локатор вопроса о подтверждении заказа
    private static final By CONFIRMATION_QUESTION = By.xpath(".//div[text()='Хотите оформить заказ?']");
    // локатор кнопки подтверждения заказа
    private static final By CONFIRMATION_BUTTON = By.xpath(".//button[text()='Да']");

    // конструктор класса страницы
    public ConfirmationOrderPage(WebDriver driver) {
        super(driver);
    }

    // проверка отображения вопроса о подтверждении заказа
    public boolean isConfirmationQuestionVisible() {
        return driver.findElement(CONFIRMATION_QUESTION).isDisplayed();
    }
    // Метод кликает по кнопке подтверждения заказа
    public void clickOnConfirmationButton() {
        waitElementToBeClickable(CONFIRMATION_BUTTON);
        driver.findElement(CONFIRMATION_BUTTON).click();
    }

}