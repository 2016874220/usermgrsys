package App;

//App16_3.java          在小程序里显示图像
import java.awt.*; 
import javax.swing.JApplet;
public class App16_3 extends JApplet
{
Image img;
public void init()
{
  img=getImage(getCodeBase(),"黄山.jpg");
}
public void paint(Graphics g)
{
  g.drawString("黄山风景",50,15);
  g.drawImage(img,30,30,200,150,this);
  play(getDocumentBase(),"ニ泉吟.mid");
}
}