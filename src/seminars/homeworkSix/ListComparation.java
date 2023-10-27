package seminars.homeworkSix;

import java.util.ArrayList;
import java.util.List;

public class ListComparation {

    public Double calcListAverage(List<Integer> list) {
        if (list.isEmpty()){
            throw new IllegalStateException("The list is empty");
        }
        Integer result = 0;
        for (int number: list) {
            result += number;
        }
        return (double) result / list.size();
    }

    public String compareAverages(List<Integer> firstList, List<Integer> secondList) {
        if (calcListAverage(firstList) > calcListAverage(secondList)) {
            return "Первый список имеет большее среднее значение";
        } else if (calcListAverage(firstList) < calcListAverage(secondList)) {
            return "Второй список имеет большее среднее значение";
        }else {
            return "Средние значения равны";
        }
    }
}
