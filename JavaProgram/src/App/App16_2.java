package App;

//App16_2.java          小程序接收HTML文件传递进来的参数
import java.awt.*; 
import javax.swing.JApplet;
public class App16_2 extends JApplet
{
private String v_name;
private int v_age;
public void init()
{
  v_name=getParameter("vname");
  v_age=Integer.parseInt(getParameter("age"));
}
public void paint(Graphics g)
{
  g.drawString("姓名："+ v_name+" ；年龄："+ v_age,10,20);
  System.out.println("计算机系");
}
}