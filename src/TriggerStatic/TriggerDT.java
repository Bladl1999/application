package TriggerStatic;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;

/**
 *
 * @author User
 */
public class TriggerDT extends JComponent {
private int h; //высота
    private int w; //длинна
    private int y;
    private int x;
    private int d = 1; //Сигнал D
    private int c = 1; //Синхро импулбс
    private int q1 = 0;//Прямой выход
    private int q2 = 1;//Инверсный выход
    public void paint(Graphics g)
 	{
            w = 100;   
            h = 100;
            x = 60;
            y = 40;
            g.setFont(new Font("Dialog",1, 30));    //Установка шрифта
            g.setColor(Color.WHITE);
            g.fillRect(x, y, w, h);                 // Внутриняя часть триггера
            g.setColor(Color.BLACK);                
            g.drawRect(x, y, w, h);                 // Внешняя часть триггера
            g.drawString("D", x + 5, y + 30);
            //Синхро вход
            g.drawLine(x, y + h - 10, x + 15, y + h - 25);
            g.drawLine(x + 15, y + h - 25, x , y + h - 40);
            //Q
            g.drawString("Q", x + w - 30, y + 30);
            //Q'
            g.drawString("Q'", x + w - 30, y + h - 10);
            g.setFont(new Font("Dialog",1, 20));
            //Вход D
            if(getC() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawString("" + getC(), x - 50 , y + h - 25);
            g.drawLine(x - 50, y + h - 25, x, y + h - 25);
            if(getQ1() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawString("" + getQ1(), x + w + 50 , y + 20);
            g.drawLine(x + w, y + 20, x + w + 50, y + 20);
           
            if(getQ2() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawString("" + getQ2(), x + w + 50 , y + h - 25);
            g.drawLine(x + w, y + h - 25, x + w + 75, y + h - 25);
            g.drawLine(x + w + 75, y + h - 25, x + w + 75, y - 20);
            g.drawLine(x + w + 75, y - 20, x - 50, y - 20);
            g.drawLine( x - 50, y - 20, x - 50, y + 20 );
            g.drawLine( x - 50, y + 20, x , y + 20 );
            
        }

    public int getQ1() {
        return q1;
    }

    public int getQ2() {
        return q2;
    }

    public int getC() {
        return c;
    }
    
    public void setC() {
        if(c == 1)
            c = 0;
        else
        {
            c = 1;
            if (q1 == 1){
                q1 = 0;
                q2 = 1;
            } else
            {
                q1 = 1;
                q2 = 0;
            }
        }
        repaint();
    }
        
    
    
    public static void main(String[] args) {
        TriggerDT triggerdt = new  TriggerDT();
        Frame frame = new Frame("Триггер Д-T");	
        frame.add(triggerdt);
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
