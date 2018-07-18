package App;

//filename：App13_10.java        BorderLayout类的使用 
import java.awt.*; 
import javax.swing.*;
public class App13_10 extends JFrame
{
static JFrame frm=new JFrame("边界式布局管理器BorderLayout");
public static void main(String[] args)
{
  BorderLayout border=new BorderLayout (5,10);
  frm.setLayout(border);
  frm.setSize(330,200);
  frm.add(new JButton("上北"), BorderLayout.NORTH);
  frm.add(new JButton("下南"), BorderLayout.SOUTH);
  frm.add(new JButton("左西"), BorderLayout.WEST);
  frm.add(new JButton("右东"), BorderLayout.EAST);
  frm.add(new JButton("中央"), BorderLayout.CENTER);
  
  frm.add(new JButton("lalala"));   //覆盖上一个中央按钮
  
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frm.setVisible(true);
}
}
