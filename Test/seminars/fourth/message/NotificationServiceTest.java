package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Задание №5
 * Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
 * Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
 * recipient), который отправляет сообщение получателю.
 * Вам необходимо проверить правильность работы класса NotificationService, который использует
 * MessageService для отправки уведомлений.
 * */
class NotificationServiceTest {

    @Test
    void messageServiceTest(){
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        notificationService.sendNotification("Hello ", "Darling");

        verify(messageService).equals("Hello Darling");
    }
}