package App;

//filename：App14_17.java              文件选择对话框应用
import java.io.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;
public class App14_17 extends JFrame implements ActionListener
{
private JTextArea ta=new JTextArea(10,20);
private JFileChooser jfc=new JFileChooser(new File("."));
private JButton bOpen,bSave;
public App14_17()
{
  super("文件选择框应用程序");
  JScrollPane ps=new JScrollPane(ta);
  bOpen=new JButton("选取");
  bSave=new JButton("存盘");
  setLayout(new FlowLayout(FlowLayout.CENTER,15,10));
  add(ps);  add(bOpen);  add(bSave);
  bOpen.addActionListener(this);
  bSave.addActionListener(this);
  setVisible(true);
  setSize(300,280);
}
public static void main(String[] args)
{
  App14_17 frm=new App14_17();
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
  JButton jbt=(JButton)e.getSource();
  if(jbt==bOpen)
  {
    int status=jfc.showOpenDialog(this);
    if(status!=JFileChooser.APPROVE_OPTION)
      ta.setText("没有选择文件");
    else
    {
    	try
    	{
    	  File file1=jfc.getSelectedFile();
        Scanner scan=new Scanner(file1);
        String info="";
        while(scan.hasNext())
        {
          String str = scan.nextLine();
          info+=str+"\r\n";
        }
        ta.setText(info);
    	}
    	catch(FileNotFoundException ioe){};
    }
  }
  else
  {
    int re=jfc.showSaveDialog(this);
    if(re==JFileChooser.APPROVE_OPTION)
    {
      try
      {
        File file2=jfc.getSelectedFile();
        FileOutputStream f=new FileOutputStream(file2);
        BufferedOutputStream out=new BufferedOutputStream(f);
        byte[] b=(ta.getText()).getBytes();
        out.write(b,0,b.length);
        out.close();
      }
      catch(IOException ioe){};
    }
  }
}
}
