package seminars.five;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {


    /**
     * Задание №1
     * Создайте два модуля. Первый модуль генерирует список случайных чисел. Второй модуль находит
     * максимальное число в этом списке.
     * Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
     * тест, который проверяет, что оба модуля работают вместе правильно
     */
    //5.1.

    List<Integer> randomList;
    @BeforeEach
    void setUp(){
        randomList = Arrays.asList(2,5,9,7,6,1);
    }


    @Test
    void maxNumberModuleTest(){
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        int maxValue = maxNumberModule.getMaxValue(randomList);

        assertThat(maxValue).isEqualTo(9);
    }

    @Test
    void RandomNumberModuleTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();

        randomList = randomNumberModule.getList(6);

        assertThat(randomList.size()).isEqualTo(6);
    }

    @Test
    void maxRandomNumberTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        randomList = randomNumberModule.getList(6);
        int maxValue = maxNumberModule.getMaxValue(randomList);

        assertThat(Collections.max(randomList)).isEqualTo(maxValue);
    }


    /**
     * Задание №2
     * У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для
     * получения информации о пользователе. Ваша задача - написать интеграционный тест, который
     * проверяет, что UserService и UserRepository работают вместе должным образом.*/
    //5.2.

    @Test
    void userServiceTest() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String user = userService.getUserName(5);

        assertThat(user).isEqualTo("User 5");
    }


    /**
     * Задание №3
     * У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и
     * PaymentService. Класс OrderService обрабатывает заказы и делает вызовы к
     * PaymentService для обработки платежей. Ваша задача - написать интеграционный тест,
     * который проверяет, что OrderService и PaymentService взаимодействуют корректно*/
    //5.3.

    @Test
    void orderServiceTest () {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("ord_15", 15000);

        assertTrue(result);
    }
}