package Text;

import java.awt.*;
import javax.swing.*;

public class Text12 extends JPanel
{
    public Text12() 
    {
        this.setPreferredSize(new Dimension(600,580));
    }

    public void draw(Graphics2D g)
    {
        Color color1 = Color.WHITE;
        Color color2 = Color.BLACK;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(240, 240, 240));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(color1);
        g.fillArc(100, 100, 400, 400, 90, 180);

        g.setColor(color2);
        g.fillArc(100, 100, 400, 400, -90, 180);

        g.setColor(color2);
        g.fillOval(200, 100, 200, 200);

        g.setColor(color1);
        g.fillOval(200, 300, 200, 200);

        g.setColor(color1);
        g.fillOval(270, 170, 60, 60);

        g.setColor(color2);
        g.fillOval(270, 370, 60, 60);

        g.setStroke(new BasicStroke(2));
        g.setColor(color2);

        g.drawOval(100, 100, 400, 400);
    }

    public void paint(Graphics g1) {
        draw((Graphics2D) g1);
    }

    public static void main(String[] args) {
        JFrame taiji = new JFrame("Ì«¼«Í¼");
        taiji.add(new Text12());
        taiji.setSize(620, 635);
        taiji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        taiji.setVisible(true);
    }
}