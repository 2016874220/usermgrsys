package App;

//filename：App14_12.java         组合框的应用
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class App14_12 extends JFrame
{
static App14_12 frm=new App14_12();
static JComboBox<String> combo;                    //声明组合框对象combo
static JTextArea ta=new JTextArea(5,15);
static String[] color={"红色","绿色","蓝色","黄色"};
public static void main(String[] args)
{
  frm.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
  combo=new JComboBox<String>(color);
  combo.setEditable(true);                         //设置组合框可编辑
  combo.addItemListener(new MyItemListener());      //为组合框注册鼠标单击监听者
  combo.addActionListener(new MyActionListener());  //为组合框注册按Enter键监听者
  frm.add(combo);
  frm.add(ta);
  frm.setSize(350,180);
  frm.setVisible(true);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
static class MyItemListener implements ItemListener
{
  public void itemStateChanged(ItemEvent e)       //处理单击事件的程序代码
  {
    JComboBox cb=(JComboBox)e.getSource();    //获取事件源
    String clr=(String)cb.getSelectedItem();        //取得被选中选项的名称
    if(clr.equals("红色"))
      ta.setBackground(Color.RED);
    else if(clr.equals("绿色"))
      ta.setBackground(Color.GREEN);
    else if(clr.equals("蓝色"))
      ta.setBackground(Color.BLUE);
    else if(clr.equals("黄色"))
      ta.setBackground(Color.YELLOW);
    frm.setTitle("您选择了【"+clr+"】");
    ta.setText("您选择的是："+clr+"\n");         //将选中的选项名称添加到文本区中
  }
}
static class MyActionListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)      //在显示栏中按Enter键时的处理操作
  {
    JComboBox cb=(JComboBox)e.getSource();    //获取事件源
    String s=(String)cb.getSelectedItem();         //取得在显示文本栏所输入的内容
    ta.setText(s+"\n");         //将用户在显示栏中输入的内容添加到文本区ta中
  }
}
}