package App;

//App15_4.java            ”√ Û±ÍÕœ∂Ø¿¥ªÊª≠Õ÷‘≤
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class App15_4 extends JFrame implements MouseMotionListener, MouseListener
{
static App15_4 frm=new App15_4();
int px1,py1,px2,py2,status=0;
int rpx1,rpy1,rpx2,rpy2;
public static void main(String[] args)
{
  frm.setTitle(" Û±ÍÕœ∂Øª≠Õ÷‘≤");
  frm.setSize(250,230);
  frm.addMouseMotionListener(frm);
  frm.addMouseListener(frm);
  frm.setVisible(true);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void mouseMoved(MouseEvent e)
{
  px1=e.getX();
  py1=e.getY();
  status=0;
}
public void mouseDragged(MouseEvent e)
{
  Graphics g=this.getGraphics();
  g.setColor(Color.YELLOW);
  g.setXORMode(Color.BLACK);
  if (status==1)
    g.drawOval (px1,py1,px2,py2);
  else {
    px1=e.getX();
    py1=e.getY();
    status=1;
  }
  px2=Math.abs(e.getX()-px1);
  py2= Math.abs(e.getY()-py1);
  g.drawOval (px1,py1,px2,py2);
  rpx1=px1;rpy1=py1;rpx2=px2;rpy2=py2;
}
public void mouseReleased(MouseEvent e)
{
  Graphics g=this.getGraphics();
  g.setColor(Color.RED);
  g.drawOval (rpx1,rpy1,rpx2,rpy2);
}
public void mousePressed(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseClicked(MouseEvent e) {}
}
