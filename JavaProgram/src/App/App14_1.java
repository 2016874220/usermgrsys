//filename：App14_1.java           简单的事件处理程序（已加入事件处理代码）

package App;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class App14_1 extends JFrame implements ActionListener
{
  static App14_1 frm=new App14_1();
  static JButton bt=new JButton("设置字体颜色");
  static JTextArea ta =new JTextArea ("字体颜色",5,20);
  public static void main(String[] args)
  {
    bt.addActionListener(frm);
    frm.setTitle("操作事件");
    frm.setLayout(new FlowLayout());
    frm.setSize(260,170);
    frm.add(ta);
    frm.add(bt);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
    ta.setForeground(Color.RED);
  }
}