package App;

//filename:App14_8.java        对话框组件及相应的事件处理
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class App14_8 extends JFrame implements ActionListener
{
JTextField inputName;
JTextArea nameArea;
public App14_8(String s)
{
  super(s);
  inputName=new JTextField(20);
  inputName.addActionListener(this);
  nameArea=new JTextArea();
  add(inputName,BorderLayout.NORTH);
  add(nameArea,BorderLayout.CENTER);
  setBounds(50,50,300,200);
  setVisible(true);
}

//------------------------------------------主函数，程序入口------------------------------------------------

public static void main(String[] args)
{
  App14_8 frm=new App14_8("确认对话框窗口");
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
  String str=inputName.getText();
  
//-----------------showConfirmDialog为静态方法可直接调用产生一个确认对话框，this表明对话框为窗口App13_8所拥有
  int n=JOptionPane.showConfirmDialog(this,"请确认您的输入是否正确","确认对话框",JOptionPane.YES_NO_OPTION);
  
  if(n==JOptionPane.YES_OPTION)
    nameArea.append(str+"\n");
  else if(n==JOptionPane.NO_OPTION) 
    inputName.setText(null); 
}
}
