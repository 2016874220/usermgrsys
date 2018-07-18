package App;
//filename：App13_3.java       在窗口中加入标签对象，并设置标签对象的大小
import java.awt.*; 
import javax.swing.*;
public class App13_3
{
  public static void main(String[] args)
  {
    JFrame jfrm=new JFrame("标签类窗口");
    JLabel jlab=new JLabel("我是一个标签",JLabel.CENTER);  //center
    jfrm.setLayout(null);        //取消布局管理器
    jfrm.setSize(300,200);
    jfrm.setBackground(Color.PINK);
    jlab.setOpaque(true);
    jlab.setBackground(Color.YELLOW);
    jlab.setForeground(Color.RED);
    jlab.setLocation(80,60); 
    jlab.setSize(130,30); 
    Font fnt=new Font("Serief",Font.BOLD+Font.ITALIC,20);
    jlab.setFont(fnt);
    jfrm.add(jlab); 
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setVisible(true);
  }
}
