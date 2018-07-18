package App;

//filename：App14_11.java         列表框控件的应用
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class App14_11 extends JFrame implements ListSelectionListener
{
private JList<String> list;            //声明列表框对象list
private JTextField tf=new JTextField("我是文本框");
private String[] color={"红色","绿色","蓝色","黄色"};
public App14_11(String s)
{
  super(s);
  list=new JList<String>(color);         //创建并用数组初始化列表框
  JScrollPane ps=new JScrollPane(list);   //创建滚动窗格对象，其显示内容是列表框对象list
  list.addListSelectionListener(this);      //设置列表框的监听者为本窗口
  add(ps,BorderLayout.CENTER);       //将列表框放在下方
  add(tf,BorderLayout.NORTH);        //将文本区放在上方
  setSize(200,130);
  setVisible(true);
}
public static void main(String[] args)
{
  App14_11 frm=new App14_11("列表框应用");
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void valueChanged(ListSelectionEvent e)  //事件处理程序代码
{
  JList lt=(JList)e.getSource();               //获取事件源
  String clr=(String)lt.getSelectedValue();      //取得被选中选项的名称
  if(clr=="红色")
    tf.setBackground(Color.RED);
  else if(clr=="绿色")
    tf.setBackground(Color.GREEN);
  else if(clr=="蓝色")
    tf.setBackground(Color.BLUE);
  else if(clr=="黄色")
    tf.setBackground(Color.YELLOW);
}
}