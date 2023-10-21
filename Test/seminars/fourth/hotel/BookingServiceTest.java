package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

/**
 * Задание №4
 * Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
 * Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
 * который обычно проверяет, доступен ли номер в отеле.
 * Вам необходимо проверить правильность работы класса BookingService, который
 * использует HotelService для бронирования номера, если он доступен.
 * */
class BookingServiceTest {

    @Test
    void testHotelService() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(2)).thenReturn(true);

        boolean check = bookingService.bookRoom(2);

        verify(hotelService).isRoomAvailable(2);
        assertThat(check).isTrue();
    }
}