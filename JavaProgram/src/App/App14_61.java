package App;

//filename：App14_6.java                文本组件的应用
import java.awt.*; 
import javax.swing.*; 
import javax.swing.event.*; 
public class App14_61 extends JFrame implements CaretListener    //定义主类
{
private JTextField jtf=new JTextField(); 
private JTextArea jText=new JTextArea("我现在不可编辑",10,30);
public App14_61()
{
  this.add(jtf,BorderLayout.NORTH);
  this.add(jText,BorderLayout.CENTER);
  jtf.addCaretListener(this);        //设置用户名文本框的监听者为本窗口
  this.setTitle("文档事件的应用");
  this.setResizable(false);               //设置窗口不可改变大小
  this.setBounds(100,100,280,220);
}
public static void main(String[] args)
{
  App14_61 frm=new App14_61();
  frm.setVisible(true);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void caretUpdate(CaretEvent e)
{
  String text=jtf.getText();
  jText.setText(text);
}
}