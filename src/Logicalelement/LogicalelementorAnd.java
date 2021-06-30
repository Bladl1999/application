package Logicalelement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;

public class LogicalelementorAnd extends JComponent{
    private int h;  // Высота логического элемента
    private int w;  // длина логического элемента
    private int x;  // координата х для размещение
    private int y;  // координата у для размещение
    private String x1 = "0"; // Вход 1
    private String x2 = "0"; // Вход 2
    private String y1 = "0"; // Выход 1
    public LogicalelementorAnd(){
        
    }
    public void paint(Graphics g)
 	{
        // Отрисовываем логического элемента
            setBackground(Color.WHITE);
            Color newColor = new Color(255, 255, 255);
            g.setColor(newColor);
            w = 50;   
            h = 100;
            x = 100;
            y = 30;
            g.fillRect(x, y, w, h);                 // Внутриняя часть логического элемента
            newColor = new Color(0, 0, 0);
            g.setColor(newColor);                   // Внешняя часть логического элемента
            g.drawRect(x, y, w, h);                 // Внешняя часть логического элемента и его входов и выдохов
            
            if(x1.equals("1"))
                g.setColor(Color.red);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x - 50, y + 25, x, y + 25);
            
            if(x2.equals("1"))
                g.setColor(Color.red);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x - 50, y + 75, x, y + 75);
            
            if(y1.equals("1"))
                g.setColor(Color.red);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x + w, y + 50, x + w + 50, y + 50);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Dialog",1, 20));
            g.drawString("&", x + w - 20, y + 25);
            g.drawString(x1 , x - 50, y + 25);
            g.drawString(x2, x - 50, y + 75);
            g.drawString(y1, x + w + 40, y + 50);
            g.drawString("Логический элемент И", x - 50, y - 10);
        
	}
    
    public void setX1(){
        if(x1.equals("0"))
            x1 = "1";
        else 
            x1 = "0";
        setY1();
        repaint();
    }
    
    public void setX2(){
        if(x2.equals("0"))
            x2 = "1";
        else 
            x2 = "0";
        setY1();
        repaint();
    }
    
    public void setY1(){
        if(x1.equals("1") & x2.equals("1"))
            y1 = "1";
        else
            y1 = "0";
    }
    
    
    public static void main(String[] args) {
        LogicalelementorAnd ili = new LogicalelementorAnd();
        Frame frame = new Frame("Или");	
        frame.add(ili);
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