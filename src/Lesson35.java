import TriggerDynamics.TriggerDynamicsJKD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson35 extends JComponent{
    public static Lesson35 lesson35;
    private TriggerDynamicsJKD triggerDynamicsJKD;

    public Lesson35() {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("D-Триггер на основе JK-Триггера:");
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
        text.append("двухступенчатого D-триггера, построенного на основе двухступенчатого JK-");
        text.append(" триггера и дополнительного инвертора. Если D = 1, J=1, К=0 и первая ");
        text.append(" ступень JK-триггера тактовым импульсом переключается в единичное ");
        text.append(" состояние, а после окончания тактового импульса в единичное состояние ");
        text.append(" переходит выходная ступень. Если же D = 0, то К= D`=1, J=0 и триггер ");
        text.append(" переходит в нулевое состояние. Таким образом, после окончания тактового ");
        text.append(" импульса информация на выходе триггера соответствует информации на ");
        text.append(" входе.». ");
        panel_main.add(text,BorderLayout.NORTH);

        JPanel panel_logik_element = new JPanel(new GridBagLayout());
        panel_logik_element.setBackground(Color.WHITE);
        panel_main.add(panel_logik_element, BorderLayout.CENTER);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;


        JPanel panel_button = new JPanel(null);
        panel_button.setBackground(Color.WHITE);
        panel_button.setPreferredSize(new Dimension(70, 340));
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


        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300, 340));
        panel_logik_element.add(logik_element, constraints);

        triggerDynamicsJKD = new TriggerDynamicsJKD();
        logik_element.add(triggerDynamicsJKD);


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
            triggerDynamicsJKD.setJ();
        }
    }

    public class button_x2_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerDynamicsJKD.setC();
        }
    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson35);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson34.lesson34 == null)
                Lesson34.lesson34 = new Lesson34();
            Controler.frame.add(Lesson34.lesson34);
            Controler.frame.remove(lesson35);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson36.lesson36 == null)
                Lesson36.lesson36 = new Lesson36();
            Controler.frame.add(Lesson36.lesson36);
            Controler.frame.remove(lesson35);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

}


