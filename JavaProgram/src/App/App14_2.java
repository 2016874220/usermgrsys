//filename：App14_2.java         定义内部类充当监听者

package App;
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
public class App14_2
{
static JFrame frm=new JFrame("操作事件");
static JButton bt=new JButton("设置字体颜色");
static JTextArea ta =new JTextArea ("字体颜色",5,20);
public static void main(String[] args)
{
  bt.addActionListener(new MyActLister());
  frm.setLayout(new FlowLayout());
  frm.setSize(260,170);
  frm.add(ta);
  frm.add(bt);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frm.setVisible(true);
}
static class MyActLister implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
    ta.setForeground(Color.red);
  }
}
}

