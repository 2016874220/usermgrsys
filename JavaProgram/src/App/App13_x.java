package App;

//filename：App13_x.java        FlowLayout类的使用 
import java.awt.*; 
import javax.swing.*;
public class App13_x extends JFrame
{
public static void main(String[] args)
{
  App13_x frm=new App13_x();
}
public App13_x()
{
  this.setBounds(100,100,360,300);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);
  Object[] selectItem={"圆形","正方形","正三角形"};
  Object selectValue=JOptionPane.showInputDialog(null,"请选择计算面积的图形","选择图形",JOptionPane.INFORMATION_MESSAGE,null,selectItem,selectItem[0]);
  String select=(String)selectValue;
  String inputValue=JOptionPane.showInputDialog(null,"请输入边长和半径","输入边长",JOptionPane.QUESTION_MESSAGE);
  int input=Integer.parseInt(inputValue);
  double result=caculate(select,input);
  String message="计算结果为："+result;
  Object[] endButton={"结束程序","继续运行"};
  JOptionPane end=new JOptionPane(message,JOptionPane.WARNING_MESSAGE,JOptionPane.DEFAULT_OPTION,null,endButton);
  JDialog endD=end.createDialog(end,"计算结果");
  endD.setVisible(true);
  Object push=end.getValue();
  if(push==endButton[0]) System.exit(0);
  else if(push==endButton[1]) new App13_x();
}
double caculate(Object select,int value)
{
  double result=0;
  if(select.equals("圆形")) result=value*value*3.14;
  else if(select.equals("正方形")) result=value*value;
  else if(select.equals("正三角形")) result=value/2*1.732*value/2;
  return result;
}
}

