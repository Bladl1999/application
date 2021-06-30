package TriggerDynamics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JComponent;

public class TriggerDynamicsDT extends JComponent implements Runnable{
    private int h; //высота
    private int w; //длинна
    private int y;
    private int x;
    private int c = 1; //Синхро импулбс
    private int q1 = 0;//Прямой выход
    private int q2 = 1;//Инверсный выход
    private ArrayList<Boolean> cy = new ArrayList<>();
    private ArrayList<Boolean> q1y = new ArrayList<>();
    private ArrayList<Boolean> q2y = new ArrayList<>();
    
    public TriggerDynamicsDT() {
        new Thread(this).start();
    }
    
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
            
            g.setColor(Color.BLACK);
            g.drawString("C", 0, y + h + 60);
            g.drawLine(x - 30, y + h + 30, x - 30, y + h + 70);
            g.drawLine(x - 30, y + h + 70, x + w + 50, y + h + 70);
            
            g.drawString("Q", 0, y + h + 110);
            g.drawLine(x - 30, y + h + 80, x - 30, y + h + 120);
            g.drawLine(x - 30, y + h + 120, x + w + 50, y + h + 120);
            
            g.drawString("Q'", 0, y + h + 160);
            g.drawLine(x - 30, y + h + 130, x - 30, y + h + 170);
            g.drawLine(x - 30, y + h + 170, x + w + 50, y + h + 170);
            
             g.setColor(Color.red);
            int temp = x - 30;
            int temp1 = y + h - 31;
            for(int i = 0; i < getCy().size() - 1; i++){
                if(cy.get(i)){
                    if(cy.get(i) == cy.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 70 , temp + 10 + 10* i,temp1 + 70);
                    } else
                    {
                        g.drawLine(temp + 10*i,temp1 + 70 , temp + 10 + 10* i,temp1 + 70);
                        g.drawLine(temp + 10 + 10* i,temp1 + 70 , temp + 10 + 10* i,temp1 + 100);
                    }
                } else {
                    if(cy.get(i) == cy.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 100 , temp + 10 + 10* i,temp1 + 100);
                    } else {
                        g.drawLine(temp + 10*i,temp1 + 100 , temp + 10 + 10* i,temp1 + 100);
                        g.drawLine(temp + 10 + 10* i,temp1 + 100 , temp + 10 + 10* i,temp1 + 70);
                    }
                }    
            }
            
            for(int i = 0; i < getQ1y().size() - 1; i++){
                if(q1y.get(i)){
                    if(q1y.get(i) == q1y.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 120 , temp + 10 + 10* i,temp1 + 120);
                    } else
                    {
                        g.drawLine(temp + 10*i,temp1 + 120 , temp + 10 + 10* i,temp1 + 120);
                        g.drawLine(temp + 10 + 10* i,temp1 + 120 , temp + 10 + 10* i,temp1 + 150);
                    }
                } else {
                    if(q1y.get(i) == q1y.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 150 , temp + 10 + 10* i,temp1 + 150);
                    } else {
                        g.drawLine(temp + 10*i,temp1 + 150 , temp + 10 + 10* i,temp1 + 150);
                        g.drawLine(temp + 10 + 10* i,temp1 + 150 , temp + 10 + 10* i,temp1 +120);
                    }
                }    
            }
            
            for(int i = 0; i < getQ2y().size() - 1; i++){
                if(q2y.get(i)){
                    if(q2y.get(i) == q2y.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 170 , temp + 10 + 10* i,temp1 + 170);
                    } else
                    {
                        g.drawLine(temp + 10*i,temp1 + 170 , temp + 10 + 10* i,temp1 + 170);
                        g.drawLine(temp + 10 + 10* i,temp1 + 170 , temp + 10 + 10* i,temp1 + 200);
                    }
                } else {
                    if(q2y.get(i) == q2y.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 200 , temp + 10 + 10* i,temp1 + 200);
                    } else {
                        g.drawLine(temp + 10*i,temp1 + 200 , temp + 10 + 10* i,temp1 + 200);
                        g.drawLine(temp + 10 + 10* i,temp1 + 200 , temp + 10 + 10* i,temp1 + 170);
                    }
                }    
            }   
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
    
    public void setCy(){
        if(cy.size() > 18)
            cy = new ArrayList<>();
        if(c == 1)
            cy.add(true);
        else
            cy.add(false);
    }
    
    public void setQ1y(){
        if(q1y.size() > 18)
            q1y = new ArrayList<>();
        if(q1 == 1)
            q1y.add(true);
        else
            q1y.add(false);
    }
    
    public void setQ2y(){
        if(q2y.size() > 18)
            q2y = new ArrayList<>();
        if(q2 == 1)
            q2y.add(true);
        else
            q2y.add(false);
    }
    
    public ArrayList<Boolean> getCy() {
        return cy;
    }

    public ArrayList<Boolean> getQ1y() {
        return q1y;
    }

    public ArrayList<Boolean> getQ2y() {
        return q2y;
    }
        
    public void run(){
        for(int i = 0; i < i + 1; i++){
            try {
                setCy();
                setQ1y();
                setQ2y();
                repaint();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Произошла ошибка в потоке");
            }
        }
    }
    
    public static void main(String[] args) {
        TriggerDynamicsDT triggerdynamicsdt = new  TriggerDynamicsDT();
        Frame frame = new Frame("Триггер Д-T");	
        frame.add(triggerdynamicsdt);
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
