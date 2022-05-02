package Lesson.Lesson2;

import Controler.Controler;
import TriggerStatic.TriggerDT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson26 extends JComponent{
    public static Lesson26 lesson26;

    private TriggerDT triggerDT;

    public Lesson26(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("Т-Триггер");
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
        text.append("T-триггер — это счетный триггер. У данного триггера имеется только один вход.Принцип работы T-триггера заключается");
        text.append("в следующем.После поступления на вход T импульса, состояние триггера меняется на прямо противоположное.");
        text.append("Счётным он называется потому, что T триггер как бы подсчитывает количество мпульсов, поступивших на его вход.");
        text.append("Жаль только, что считать этот триггер умеет только до одного. При поступлении второго импульса T-триггер снова");
        text.append("сбрасывается в исходное состояние.");
        panel_main.add(text, BorderLayout.NORTH);

        JPanel panel1 = new JPanel(new GridLayout(1,1));
        panel1.setBackground(Color.WHITE);
        panel_main.add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        panel1.add(panel2);

        JLabel label = new JLabel("T триггер на основе D");
        label.setFont(new Font("Bold", 0,36));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(label,BorderLayout.NORTH);

        ImageIcon icon1 = new ImageIcon("image\\table-dt.png");
        JLabel image1 = new JLabel(icon1);
        panel2.add(image1,BorderLayout.CENTER);

        JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.setBackground(Color.WHITE);
        panel2.add(panel3,BorderLayout.SOUTH);

        GridBagConstraints constraints =  new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JPanel panel_button =  new JPanel(null);
        panel_button.setBackground(Color.WHITE);
        panel_button.setPreferredSize(new Dimension(70,200));
        panel3.add(panel_button);


        JButton button_x1 = new JButton("C");
        ActionListener actionListener1 = new button_x1_ActionListener();
        button_x1.addActionListener(actionListener1);
        button_x1.setBounds( 20, 100, 50, 30);
        panel_button.add(button_x1);


        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300,200));
        panel3.add(logik_element,constraints);

        triggerDT =  new TriggerDT();
        logik_element.add(triggerDT);







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
            triggerDT.setC();
        }
    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Controler.frame.add(Controler.getInstance());
            Controler.frame.remove(lesson26);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson25.lesson25 == null)
                Lesson25.lesson25 = new Lesson25();
            Controler.frame.add(Lesson25.lesson25);
            Controler.frame.remove(lesson26);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson26_2.lesson26_2 == null)
                Lesson26_2.lesson26_2 = new Lesson26_2();
            Controler.frame.add(Lesson26_2.lesson26_2);
            Controler.frame.remove(lesson26);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}

