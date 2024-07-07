package ru.yandex.practium.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// родительский класс для пом
public class BasePage {
    // драйвер
    protected final WebDriver driver;
    // урл главной страницы
    private final static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    // конструктор класса BasePage
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // получение урла главной страницы
    public static String getMainPageUrl() {
        return MAIN_PAGE_URL;
    }

    // ожидание элемента с данным локатором
    public void waitElementToBeClickable(By elementLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(elementLocator)));
    }

    // ожидание заданного элемента
    public void waitElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}