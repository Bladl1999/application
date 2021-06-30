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

public class TriggerRS_And_Not extends JComponent implements Runnable{
    private int h;  // Высота логического элемента
    private int w;  // длина логического элемента
    private int x;  // координата х для размещение
    private int y;  // координата у для размещение
    private int height; //Высота шрифта
    private int width; // оступ по длинне буквы
    private int radius;
    private int h1;
    private int r;
    private int s;
    private int q1;
    private int q2;
    private Thread thread;

    public void paint(Graphics g)
    {

        h = 50;
        w = 50;
        x = 50;
        y = 10;
        height = 20;
        width = height * 3 / 4;
        radius = 10;
        //Задаем шрифт
        g.setFont(new Font("Dialog",1, height));

        //Верхний логический элемент и
        g.drawRect(x, y, w,h * 2);
        g.drawString("&",x + w - width, y + height);

        //Верхний логический элемент не
        g.drawRect(x + w + 20,y + h / 2,w , h);
        g.drawString("1",x + 2 * w + 20 - width, y + h - radius/2);
        g.drawOval(x + 2 * w + 20 - radius / 2,y + h - radius/2,radius,radius);

        //Нижний логичесикий элемент и
        g.drawRect(x , y + h*3, w,h * 2);
        g.drawString("&",x + w - width, y + h*3 +  height);

        //Нижний логический элемент не
        g.drawRect(x + w + 20,y + h / 2 + h * 3,w , h);
        g.drawString("1",x + 2 * w + 20 - width, y + h - radius/2 + h * 3);
        g.drawOval(x + 2 * w + 20 - radius / 2,y + h - radius/2 + h * 3,radius,radius);

        // Верхний лог элемент вход к логическому элементу
        if(s == 0)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.RED);
        g.drawLine(x - 40,y + 20,x,y + 20);
        g.drawString("" + s,x - 40, y + 20);

        //Нижний лог элемент  вход к логическому элементу
        if(r == 0)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.RED);
        g.drawLine(x - 40, y + 5 * h - 20, x,y + 5 * h - 20);
        g.drawString("" + r,x - 40, y + 5 * h - 20);

        //соеденение между верхними элементами
        if(s == 1 && q2 == 1)
            g.setColor(Color.RED);
        else
            g.setColor(Color.BLACK);
        g.drawLine(x +  w , y + h - radius/2 , x + w + 20,y + h - radius/2);

        //соединение между нижними
        if(r == 1 && q1 == 1)
            g.setColor(Color.RED);
        else
            g.setColor(Color.BLACK);
        g.drawLine(x +  w , y + 4 * h - radius/2 , x + w + 20,y + 4 * h - radius/2);

        //соединение с верху в низ
        if(q1 == 0)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.RED);
        g.drawLine(x + 2 * w + 20 + radius/2,y + h ,x + 2 * w + 70 + radius,y + h);
        g.drawString(q1 + "",x + 2 * w + 30 + radius/2, y + h);
        g.drawLine(x + 2 * w + 30 + radius/2,y + h,x + 2 * w + 30 + radius/2, y + 2 * h + 10);
        g.drawLine(x + 2 * w + 30 + radius/2,y + 2 * h + 10,x - 20, y + 3 * h );
        g.drawLine(x - 20,y + 3 * h,x - 20, y + 3 * h + 20 );
        g.drawLine(x - 20,y + 3 * h + 20,x, y + 3 * h + 20 );

        //соединение с низу в верх
        if(q2 == 0)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.RED);
        g.drawLine(x + 2 * w + 20 + radius/2,y + 4 * h  ,x + 2 * w + 70 + radius,y + 4 * h);
        g.drawString(q2 + "",x + 2 * w + 30 + radius/2, y + 4 * h);
        g.drawLine(x + 2 * w + 30 + radius/2,y + 4 * h ,x + 2 * w + 30 + radius/2, y + 3 * h - 10 );
        g.drawLine(x + 2 * w + 30 + radius/2,y + 3 * h - 10,x - 20, y + 2 * h );
        g.drawLine(x - 20,y + 2 * h,x - 20, y + 2 * h - 20 );
        g.drawLine(x - 20,y + 2 * h - 20,x, y + 2 * h - 20);
    /*
    private int h;  // Высота логического элемента
    private int w;  // длина логического элемента
    private int x;  // координата х для размещение
    private int y;  // координата у для размещение
    private int h1;
    private int r = 1;
    private int s = 1;
    private int q1;
    private int q2;
    private Thread thread;

    public void paint(Graphics g)
    {
        // Отрисовываем логического элемента

        Color newColor = new Color(255, 255, 255);
        g.setColor(newColor);
        w = 50;
        h = 100;
        x = 60;
        y = 10;
        h1 = 200;
        g.fillRect(x, y - 10, w, h);                 // Внутриняя часть логического элемента
        newColor = new Color(0, 0, 0);
        g.setColor(newColor);                   // Внешняя часть логического элемента
        g.drawRect(x, y - 10, w, h);                 // Внешняя часть логического элемента и его входов и выдохов
        g.drawOval(x + w -  5, y + h/2 - 15, 10, 10);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Dialog",1, 20));
        g.drawString("&", x + w - 15, y + 15);
        g.setFont(new Font("Dialog",1, 20));
        //Второй лог элемент
        newColor = new Color(255, 255, 255);
        g.setColor(newColor);
        g.fillRect(x, h1 - 60, w, h);                 // Внутриняя часть логического элемента
        newColor = new Color(0, 0, 0);
        g.setColor(newColor);                   // Внешняя часть логического элемента
        g.drawOval(x + w -  5, h1 + h/2 - 65, 10, 10);
        g.drawRect(x, h1 - 60, w, h);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Dialog",1, 20));
        g.drawString("&", x + w - 15, h1 - 35);
        g.setFont(new Font("Dialog",1, 20));

        if(getS() == 1)
            g.setColor(Color.RED);
        else
            g.setColor(Color.BLACK);
        g.drawLine(x - 50, y + 15, x, y + 15);
        g.drawString("" + getS(), x - 50, y + 15);

        if(getR() == 1)
            g.setColor(Color.RED);
        else
            g.setColor(Color.BLACK);
        g.drawLine(x - 50, h1 + 15, x, h1 + 15);
        g.drawString("" + getR(), x - 50, h1 + 15);

        if(getQ1() == 1)
            g.setColor(Color.RED);
        else
            g.setColor(Color.BLACK);
        g.drawString("" + getQ1(), x + w + 50, y + 40);
        g.drawLine(x + w, y + 40, x + w + 50 + 100, y + 40);
        g.drawLine(x + w + 50, y + 40, x + w + 50, y + 90);
        g.drawLine(x + w + 50, y + 90, x - 50, y + 130);
        g.drawLine(x - 50, y + 130, x - 50, h1 - 35);
        g.drawLine(x - 50, h1  - 35, x, h1 - 35);

        if(getQ2() == 1)
            g.setColor(Color.RED);
        else
            g.setColor(Color.BLACK);
        g.drawString("" + getQ2(), x + w + 50, h1 - 10);
        g.drawLine(x + w, h1 - 10, x + w + 50 + 100, h1 - 10);
        g.drawLine(x + w + 50, h1 - 10, x + w + 50, h1 - 85);
        g.drawLine(x + w + 50, h1 - 85, x - 50, h1 - 95);
        g.drawLine(x - 50, h1 - 95, x - 50, y + 65);
        g.drawLine(x - 50, y + 65, x, y + 65);
         */
    }

    public int getR() {
        return r;
    }

    public int getS() {
        return s;
    }

    public int getQ1() {
        return q1;
    }

    public int getQ2() {
        return q2;
    }



    public void setS() {
        if((s == 0) && (r == 0)){
            thread =  null;
            System.out.println("поток закончен");
        }
        if(s == 0){
            s = 1;
            if(r == 0){
                q1 = 0;
                q2 = 1;
            }
        } else
        {
            s = 0;
            if( r == 1){
                q1 = 1;
                q2 = 0;
            } else
            {
                System.out.println("момент 0 0");
                thread =  new Thread(this);
                thread.start();
            }
        }
        repaint();
    }

    public void setR() {
        if((s == 0) && (r == 0)){
            thread =  null;
            System.out.println("поток закончен");
        }
        if(r == 0){
            r = 1;
            if(s == 0){
                q1 = 1;
                q2 = 0;
            }
        } else
        {
            r = 0;
            if(s == 0){
                System.out.println("момент 0 0");
                thread =  new Thread(this);
                thread.start();
            } else
            {
                q1 = 0;
                q2 = 1;
            }
        }
        repaint();
    }

    public void run(){
        for(int i = 0; i < i + 1;i++){
            System.out.println("Поток запушен");
            if(q1 == 1){
                q1 = 0;
                q2 = 1;
            } else
            {
                q1 = 1;
                q2 = 0;
            }
            repaint();
            try {
                thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Произошла ошабка в ран");
            }
            if((r != 0) || (s != 0))
                break;
        }
    }

    public static void main(String[] args) {
        TriggerRS_And_Not ili = new TriggerRS_And_Not();
        Frame frame = new Frame("RS триггер");
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
