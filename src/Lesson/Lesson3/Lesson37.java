package Lesson.Lesson3;

import Controler.Controler;
import TriggerDynamics.TriggerDynamicsJKT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson37 extends JComponent{
    public static Lesson37 lesson37;
    private TriggerDynamicsJKT triggerDynamicsJKT;

    public Lesson37() {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("Т-Триггер на основе D");
        header.setFont(new Font("Bold", 0, 36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header, BorderLayout.NORTH);

        JPanel panel_main = new JPanel(new BorderLayout());
        panel_main.setBackground(Color.WHITE);
        add(panel_main, BorderLayout.CENTER);


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
        button_x2.setBounds(20, 65, 50, 30);
        panel_button.add(button_x2);

        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300, 340));
        panel_logik_element.add(logik_element, constraints);

        triggerDynamicsJKT = new TriggerDynamicsJKT();
        logik_element.add(triggerDynamicsJKT);


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
    }

    public class button_x1_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerDynamicsJKT.setJ();
        }
    }

    public class button_x2_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerDynamicsJKT.setC();
        }
    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Controler.frame.add(Controler.getInstance());
            Controler.frame.remove(lesson37);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson36.lesson36 == null)
                Lesson36.lesson36 = new Lesson36();
            Controler.frame.add(Lesson36.lesson36);
            Controler.frame.remove(lesson37);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}



