import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Controler extends JComponent {
    public static JFrame frame = new JFrame();
    static Controler controler;

    public Controler(){


        setLayout(new BorderLayout());

        JPanel panel =  new JPanel(new GridLayout(1,3));
        add(panel, BorderLayout.CENTER);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel.add(panel1);

        JPanel panel2 = new JPanel(new GridLayout(3,1));
        panel2.setBackground(Color.WHITE);
        panel.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.WHITE);
        panel.add(panel3);

        JPanel panel21 = new JPanel();
        panel21.setBackground(Color.WHITE);
        panel2.add(panel21);

        JPanel panel22 = new JPanel(new GridLayout(7,1));
        panel22.setBackground(Color.WHITE);
        panel2.add(panel22);


        ActionListener actionListener1 = new button1ActionListener();
        JButton b1 = new JButton("Урок \"Логические элементы\"");
        b1.addActionListener(actionListener1);
        b1.setFont(new Font("Dialog", 0, 20));
        b1.setPreferredSize(new Dimension(400, 50));
        panel22.add(b1);


        ActionListener actionListener2 = new button2ActionListener();
        JButton b2 = new JButton("Урок \"Триггеры статика\"");
        b2.addActionListener(actionListener2);
        b2.setFont(new Font("Dialog", 0, 20));
        b2.setPreferredSize(new Dimension(400, 50));
        panel22.add(b2);

        ActionListener actionListener3 = new button3ActionListener();
        JButton b3 = new JButton("Урок \"Триггеры динамика\"");
        b3.addActionListener(actionListener3);
        b3.setFont(new Font("Dialog", 0, 20));
        b3.setPreferredSize(new Dimension(400, 50));
        panel22.add(b3);


        ActionListener actionListener4 = new button4ActionListener();
        JButton b4 = new JButton("Тест \"Логические элементы\"");
        b4.addActionListener(actionListener4);
        b4.setFont(new Font("Dialog", 0, 20));
        b4.setPreferredSize(new Dimension(400, 50));
        panel22.add(b4);

        ActionListener actionListener5 = new button5ActionListener();
        JButton b5 = new JButton("Тест \"Триггеры статика\"");
        b5.addActionListener(actionListener5);
        b5.setFont(new Font("Dialog", 0, 20));
        b5.setPreferredSize(new Dimension(400, 50));
        panel22.add(b5);

        ActionListener actionListener6 = new button6ActionListener();
        JButton b6 = new JButton("Тест \"Триггеры динамика\"");
        b6.addActionListener(actionListener6);
        b6.setFont(new Font("Dialog", 0, 20));
        b6.setPreferredSize(new Dimension(400, 50));
        panel22.add(b6);

        ActionListener actionListener7 = new button7ActionListener();
        JButton b7 = new JButton("Выход");
        b7.addActionListener(actionListener7);
        b7.setFont(new Font("Dialog", 0, 20));
        b7.setPreferredSize(new Dimension(400, 50));
        panel22.add(b7);

/*
        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new GridBagLayout());
        add(menu,BorderLayout.SOUTH);

        GridBagConstraints constraints =  new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JButton b8 = new JButton("меню");
        b8.setPreferredSize(new Dimension(100,50));
        //b1.addActionListener(actionListener1);
        menu.add(b8);

        JPanel interval = new JPanel();
        interval.setPreferredSize(new Dimension(50,50));
        interval.setBackground(Color.WHITE);
        menu.add(interval);

        //ActionListener actionListener1 = new button1ActionListener();
        JButton b9 = new JButton("Назад");
        b9.setPreferredSize(new Dimension(100,50));
        //b1.addActionListener(actionListener1);
        menu.add(b9);

        menu.add(interval);


        //ActionListener actionListener2 = new button2ActionListener();
        JButton b10 = new JButton("Вперёд");
        b10.setPreferredSize(new Dimension(100,50));
        //b2.addActionListener(actionListener2);
        menu.add(b10);

*/

    }

    public class button1ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson11.lesson11 == null)
                Lesson11.lesson11 = new Lesson11();
            frame.add(Lesson11.lesson11);
            frame.remove(controler);
            frame.revalidate();
            frame.repaint();

        }
    }

    public class button2ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson21.lesson21 == null)
                Lesson21.lesson21 = new Lesson21();
            frame.add(Lesson21.lesson21);
            frame.remove(controler);
            frame.revalidate();
            frame.repaint();

        }
    }


    public class button3ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(Lesson31.lesson31 == null)
                Lesson31.lesson31 = new Lesson31();
            frame.add(Lesson31.lesson31);
            frame.remove(controler);
            frame.revalidate();
            frame.repaint();

        }
    }

    public class button4ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Test.list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("Test\\test1.txt"))){
                String [] stringargs = new String[9];
                int count = 0;
                while(reader.ready()){
                    stringargs[count] = reader.readLine();
                    count++;
                    if(count == 9){
                        Test.list.add(new Test(stringargs));

                        count = 0;
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Not field");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Test.balls = 0;
            frame.add(Test.list.get(0));
            frame.remove(controler);
            frame.revalidate();
            frame.repaint();

        }
    }

    public class button5ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Test.list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("Test\\test2.txt"))){
                String [] stringargs = new String[9];
                int count = 0;
                while(reader.ready()){
                    stringargs[count] = reader.readLine();
                    count++;
                    if(count == 9){
                        Test.list.add(new Test(stringargs));

                        count = 0;
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Not field");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Test.balls = 0;
            frame.add(Test.list.get(0));
            frame.remove(controler);
            frame.revalidate();
            frame.repaint();

        }
    }

    public class button6ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Test.list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("Test\\test3.txt"))){
                String [] stringargs = new String[9];
                int count = 0;
                while(reader.ready()){
                    stringargs[count] = reader.readLine();
                    count++;
                    if(count == 9){
                        Test.list.add(new Test(stringargs));

                        count = 0;
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Not field");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Test.balls = 0;
            frame.add(Test.list.get(0));
            frame.remove(controler);
            frame.revalidate();
            frame.repaint();

        }
    }


    public class button7ActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }



    public static void main(String[] args) {
        controler = new Controler();

        frame.add(controler);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setSize(800,600);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
