import TriggerDynamics.TriggerDynamicsJK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson34 extends JComponent {
    public static Lesson34 lesson34;
    private TriggerDynamicsJK triggerDynamicsJK;

    public Lesson34() {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("J K-Триггеры");
        header.setFont(new Font("Bold", 0, 36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header, BorderLayout.NORTH);

        JPanel panel_main = new JPanel(new BorderLayout());
        panel_main.setBackground(Color.WHITE);
        add(panel_main, BorderLayout.CENTER);

        JTextArea text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Bold", 0, 20));
        text.setEditable(false);
        text.append("Его входы являются теми же R и S, но им присвоены буквы J и K по");
        text.append(" имени изобретателя схемы, чтобы отличить от других триггеров. JK схема");
        text.append(" отличается от RS триггера тем, что она не имеет неопределенных или");
        text.append(" запрещенных входных статусов. В JK добавлена входная схема ");
        text.append(" синхронизации, предотвращающая неопределенное условие вывода, которое ");
        text.append(" может случиться, если R и S равны единице. Поэтому в наличии четыре ");
        text.append(" возможных комбинации ввода: 1, 0, «без изменений» и «переключение». ");
        text.append(" Вход J соответствует S, а K – R. Кроме того, для каждого вентиля имеется ");
        text.append(" третий вход. На выходе остаются Q? и Q. Перекрестная связь RS триггера");
        text.append(" позволяет использовать ранее неопределенные условия работы триггера, ");
        text.append(" когда оба входных сигнала равны 1, для создания «переключателя», так как ». ");
        text.append(" два входа могут быть блокированы.");
        panel_main.add(text,BorderLayout.NORTH);

        JPanel panel_logik_element = new JPanel(new GridBagLayout());
        panel_logik_element.setBackground(Color.WHITE);
        panel_main.add(panel_logik_element, BorderLayout.CENTER);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;


        JPanel panel_button = new JPanel(null);
        panel_button.setBackground(Color.WHITE);
        panel_button.setPreferredSize(new Dimension(70, 350));
        panel_logik_element.add(panel_button);


        JButton button_x1 = new JButton("J");
        ActionListener actionListener1 = new button_x1_ActionListener();
        button_x1.addActionListener(actionListener1);
        button_x1.setBounds(20, 25, 50, 30);
        panel_button.add(button_x1);

        JButton button_x2 = new JButton("C");
        ActionListener actionListener2 = new button_x2_ActionListener();
        button_x2.addActionListener(actionListener2);
        button_x2.setBounds(20, 60, 50, 30);
        panel_button.add(button_x2);

        JButton button_x3 = new JButton("K");
        ActionListener actionListener3 = new button_x3_ActionListener();
        button_x3.addActionListener(actionListener3);
        button_x3.setBounds(20, 95, 50, 30);
        panel_button.add(button_x3);

        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(800, 370));
        panel_logik_element.add(logik_element, constraints);

        triggerDynamicsJK = new TriggerDynamicsJK();
        logik_element.add(triggerDynamicsJK);


        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        add(panel2, BorderLayout.SOUTH);

        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel2.add(menu, BorderLayout.LINE_END);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;

        ActionListener actionListener4 = new button1ActionListener();
        JButton b1 = new JButton("Меню");
        b1.setPreferredSize(new Dimension(100, 50));
        b1.addActionListener(actionListener4);
        menu.add(b1);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(15, 50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        ActionListener actionListener5 = new button2ActionListener();
        JButton b2 = new JButton("Назад");
        b2.setPreferredSize(new Dimension(100, 50));
        b2.addActionListener(actionListener5);
        menu.add(b2);

        JPanel interval1 = new JPanel();
        interval.setPreferredSize(new Dimension(15, 50));
        interval.setBackground(Color.WHITE);
        menu.add(interval1);


        ActionListener actionListener6 = new button3ActionListener();
        JButton b3 = new JButton("Вперёд");
        b3.setPreferredSize(new Dimension(100, 50));
        b3.addActionListener(actionListener6);
        menu.add(b3);

    }

    public class button_x1_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerDynamicsJK.setJ();
        }
    }

    public class button_x2_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerDynamicsJK.setC();
        }
    }

    public class button_x3_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerDynamicsJK.setK();
        }
    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson34);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson33.lesson33 == null)
                Lesson33.lesson33 = new Lesson33();
            Controler.frame.add(Lesson33.lesson33);
            Controler.frame.remove(lesson34);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson35.lesson35 == null)
                Lesson35.lesson35 = new Lesson35();
            Controler.frame.add(Lesson35.lesson35);
            Controler.frame.remove(lesson34);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }



}

