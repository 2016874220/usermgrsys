package App;

//filename：App14_4.java        命令按钮功能的实现
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
public class App14_4 extends JFrame implements ActionListener
{
static App14_4 frm=new App14_4();
static JPanel pan1=new JPanel();
static JPanel pan2=new JPanel();
static JButton but1= new JButton("第一页");    //JToggleButton：两次点击按钮，按钮方可恢复原状
static JButton but2= new JButton("上一页");
static JButton but3= new JButton("下一页");
static JButton but4= new JButton("最后页");
static CardLayout crd=new CardLayout (5,10);
public static void main(String[] args)
{
  frm.setLayout(null);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frm.setTitle("操作事件");
  pan2.setLayout(new GridLayout(1,4)); 
  pan1.setLayout(crd);
  frm.setSize(350,300);
  frm.setResizable(false);
  but1.addActionListener(frm);
  but2.addActionListener(frm);
  but3.addActionListener(frm);
  but4.addActionListener(frm);
  pan1.setBounds(10,10,320,200);
  pan2.setBounds(10,220,320, 25);
  frm.add(pan1); 
  frm.add(pan2) ;
  JLabel lab1=new JLabel("第一页", JLabel.CENTER);
  JLabel lab2=new JLabel("第二页", JLabel.CENTER);
  JTextField tex=new JTextField("卡片式布局策略CardLayout",18);
  pan1.add(lab1, "n1");
  pan1.add(lab2, "n2");
  pan1.add(tex, "n3");
  crd.show(pan1, "n3");
  pan2.add(but1);
  pan2.add(but2);
  pan2.add(but3);
  pan2.add(but4);
  frm.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
  JButton but=(JButton)e.getSource();    //通过事件e来获取事件源
  if(but==but1) crd.first(pan1);
  else if(but==but2) crd.previous(pan1);
  else if(but==but3) crd.next(pan1);
  else crd.last(pan1);
}
}