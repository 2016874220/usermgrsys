package checkout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TaiChi extends JPanel 
{

    public TaiChi() 
    {
        this.setPreferredSize(new Dimension(600,580)); // 设置首选大小600,580
    }

    public void drawBaGua(Graphics2D g2d)
    {
        Color color1 = Color.WHITE; // 颜色1
        Color color2 = Color.BLACK; // 颜色2

        // 抗边缘锯齿
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // 画背景
        // g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(new Color(240, 240, 240));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        // 画左半边大圆白背景
        //g2d.setColor(color1);
        //g2d.fillArc(100, 100, 400, 400, 90, 180);
        // 画右半边大圆黑背景
//        g2d.setColor(color2);
//        g2d.fillArc(100, 100, 400, 400, -90, 180);

        // 画上面白色圆
        g2d.setColor(color1);
        g2d.fillOval(200, 100, 200, 200);
        // 画下面黑色圆
        g2d.setColor(color2);
        g2d.fillOval(200, 300, 200, 200);

        // 画上面白色圆内的小黑圆
        g2d.setColor(color2);
        g2d.fillOval(270, 170, 60, 60);
        // 画下面黑色圆内的小白圆
        g2d.setColor(color1);
        g2d.fillOval(270, 370, 60, 60);

        // 画边缘的黑弧线
        g2d.setStroke(new BasicStroke(2)); // 设置画笔宽度
        g2d.setColor(color2);
        // g2d.drawArc(100, 100, 400, 400, 0, 360);
        g2d.drawOval(100, 100, 400, 400);
    }

    public void paint(Graphics g) {
        drawBaGua((Graphics2D) g);
    }

    public static void main(String[] args) {
        JFrame win = new JFrame("八卦");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add(new TaiChi());
        win.pack();
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}