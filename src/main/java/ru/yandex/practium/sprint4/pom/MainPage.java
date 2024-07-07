package ru.yandex.practium.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Создаем класс главной страницы MainPage
public class MainPage extends BasePage {

    // локатор верхней кнопки заказа
    private static final By HEADER_ORDER_BUTTON =
            By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // локатор нижней кнопки заказа
    private static final By BODY_ORDER_BUTTON =
            By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");


    // конструктор класса MainPage
    public MainPage(WebDriver driver) {
        super(driver);
    }

    // метод открытия стартовой страницы
    public void open() {
        driver.get(BasePage.getMainPageUrl());
    }

    // метод клика на вопрос
    public void clickOnQuestion(String questionNumber) {
        // определение локатора вопроса
        By questionLocator;
        String questionId = String.format("accordion__heading-%s", questionNumber);
        questionLocator = By.id(questionId);
        // поиск вопроса по локатору
        WebElement questionElement = driver.findElement(questionLocator);
        // скролинг страницы до вопроса
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        // ожидание доступности вопроса
        waitElementToBeClickable(questionElement);
        // клик на вопрос
        questionElement.click();
    }

    // проверка доступности ответа на вопрос
    public boolean isAnswerDisplayed(String questionNumber) {
        // локатор ответа в зависимости от переменной
        By answerLocator;
        String answerId = String.format("accordion__panel-%s", questionNumber);
        answerLocator = By.id(answerId);
        // поиск ответа по локатору
        WebElement answerElement = driver.findElement(answerLocator);
        // ожидание доступности ответа
        waitElementToBeClickable(answerElement);
        return answerElement.isDisplayed();
    }

    // метод клика по верхней или нижней кнопке заказа самоката
    public void clickOrderButton(String orderButton) {
        if (orderButton.equals("верхняя кнопка заказа")) {
            driver.findElement(HEADER_ORDER_BUTTON).click();
        } else if (orderButton.equals("нижняя кнопка заказа")) {
            // скрол до кнопки
            WebElement lowerOrderButton = driver.findElement(BODY_ORDER_BUTTON);
            ((JavascriptExecutor)driver).
                    executeScript("arguments[0].scrollIntoView();", lowerOrderButton);
            waitElementToBeClickable(lowerOrderButton); // ожидание доступности кнопки
            lowerOrderButton.click();
        }
    }

}