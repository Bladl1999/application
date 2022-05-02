package Lesson.Lesson2;

import Controler.Controler;
import TriggerStatic.TriggerRS_Or_Not;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson22 extends JComponent {

    public static Lesson22 lesson22;
    private TriggerRS_Or_Not triggerRS;

    public Lesson22(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("RS триггер");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JPanel panel_main = new JPanel(new GridLayout(2,1));
        panel_main.setBackground(Color.WHITE);
        add(panel_main,BorderLayout.CENTER);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.WHITE);
        panel_main.add(panel1);

        JTextArea text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Bold", 0,20));
        text.setEditable(false);
        text.append("Простейшим триггером является асинхронный RS-триггер. Входы S и R названы по первым буквам английских слов ");
        text.append("set - установка и reset – сброс. Условное графическое изображение которого представлено на рисунке ");
        panel1.add(text, BorderLayout.NORTH);

        ImageIcon icon1 = new ImageIcon("image\\trigger-rs.png");
        JLabel image1 = new JLabel(icon1);
        panel1.add(image1);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Bold", 0,20));
        textArea.setEditable(false);
        textArea.append("а - RS-триггер на элементах И-НЕ; б - RS-триггер на элементах ИЛИ-НЕ Триггер имеет два раздельных информационных");
        textArea.append("входа (R и S) и два выхода (Q и Q’). Независимым является один (прямой) выход Q, так как инверсный сигнал Q’ можно");
        textArea.append("получить с помощью внешнего инвертора.Когда на прямом выходе Q сигнал равен 1, говорят, что триггер находится в");
        textArea.append("состоянии 1 или что он установлен. В силу симметрии схемы она будет столь же устойчива в своем противоположном ");
        textArea.append("- нулевом состоянии, когда Q =0, а  =1. В этом случае говорят, что триггер сброшен. Режим RS-триггера, когда оба управляющих ");
        textArea.append("сигнала R и S неактивны, называют режимом хранения.Рассмотрим таблицу переходов на элементах И-НЕ:");
        panel_main.add(textArea);



        /*

        JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.setBackground(Color.WHITE);
        panel4.add(panel3);

        GridBagConstraints constraints =  new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JPanel panel_button =  new JPanel(null);
        panel_button.setBackground(Color.WHITE);
        panel_button.setPreferredSize(new Dimension(70,300));
        panel3.add(panel_button);


        JButton button_x1 = new JButton("S");
        ActionListener actionListener1 = new button_x1_ActionListener();
        button_x1.addActionListener(actionListener1);
        button_x1.setBounds( 20, 10, 50, 30);
        panel_button.add(button_x1);

        JButton button_x2 = new JButton("R");
        ActionListener actionListener2 = new button_x2_ActionListener();
        button_x2.addActionListener(actionListener2);
        button_x2.setBounds(20, 200, 50, 30);
        panel_button.add(button_x2);

        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300,300));
        panel3.add(logik_element,constraints);

        triggerRS =  new TriggerRS();
        logik_element.add(triggerRS);


         */
        JPanel panel6 = new JPanel(new BorderLayout());
        panel6.setBackground(Color.WHITE);
        add(panel6,BorderLayout.SOUTH);

        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel6.add(menu,BorderLayout.LINE_END);

        GridBagConstraints constraints1 =  new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;

        ActionListener actionListener3 = new button1ActionListener();
        JButton b1 = new JButton("Меню");
        b1.setPreferredSize(new Dimension(100,50));
        b1.addActionListener(actionListener3);
        menu.add(b1);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        ActionListener actionListener4 = new button2ActionListener();
        JButton b2 = new JButton("Назад");
        b2.setPreferredSize(new Dimension(100,50));
        b2.addActionListener(actionListener4);
        menu.add(b2);

        JPanel interval1 = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval1);


        ActionListener actionListener5 = new button3ActionListener();
        JButton b3 = new JButton("Вперёд");
        b3.setPreferredSize(new Dimension(100,50));
        b3.addActionListener(actionListener5);
        menu.add(b3);


    }


    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Controler.frame.add(Controler.getInstance());
            Controler.frame.remove(lesson22);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson21.lesson21 == null)
                Lesson21.lesson21 = new Lesson21();
            Controler.frame.add(Lesson21.lesson21);
            Controler.frame.remove(lesson22);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson22_2.lesson22_2 == null)
                Lesson22_2.lesson22_2 = new Lesson22_2();
            Controler.frame.add(Lesson22_2.lesson22_2);
            Controler.frame.remove(lesson22);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}
