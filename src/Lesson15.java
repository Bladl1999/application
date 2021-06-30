import Logicalelement.LogicalelementorAndNo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson15 extends JComponent {

    public static Lesson15 lesson15;
    private LogicalelementorAndNo logicalelementorAndNo;

    public Lesson15() {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("Логический элемент «И-НЕ»");
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
        text.append("Логическое сложение (дизъюнкция) с отрицанием (инверсией), или функция ИЛИ-НЕ представляет последовательное");
        text.append("выполнение функций логического умножения и отрицания. Эта функция определяется как Y = !(X1·X2)");
        panel_text.add(text);

        JPanel items = new JPanel(new GridLayout(1, 2));
        panel_text.add(items);

        JPanel element1 = new JPanel(new GridLayout(2, 1));
        element1.setBackground(Color.WHITE);
        items.add(element1);

        ImageIcon icon1 = new ImageIcon("image\\log-and-no.png");
        JLabel image1 = new JLabel(icon1);
        element1.add(image1);

        JTextArea drawing_text1 = new JTextArea();
        drawing_text1.setLineWrap(true);
        drawing_text1.setWrapStyleWord(true);
        drawing_text1.setFont(new Font("Bold", 0, 18));
        drawing_text1.setEditable(false);
        drawing_text1.append("Условное обозначение этой функции объединяет в себе обозначение логического элемента И и кружок – символ операции отрицания (НЕ).");
        element1.add(drawing_text1);

        JPanel element2 = new JPanel(new GridLayout(2, 1));
        element2.setBackground(Color.WHITE);
        items.add(element2);

        ImageIcon icon2 = new ImageIcon("image\\log-and-no-new.png");
        JLabel image2 = new JLabel(icon2);
        element2.add(image2);

        JTextArea drawing_text2 = new JTextArea();
        drawing_text2.setLineWrap(true);
        drawing_text2.setWrapStyleWord(true);
        drawing_text2.setFont(new Font("Bold", 0, 18));
        drawing_text2.setEditable(false);
        drawing_text2.append("Зарубежное обозначение элемента И-НЕ (в данном случае 2И-НЕ). Называется NAND.");
        element2.add(drawing_text2);

        ImageIcon icon3 = new ImageIcon("image\\table-and_no.png");
        JLabel table = new JLabel(icon3);
        panel_main.add(table);

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
        button_x1.setBounds(20, 40, 50, 30);
        panel_button.add(button_x1);

        JButton button_x2 = new JButton("X2");
        ActionListener actionListener2 = new button_x2_ActionListener();
        button_x2.addActionListener(actionListener2);
        button_x2.setBounds(20, 90, 50, 30);
        panel_button.add(button_x2);


        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300, 150));
        panel_logik_element.add(logik_element, constraints);

        logicalelementorAndNo = new LogicalelementorAndNo();
        logik_element.add(logicalelementorAndNo);


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
            logicalelementorAndNo.setX1();
        }
    }

    public class button_x2_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            logicalelementorAndNo.setX2();
        }
    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(Lesson15.lesson15);
            Controler.frame.revalidate();
            Controler.frame.repaint();
            System.out.println("Тут");

        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson14.lesson14 == null)
                Lesson14.lesson14 = new Lesson14();
            Controler.frame.add(Lesson14.lesson14);
            Controler.frame.remove(Lesson15.lesson15);
            Controler.frame.revalidate();
            Controler.frame.repaint();
            System.out.println("Тут");



        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if(Lesson16.lesson16 == null)
                Lesson16.lesson16 = new Lesson16();
            Controler.frame.add(Lesson16.lesson16);
            Controler.frame.remove(Lesson15.lesson15);
            Controler.frame.revalidate();
            Controler.frame.repaint();
            System.out.println("Тут");
        }


    }



}

