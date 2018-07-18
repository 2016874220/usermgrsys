package App;
import javax.swing.*;
public class App13_8 extends JFrame
{
  JTabbedPane jtab=new JTabbedPane(JTabbedPane.TOP);
  public App13_8()
  {
    JLabel[] lab=new JLabel[6];
    Icon pic;
    String title;
    for(int i=1;i<=5;i++)
    {
      pic=new ImageIcon("t"+i+".jpg");
      lab[i]=new JLabel();
      lab[i].setIcon(pic);
      title="第"+i+"页";
      jtab.add(title,lab[i]);
    }
    this.add(jtab);
  }
  public static void main(String[] args)
  {
    App13_8 frm=new App13_8();    
    frm.setTitle("选项卡的应用");
    frm.setSize(300,300);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setVisible(true);
  }
}

