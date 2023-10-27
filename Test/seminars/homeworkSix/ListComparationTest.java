package seminars.homeworkSix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ListComparationTest {

    ListComparation listComparation;

    @BeforeEach
    void setUp(){
        listComparation = new ListComparation();
    }


    @Test
    void calcListAverageTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 9, 115, 23, 2));

        Double listAverage = listComparation.calcListAverage(list);

        assertThat(listAverage).isEqualTo(26.66666666666667, offset(0.0001));
    }

    @Test
    void calcListAverageExceptionNullTest() {
        List<Integer> list = new ArrayList<>();

        assertThatThrownBy(() -> listComparation.calcListAverage(list))
                .isInstanceOf(IllegalStateException.class).hasMessage("The list is empty");
    }

    @Test
    void firstAverageGreaterTest() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(4, 7, 9, 115, 23, 2));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(1, 7, 9, 0, 5, 2));

        String summary = listComparation.compareAverages(firstList, secondList);

        assertThat(summary).isEqualTo("Первый список имеет большее среднее значение");
    }

    @Test
    void secondAverageGreaterTest() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(1, 7, 9, 0, 5, 2));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(4, 7, 9, 115, 23, 2));

        String summary = listComparation.compareAverages(firstList, secondList);

        assertThat(summary).isEqualTo("Второй список имеет большее среднее значение");
    }

    @Test
    void equalAveragesTest() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(1, 7, 9, 0, 5, 2));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(1, 6, 9, 1, 5, 2));

        String summary = listComparation.compareAverages(firstList, secondList);

        assertThat(summary).isEqualTo("Средние значения равны");
    }
}
