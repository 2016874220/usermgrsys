package App;

//filename：App14_10.java          鼠标事件的处理
import javax.swing.*;
import java.awt.event.*; 
public class App14_10 extends JFrame
{
static JTextField tf=new JTextField(20);
static JButton bun=new JButton("拖动我");
static int px,py,ox,oy,offx,offy,x,y;
public static void main(String[] args)
{
  App14_10 frm=new App14_10();
  frm.setLayout(null);
  frm.setTitle("鼠标事件的处理");
  frm.setBounds(10,10,330,260);
  tf.setBounds(60,200,200,20);
  bun.setBounds(60,50,80,25);
  tf.setEditable(false);
  frm.add(tf);
  frm.add(bun);
  bun.addMouseMotionListener(new MyMouseMotionList ());
  bun.addMouseListener(new MyMouseList());
  frm.setVisible(true);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
static class MyMouseList extends MouseAdapter
{
  public void mousePressed(MouseEvent e)
  {
    px=e.getX();
    py=e.getY();
    ox=bun.getLocation().x;
    oy=bun.getLocation().y;
  }
}
static class MyMouseMotionList extends MouseMotionAdapter
{
  public void mouseDragged(MouseEvent e)
  {
    offx=e.getX()-px;
    offy=e.getY()-py;
    x=ox+offx;
    y=oy+offy;
    String position="命令按钮放置在（"+ x+","+y+"）的位置";
    tf.setText(position);
    bun.setLocation(x,y);
    ox=x;
    oy=y;
  }
}
}