package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

/**
 * Задание №6
 * Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
 * Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQLзапрос и возвращает результат.
 * Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
 * выполнения запроса и обработки результатов.
 * */
class DataProcessorTest {
    @Test
    void dataBaseTest(){
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
//        when(database.query("Oh My God")).thenReturn(new ArrayList<>(Arrays.asList("Oh", "My", "God")));
        when(database.query(anyString())).thenReturn(new ArrayList<>(Arrays.asList("Oh", "My", "God")));

        List<String> data = dataProcessor.processData("Oh My God");

        verify(database).query("Oh My God");
        assertThat(database.query("Oh My God")).isEqualTo(data);

    }

}