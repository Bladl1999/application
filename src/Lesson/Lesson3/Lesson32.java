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

        JLabel header =  new JLabel("Динамические триггеры");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JTextArea textArea2 = new JTextArea();
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setFont(new Font("Bold", 0,20));
        textArea2.setEditable(false);
        textArea2.append("Положительный фронт сигнала — переход сигнала из нуля в единицу.Отрицательный фронт сигнала (спад) — переход");
        textArea2.append(" сигнала из единицы в нуль.Передний фронт сигнала —переход сигнала из пассивного уровня в активный (из единицы");
        textArea2.append(" в ноль, из нуля в единицу).Задний фронт сигнала — переход сигнала из активного уровня в пассивный (из единицы");
        textArea2.append(" в ноль, из нуля в единицу).Тактовый сигнал (синхросигнал) — сигнал, который используется для согласовани");
        textArea2.append(" операций одной или более цифровых схем.Тактовая частота— частота синхронизирующих импульсов синхронной ");
        textArea2.append(" электронной схемы, другими словами, количество синхронизирующих тактов, поступающих извне на вход схемы");
        textArea2.append(" за одну секунду.Период синхросигнала— отрезок времени между соседними переключениями(вершинами),");
        textArea2.append(" совершаемыми в одном и том же направлении.Частота синхросигнала — величина, обратная периоду.\n");
        textArea2.append(" Триггеры с динамическим управлением:\n");
        textArea2.append(" В триггерах с динамическим управлением срабатывание происходит по фронту синхронизирующего сигнала.");
        textArea2.append(" Поэтому процессы, связанные с переключением, происходят в течение короткого времени вблизи фронта");
        textArea2.append(" сигнала на синхронизирующем входе только при перепаде тактового сигнала.");
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
        text.append("Переключение триггера может происходить при положительном фронте сигнала, тогда этот вход называется");
        text.append("прямым динамическим входом (рисунок а), либо при отрицательном — инверсный динамический вход (рисунок б).");
        text.append("Положительный фронт означает изменение с нулевого значения на единичное, отрицательный фронт — с логической 1");
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


