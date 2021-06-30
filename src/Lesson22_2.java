import TriggerStatic.TriggerRS_Or_Not;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson22_2 extends JComponent {

    public static Lesson22_2 lesson22_2;
    private TriggerRS_Or_Not triggerRS_or_not;

    public Lesson22_2(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setBackground(Color.WHITE);

        JLabel header = new JLabel("RS триггер на базисе ИЛИ-НЕ");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JPanel main = new JPanel(new GridLayout(1,2));
        main.setBackground(Color.WHITE);
        add(main,BorderLayout.CENTER);

        JPanel trigger = new JPanel(new GridBagLayout());
        trigger.setBackground(Color.WHITE);
        GridBagConstraints constraints1 =  new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;
        main.add(trigger,constraints1);


        JPanel panel_button =  new JPanel(null);
        panel_button.setBackground(Color.WHITE);
        panel_button.setPreferredSize(new Dimension(70,300));
        trigger.add(panel_button);


        JButton button_x1 = new JButton("R");
        ActionListener actionListener1 = new button_x1_ActionListener();
        button_x1.addActionListener(actionListener1);
        button_x1.setBounds( 20, 10, 50, 30);
        panel_button.add(button_x1);

        JButton button_x2 = new JButton("S");
        ActionListener actionListener2 = new button_x2_ActionListener();
        button_x2.addActionListener(actionListener2);
        button_x2.setBounds(20, 220, 50, 30);
        panel_button.add(button_x2);

        triggerRS_or_not =  new TriggerRS_Or_Not();
        triggerRS_or_not.setPreferredSize(new Dimension(300,300));
        triggerRS_or_not.setBackground(Color.WHITE);
        trigger.add(triggerRS_or_not);

        JPanel table_rs = new JPanel(new BorderLayout());
        table_rs.setBackground(Color.WHITE);
        main.add(table_rs);

        ImageIcon icon1 = new ImageIcon("image\\table-rs.png");
        JLabel table = new JLabel(icon1);
        table_rs.add(table,BorderLayout.CENTER);


        /*
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("RS триггер на основе ИЛИ-НЕ");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JPanel panel_main = new JPanel(new BorderLayout());
        panel_main.setBackground(Color.WHITE);
        add(panel_main,BorderLayout.CENTER);

        ImageIcon icon1 = new ImageIcon("image\\table-rs.png");
        JLabel table = new JLabel(icon1);
        panel_main.add(table, BorderLayout.CENTER);


        JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.setBackground(Color.WHITE);
        panel_main.add(panel3,BorderLayout.SOUTH);

        GridBagConstraints constraints =  new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JPanel panel_button =  new JPanel(null);
        panel_button.setBackground(Color.WHITE);
        panel_button.setPreferredSize(new Dimension(70,300));
        panel3.add(panel_button);


        JButton button_x1 = new JButton("R");
        ActionListener actionListener1 = new button_x1_ActionListener();
        button_x1.addActionListener(actionListener1);
        button_x1.setBounds( 20, 10, 50, 30);
        panel_button.add(button_x1);

        JButton button_x2 = new JButton("S");
        ActionListener actionListener2 = new button_x2_ActionListener();
        button_x2.addActionListener(actionListener2);
        button_x2.setBounds(20, 200, 50, 30);
        panel_button.add(button_x2);

        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300,300));
        panel3.add(logik_element,constraints);

        triggerRS =  new TriggerStatic.TriggerRS_Or_Not();
        logik_element.add(triggerRS);


        JPanel panel6 = new JPanel(new BorderLayout());
        panel6.setBackground(Color.WHITE);
        add(panel6,BorderLayout.SOUTH);
           */

        JPanel panel_end = new JPanel(new BorderLayout());
        panel_end.setBackground(Color.WHITE);
        add(panel_end,BorderLayout.LINE_END);

        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel_end.add(menu,BorderLayout.AFTER_LAST_LINE);

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

    public class button_x1_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerRS_or_not.setR();
        }
    }

    public class button_x2_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerRS_or_not.setS();
        }
    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson22_2);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson22.lesson22 == null)
                Lesson22.lesson22 = new Lesson22();
            Controler.frame.add(Lesson22.lesson22);
            Controler.frame.remove(lesson22_2);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson22_3.lesson22_3 == null)
                Lesson22_3.lesson22_3 = new Lesson22_3();
            Controler.frame.add(Lesson22_3.lesson22_3);
            Controler.frame.remove(lesson22_2);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}
