package App;
//filename：App13_7.java        设置文本行、密码文本行和文本区组件
import javax.swing.*; 
public class App13_7 extends JFrame
{
  JTextField jtf=new JTextField("该文本框不可编辑",30);
  static JPasswordField jpf=new JPasswordField ("太空人3号",30);
  public App13_7(String str)
  {
    super(str);
    jtf.setBounds(20,40,140,20);
    jtf.setEditable(false);      //不可编辑
    add(jtf);
  }
  public static void main(String[] args)
  {
    App13_7 frm=new App13_7("文本编辑功能窗口");
    JTextArea jta=new JTextArea ("您好",10,30);
    JScrollPane jsp=new JScrollPane(jta);
    frm.setLocation(200,150);
    frm.setSize(240,220);
    frm.setLayout(null);
    jsp.setBounds(20,70,160,100);
    jpf.setBounds(20,10,140,20);
    frm.add(jpf);
    frm.add(jsp);
    char[] password=jpf.getPassword();
    String str=new String(password);
    System.out.println("今天口令是："+ password +"  转换成文本后是："+str);
    frm.setVisible(true);
    frm.setResizable(false);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
