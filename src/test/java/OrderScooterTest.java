import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practium.sprint4.pom.*;

@RunWith(Parameterized.class)
// Класс для тестирования заказа самоката
public class OrderScooterTest extends BaseTest {

    // Поля класса
    private final String orderButton; // кнопка заказа (верхняя или нижняя)
    private final String name; // имя
    private final String surname; // фамилия
    private final String adress; // адрес
    private final String phoneNumber; // номер телефона
    private final String rentalPeriod; // период аренды
    private final String colour; // цвет самоката
    private final String comment; // комментарий
    private boolean actual; // флаг соответствия ожидаемому результату

    // конструктор OrderScooterTest
    public OrderScooterTest(String orderButton, String name, String surname, String adress, String phoneNumber, String rentalPeriod, String colour, String comment)
    {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.comment = comment;
    }

    // параметризация данных
    @Parameterized.Parameters
    public static Object[][] getOrderFormData() {
        return new Object[][] {
                { "верхняя кнопка заказа", "Георгий", "Бакланский", "3-я улица Строителей, 25-12", "+79991234567", "сутки", "black", "Три коротких звонка" },
                { "нижняя кнопка заказа", "Евфросиния", "Залихватская", "Советский Союз", "+79997654321", "семеро суток", "grey", "А курьер тоже на самокате приезжает?" },
        };
    }

    // тест проверки заказа самоката
    @Test
    public void checkOrderScooterExpectedIsOrdered() {
        super.implicitlyWait(3); // Неявное ожидание

        // экземпляр класса главной страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderButton(orderButton); // клик по заданной кнопке заказа самоката

        // экземпляр класса страницы формы заказа
        OrderPage orderPage = new OrderPage(driver);
        orderPage.isOrderFormHeaderVisible(); // проверка отображения заголовка формы заказа
        orderPage.enterData(orderPage.getNameLocator(), name); // ввод имени
        orderPage.enterData(orderPage.getSurnameLocator(), surname); // ввод фамилии
        orderPage.enterData(orderPage.getAddressLocator(), adress); // ввод адреса
        orderPage. chooseMetroStation(); // выбор станции метро
        orderPage.enterData(orderPage.getPhoneNumberLocator(), phoneNumber); // ввод номера телефона
        orderPage.clickOnContinueButton(); // клик на кнопку Далее

        // экземпляр класса страницы детали арендф
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.isRentHeaderVisible(); // проверка отображения ли заголовок про аренду
        orderDetailsPage.enterDeliveryDate(); // ввод даты доставки
        orderDetailsPage.chooseRentalPeriod(rentalPeriod); // выбор срока ареды
        orderDetailsPage.chooseColor(colour); // выбор цвета самоката
        orderPage.enterData(orderDetailsPage.getCommentLocator(), comment); // ввод комментария
        orderDetailsPage.clickOnOrderButton(); // клик по кнопке подтверждения заказа

        // экземпляр класса окна с вопросом о подтверждении заказа
        ConfirmationOrderPage confirmationOrderPage = new ConfirmationOrderPage(driver);
        confirmationOrderPage.isConfirmQuestionIsVisible(); // проверка доступности вопроса о подтверждении заказа
        confirmationOrderPage.clickOnConfirmationButton(); // клик на кнопку подтверждения заказа

        // экземпляр класса окна с сообщением об успешном создании заказа
        SuccessfulOrderCreationPage successfulOrderCreationPage = new SuccessfulOrderCreationPage(driver);
        // проверка отображения сообщения об успешном создании заказа
        actual = successfulOrderCreationPage.isOrderCreationSuccessfulMessageVisible();
        Assert.assertTrue("Something went wrong with the order scenario",
                actual);
    }

}