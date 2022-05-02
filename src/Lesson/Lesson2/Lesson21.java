package Lesson.Lesson2;

import Controler.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson21  extends JComponent {
    public static Lesson21 lesson21;

    public Lesson21(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel header = new JLabel("Триггер");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Bold", 0,20));
        textArea.setEditable(false);
        textArea.append("Триггером называют логическую схему с положительной обратной связью,");
        textArea.append("имеющую два устойчивых состояния, которые называются единичным и");
        textArea.append("нулевым и обозначаются 1 и 0 (триггер обладает свойством памяти)." + "\n" + "\n");
        textArea.append("В общем случае триггер может иметь асинхронные входы предварительной");
        textArea.append("установки, тактовый или синхронизирующий и информационные входы.");
        textArea.append("К основным типам триггеров относятся:" + "\n" + "- триггер с раздельной установкой состояний (RS-триггер)," + "\n");
        textArea.append("- триггер «защелка» (D-триггер)," + "\n");
        textArea.append("- триггер со счетным входом (Т-триггер)." + "\n" + "\n");
        textArea.append("По способу записи информации триггеры подразделяются на асинхронные и");
        textArea.append("синхронные, или тактируемые, а по способу управления на триггеры со");
        textArea.append("статическим управлением (единичным или реже нулевым уровнем тактового");
        textArea.append("сигнала) и триггеры с динамическим управлением (положительным - из 0 в или");
        textArea.append("отрицательным - из в фронтом тактового сигнала). В последнем случае говорят");
        textArea.append("о триггерах с прямым или инверсным динамическим входом управления." + "\n" + "\n");
        textArea.append("Для задания единичного сигнала на синхровходе тригтера необходимо");
        textArea.append("включить и выключить тумблер (ключ)." + " \n \n");
        textArea.append("При известной принципиальной схеме комбинационного узла достаточно путём");
        textArea.append("перебора всех возможных состояний входных сигналов составить таблицу");
        textArea.append("истинности выходных сигналов, что позволяет затем выполнить анализ работы");
        textArea.append("устройства.");
        add(textArea,BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.SOUTH);

        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel.add(menu,BorderLayout.LINE_END);

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

        ActionListener actionListener2 = new button2ActionListener();
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
            Controler.frame.remove(lesson21);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Controler.frame.add(Controler.getInstance());
            Controler.frame.remove(lesson21);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson22.lesson22 == null)
                Lesson22.lesson22 = new Lesson22();
            Controler.frame.add(Lesson22.lesson22);
            Controler.frame.remove(lesson21);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }
}
