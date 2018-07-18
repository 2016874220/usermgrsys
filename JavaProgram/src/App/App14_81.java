package App;

//App14_8.java        对话框组件及相应的事件处理
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class App14_81
{

public App14_81()
{
  Object[] selectItem={"圆形","正方形","正三角形"};
  Object selectValue=JOptionPane.showInputDialog(null,"请选择计算图形的面积","选择图形",JOptionPane.INFORMATION_MESSAGE,null,selectItem,selectItem[0]);
  String select=(String)selectValue;   //将用户选择转换成字符串
  String inputValue=JOptionPane.showInputDialog(null,"请输入边长或半径","输入边长",JOptionPane.QUESTION_MESSAGE);
  int input=Integer.parseInt(inputValue);
}
}