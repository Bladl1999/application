package TriggerStatic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;

public class TriggerJKD extends JComponent {

    private int h; //высота
    private int w; //длинна
    private int y;
    private int x;
    private int j = 1; //Сигнал j
    private int c = 1; //Синхро импулбс
    private int q1 = 1;//Прямой выход
    private int q2 = 0;//Инверсный выход
    public void paint(Graphics g)
 	{
            w = 100;   
            h = 100;
            x = 150;
            y = 30;
            g.setFont(new Font("Dialog",1, 30));    //Установка шрифта
            g.setColor(Color.WHITE);
            g.fillRect( x - 90, y + h - 30, 20, 30);
            g.fillRect(x, y, w, h);                 // Внутриняя часть триггера
            g.setColor(Color.BLACK);                
            g.drawRect(x, y, w, h);                 // Внешняя часть триггера
            g.drawRect(x - 90, y + h - 30, 20, 30);
            g.drawOval(x - 75, y + h - 20, 10, 10);
            g.drawString("J", x + 5, y + 30);
            g.drawLine(x, y + h/2 - 10, x + 20, y + h/2);
            g.drawLine(x + 20, y + h/2, x, y + h/2 + 10);
            g.drawString("K", x + 5, y + h - 5);
            g.drawString("Q", x + w - 30, y + 30);
            g.drawString("Q'", x + w - 30, y + h - 5);
            g.setFont(new Font("Dialog",1, 20)); 
            //Сигнал J
            if(getJ() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x - 150, y + 15, x , y + 15);
            g.drawLine(x - 100, y + 15, x - 100 , y + h - 15);
            g.drawLine(x - 100, y + h - 15, x - 90 , y + h - 15);
            g.drawString("" + getJ(), x - 150, y + 15);
            //Сихроный сигнал С
            if(getC() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x - 50, y + h/2, x , y + h/2);
            g.drawString("" + getC(), x - 50, y + h/2);
            //Сигнал нижний
            if(getJ() == 0)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x - 70, y + h - 15, x, y + h - 15);
            if(getJ() == 1)
                g.drawString("0", x - 60, y + h - 15);
            else
                g.drawString("1", x - 60, y + h - 15);
            //Выходной сигнал Q
            if(getQ1() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x + w, y + 15, x + w + 50 , y + 15);
            g.drawString("" + getQ1(), x + w + 40, y + 15);
            //Выходной сигнал Q'
            if(getQ2() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x + w, y + h - 15, x + w + 50, y + h - 15);
            g.drawString("" + getQ2(), x + w + 40, y + h - 15);
        }
    public int getJ() {
        return j;
    }

    public int getC() {
        return c;
    }

    public int getQ1() {
        return q1;
    }

    public int getQ2() {
        return q2;
    }
   
    public void setC() {
        if(c == 1)
            c = 0;
        else
            c = 1;
        repaint();
    }

    public void setJ() {
        if(j == 1){
            j = 0;
            if(c == 1){
                q1 = 0;
                q2 = 1;
            }
        } else
        {
            j = 1;
            if(c == 1){
                q1 = 1;
                q2 = 0;
            }
        }
        repaint();
    }

   public static void main(String[] args) {
        TriggerJKD triggerjkd = new  TriggerJKD();
        Frame frame = new Frame("Триггер Д");	
        frame.add(triggerjkd);
        frame.setSize(920, 600);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
               System.exit(0);
            }    
       });    
    }
    
}
