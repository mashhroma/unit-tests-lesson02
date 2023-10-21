package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {

    /**
     * Задание №5
     * Примените подход TDD для создания нового класса MoodAnalyser,
     * который оценивает настроение выраженное во фразах.
     * *
     */

    MoodAnalyser moodAnalyser;
    @BeforeEach
    void  setUp(){
        moodAnalyser = new MoodAnalyser();
    }

    //3.5. Red-Green-Refactor
    @ParameterizedTest
    @ValueSource(strings = {"Hi","Hello", "Ok"})
    void checkGoodMood(String input){
        String actual = moodAnalyser.analyseMood(input);

        assertThat(actual).isEqualTo("Great");
    }

    @ParameterizedTest
    @ValueSource(strings = {"By", "Sad", "Bad"})
    void checkBadMood(String input){
        String actual = moodAnalyser.analyseMood(input);

        assertThat(actual).isEqualTo("You make me sadly");
    }

    @ParameterizedTest
    @ValueSource(strings = {"..", "..", ".."})
    void checkUnknownMood(String input){
        String actual = moodAnalyser.analyseMood(input);

        assertThat(actual).isEqualTo("What are you mean?");
    }
}