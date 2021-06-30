package TriggerDynamics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author User
 */
public class TriggerDynamicsJKT extends JComponent implements Runnable{
    private int h; //высота
    private int w; //длинна
    private int y;
    private int x;
    private int j = 1; //Сигнал j
    private int c = 1; //Синхро импулбс
    private int q1 = 1;//Прямой выход
    private int q2 = 0;//Инверсный выход
    private ArrayList<Boolean> jy = new ArrayList<>();
    private ArrayList<Boolean> ky = new ArrayList<>();
    private ArrayList<Boolean> cy = new ArrayList<>();
    private ArrayList<Boolean> q1y = new ArrayList<>();
    private ArrayList<Boolean> q2y = new ArrayList<>();
    
    public TriggerDynamicsJKT() {
        new Thread(this).start();
    }
    
    public void paint(Graphics g)
 	{
            w = 100;   
            h = 100;
            x = 150;
            y = 30;
            g.setFont(new Font("Dialog",1, 30));    //Установка шрифта
            g.setColor(Color.WHITE);
            g.fillRect(x, y, w, h);                 // Внутриняя часть триггера
            g.setColor(Color.BLACK);                
            g.drawRect(x, y, w, h);                 // Внешняя часть триггера
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
            g.drawLine(x - 100, y + h - 15, x , y + h - 15);
            
            g.drawString("" + getJ(), x - 150, y + 15);
            //Сихроный сигнал С
            if(getC() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x - 50, y + h/2, x , y + h/2);
            g.drawString("" + getC(), x - 50, y + h/2);
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
            
                        g.setColor(Color.BLACK);
            g.drawString("J", 0, y + h + 40);
            g.drawLine(x - 120, y + h + 10, x - 120, y + h + 50);
            g.drawLine(x - 120, y + h + 50, x + w - 40, y + h + 50);
            
            g.drawString("K", 0, y + h + 90);
            g.drawLine(x - 120, y + h + 60, x - 120, y + h + 100);
            g.drawLine(x - 120, y + h + 100, x + w - 40, y + h + 100);
            
            g.drawString("C", 0, y + h + 140);
            g.drawLine(x - 120, y + h + 110, x - 120, y + h + 150);
            g.drawLine(x - 120, y + h + 150, x + w - 40, y + h + 150);
            
            g.drawString("Q", 0, y + h + 190);
            g.drawLine(x - 120, y + h + 160, x - 120, y + h + 200);
            g.drawLine(x - 120, y + h + 200, x + w  - 40, y + h + 200);
            
            g.drawString("Q'", 0, y + h + 240);
            g.drawLine(x - 120, y + h + 210, x - 120, y + h + 250);
            g.drawLine(x - 120, y + h + 250, x + w - 40, y + h + 250);
            
            g.setColor(Color.red);
            int temp = x - 120;
            for(int i = 0; i < getJy().size() - 1; i++){
                if(jy.get(i)){
                    if(jy.get(i) == jy.get(i + 1)){
                        g.drawLine(temp + 10*i,y + h + 19 , temp + 10 + 10* i,y + h + 19);
                    } else
                    {
                        g.drawLine(temp + 10*i,y + h + 19 , temp + 10 + 10* i,y + h + 19);
                        g.drawLine(temp + 10 + 10* i,y + h + 19 , temp + 10 + 10* i,y + h + 49);
                    }
                } else {
                    if(jy.get(i) == jy.get(i + 1)){
                        g.drawLine(temp + 10*i,y + h + 49 , temp + 10 + 10* i,y + h + 49);
                    } else {
                        g.drawLine(temp + 10*i,y + h + 49 , temp + 10 + 10* i,y + h + 49);
                        g.drawLine(temp + 10 + 10* i,y + h + 49 , temp + 10 + 10* i,y + h + 19);
                    }
                }    
            }
            
            int temp1 = y + h - 1;
            for(int i = 0; i < getJy().size() - 1; i++){
                if(ky.get(i)){
                    if(ky.get(i) == ky.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 70 , temp + 10 + 10* i,temp1 + 70);
                    } else
                    {
                        g.drawLine(temp + 10*i,temp1 + 70 , temp + 10 + 10* i,temp1 + 70);
                        g.drawLine(temp + 10 + 10* i,temp1 + 70 , temp + 10 + 10* i,temp1 + 100);
                    }
                } else {
                    if(ky.get(i) == ky.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 100 , temp + 10 + 10* i,temp1 + 100);
                    } else {
                        g.drawLine(temp + 10*i,temp1 + 100 , temp + 10 + 10* i,temp1 + 100);
                        g.drawLine(temp + 10 + 10* i,temp1 + 100 , temp + 10 + 10* i,temp1 + 70);
                    }
                }    
            }
            
            for(int i = 0; i < getCy().size() - 1; i++){
                if(cy.get(i)){
                    if(cy.get(i) == cy.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 120 , temp + 10 + 10* i,temp1 + 120);
                    } else
                    {
                        g.drawLine(temp + 10*i,temp1 + 120 , temp + 10 + 10* i,temp1 + 120);
                        g.drawLine(temp + 10 + 10* i,temp1 + 120 , temp + 10 + 10* i,temp1 + 150);
                    }
                } else {
                    if(cy.get(i) == cy.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 150 , temp + 10 + 10* i,temp1 + 150);
                    } else {
                        g.drawLine(temp + 10*i,temp1 + 150 , temp + 10 + 10* i,temp1 + 150);
                        g.drawLine(temp + 10 + 10* i,temp1 + 150 , temp + 10 + 10* i,temp1 +120);
                    }
                }    
            }
            
            for(int i = 0; i < getQ1y().size() - 1; i++){
                if(q1y.get(i)){
                    if(q1y.get(i) == q1y.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 170 , temp + 10 + 10* i,temp1 + 170);
                    } else
                    {
                        g.drawLine(temp + 10*i,temp1 + 170 , temp + 10 + 10* i,temp1 + 170);
                        g.drawLine(temp + 10 + 10* i,temp1 + 170 , temp + 10 + 10* i,temp1 + 200);
                    }
                } else {
                    if(q1y.get(i) == q1y.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 200 , temp + 10 + 10* i,temp1 + 200);
                    } else {
                        g.drawLine(temp + 10*i,temp1 + 200 , temp + 10 + 10* i,temp1 + 200);
                        g.drawLine(temp + 10 + 10* i,temp1 + 200 , temp + 10 + 10* i,temp1 + 170);
                    }
                }    
            }
            
            for(int i = 0; i < getQ2y().size() - 1; i++){
                if(q2y.get(i)){
                    if(q2y.get(i) == q2y.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 220 , temp + 10 + 10* i,temp1 + 220);
                    } else
                    {
                        g.drawLine(temp + 10*i,temp1 + 220 , temp + 10 + 10* i,temp1 + 220);
                        g.drawLine(temp + 10 + 10* i,temp1 + 220 , temp + 10 + 10* i,temp1 + 250);
                    }
                } else {
                    if(q2y.get(i) == q2y.get(i + 1)){
                        g.drawLine(temp + 10*i,temp1 + 250 , temp + 10 + 10* i,temp1 + 250);
                    } else {
                        g.drawLine(temp + 10*i,temp1 + 250 , temp + 10 + 10* i,temp1 + 250);
                        g.drawLine(temp + 10 + 10* i,temp1 + 250 , temp + 10 + 10* i,temp1 + 220);
                    }
                }    
            }
            
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
    // проверить     
    public void setC() {
        if(c == 1)
            c = 0;
        else{
            c = 1;
            if(j == 1){
                if(q1 == 1){
                    q1 = 0;
                    q2 = 1;
                } else 
                {
                    q1 = 1;
                    q2 = 0;
                }
            }
        }
        repaint();
    }
    // проверить 
    public void setJ() {
        if(j == 1){
            j = 0;
            if(c == 1){
                
            }
        } else
        {
            j = 1;
            if(c == 1){
                if(q1 == 1){
                    q1 = 0;
                    q2 = 1;
                } else 
                {
                    q1 = 1;
                    q2 = 0;
                }
            }
        }
        repaint();
    }

    public void setJy(){
        if(jy.size() > 18)
            jy = new ArrayList<>();
        if(j == 1)
            jy.add(true);
        else
            jy.add(false);
    }
    
    public void setKy(){
        if(ky.size() > 18)
            ky = new ArrayList<>();
        if(j == 1)
            ky.add(true);
        else
            ky.add(false);
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

    
    public ArrayList<Boolean> getJy() {
        return jy;
    }

    public ArrayList<Boolean> getKy() {
        return ky;
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
                setJy();
                setKy();
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
        TriggerDynamicsJKT triggerdynamicsjkt = new  TriggerDynamicsJKT();
        Frame frame = new Frame("Триггер Д");	
        frame.add(triggerdynamicsjkt);
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
