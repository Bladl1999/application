

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

        JLabel header =  new JLabel("Логический элементы");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JTextArea textArea2 = new JTextArea();
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setFont(new Font("Bold", 0,17));
        textArea2.setEditable(false);
        textArea2.append("Логические элементы — устройства, предназначенные для обработки информации в цифровой форме (последовательности");
        textArea2.append(" сигналов высокого —«1» и низкого —«0» уровней в двоичной логике,последовательность «0», «1» и «2» в троичной логике,");
        textArea2.append(" последовательностями «0», «1», «2», «3», «4», «5», «6»,«7», «8» и «9» в десятичной логике). Физически логические");
        textArea2.append(" логические элементы могут быть выполнены механическими, электромеханическими (на электромагнитных реле),");
        textArea2.append(" электронными (в частности, на диодах или транзисторах),пневматическими, гидравлическими, оптическими и другими.");
        textArea2.append(" Обычно каждый логический элемент имеет имеет несколько входов (от одного до двенадцати) и один выход. При этом ");
        textArea2.append(" связь между выходным сигналом и входными сигналами (таблица истинности) предельно проста.Каждой комбинации");
        textArea2.append(" входных сигналов элемента соответствует уровень нуля или единицы на его выходе. Никакой внутренней памяти");
        textArea2.append(" у логических элементов нет, поэтому они относятся к группе так называемых комбинационных микросхем. Но в ");
        textArea2.append(" отличие от более сложных комбинационных микросхем, рассматриваемых в следующей лекции, логические элементы");
        textArea2.append(" имеют входы, которые не могут быть разделены на группы, различающиеся по выполняемым ими функциям.");
        textArea2.append(" Логические величины. В основе алгебры логики лежат логические величины, которые будем обозначать X, Y. Логическая");
        textArea2.append(" величина характеризует два взаимоисключающих понятия: «есть» и «нет», «черное» и «нечерное», «включено»");
        textArea2.append(" и «выключено» и т. п. Если одно значение логической величины обозначить Х, то второе (обратное) значение обозначают");
        textArea2.append(" X (не Х).Для операций с логическими величинами удобно использовать двоичный код, полагая Х = 1, X = 0 или наоборот:");
        textArea2.append(" Х = 0, X = 1. При этом одна и та же электронная схема может выполнять как логические, так и арифметические операции");
        textArea2.append(" (в двоичной системе счисления).\n                                     ГОСТ 2.743-72 ");


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
        JButton b1 = new JButton("Меню");
        b1.setPreferredSize(new Dimension(100,50));
        b1.addActionListener(actionListener1);
        menu.add(b1);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        ActionListener actionListener2 = new button1ActionListener();
        JButton b2 = new JButton("Назад");
        b2.setPreferredSize(new Dimension(100,50));
        b2.addActionListener(actionListener2);
        menu.add(b2);

        JPanel interval1 = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval1);


        ActionListener actionListener3 = new button3ActionListener();
        JButton b3 = new JButton("Вперёд");
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
            System.out.println("Тут");



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
            System.out.println("Тут");



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
            System.out.println("Тут");



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
