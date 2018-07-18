package App;

//filename£ºApp16_6
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class App16_6 extends JApplet
{
JLabel label=new JLabel(new ImageIcon("d0.gif"));
JButton bPlay=new JButton("²¥·Å");
JButton bStop=new JButton("Í£Ö¹");
Timer timer=new Timer(50,new ActionLis());
ImageIcon[] img=new ImageIcon[10];
int num=0;
public void init()
{
  JPanel p1=new JPanel();
  JPanel p2=new JPanel();
  add(p1,BorderLayout.CENTER);
  add(p2,BorderLayout.SOUTH);
  p1.add(label);
  p2.add(bPlay);
  p2.add(bStop);
  bPlay.addActionListener(new ActionLis());
  bStop.addActionListener(new ActionLis());
  for(int i=0;i<=9;i++)
  {
    img[i]=new ImageIcon("d"+num+".gif");
    num++;
  }
}
class ActionLis implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
    if(e.getSource()==bPlay)
      timer.start();
    else if(e.getSource()==bStop)
      timer.stop();
    else if(e.getSource()==timer)
    {
      num=num==10 ? 0 : num;
      label.setIcon(img[num]);
      num++;
    }
  }
}
}