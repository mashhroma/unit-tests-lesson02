package seminars.third.hw;

public class NumberChecker {

    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean numberInInterval(int intervalStart, int intervalEnd, int number) {
        if (number > intervalStart && number < intervalEnd) {
            return true;
        } else if (number < intervalStart && number > intervalEnd) {
                return true;
        } else {
            return false;
        }
    }
}
