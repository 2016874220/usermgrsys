package App;

//filename：App13_9.java        FlowLayout类的使用 
import java.awt.*; 
import javax.swing.*;
public class App13_9 extends JFrame
{
static JFrame frm=new JFrame("流式布局设置管理器FlowLayout");
public static void main(String[] args)
{
  FlowLayout flow=new FlowLayout (FlowLayout.CENTER,5,10);
  JButton but=new JButton("按钮");
  JLabel lab=new JLabel("我是一个标签");
  frm.setLayout(flow);
  frm.setSize(260,150);
  frm.add(but);
  frm.add(lab);
  frm.add(new JTextField("流式布局策略FlowLayout",18));
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frm.setVisible(true);
}
}
