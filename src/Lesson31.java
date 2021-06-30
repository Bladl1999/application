import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson31 extends JComponent{

    public static Lesson31 lesson31;


    public Lesson31(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel panel_main =  new JPanel(new BorderLayout());
        panel_main.setBackground(Color.WHITE);
        add(panel_main, BorderLayout.CENTER);

        JLabel header =  new JLabel("“риггер с динамическим управлением");
        header.setFont(new Font("Bold", 0,36));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JTextArea textArea2 = new JTextArea();
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setFont(new Font("Bold", 0,20));
        textArea2.setEditable(false);
        textArea2.append("“риггер с динамическим управлением €вл€етс€ система, имеюща€ одно из состо€ний - единичное, которое характеризуетс€ наличием");
        textArea2.append(" на выходе непрерывной последовательности импульсов, а другое Ч отсутствием выходных импульсов-нулевое.");
        textArea2.append(" —мена состо€ний производитс€ внешними воздействи€ми.÷ифровой сигнал Ч это дискретный сигнал, квантованный");
        textArea2.append(" по амплитуде.»зменени€ напр€жени€ от низкого уровн€ к высокому , называетс€ фронтом сигнала (положительным");
        textArea2.append(" перепадом, положительным фронтом), а обратный процесс - спадом (отрицательным перепадом,отрицательным");
        textArea2.append(" фронтом). ≈сли существенно их взаимное расположение, то фронт может быть передним и задним.ѕоложительный сигнал -");
        textArea2.append(" Ц сигнал, у которого активный уровень равен единицы.Ќуль Ч это отсутствие сигнала, единица - наличие сигнала.");
        textArea2.append(" ќтрицательный сигнал Ч сигнал, у которого активный уровень равен логическому нулю.");
        textArea2.append(" ≈диница Ч это отсутствие сигнала, нуль - наличие сигнала.");
        textArea2.append(" јктивный уровень сигнала Ч уровень, соответствующий возникновению сигнала");
        textArea2.append(" ѕассивный уровень сигнала Ч уровень, в котором сигнал не выполн€ет никакой функции");
        textArea2.append(" “актовый сигналЧ управл€ющий сигнал, он определ€ет момент выполнени€ элементом его функции.");
        panel_main.add(textArea2,BorderLayout.NORTH);

        ImageIcon icon1 = new ImageIcon("image\\impyls.png");
        JLabel label = new JLabel(icon1);
        panel_main.add(label, BorderLayout.CENTER);

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
        JButton b1 = new JButton("ћеню");
        b1.setPreferredSize(new Dimension(100,50));
        b1.addActionListener(actionListener1);
        menu.add(b1);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        ActionListener actionListener2 = new button1ActionListener();
        JButton b2 = new JButton("Ќазад");
        b2.setPreferredSize(new Dimension(100,50));
        b2.addActionListener(actionListener2);
        menu.add(b2);

        JPanel interval1 = new JPanel();
        interval.setPreferredSize(new Dimension(15,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval1);


        ActionListener actionListener3 = new button3ActionListener();
        JButton b3 = new JButton("¬перЄд");
        b3.setPreferredSize(new Dimension(100,50));
        b3.addActionListener(actionListener3);
        menu.add(b3);


    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson31);
            Controler.frame.revalidate();
            Controler.frame.repaint();




        }
    }


    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(lesson31);
            Controler.frame.revalidate();
            Controler.frame.repaint();




        }
    }

    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if(Lesson32.lesson32 == null)
                Lesson32.lesson32 = new Lesson32();
            Controler.frame.add(Lesson32.lesson32);
            Controler.frame.remove(lesson31);
            Controler.frame.revalidate();
            Controler.frame.repaint();






        }
    }
}

