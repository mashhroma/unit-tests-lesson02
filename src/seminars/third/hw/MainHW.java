package seminars.third.hw;

public class MainHW {
    public static void main(String[] args) {

        NumberChecker numberChecker = new NumberChecker();

        // HW 3.1. Нужно покрыть тестами метод на 100%
        // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).
        System.out.println(numberChecker.evenOddNumber(1000));

        // HW 3.2. Нужно написать метод, который проверяет,
        // попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
        // покрыть тестами метод на 100%
        System.out.println(numberChecker.numberInInterval(25, 100, 50));

    }
}
