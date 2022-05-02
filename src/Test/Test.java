package Test;

import Controler.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Test extends JComponent {
    public static int balls = 0;
    static int j = 0;
    public static ArrayList<Test> list;

    public Test(String[] stringargs){

        setLayout(new BorderLayout());

        Panel p1 = new Panel(new BorderLayout());
        p1.setVisible(true);
        add(p1,BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel panelCheck = new JPanel(new GridLayout(0, 1, 0, 0));
        panelCheck.setFont(new Font("Bold", Font.BOLD,25));
        JTextArea text =  new JTextArea();
        text.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Bold", Font.BOLD,25));
        text.setText(stringargs[0]);
        text.setEditable(false);
        text.setBackground(Color.WHITE);
        panelCheck.add(text);

        String[] names2 = {stringargs[1], stringargs[3], stringargs[5], stringargs[7]};
        int[] temp = {Integer.parseInt(stringargs[2]),Integer.parseInt(stringargs[4]),Integer.parseInt(stringargs[6]),Integer.parseInt(stringargs[8])};
        ButtonGroup bg2 = new ButtonGroup();
        for (int i = 0; i < names2.length; i++) {
            JCheckBox check = new JCheckBox(names2[i]);
            check.setFont(new Font("Bold", Font.BOLD,14));
            check.setBackground(Color.WHITE);
            int finalI = i;
            check.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    balls += temp[finalI];
                }
            });
            check.setFont(new Font("Bold", Font.BOLD,30));
            panelCheck.add(check);
            bg2.add(check);
        }

        JPanel panel1 =  new JPanel(new BorderLayout());
        panelCheck.setBackground(Color.WHITE);
        panelCheck.add(panel1);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel1.add(panel);

        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        panel.add(menu,BorderLayout.LINE_END);

        GridBagConstraints constraints =  new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        ActionListener actionListener2 = new button2ActionListener();
        JButton b2 = new JButton("Âïåð¸ä");
        b2.setPreferredSize(new Dimension(100,50));
        b2.addActionListener(actionListener2);
        menu.add(b2);

        p1.add(panelCheck);
    }

    public class button2ActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            j++;
            if(j < list.size()) {
                Test temp = list.get(j);
                Controler.frame.add(temp);
                Controler.frame.remove(list.get(j - 1));
                Controler.frame.revalidate();
                Controler.frame.repaint();

            } else {
                TestFinal.testFinal =  new TestFinal(balls);
                Controler.frame.add(TestFinal.testFinal);
                Controler.frame.remove(list.get(j - 1));
                Controler.frame.revalidate();
                Controler.frame.repaint();
            }
        }
    }

    public static void main(String[] args) {
            Test temp = list.get(j);
            JFrame frame = new JFrame("");
            frame.add(temp);
            frame.setBackground(Color.WHITE);
            frame.setVisible(true);
            frame.setSize(800,600);
            frame.setExtendedState(MAXIMIZED_BOTH);
            frame.getContentPane().setBackground(Color.WHITE);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
