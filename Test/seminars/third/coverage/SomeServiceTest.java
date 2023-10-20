package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {

   SomeService service;
    @BeforeEach
    void setUp(){
        service = new SomeService();
    }

    /**
     * Задание №1
     * Создайте набор тестов, полностью покрывающих все ветви кода функции fizzBuzz. Эта
     * функция принимает на вход число и возвращает "Fizz", если число делится на 3, "Buzz",
     * если число делится на 5, и "FizzBuzz", если число делится на 15. Если число не делится ни
     * на 3, ни на 5, ни на 15, функция возвращает входное число в виде строки.
     * */

    /*1.1*/
    @ParameterizedTest
    @ValueSource(ints ={3,6,9,12})
    void multipleThreeNotFiveReturnsFizz(int input) {
         String actual = service.fizzBuzz(input);

         assertThat(actual).isEqualTo("Fizz");
    }

    /*1.2*/
    @ParameterizedTest
    @ValueSource(ints ={5,10,20,25})
    void multipleFiveNotThreeReturnsBuzz(int input) {
        String actual = service.fizzBuzz(input);

        assertThat(actual).isEqualTo("Buzz");
    }

    /*1.3*/
    @ParameterizedTest
    @ValueSource(ints ={15,30,45,60})
    void multipleFiveWithThreeReturnsFizzBuzz(int input) {
        String actual = service.fizzBuzz(input);

        assertThat(actual).isEqualTo("FizzBuzz");
    }

    /*1.4*/
    @ParameterizedTest
    @ValueSource(ints ={14,31,46,61})
    void multipleNoFiveNoThreeReturnsValue(int input) {
        String actual = service.fizzBuzz(input);
        assertThat(actual).isEqualTo(String.valueOf(input));
    }

    /******************************************************/


    /**
     * Задание №2
     * Разработайте тесты для метода firstLast6, где на вход подается массив чисел, а метод
     * возвращает true, если первое или последнее число в массиве равно 6, иначе false.
     * */

    /*2.1*/
    @Test
    void checkNullableArray(){
        boolean actual = service.firstLast6(null);
        assertFalse(actual);
    }

    /*2.2*/
    @Test
    void checkEmptyArray(){
        boolean actual = service.firstLast6(new int[]{});
        assertFalse(actual);
    }

    /*2.3*/
    @Test
    void checkWithout6Array(){
        boolean actual = service.firstLast6(new int[]{0,0,0});
        assertFalse(actual);
    }

    /*2.4*/
    @Test
    void checkFirst6Array(){
        boolean actual = service.firstLast6(new int[]{6,0,0});
        assertTrue(actual);
    }

    /*2.5*/
    @Test
    void checkLast6Array(){
        boolean actual = service.firstLast6(new int[]{0,0,6});
        assertTrue(actual);
    }

    /*2.6*/
    @Test
    void checkMiddle6Array(){
        boolean actual = service.firstLast6(new int[]{0,6,0});
        assertFalse(actual);
    }

    /*2.7*/
    @Test
    void checkAndFirstAndLast6Array(){
        boolean actual = service.firstLast6(new int[]{6,0,6});
        assertTrue(actual);
    }

    /******************************************************/


    /**
     * Задание №3
     * Создайте тесты, обеспечивающие полное покрытие кода метода calculatingDiscount, который принимает сумму
     * покупки и размер скидки, затем вычисляет и возвращает сумму с учетом скидки. Метод должен обрабатывать
     * исключения, связанные с некорректным размером скидки или отрицательной суммой покупки.
     * */

    /*3.1*/
    @ParameterizedTest
    @CsvSource(value = {"100, 50", "200, 50", "1000, 20"})
    void checkCalculateDiscountPositive(double purchase, int discount){
        double actual = service.calculatingDiscount(purchase, discount);
        assertThat(actual).isEqualTo(purchase - purchase * discount / 100);
    }

    /*3.2*/
    @ParameterizedTest
    @CsvSource(value = {"-100, 50", "-200, 50", "-1000, 20"})
    void checkCalculateDiscountWithNegPurchaseNegative(double purchase, int discount){
        Exception exc = assertThrows(IllegalArgumentException.class,
                ()-> service.calculatingDiscount(purchase, discount));
        assertEquals(exc.getMessage(), "purchase can't be less than zero");
    }

    /*3.3*/
    @ParameterizedTest
    @CsvSource(value = {"100, -50", "200, -50", "1000, -20"})
    void checkCalculateDiscountWithNegDiscNegative(double purchase, int discount){
        Exception exc = assertThrows(IllegalArgumentException.class,
                ()-> service.calculatingDiscount(purchase, discount));
        assertEquals(exc.getMessage(), "discount can't be less than zero");
    }

    /*3.4*/
    @ParameterizedTest
    @CsvSource(value = {"100, 150", "200, 150", "1000, 120"})
    void checkCalculateDiscountWithBigDiscountNegative(double purchase, int discount){
        Exception exc = assertThrows(IllegalArgumentException.class,
                ()-> service.calculatingDiscount(purchase, discount));
        assertEquals(exc.getMessage(), "discount can't be greater than zero");
    }


    /******************************************************/


    /**
     * Задание №4
     * Разработайте метод luckySum и напишите для него тесты. Этот метод принимает на вход три числа и возвращает
     * их сумму. Однако, если одно из чисел равно 13, то оно не учитывается при подсчете суммы.
     * Так, например, если b равно 13, то считается сумма только a и c.
     * */

    /*4.1*/
    @Test
    void checkSumThreeNumbersPositiveResult(){
        int actual = service.calculatingSumThreeNumbers(1, 2, 3);
        assertThat(actual).isEqualTo(6);
    }

    /*4.2*/
    @Test
    void checkSumThreeNumbersNegativeResult(){
        assertThat(service.calculatingSumThreeNumbers(13, 2, 3))
                .isEqualTo(5);
        assertThat(service.calculatingSumThreeNumbers(1, 2, 13))
                .isEqualTo(3);
        assertThat(service.calculatingSumThreeNumbers(1, 13, 3))
                .isEqualTo(4);

        assertThat(service.calculatingSumThreeNumbers(13, 2, 13))
                .isEqualTo(2);
        assertThat(service.calculatingSumThreeNumbers(1, 13, 13))
                .isEqualTo(1);
        assertThat(service.calculatingSumThreeNumbers(13, 13, 3))
                .isEqualTo(3);

        assertThat(service.calculatingSumThreeNumbers(13, 13, 13))
                .isEqualTo(0);
    }

}