package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Yamaha", "YZF-R1", 2015);
    }

    /** 1. Проверить, что экземпляр объекта Car также является экземпляром транспортного средства
     * (используя оператор instanceof).
     */
    @Test
    void testCarIsInstanceOfVehicle() {
        // Assert (Проверка утверждения)
        assertTrue(car instanceof Vehicle);
    }

    /**
     * 2. Проверить, что объект Car создается с 4-мя колесами.
     */
    @Test
    void testCarHasFourWheels() {
        // Assert (Проверка утверждения)
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * 3. Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    void testMotorcycleHasTwoWheels() {
        // Assert (Проверка утверждения)
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    /**
     * 4. Проверить, что объект Car развивает скорость 60 в режиме тестового вождения
     * (используя метод testDrive()).
     */
    @Test
    void testCarHasTestSpeed60() {
        // Act (Выполнение)
        car.testDrive();
        // Assert (Проверка утверждения)
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     * 5. Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
     * (используя метод testDrive()).
     */
    @Test
    void testMotorcycleHasTestSpeed75() {
        // Act (Выполнение)
        motorcycle.testDrive();
        // Assert (Проверка утверждения)
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    /**
     * 6. Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * машина останавливается (speed = 0).
     */
    @Test
    void testParkingCarStopped() {
        // Act (Выполнение)
        car.testDrive();
        car.park();
        // Assert (Проверка утверждения)
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     * 7. Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * мотоцикл останавливается (speed = 0).
     */
    @Test
    void testParkingMotorcycleStopped() {
        // Act (Выполнение)
        motorcycle.testDrive();
        motorcycle.park();
        // Assert (Проверка утверждения)
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }

}

