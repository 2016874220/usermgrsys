package App;

//filename：App13_11.java          GridLayout类的使用 
import java.awt.*; 
import javax.swing.*;
public class App13_11 extends JFrame
{
static JPanel pan=new JPanel();
static JTextField tf=new JTextField("0. ");
static JButton[] b=new JButton[10] ;
static JButton bp,ba,bs,bm,bd,be;
public static void main(String[] args)
{
  App13_11 frm=new App13_11();
  for(int i=0;i<=9;i++)
    b[i] =new JButton(""+i); 
  bp=new JButton("."); ba=new JButton("+");bs=new JButton("-");
  bm=new JButton("*"); bd=new JButton("/"); be=new JButton("=");
  frm.setTitle("网格式布局管理器GridLayout");
  frm.setLayout(null);
  frm.setSize(300,220);
  frm.setResizable(false);
  GridLayout grid=new GridLayout (4,4);
  pan.setLayout(grid);
  tf.setBounds(35,15,200,25);
  pan.setBounds(35,50,200,120);
  tf.setBackground(Color.CYAN);
  tf.setHorizontalAlignment(JTextField.RIGHT);
  pan.add(b[7]);  pan.add(b[8]);  pan.add(b[9]);  pan.add(bd);
  pan.add(b[4]);  pan.add(b[5]);  pan.add(b[6]);  pan.add(bm);
  pan.add(b[1]);  pan.add(b[2]);  pan.add(b[3]);  pan.add(bs);
  pan.add(b[0]);  pan.add(bp);  pan.add(be);  pan.add(ba);
  frm.add(tf);
  frm.add(pan);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frm.setVisible(true);
}
}
