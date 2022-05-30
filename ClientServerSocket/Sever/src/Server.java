import mySocketPhone.Phone;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {

            System.out.println("Сервер запущен!");

            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    String response = (int) (Math.random() * 30 - 10) + " ";
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    phone.writeLine(response);
                    System.out.println("Клиент получил ответ!");
                    try {
                        phone.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
