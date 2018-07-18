package App;
//filename：App13_5.java          设置命令按钮
import javax.swing.*; 
public class App13_5 extends JFrame
{
  public static void main(String[] args)
  {
    App13_5 jfrm=new App13_5();
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon ic=new ImageIcon("中国灯笼.jpg");
    JButton btn=new JButton("灯笼",ic);
    jfrm.setLayout(null);
    jfrm.setSize(200,180);
    jfrm.setTitle("按钮类窗口");
    btn.setBounds(50,45,100,40); 
    btn.setToolTipText("我是按钮");
    jfrm.add(btn); 
    jfrm.setVisible(true);
  }
}
