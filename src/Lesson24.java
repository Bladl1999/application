import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson24 extends JComponent {
    public static Lesson24 lesson24;

    public Lesson24(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("JK-�������");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JPanel panel_main = new JPanel(new GridLayout(2,1));
        panel_main.setBackground(Color.BLUE);
        add(panel_main,BorderLayout.CENTER);

        JTextArea text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Bold", 0,20));
        text.setEditable(false);
        text.append("JK-������� ������ ��������� �����������. JK-������� ����� ����� ��� ����������� ����� J � K. ������� RS-��������,");
        text.append("� JK-�������� J � K � ��� ����� ��������� �������� � ������� � ����. � ������� �� ����������� RS-�������� ");
        text.append("������������� ����������� ���������� ������ �� �������������� ������ �� ��������.��� JK-�������� ����������� ");
        text.append("�����������; ��� J = 1 � K = 1 ������� �������� � ������� ������, �. �. ������������� ������ �������� ���������");
        text.append("�� ����� �.");
        panel_main.add(text);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.WHITE);
        panel_main.add(panel1);

        ImageIcon icon1 = new ImageIcon("image\\trigger-jk.png");
        JLabel image1 = new JLabel(icon1);
        panel1.add(image1,BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Bold", 0,20));
        textArea.setEditable(false);
        textArea.append("�) ������� ����������� ����������� JK -��������; �) ����� JK -��������.���������������� JK - �������� ������������");
        textArea.append("���������� Q(t+1) = Q(t)K�+Q�(t)J ");
        panel1.add(textArea,BorderLayout.CENTER);


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
        JButton b1 = new JButton("����");
        b1.setPreferredSize(new Dimension(100,50));
        b1.addActionListener(actionListener3);
        menu.add(b1);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        ActionListener actionListener4 = new button2ActionListener();
        JButton b2 = new JButton("�����");
        b2.setPreferredSize(new Dimension(100,50));
        b2.addActionListener(actionListener4);
        menu.add(b2);

        JPanel interval1 = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval1);


        ActionListener actionListener5 = new button3ActionListener();
        JButton b3 = new JButton("�����");
        b3.setPreferredSize(new Dimension(100,50));
        b3.addActionListener(actionListener5);
        menu.add(b3);


    }


    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson24);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson23_2.lesson23_2 == null)
                Lesson23_2.lesson23_2 = new Lesson23_2();
            Controler.frame.add(Lesson23_2.lesson23_2);
            Controler.frame.remove(lesson24);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson24_2.lesson24_2 == null)
                Lesson24_2.lesson24_2 = new Lesson24_2();
            Controler.frame.add(Lesson24_2.lesson24_2);
            Controler.frame.remove(lesson24);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}

