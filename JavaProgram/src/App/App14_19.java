package App;

//filename：App14_19.java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class App14_19 extends JFrame
{
static Timer timer;
static JLabel lab=new JLabel("我是滚动字幕");
static JButton bt1=new JButton("开始");
static JButton bt2=new JButton("停止");
static int moveX,moveY;
static App14_19 frm=null;
public static void main(String[] args)
{
  frm=new App14_19();
  timer=new Timer(50,new TimerListener(2));
  frm.setLayout(null);
  frm.setSize(300,200);
  frm.add(lab);
  frm.add(bt1);
  frm.add(bt2);
  Font font=new Font("楷体",Font.ITALIC|Font.BOLD,20);
  lab.setFont(font);
  lab.setBounds(100,100,150,30);
  bt1.setBounds(50,50,80,30);
  bt2.setBounds(150,50,80,30);
  bt1.addActionListener(new TimerListener(0));
  bt2.addActionListener(new TimerListener(1));
  moveX=lab.getLocation().x;
  moveY=lab.getLocation().y;
  frm.setTitle("定时器应用程序");
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frm.setVisible(true);
}
private static class TimerListener implements ActionListener
{
  int select;
  public TimerListener(int select)
  {
    this.select=select;
  }
  public void actionPerformed(ActionEvent e)
  {
    if(select==0) timer.start();
    else if(select==1) timer.stop();
    else if(select==2)
    {
      if(moveX>-lab.getWidth()) moveX-=3;
      else moveX=frm.getWidth();
      lab.setLocation(moveX,moveY);
    }
  }
}
}