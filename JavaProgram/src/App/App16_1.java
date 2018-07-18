package App;

//filename：App16_1.java           小程序的应用
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.JApplet;
public class App16_1 extends JApplet implements ActionListener
{
private JTextField name;              //用户名文本框
private JPasswordField password;       //口令文本框
private JComboBox<String> mailBox;          //邮箱组合框
private JButton login;                //登录按钮
public void init()                    //初始化方法
{
	Container c=getContentPane();       //获取内容窗格
	c.setBackground(Color.WHITE);     //设置内容窗格的背景为白色
	c.setLayout(new FlowLayout(FlowLayout.LEFT));
	c.add(new JLabel("邮箱"));
	name=new JTextField("用户名",10);
  name.addActionListener(this);      //设置小程序本身为文本框的监听者
  c.add(name);
  c.add(new JLabel("@"));
  String[] box={"tom.com","263.net"};
  mailBox=new JComboBox<String>(box);
  c.add(mailBox);
  c.add(new JLabel("密码"));
  password=new JPasswordField("*",10);
  c.add(password);
  login=new JButton("登录");
  c.add(login);
  login.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==login||e.getSource()==password)
  {}   //用户可以自己根据需要添加代码
}
}