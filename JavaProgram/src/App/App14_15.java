package App;

//filename：App14_15.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class App14_15 extends JFrame implements ActionListener
{
private JToolBar toolBar=new JToolBar("浮动工具栏");
private JButton button1=new JButton();
private JButton button2=new JButton();
private JButton button3=new JButton();
private JTextArea ta=new JTextArea("我现在是禁用状态",10,30);
private ImageIcon image1,image2,image3;
public App14_15(String strTitle)
{
  super(strTitle);
  image1=new ImageIcon("openFile.jpg");
  image2=new ImageIcon("saveFile.jpg");
  image3=new ImageIcon("helpFile.jpg");
  button1.setIcon(image1);
  button2.setIcon(image2);
  button3.setIcon(image3);
  button1.setToolTipText("打开");
  button2.setToolTipText("保存");
  button3.setToolTipText("帮助");
  button1.addActionListener(this);
  toolBar.add(button1);
  toolBar.add(button2);
  toolBar.add(button3);
  add(toolBar,BorderLayout.NORTH);
  add(ta,BorderLayout.CENTER);
  ta.setEnabled(false);
  ta.setDisabledTextColor(Color.RED);
  setSize(260,160);
  setVisible(true);
}
public static void main(String[] args)
{
  App14_15 frm=new App14_15("工具栏应用程序");
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
	JButton jbt=(JButton)e.getSource();
  if(jbt==button1)
    ta.setEnabled(true); 
    ta.setText("恭喜你!!\n哈哈，你现在可以编辑我了!!");
}  	
}
