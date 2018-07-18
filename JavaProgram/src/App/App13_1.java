package App;
//filename：App13_1.java
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
public class App13_1
{
  static JFrame jfrm=new JFrame("这是个Swing程序");
  public static void main(String[] args)
  {
    JLabel lab=new JLabel("我是一个标签"); 
    Image im=
    		(new ImageIcon("src\\chap13\\中国心.jpg")).getImage();
    jfrm.setIconImage(im);
    jfrm.setSize(250,140);
    jfrm.setBackground(Color.YELLOW);     //设置的是顶层窗口，颜色被盖，无法显示。可设置内容窗口的颜色，如下行代码。
    jfrm.getContentPane().setBackground(Color.green);
    jfrm.setLocation(260,150);
    jfrm.add(lab); 
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setVisible(true);
  }
}
