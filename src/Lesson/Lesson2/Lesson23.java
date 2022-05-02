package Lesson.Lesson2;

import Controler.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson23 extends JComponent {
    public static Lesson23 lesson23;

    public Lesson23(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("D-триггер");
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
        text.append("Триггер задержки (D-триггер) может быть только синхронным,так как имеет один информационный D-вход,информация");
        text.append("с которого переписывается на выход триггера только по тактовому сигналу,подаваемому на С-вход(синхровход).");
        text.append("Вход синхронизации С может быть статическим (потенциальным) и динамическим. У триггеров со статическим входом С");
        text.append("информация записывается в течение времени, при котором уровень сигнала C=1. В триггерах с динамическим входом ");
        text.append("С информация записывается только в течение перепада напряжения на входе С.");
        panel_main.add(text, BorderLayout.NORTH);

        ImageIcon icon1 = new ImageIcon("image\\trigger-d.png");
        JLabel image1 = new JLabel(icon1);
        panel_main.add(image1,BorderLayout.CENTER);


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
            Controler.frame.remove(lesson23);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson22_3.lesson22_3 == null)
                Lesson22_3.lesson22_3 = new Lesson22_3();
            Controler.frame.add(Lesson22_3.lesson22_3);
            Controler.frame.remove(lesson23);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson23_2.lesson23_2 == null)
                Lesson23_2.lesson23_2 = new Lesson23_2();
            Controler.frame.add(Lesson23_2.lesson23_2);
            Controler.frame.remove(lesson23);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}
