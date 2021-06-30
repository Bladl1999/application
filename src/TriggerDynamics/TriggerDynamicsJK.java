package TriggerDynamics;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author User
 */
public class TriggerDynamicsJK extends JComponent implements Runnable {
 private int h; //высота
    private int w; //длинна
    private int y;
    private int x;
    private int j = 1; //Сигнал j
    private int k = 1; //Сигнал к
    private int c = 1; //Синхро импулбс
    private int q1 = 1;//Прямой выход
    private int q2 = 0;//Инверсный выход
    private ArrayList<Boolean> jy = new ArrayList<>();
    private ArrayList<Boolean> ky = new ArrayList<>();
    private ArrayList<Boolean> cy = new ArrayList<>();
    private ArrayList<Boolean> q1y = new ArrayList<>();
    private ArrayList<Boolean> q2y = new ArrayList<>();
    
    public TriggerDynamicsJK() {
        new Thread(this).start();
    }
    public void paint(Graphics g)
 	{
            w = 100;   
            h = 100;
            x = 100;
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
            g.drawLine(x - 50, y + 15, x , y + 15);
            g.drawString("" + getJ(), x - 50, y + 15);
            //Сихроный сигнал С
            if(getC() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x - 50, y + h/2, x , y + h/2);
            g.drawString("" + getC(), x - 50, y + h/2);
            //Сигнал К
            if(getK() == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            g.drawLine(x - 50, y + h - 15, x , y + h - 15);
            g.drawString("" + getK(), x - 50, y + h - 15);
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

            int temp = x + 300; //диаграммы по х
            int temp1 = y - 20; //диаграмы по y
            int kof = 20;
            g.setColor(Color.BLACK);
            g.drawString("J", temp - 30, temp1 + 41);
            g.drawLine(temp, temp1 + 11, temp, temp1 + 71);
            g.drawLine(temp, temp1 + 71, temp + kof*18, temp1 + 71);
            
            g.drawString("K", temp - 30, temp1 + 111);
            g.drawLine(temp, temp1+ 81, temp, temp1 + 141);
            g.drawLine(temp, temp1+ 141, temp + kof*18, temp1 + 141);
            
            g.drawString("C", temp - 30, temp1 + 181);
            g.drawLine(temp, temp1 + 151, temp, temp1 + 211);
            g.drawLine(temp, temp1 + 211, temp + kof*18, temp1 + 211);
            
            g.drawString("Q", temp - 30, temp1 + 251);
            g.drawLine(temp, temp1 + 221, temp, temp1 + 281);
            g.drawLine(temp, temp1 + 281, temp + kof*18, temp1 + 281);
            
            g.drawString("Q'", temp - 30, temp1 + 321);
            g.drawLine(temp, temp1 + 291, temp, temp1 + 351);
            g.drawLine(temp, temp1 + 351, temp + kof*18, temp1 + 351);



            for(int i = 0; i < 18; i++){
                g.drawLine(temp + kof + kof* i,temp1 + 10 , temp + kof + kof* i,temp1 + 70);
                g.drawLine(temp + kof + kof* i,temp1 + 80 , temp + kof + kof* i,temp1 + 140);
                g.drawLine(temp + kof + kof* i,temp1 + 150 , temp + kof + kof* i,temp1 + 210);
                g.drawLine(temp + kof + kof* i,temp1 + 220 , temp + kof + kof* i,temp1 + 280);
                g.drawLine(temp  + kof+ kof* i,temp1 + 290 , temp + kof + kof* i,temp1 + 350);
            }
            
            g.setColor(Color.red);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3.0f));

            for(int i = 0; i < getJy().size() - 1; i++){
                if(jy.get(i)){
                    if(jy.get(i) == jy.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 20 , temp + kof+ kof* i,temp1 + 20);
                    } else
                    {
                        g.drawLine(temp + kof*i,temp1 + 20 , temp + kof + kof* i,temp1 + 20);
                        g.drawLine(temp + kof + kof* i,temp1 + 20 , temp + kof + kof* i,temp1 + 70);
                    }
                } else {
                    if(jy.get(i) == jy.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 70 , temp + kof + kof* i,temp1 + 70);
                    } else {
                        g.drawLine(temp + kof*i,temp1 + 70 , temp + kof + kof* i,temp1 + 70);
                        g.drawLine(temp + kof + kof* i,temp1 + 70 , temp + kof + kof* i,temp1 + 20);
                    }
                }    
            }
            

            for(int i = 0; i < getJy().size() - 1; i++){
                if(ky.get(i)){
                    if(ky.get(i) == ky.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 90 , temp + kof + kof* i,temp1 + 90);
                    } else
                    {
                        g.drawLine(temp + kof*i,temp1 + 90 , temp + kof + kof* i,temp1 + 90);
                        g.drawLine(temp + kof + kof* i,temp1 + 90 , temp + kof + kof* i,temp1 + 140);
                    }
                } else {
                    if(ky.get(i) == ky.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 140 , temp + kof + kof* i,temp1 + 140);
                    } else {
                        g.drawLine(temp + kof*i,temp1 + 140 , temp + kof + kof* i,temp1 + 140);
                        g.drawLine(temp + kof + kof* i,temp1 + 140 , temp + kof + kof* i,temp1 + 90);
                    }
                }    
            }
            
            for(int i = 0; i < getCy().size() - 1; i++){
                if(cy.get(i)){
                    if(cy.get(i) == cy.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 160 , temp + kof + kof* i,temp1 + 160);
                    } else
                    {
                        g.drawLine(temp + kof*i,temp1 + 160 , temp + kof + kof* i,temp1 + 160);
                        g.drawLine(temp + kof + kof* i,temp1 + 160 , temp + kof + kof* i,temp1 + 210);
                    }
                } else {
                    if(cy.get(i) == cy.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 210 , temp + kof + kof* i,temp1 + 210);
                    } else {
                        g.drawLine(temp + kof*i,temp1 + 210 , temp + kof + kof* i,temp1 + 210);
                        g.drawLine(temp + kof + kof* i,temp1 + 210 , temp + kof + kof* i,temp1 +160);
                    }
                }    
            }
            
            for(int i = 0; i < getQ1y().size() - 1; i++){
                if(q1y.get(i)){
                    if(q1y.get(i) == q1y.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 230 , temp + kof + kof* i,temp1 + 230);
                    } else
                    {
                        g.drawLine(temp + kof*i,temp1 + 230 , temp + kof + kof* i,temp1 + 230);
                        g.drawLine(temp + kof + kof* i,temp1 + 230 , temp + kof + kof* i,temp1 + 280);
                    }
                } else {
                    if(q1y.get(i) == q1y.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 280 , temp + kof + kof* i,temp1 + 280);
                    } else {
                        g.drawLine(temp + kof*i,temp1 + 280 , temp + kof + kof* i,temp1 + 280);
                        g.drawLine(temp + kof + kof* i,temp1 + 280 , temp + kof + kof* i,temp1 + 230);
                    }
                }    
            }
            
            for(int i = 0; i < getQ2y().size() - 1; i++){
                if(q2y.get(i)){
                    if(q2y.get(i) == q2y.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 300 , temp + kof + kof* i,temp1 + 300);
                    } else
                    {
                        g.drawLine(temp + kof*i,temp1 + 300 , temp + kof + kof* i,temp1 + 300);
                        g.drawLine(temp + kof + kof* i,temp1 + 300 , temp + kof + kof* i,temp1 + 350);
                    }
                } else {
                    if(q2y.get(i) == q2y.get(i + 1)){
                        g.drawLine(temp + kof*i,temp1 + 350 , temp + kof + kof* i,temp1 + 350);
                    } else {
                        g.drawLine(temp + kof*i,temp1 + 350 , temp + kof + kof* i,temp1 + 350);
                        g.drawLine(temp + kof + kof* i,temp1 + 350 , temp + kof + kof* i,temp1 + 300);
                    }
                }    
            }
            
        }

    public int getJ() {
        return j;
    }

    public int getK() {
        return k;
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
        else{
            c = 1;
            if((j == 1) &&( k == 0)){
                q1 = 1;
                q2 = 0;
            }
            if((k == 1) && (j == 0)){
                q1 = 0;
                q2 = 1;
            }
        }
        repaint();
    }
    
    public void setJ() {
        if(j == 1){
            j = 0;
            if(c == 1){
                if( k == 1){
                    q1 = 0;
                    q2 = 1;
                }
            }
        } else
        {
            j = 1;
            if(c == 1){
                if(k == 1){
                    if(q1 == 1){
                        q1 = 0;
                        q2 = 1;
                    } else 
                    {
                        q1 = 1;
                        q2 = 0;
                    }
                } else
                {
                    q1 = 1;
                    q2 = 0;
                }
            }
        }
        repaint();
    }
    
    public void setK(){
        if(k == 1){
            k = 0;
            if(c == 1){
                if(j == 1){
                    q1 = 1;
                    q2 = 0;
                }
            }
        } else
        {
            k = 1;
            if(c == 1){
                if( j == 1){
                    if(q1 == 1){
                        q1 = 0;
                        q2 = 1;
                    } else
                    {
                        q1 = 1;
                        q2 = 0;
                    }
                    
                } else
                {
                    q1 = 0;
                    q2 = 1;
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
        if(k == 1)
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
        TriggerDynamicsJK triggerdynamicsjk = new  TriggerDynamicsJK();
        JFrame frame = new JFrame("Триггер Д");
        frame.add(triggerdynamicsjk);
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
