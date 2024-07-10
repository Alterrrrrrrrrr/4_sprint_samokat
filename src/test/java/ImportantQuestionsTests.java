import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practium.sprint4.pom.*;

// аннотация параметризации раздела "Вопросы о важном"
@RunWith(Parameterized.class)
public class ImportantQuestionsTests extends BaseTest{

    private final String questionNumber; // номер вопроса в разделе
    private String expected; // ожидаемый текст ответа
    private String actual; // действительный текст ответа

    // конструктор ImportantQuestionsTests
    public ImportantQuestionsTests (String questionField, String expected) {
        this.questionNumber = questionField;
        this.expected = expected;
    }

    // параметризация данных
    @Parameterized.Parameters
    public static Object[][] getQuestionNumber() {
        return new Object[][] {
                {"0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    // метод теста
    @Test
    public void checkClickQuestion_expectTextIsDisplayed() {
        super.implicitlyWait(3); // ожидание

        MainPage mainPage = new MainPage(driver); // экземпляр класса главной страницы
        mainPage.open(); //
        mainPage.clickOnQuestion(questionNumber); // клик на вопрос

        // проверка открывающегося текста
        actual = mainPage.getAnswerDisplayed(questionNumber);
        Assert.assertEquals("Wrong text found in " + questionNumber + " answer", expected, actual);
    }

}