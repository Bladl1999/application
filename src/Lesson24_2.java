import TriggerStatic.TriggerJK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson24_2 extends JComponent {
    public static Lesson24_2 lesson24_2;
    private TriggerJK triggerJK;

    public Lesson24_2(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("JK-триггер");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JPanel panel_main = new JPanel(new BorderLayout());
        panel_main.setBackground(Color.WHITE);
        add(panel_main,BorderLayout.CENTER);

        ImageIcon icon1 = new ImageIcon("image\\table-jk.png");
        JLabel table = new JLabel(icon1);
        panel_main.add(table, BorderLayout.CENTER);


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

        JButton button_x3 = new JButton("K");
        ActionListener actionListener3 = new button_x3_ActionListener();
        button_x3.addActionListener(actionListener3);
        button_x3.setBounds(20, 100, 50, 30);
        panel_button.add(button_x3);

        JPanel logik_element = new JPanel(new BorderLayout());
        logik_element.setBackground(Color.WHITE);
        logik_element.setPreferredSize(new Dimension(300,200));
        panel3.add(logik_element,constraints);

        triggerJK =  new TriggerJK();
        logik_element.add(triggerJK);


        JPanel panel6 = new JPanel(new BorderLayout());
        panel6.setBackground(Color.WHITE);
        add(panel6,BorderLayout.SOUTH);

        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel6.add(menu,BorderLayout.LINE_END);

        GridBagConstraints constraints1 =  new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;

        ActionListener actionListener4 = new button1ActionListener();
        JButton b1 = new JButton("Меню");
        b1.setPreferredSize(new Dimension(100,50));
        b1.addActionListener(actionListener4);
        menu.add(b1);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        ActionListener actionListener5 = new button2ActionListener();
        JButton b2 = new JButton("Назад");
        b2.setPreferredSize(new Dimension(100,50));
        b2.addActionListener(actionListener5);
        menu.add(b2);

        JPanel interval1 = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval1);


        ActionListener actionListener6 = new button3ActionListener();
        JButton b3 = new JButton("Вперёд");
        b3.setPreferredSize(new Dimension(100,50));
        b3.addActionListener(actionListener6);
        menu.add(b3);


    }

    public class button_x1_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerJK.setJ();
        }
    }

    public class button_x2_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerJK.setC();
        }
    }

    public class button_x3_ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            triggerJK.setK();
        }
    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson24_2);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson24.lesson24 == null)
                Lesson24.lesson24 = new Lesson24();
            Controler.frame.add(Lesson24.lesson24);
            Controler.frame.remove(lesson24_2);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson25.lesson25 == null)
                Lesson25.lesson25 = new Lesson25();
            Controler.frame.add(Lesson25.lesson25);
            Controler.frame.remove(lesson24_2);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}



