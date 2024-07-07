import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practium.sprint4.pom.*;

// аннотация параметризации раздела "Вопросы о важном"
@RunWith(Parameterized.class)
public class ImportantQuestionsTests extends BaseTest{

    private final String questionNumber; // номер вопроса в разделе
    private boolean actual; // флаг ожидаемого результата

    // конструктор ImportantQuestionsTests
    public ImportantQuestionsTests (String questionField) {
        this.questionNumber = questionField;
    }

    // параметризация данных
    @Parameterized.Parameters
    public static Object[][] getQuestionNumber() {
        return new Object[][] {
                {"0"},
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"},
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
        actual = mainPage.isAnswerDisplayed(questionNumber);
        Assert.assertTrue("Expect: price and payment text is displayed", actual);
    }

}