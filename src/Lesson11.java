

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Lesson11 extends JComponent {

    public static Lesson11 lesson11;
    public Lesson11(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel panel =  new JPanel(new GridLayout(2,1));
        add(panel, BorderLayout.CENTER);

        JLabel header =  new JLabel("���������� ��������");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JTextArea textArea2 = new JTextArea();
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setFont(new Font("Bold", 0,17));
        textArea2.setEditable(false);
        textArea2.append("���������� �������� � ����������, ��������������� ��� ��������� ���������� � �������� ����� (������������������");
        textArea2.append(" �������� �������� ��1� � ������� ��0� ������� � �������� ������,������������������ �0�, �1� � �2� � �������� ������,");
        textArea2.append(" �������������������� �0�, �1�, �2�, �3�, �4�, �5�, �6�,�7�, �8� � �9� � ���������� ������). ��������� ����������");
        textArea2.append(" ���������� �������� ����� ���� ��������� �������������, �������������������� (�� ���������������� ����),");
        textArea2.append(" ������������ (� ���������, �� ������ ��� ������������),���������������, ���������������, ����������� � �������.");
        textArea2.append(" ������ ������ ���������� ������� ����� ����� ��������� ������ (�� ������ �� ����������) � ���� �����. ��� ���� ");
        textArea2.append(" ����� ����� �������� �������� � �������� ��������� (������� ����������) ��������� ������.������ ����������");
        textArea2.append(" ������� �������� �������� ������������� ������� ���� ��� ������� �� ��� ������. ������� ���������� ������");
        textArea2.append(" � ���������� ��������� ���, ������� ��� ��������� � ������ ��� ���������� �������������� ���������. �� � ");
        textArea2.append(" ������� �� ����� ������� �������������� ���������, ��������������� � ��������� ������, ���������� ��������");
        textArea2.append(" ����� �����, ������� �� ����� ���� ��������� �� ������, ������������� �� ����������� ��� ��������.");
        textArea2.append(" ���������� ��������. � ������ ������� ������ ����� ���������� ��������, ������� ����� ���������� X, Y. ����������");
        textArea2.append(" �������� ������������� ��� ����������������� �������: ������ � ����, ������� � ���������, ���������");
        textArea2.append(" � ���������� � �. �. ���� ���� �������� ���������� �������� ���������� �, �� ������ (��������) �������� ����������");
        textArea2.append(" X (�� �).��� �������� � ����������� ���������� ������ ������������ �������� ���, ������� � = 1, X = 0 ��� ��������:");
        textArea2.append(" � = 0, X = 1. ��� ���� ���� � �� �� ����������� ����� ����� ��������� ��� ����������, ��� � �������������� ��������");
        textArea2.append(" (� �������� ������� ���������).\n                                     ���� 2.743-72 ");


        panel.add(textArea2);


        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        panel.add(panel2);

        ImageIcon icon1 = new ImageIcon("image\\table1.png");
        JLabel label = new JLabel(icon1);
        panel2.add(label, BorderLayout.CENTER);

        JPanel panel3 =  new JPanel(new BorderLayout());
        panel3.setBackground(Color.WHITE);
        panel2.add(panel3,BorderLayout.LINE_END);


        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel3.add(menu,BorderLayout.SOUTH);

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
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson11);
            Controler.frame.revalidate();
            Controler.frame.repaint();
            System.out.println("���");



        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson11);
            Controler.frame.revalidate();
            Controler.frame.repaint();
            System.out.println("���");



        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson12.lesson12 == null)
                Lesson12.lesson12 = new Lesson12();
            Controler.frame.add(Lesson12.lesson12);
            Controler.frame.remove(lesson11);
            Controler.frame.revalidate();
            Controler.frame.repaint();
            System.out.println("���");



        }
    }


    public static void main(String[] args) {
        Lesson11 controler = new Lesson11();
        JFrame frame = new JFrame();

        frame.add(controler);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setSize(800,600);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
