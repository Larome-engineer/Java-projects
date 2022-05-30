package chat.bot;
import java.util.*;
import java.util.regex.*;

public class SimpleBot {
    Pattern pattern;
    Random random;
    Date date;

    final String[] COMMON_PHRASES = {
            "Куда гонишь брат?",
            "Да и хуй с ним"
    };

    final String[] ELUSIVE_ANSWERS ={
            "Ура, ты вернулся!",
            "Отлично! А как твои?",
            "Общаюсь с тобой!"
    };

    SimpleBot(){
        random = new Random();
        date = new Date();
    }

    String SayInReturn(String msg, boolean ai){
        String say = (msg.trim().endsWith("?"))?
            ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)] :
            COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];
        return say + "\n";
    }
}
