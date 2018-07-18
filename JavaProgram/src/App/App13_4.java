package App;
//filename：App13_4.java
import java.awt.*; 
import javax.swing.*;
public class App13_4
{
  public static void main(String[] args)
  {
    JFrame jfrm=new JFrame("标签类窗口");
    JLabel jlab=new JLabel("我是一个标签",JLabel.CENTER);
    jfrm.setLayout(null);
    jfrm.setSize(300,200); 
    jfrm.setBackground(Color.PINK);
    Container c=jfrm.getContentPane();
    c.setBackground(Color.PINK); 
    jlab.setOpaque(true); 
    jlab.setBackground(Color.YELLOW); 
    jlab.setForeground(Color.RED); 
    jlab.setLocation(80,60); 
    jlab.setSize(130,30); 
    jlab. setToolTipText("我被设置为不透明状态");
    Font fnt=new Font("Serief",Font.BOLD+Font.ITALIC,20);
    jlab.setFont(fnt); 
    jfrm.add(jlab); 
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setVisible(true);
  }
}
