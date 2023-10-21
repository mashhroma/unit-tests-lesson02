package seminars.fourth.webService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Задание №7
 * Вам нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы.
 * Условие: У вас есть класс HttpClient с методом public String get(String url), который выполняет
 * HTTP-запрос и возвращает результат. Вам необходимо проверить правильность работы класса
 * WebService, который использует HttpClient для получения данных с веб-сайта.
 * */
public class webServiceTest {

    @Test
    void httpClientTest(){

        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.get(anyString())).thenReturn("some page");

        String result = webService.getPage("some page");

        verify(httpClient).get("some page");
        assertEquals("some page", result);

    }
}
