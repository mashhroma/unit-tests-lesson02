package seminars.third.hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TddTests {

    /**
     * Задание 1.
     * Напишите тесты, покрывающие на 100% метод evenOddNumber,
     * который проверяет, является ли переданное число четным или нечетным. (код приложен в презентации)
     * */

    // 1.1
    @ParameterizedTest
    @ValueSource(ints ={2,6,12,-204})
    void testEvenNumber(int num) {
        NumberChecker numberChecker = new NumberChecker();
        boolean check = numberChecker.evenOddNumber(num);

        assertTrue(check);
    }

    // 1.2
    @ParameterizedTest
    @ValueSource(ints ={1,7,13,-205})
    void testOddNumber(int num) {
        NumberChecker numberChecker = new NumberChecker();
        boolean check = numberChecker.evenOddNumber(num);

        assertFalse(check);
    }



    /**
     * Задание 2. Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли
     * переданное число в интервал (25;100)
     * */

    // 2.1
    @ParameterizedTest
    @CsvSource(value = {"25, 100, 50", "10, 13, 12", "0, 555, 400", "-70, 70, 0"})
    void testNumberInIntervalTrue(int intervalStart, int intervalEnd, int number){
        NumberChecker numberChecker = new NumberChecker();
        boolean check = numberChecker.numberInInterval(intervalStart, intervalEnd, number);

        assertTrue(check);
    }

    // 2.2
    @ParameterizedTest
    @CsvSource(value = {"100, 25, 50", "13, 10, 12", "555, 0, 400", "70, -70, 0"})
    void testNumberInIntervalTrueReverse(int intervalStart, int intervalEnd, int number){
        NumberChecker numberChecker = new NumberChecker();
        boolean check = numberChecker.numberInInterval(intervalStart, intervalEnd, number);

        assertTrue(check);
    }

    // 2.3
    @ParameterizedTest
    @CsvSource(value = {"25, 100, 25", "10, 13, 13", "0, 555, -400", "-70, 70, 100"})
    void testNumberInIntervalFalse(int intervalStart, int intervalEnd, int number){
        NumberChecker numberChecker = new NumberChecker();
        boolean check = numberChecker.numberInInterval(intervalStart, intervalEnd, number);

        assertFalse(check);
    }

}
