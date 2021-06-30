import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class TestFinal extends JComponent {
    public static TestFinal testFinal;

    public TestFinal(int balls){
        setLayout(new BorderLayout());

        Panel p1 = new Panel(new GridBagLayout());
        p1.setBackground(Color.WHITE);
        add(p1,BorderLayout.CENTER);
        setSize(new Dimension(600,600));


        JTextArea text =  new JTextArea();
        text.setPreferredSize(new Dimension(500, 100));
        text.setLineWrap(true);
        text.setFont(new Font("Bold", Font.BOLD,30));
        text.setText("Вы получили " + balls + " баллов \n" );
        p1.add(text);
        text.setEditable(false);
        text.setBackground(Color.WHITE);

        JPanel menu = new JPanel();
        menu.setBackground(Color.WHITE);
        menu.setLayout(new BorderLayout());
        add(menu,BorderLayout.SOUTH);


        ActionListener actionListener1 = new button1ActionListener();
        JButton b1 = new JButton("Меню");
        b1.setPreferredSize(new Dimension(100,50));
        b1.addActionListener(actionListener1);
        menu.add(b1,BorderLayout.LINE_END);



    }

    public class button1ActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Test.list = null;
            Test.j = 0;
            Test.balls = 0;
            if(Controler.controler == null)
                Controler.controler = new Controler();
            Controler.frame.add(Controler.controler);
            Controler.frame.remove(TestFinal.testFinal);
            Controler.frame.revalidate();
            Controler.frame.repaint();
        }
    }

    public static void main(String[] args) {
        TestFinal temp = new TestFinal(5);
        JFrame frame = new JFrame("");
        frame.add(temp);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
