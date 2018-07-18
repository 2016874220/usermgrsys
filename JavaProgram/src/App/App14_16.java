package App;

//filename：App14_16.java              滑动条组件及相应的事件处理
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class App14_16 extends JFrame implements ChangeListener
{
private JSlider rSlider,gSlider,bSlider;
private JTextArea ta=new JTextArea();
private int r,g,b;
public App14_16(String s)
{
  super(s);
  rSlider=new JSlider(JSlider.VERTICAL,0,255,0);
  rSlider.setMajorTickSpacing(50); 
  rSlider.setMinorTickSpacing(10);
  rSlider.setPaintTicks(true); 
  rSlider.setPaintLabels(true); 
  add(rSlider,BorderLayout.WEST); 
  gSlider=new JSlider(JSlider.HORIZONTAL,0,255,0);
  gSlider.setMajorTickSpacing(50);
  gSlider.setMinorTickSpacing(10);
  gSlider.setPaintTicks(true);
  gSlider.setPaintLabels(true);
  add(gSlider,BorderLayout.SOUTH);
  bSlider=new JSlider(JSlider.VERTICAL,0,255,0);
  bSlider.setMajorTickSpacing(50);
  bSlider.setMinorTickSpacing(10);
  bSlider.setPaintTicks(true);
  bSlider.setPaintLabels(true);
  add(bSlider,BorderLayout.EAST);
  add(ta,BorderLayout.CENTER);
  rSlider.addChangeListener(this);
  gSlider.addChangeListener(this);
  bSlider.addChangeListener(this);
  setSize(350,200);
}
public static void main(String[] args)
{
  App14_16 frm=new App14_16("滑动条应用程序");
  frm.setVisible(true);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void stateChanged(ChangeEvent e)
{
  r=rSlider.getValue();
  g=gSlider.getValue();
  b=bSlider.getValue();
  ta.setBackground(new Color(r,g,b));
  ta.setText("\n\n   现在(红，绿，蓝)三色值是("+r+","+g+","+b+")");
}
}