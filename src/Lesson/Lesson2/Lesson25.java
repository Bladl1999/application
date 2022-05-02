package Lesson.Lesson2;

import Controler.Controler;
import TriggerStatic.TriggerJKD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson25 extends JComponent{
    public static Lesson25 lesson25;
    private TriggerJKD triggerJKD;

    public Lesson25(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("D-Триггер на основе JK-Триггера:");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JPanel panel_main = new JPanel(new BorderLayout());
        panel_main.setBackground(Color.WHITE);
        add(panel_main,BorderLayout.CENTER);

        JTextArea text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Bold", 0,20));
        text.setEditable(false);
        text.append("двухступенчатого D-триггера, построенного на основе двухступенчатого JK-триггера и дополнительного инвертора.");
        text.append("Если D = 1, J=1, К=0 и первая ступень JK-триггера тактовым импульсом переключается в единичное состояние,");
        text.append("а после окончания тактового импульса в единичное состояние переходит выходная ступень. Если же D = 0,");
        text.append("то К= D`=1, J=0 и триггер переходит в нулевое состояние. Таким образом, после окончания тактового импульса");
        text.append("информация на выходе триггера соответствует информации на входе.");
        panel_main.add(text,BorderLayout.NORTH);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.WHITE);
        panel_main.add(panel1,BorderLayout.CENTER);

        ImageIcon icon1 = new ImageIcon("image\\table-jkd.png");
        JLabel image1 = new JLabel(icon1);
        panel1.add(image1,BorderLayout.NORTH);

        JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.setBackground(Color.WHITE);
        panel_main.add(panel3,BorderLayout.SOUTH);

        GridBagConstraints constraints =  new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JPanel panel_button =  new JPanel(null);
        panel_button.setBackground(Color.WHITE);
        panel_button.setPreferredSize(new Dimension(70,200));
        panel3.add(panel_button);


        JButton button_x1 = new JButton("J");
        ActionListener actionListener1 = new button_x1_ActionListener();
        button_x1.addActionListener(actionListener1);
        button_x1.setBounds( 20, 30, 50, 30);
        panel_button.add(button_x1);

        JButton button_x2 = new JButton("C");
        ActionListener actionListener2 = new button_x2_ActionListener();
        button_x2.addActionListener(actionListener2);
        button_x2.setBounds(20, 65, 50, 30);
        panel_button.add(button_x2);


        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300,200));
        panel3.add(logik_element,constraints);

        triggerJKD =  new TriggerJKD();
        logik_element.add(triggerJKD);


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

    public class button_x1_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerJKD.setJ();
        }
    }

    public class button_x2_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerJKD.setC();
        }
    }




    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Controler.frame.add(Controler.getInstance());
            Controler.frame.remove(lesson25);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson24_2.lesson24_2 == null)
                Lesson24_2.lesson24_2 = new Lesson24_2();
            Controler.frame.add(Lesson24_2.lesson24_2);
            Controler.frame.remove(lesson25);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if(Lesson26.lesson26 == null)
                Lesson26.lesson26 = new Lesson26();
            Controler.frame.add(Lesson26.lesson26);
            Controler.frame.remove(lesson25);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}


