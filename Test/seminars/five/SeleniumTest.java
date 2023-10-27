package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SeleniumTest {

    /**
     * Задание №4
     * Напишите автоматизированный тест, который выполнит следующие шаги:
     * 1. Открывает главную страницу Google.
     * 2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
     * 3. В результатах поиска ищет ссылку на официальный сайт Selenium
     * (https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди
     * результатов поиска.
     * */

    @Test
    void seleniumTest(){
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.google.com");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        WebElement seleniumEl = webDriver.findElement(By.tagName("cite"));

        assertThat(seleniumEl.getText()).isEqualTo("https://www.selenium.dev");


//        webDriver.quit();
    }

    @Test
    void seleniumSecondTest() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        List<WebElement> seleniumElement = webDriver.findElements(By.cssSelector("div"));
        boolean f = false;
        for (WebElement element : seleniumElement) {
            if (element.getText().contains("https://www.selenium.dev")) {
                f = true;
                break;
            }
        }
        assertThat(f).isTrue();

        Thread.sleep(1000);
        webDriver.quit();
    }

    /**
     * Задание №5
     * Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя на
     * сайте https://www.saucedemo.com/.
     * Данные для входа - логин: "standard_user", пароль: "secret_sauce".
     * Проверить, что авторизация прошла успешно и отображаются товары.
     * Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
     * данных в поля формы, и submit() для отправки формы. После этого, проверьте, что на странице
     * отображаются продукты (productsLabel.getText() = "Products").
     * */

    @Test
    void autorisationTest(){
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.saucedemo.com/");
        WebElement userEl = webDriver.findElement(By.id("user-name"));
        userEl.sendKeys("standard_user");
        WebElement passwordEl = webDriver.findElement(By.id("password"));
        passwordEl.sendKeys("secret_sauce");
        passwordEl.submit();
        WebElement productsLabel = webDriver.findElement(By.className("title"));

        assertThat(productsLabel.getText()).isEqualTo("Products");
    }
}
