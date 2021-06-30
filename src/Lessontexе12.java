import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Lessontexе12 extends JComponent{
    private int x = 0;
    private int y = 0;
    private int h;
    private int d;
    private int x1;
    private int font_h,pro;

    public void paint(Graphics g){
        font_h = 18;
        pro =4;
        h = getHeight();
        d = getWidth();
        if(h > 850){
            font_h = 19;
            pro = 10;
        }
        if(h > 950){
            font_h =  20;
            pro = 15;
        }

        if(d > 1100){
            x = (d - 1100)/2;
            // g.drawPolygon(new int[]{(d - 1100)/2,(d - 1100)/2 + 1100,(d - 1100)/2 + 1100,(d - 1100)/2},new int[]{y,y,y + 750,y + 750},4);
        }
        g.setFont(new Font("Bold", Font.BOLD,30));
        g.drawString("Логический элемент «И »",x + 380,y + 40);
        g.setFont(new Font("Bold", Font.BOLD,font_h));
        g.drawString("Логический элемент «И» - конъюнкция, логическое умножение, AND «И» - логический элемент, выполняющий над", x, y + 3*(font_h+pro));
        g.drawString("входными данными операцию конъюнкции или логического умножения. Данный элемент операцию конъюнкции", x, y + 4*(font_h+pro));
        g.drawString("или логического умножения. Данный элемент может иметь от 2 до 8 (наиболее распространены в производстве", x, y +5*(font_h+pro));
        g.drawString("элементы «И» с 2, 3, 4 и 8 входами) входов и один выход.Логическое умножение (конъюнкция), или функция", x, y + 6*(font_h+pro));
        g.drawString("И определяется логическим выражением Y = X1· X2", x, y + 7*(font_h+pro));
        Image image1 = new ImageIcon("..\\image\\logic-and.png").getImage();
        g.drawImage(image1, x ,y + 7*(font_h+pro), this);
        if(pro == 4){
            g.drawString("Условное графическое обозначение схемы И, изображают в виде прямоугольника с символом & (и).", x + 110, y + 9*(font_h+pro));
            g.drawString("На зарубежных схемах обозначение элемента \"И\" имеет другое начертание. Его кратко называют AND.", x + 110, y + 13*(font_h+pro));
        } else if(pro == 10){
            g.drawString("Условное графическое обозначение схемы И, изображают в виде прямоугольника с символом & (и).", x + 110, y + 9*(font_h+9));
            g.drawString("На зарубежных схемах обозначение элемента \"И\" имеет другое начертание. Его кратко называют AND.", x + 110, y + 13*(font_h+7));
        } else if(pro == 15){
            g.drawString("Условное графическое обозначение схемы И, изображают в виде прямоугольника с символом & (и).", x + 110, y + 9*(font_h+12));
            g.drawString("На зарубежных схемах обозначение элемента \"И\" имеет другое начертание. Его кратко называют AND.", x + 110, y + 13*(font_h+9));
        }
        Image image2 = new ImageIcon("..\\image\\table-And.png").getImage();
        g.drawImage(image2, x + 350 ,y + 14*(font_h+pro), this);

        g.drawString("", x, y + 9*(font_h+pro));
        g.drawString("", x, y + 10*(font_h+pro));
        g.drawString("", x, y + 11*(font_h+pro));
        g.drawString("", x, y + 12*(font_h+pro));
        g.drawString("", x, y + 13*(font_h+pro));
        g.drawString("", x + 10, y + 14*(font_h+pro));
    }

    /*

    private int x = 10;
        private int y = 120;
        private int h;
        private int d;

    public void paint(Graphics g){
        h = getHeight();
        d = getWidth();
        if(d > 920)
            x = (d - 920)/2;
        g.setFont(new Font("Bold", Font.BOLD, 24));
        g.drawString("Логический элемент «И»",x + 250,y - 90);
        g.drawString("",x,y - 60);
        g.drawString("Логический элемент «И» - конъюнкция, логическое умножение, AND",x,y - 30);
        g.drawString("«И» - логический элемент, выполняющий над входными данными",x,y);
        g.drawString("операцию конъюнкции или логического умножения. Данный элемент",x,y + 30);
        g.drawString("может иметь от 2 до 8 (наиболее распространены в производстве",x,y + 60);
        g.drawString("элементы «И» с 2, 3, 4 и 8 входами) входов и один выход.",x,y + 90);

    }
*/
    public static void main(String[] args) {
        Lessontexе12 lessontexе12 = new Lessontexе12();
        JFrame frame = new JFrame("");
        frame.add(lessontexе12);
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

