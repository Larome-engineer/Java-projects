import mySocketPhone.Phone;
import java.io.*;

public class Client {

    public static void main(String[] args) {

        try (Phone phone = new Phone("127.0.0.1", 8000)){

            System.out.println("Вы подключились к серверу!");

            String request = "Город: Санкт-Петербург";
            System.out.println(request);
            phone.writeLine(request);

            String response = phone.readNLine();
            System.out.println("Температура воздуха: " + response + "градуса");

        } catch (IOException e){throw new RuntimeException(e);}

    }
}
