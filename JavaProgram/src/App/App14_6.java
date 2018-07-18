package App;

//filename：App14_6.java                文本组件的应用
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 
public class App14_6 extends JFrame implements ActionListener
{
private JLabel[] jlArray={new JLabel("用户名"),new JLabel("密   码")};
// private JButton[] jbArray={new JButton("登录"),new JButton("清空")};
private JTextField jName=new JTextField();
private JPasswordField jPassword=new JPasswordField();
private JTextArea jText=new JTextArea("我现在不可编辑",10,30);
private JScrollPane jsp=new JScrollPane(jText);
public App14_6()
{
  this.setLayout(null);
  jlArray[0].setBounds(20,10,50,25);
  jName.setBounds(70,10,170,25);
  jlArray[1].setBounds(20,30,50,25);
  jPassword.setBounds(70,35,170,25);
  jsp.setBounds(20,70,220,100);
  jText.setEnabled(false);
  jText.setDisabledTextColor(Color.RED);
  this.add(jsp);
  this.add(jlArray[0]);
  this.add(jlArray[1]);
  this.add(jName);
  this.add(jPassword);
  jName.addActionListener(this);
  jPassword.addActionListener(this);
  this.setTitle("文本组件的应用");
  this.setResizable(false);
  this.setBounds(100,100,280,220);
}
public void actionPerformed(ActionEvent e)
{
   if(jName.getText().equals("abc") && String.valueOf(jPassword.getPassword()).equals("123"))
   {
      jText.setEnabled(true);
      jText.setText("恭喜你!!\n哈哈，我现在可以被编辑了!!");
      jText.setLineWrap(true);
   }
}
public static void main(String[] args)
{
  App14_6 frm=new App14_6();
  frm.setVisible(true);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}