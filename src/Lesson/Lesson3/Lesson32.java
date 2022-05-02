package Lesson.Lesson3;

import Controler.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson32 extends JComponent {

    public static Lesson32 lesson32;


    public Lesson32(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel panel_main =  new JPanel(new BorderLayout());
        panel_main.setBackground(Color.WHITE);
        add(panel_main, BorderLayout.CENTER);

        JLabel header =  new JLabel("������������ ��������");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JTextArea textArea2 = new JTextArea();
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setFont(new Font("Bold", 0,20));
        textArea2.setEditable(false);
        textArea2.append("������������� ����� ������� � ������� ������� �� ���� � �������.������������� ����� ������� (����) � �������");
        textArea2.append(" ������� �� ������� � ����.�������� ����� ������� �������� ������� �� ���������� ������ � �������� (�� �������");
        textArea2.append(" � ����, �� ���� � �������).������ ����� ������� � ������� ������� �� ��������� ������ � ��������� (�� �������");
        textArea2.append(" � ����, �� ���� � �������).�������� ������ (������������) � ������, ������� ������������ ��� �����������");
        textArea2.append(" �������� ����� ��� ����� �������� ����.�������� �������� ������� ���������������� ��������� ���������� ");
        textArea2.append(" ����������� �����, ������� �������, ���������� ���������������� ������, ����������� ����� �� ���� �����");
        textArea2.append(" �� ���� �������.������ �������������� ������� ������� ����� ��������� ��������������(���������),");
        textArea2.append(" ������������ � ����� � ��� �� �����������.������� ������������� � ��������, �������� �������.\n");
        textArea2.append(" �������� � ������������ �����������:\n");
        textArea2.append(" � ��������� � ������������ ����������� ������������ ���������� �� ������ ����������������� �������.");
        textArea2.append(" ������� ��������, ��������� � �������������, ���������� � ������� ��������� ������� ������ ������");
        textArea2.append(" ������� �� ���������������� ����� ������ ��� �������� ��������� �������.");
        panel_main.add(textArea2,BorderLayout.NORTH);


        JPanel panel2 = new JPanel(new GridLayout(1,2));
        panel2.setBackground(Color.WHITE);
        panel_main.add(panel2);

        ImageIcon icon1 = new ImageIcon("image\\front.png");
        JLabel label = new JLabel(icon1);
        panel2.add(label);


        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(Color.WHITE);
        panel2.add(panel3);


        JTextArea text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Bold", 0,20));
        text.setEditable(false);
        text.append("������������ �������� ����� ����������� ��� ������������� ������ �������, ����� ���� ���� ����������");
        text.append("������ ������������ ������ (������� �), ���� ��� ������������� � ��������� ������������ ���� (������� �).");
        text.append("������������� ����� �������� ��������� � �������� �������� �� ���������, ������������� ����� � � ���������� 1");
        panel3.add(text,BorderLayout.CENTER);

        JPanel panel1 =  new JPanel(new BorderLayout());
        panel1.setBackground(Color.WHITE);
        add(panel1,BorderLayout.SOUTH);


        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel1.add(menu,BorderLayout.LINE_END);

        GridBagConstraints constraints =  new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        ActionListener actionListener1 = new button1ActionListener();
        JButton b1 = new JButton("����");
        b1.setPreferredSize(new Dimension(100,50));
        b1.addActionListener(actionListener1);
        menu.add(b1);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        ActionListener actionListener2 = new button1ActionListener();
        JButton b2 = new JButton("�����");
        b2.setPreferredSize(new Dimension(100,50));
        b2.addActionListener(actionListener2);
        menu.add(b2);

        JPanel interval1 = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval1);


        ActionListener actionListener3 = new button3ActionListener();
        JButton b3 = new JButton("�����");
        b3.setPreferredSize(new Dimension(100,50));
        b3.addActionListener(actionListener3);
        menu.add(b3);


    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Controler.frame.add(Controler.getInstance());
            Controler.frame.remove(lesson32);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson31.lesson31 == null)
                Lesson31.lesson31 = new Lesson31();
            Controler.frame.add(Lesson31.lesson31);
            Controler.frame.remove(lesson32);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson33.lesson33 == null)
                Lesson33.lesson33 = new Lesson33();
            Controler.frame.add(Lesson33.lesson33);
            Controler.frame.remove(lesson32);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}


