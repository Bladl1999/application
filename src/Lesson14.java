import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logicalelement.LogicalelementNo;

public class Lesson14 extends JComponent {

    public static Lesson14 lesson14;
    private  LogicalelementNo logicalelementNo;

    public Lesson14() {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("Логический элемент «НЕ»");
        header.setFont(new Font("Bold", 0, 36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header, BorderLayout.NORTH);

        JPanel panel_main = new JPanel(new GridLayout(3, 1));
        panel_main.setBackground(Color.WHITE);
        add(panel_main);

        JPanel panel_text = new JPanel(new GridLayout(2, 1));
        panel_main.add(panel_text);

        JTextArea text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Bold", 0, 20));
        text.setEditable(false);
        text.append("Логический элемент «НЕ» - отрицание, инвертор, NOT «НЕ» - логический элемент, выполняющий над входными данными");
        text.append("выход и только один вход, называют еще инвертором, поскольку он на самом деле инвертирует (обращает) входной");
        text.append("сигнал. На рисунке приведено условное обозначение логического элемента «НЕ».Функция логического отрицания");
        text.append("записывается как Y = X Схему, обеспечивающую выполнение такой функции, называют инвертором или схемой НЕ.");
        panel_text.add(text);

        JPanel items = new JPanel(new GridLayout(1, 2));
        panel_text.add(items);

        JPanel element1 = new JPanel(new GridLayout(2, 1));
        element1.setBackground(Color.WHITE);
        items.add(element1);

        ImageIcon icon1 = new ImageIcon("image\\log-no.png");
        JLabel image1 = new JLabel(icon1);
        element1.add(image1);

        JTextArea drawing_text1 = new JTextArea();
        drawing_text1.setLineWrap(true);
        drawing_text1.setWrapStyleWord(true);
        drawing_text1.setFont(new Font("Bold", 0, 18));
        drawing_text1.setEditable(false);
        drawing_text1.append("Условное обозначение схемы НЕ обозначается здесь кружком около выхода логического элемента.");
        element1.add(drawing_text1);

        JPanel element2 = new JPanel(new GridLayout(2, 1));
        element2.setBackground(Color.WHITE);
        items.add(element2);

        ImageIcon icon2 = new ImageIcon("image\\log-no-new.png");
        JLabel image2 = new JLabel(icon2);
        element2.add(image2);

        JTextArea drawing_text2 = new JTextArea();
        drawing_text2.setLineWrap(true);
        drawing_text2.setWrapStyleWord(true);
        drawing_text2.setFont(new Font("Bold", 0, 18));
        drawing_text2.setEditable(false);
        drawing_text2.append("В зарубежной документации элемент \\\"НЕ\\\" изображают следующим образом. Сокращённо называют его NOT");
        element2.add(drawing_text2);


        JPanel panel_table = new JPanel(new GridLayout(2,1));
        panel_table.setBackground(Color.WHITE);
        panel_main.add(panel_table);

        JTextArea table_text = new JTextArea();
        table_text.setLineWrap(true);
        table_text.setWrapStyleWord(true);
        table_text.setFont(new Font("Bold", 0, 18));
        table_text.setEditable(false);
        table_text.append("Таблицы истинности задают связь между логическими величинами на входах (величины X) и на выходах ");
        table_text.append("схемы (величины Y): в ее левой части выписаны все возможные наборы значений аргументов (X1, X2, … , Xn),");
        table_text.append("а правая часть представляет собой столбец значений функции Y, соответствующих этим наборам. В общем ");
        table_text.append("случае таблица истинности для функций n переменных должна иметь 2n строк.");
        panel_table.add(table_text);


        ImageIcon icon3 = new ImageIcon("image\\table-no.png");
        JLabel table = new JLabel(icon3);
        panel_table.add(table);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.WHITE);
        panel_main.add(panel1);

        JPanel panel_logik_element = new JPanel(new GridBagLayout());
        panel_logik_element.setBackground(Color.WHITE);
        panel1.add(panel_logik_element);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;


        JPanel panel_button = new JPanel(null);
        panel_button.setBackground(Color.WHITE);
        panel_button.setPreferredSize(new Dimension(70, 150));
        panel_logik_element.add(panel_button);


        JButton button_x1 = new JButton("X1");
        ActionListener actionListener1 = new button_x1_ActionListener();
        button_x1.addActionListener(actionListener1);
        button_x1.setBounds(20, 65, 50, 30);
        panel_button.add(button_x1);

        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300, 150));
        panel_logik_element.add(logik_element, constraints);

        logicalelementNo = new LogicalelementNo();
        logik_element.add(logicalelementNo);


        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        panel1.add(panel2, BorderLayout.SOUTH);

        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel2.add(menu, BorderLayout.LINE_END);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;

        ActionListener actionListener3 = new button1ActionListener();
        JButton b1 = new JButton("Меню");
        b1.setPreferredSize(new Dimension(100, 50));
        b1.addActionListener(actionListener3);
        menu.add(b1);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(15, 50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        ActionListener actionListener4 = new button2ActionListener();
        JButton b2 = new JButton("Назад");
        b2.setPreferredSize(new Dimension(100, 50));
        b2.addActionListener(actionListener4);
        menu.add(b2);

        JPanel interval1 = new JPanel();
        interval.setPreferredSize(new Dimension(15, 50));
        interval.setBackground(Color.WHITE);
        menu.add(interval1);


        ActionListener actionListener5 = new button3ActionListener();
        JButton b3 = new JButton("Вперёд");
        b3.setPreferredSize(new Dimension(100, 50));
        b3.addActionListener(actionListener5);
        menu.add(b3);

    }

    public class button_x1_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            logicalelementNo.setX1();
        }
    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(Lesson14.lesson14);
            Controler.frame.revalidate();
            Controler.frame.repaint();
            System.out.println("Тут");

        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson13.lesson13 == null)
                Lesson13.lesson13 = new Lesson13();
            Controler.frame.add(Lesson13.lesson13);
            Controler.frame.remove(Lesson14.lesson14);
            Controler.frame.revalidate();
            Controler.frame.repaint();
            System.out.println("Тут");



        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson15.lesson15 == null)
                Lesson15.lesson15 = new Lesson15();
            Controler.frame.add(Lesson15.lesson15);
            Controler.frame.remove(Lesson14.lesson14);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }



}

