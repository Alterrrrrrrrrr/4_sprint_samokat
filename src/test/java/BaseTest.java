import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

// базовый класс настройки тестов
public class BaseTest {
    // переменная драйвера
    protected WebDriver driver;

    // инициализация драйвера
    @Before
    public void tearUp() {
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // ожидание заданного количества секунд
    public void implicitlyWait(int numberOfSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(numberOfSeconds));
    }

}