package App;

//filename：App16_4.java          在小程序里播放音频
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
public class App16_4 extends JApplet implements ItemListener
{
AudioClip[] midi=new AudioClip[3];   //定义AudioClip接口类型的数组
AudioClip song;                    //目前选取的音频
JComboBox<String> coi;                    //创建下拉列表对象
JButton bntLoop=new JButton("循环");
JButton bntStop=new JButton("停止");
public void init()
{
 String num;
 String[] musical={"天路","上海滩","爱你多年"};
 coi=new JComboBox<String>(musical);
 for(int i=0;i<midi.length;i++)
 {
   num=String.valueOf(i+1);
   midi[i]=getAudioClip(getCodeBase(),num+".mid");   //取得音频来源
 }
 Container c=getContentPane();                     //获取内容窗格
 c.setLayout(new FlowLayout(FlowLayout.LEFT));
 c.add(coi);   
 c.add(bntLoop);
 c.add(bntStop);
 coi.addItemListener(this);   //将小程序本身设置为coi的监听者
 bntLoop.addActionListener(new MyActLit());  //设置监听者
 bntStop.addActionListener(new MyActLit());  
 song=midi[0];     //设置启动小程序时播放的音频
 song.play();      //播放音频
}
public void itemStateChanged(ItemEvent e)
{
 song.stop();                   //停止正在播放的音频
 int i=coi.getSelectedIndex();      //在下拉列表中选择播放音频的序号
 song=midi[i];                  //设置待播放的音频
 song.play();                   //播放音频
}
class MyActLit implements ActionListener  //定义内部类
{
  public void actionPerformed(ActionEvent e)  //处理按钮事件的程序代码
  {
     JButton bnt=(JButton) e.getSource();     //取得被选中的按钮
     if(bnt==bntLoop) song.loop();          //若选择“循环”按钮，则循环播放
     else song.stop();                     //若选择“停止”按钮，则停止播放
 }
}
}