package chat.bot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleChatBot extends JFrame implements ActionListener {
    /*Наследуем JFrame и реализуем интерфейс ActionListener*/
    final String TITLE_OF_PROGRAM = "Chatter: simple chatbot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;

    JTextArea dialogue; //Рамки для диалога
    JCheckBox ai; // Вкл/выкл АИ // Объявляем объект ai
    JTextField message; // Поле для ввода сообщения
    SimpleBot sbot; //чат-бот класс //Объявляем объект sbot

    SimpleChatBot() {
        // Все set операции - это вызов метода JFrame.
        setTitle(TITLE_OF_PROGRAM); // Этот метод объявляет заголовок программы
        setDefaultCloseOperation(EXIT_ON_CLOSE); /* Этот метод определяет завершение программы, если
        мы нажимаем на крестик (закрыть программу)*/
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT); /* Этот метод устанавливает коорди-
        -наты окна и его размеры, где START_LOCATION - координаты X и Y, WINDOW_WIDTH, WINDOW_HEIGHT - ширина
        и высота окна в пикселях*/

        //area for dialogue
        dialogue = new JTextArea(); // Объявляем диалоговое окно
        dialogue.setLineWrap(true); // Ставим перенос строки значение тру
        JScrollPane scrollBar = new JScrollPane(dialogue); /* объявляем scrollbar(окно c диалогом) и помещаем туда объект, кот
        орый будем скролить (в данном случае dialogue) */


        //Panel for checking, message field and button (bp - button panel)
        JPanel bp = new JPanel(); /*Создаем объект-панель bp на основе класса JPanel*/
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS)); /* обозначаем для объекта компоновщик - setLayout, где
        вызываем компоновщик BoxLayout, в которое помещаем наш объект и BoxLayout.X_AXIS, чтобы окно находилось
        по горизонтали */

        ai = new JCheckBox("AI"); /*создаем компонент CheckBox*/
        //ai.doClick();
        message = new JTextField(); /*Создаем компонент message на основе класса JTextField*/
        message.addActionListener( this);
        JButton enter = new JButton("Send"); /*Создаем кнопку с именем Enter*/
        enter.addActionListener( this); /*запускаем/регистрируем прослушиватель событий на этой кнопке*/

        //Add all elements to the window /*Добавляем все созданные объект в панель bp --> */
        bp.add(ai);
        bp.add(message);
        bp.add(enter);
        /*Два нижних объекта add работают на всё окно*/
        add(BorderLayout.CENTER, scrollBar); /* После объявления объекта, его нужно добавить, поэтому вызываем add
        и добавляем туда расположение объекта и какой объект будем добавлять, в данном случае расположил по центру Scrollbar*/
        add(BorderLayout.SOUTH, bp); /*Добавил объект-панель bp в нижнюю часть */
        setVisible(true); // делает всё вызываемое окно видимым для меня.
        // sbot = new SimpleBot(); // Создаем объект бот
        sbot = new SimpleBot(); // Создаем объект sbot
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Переопределяем метод ActionPerformed
         * Метод возникает, когда наживаем на кнопку Enter */
        if (message.getText().trim().length() > 0)
            /*Проверяем: берем компонент message, достаем оттуда текст, убираем все пробелы, и замеряем длину
             * если длину > 0, то есть что-то набрано и нет пробелов*/
        {
            dialogue.append(message.getText() + "\n"); /*то мы добавляем в наш диалог это сообщение*/
            dialogue.append(TITLE_OF_PROGRAM.substring(0, 9) +
                    sbot.SayInReturn(message.getText(), ai.isSelected()));
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}


