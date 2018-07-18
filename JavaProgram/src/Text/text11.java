package Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class text11 extends JFrame implements ActionListener
{
	JTextArea t1 = new JTextArea("第一个数");
	JTextArea t2 = new JTextArea("第二个数");
	JTextArea t3 = new JTextArea("=");
	
	JTextField a3 = new JTextField(5);
	JTextField a1 = new JTextField(5);
	JTextField a2 = new JTextField(5);
	
	JButton b1 = new JButton("计算");
	JButton b2 = new JButton("清除");
	JButton b3 = new JButton("退出");
	
	static JComboBox<String> combo;
	
	public text11()
	{
		super("text11");
		String[] sel={"+","-","*","/"};
		JFrame frm = new JFrame();
		frm.setTitle("简易计算器");
		frm.setLayout(null);
		frm.setSize(600, 160);
	
		combo=new JComboBox<String>(sel);
		combo.setEditable(false);
		combo.addActionListener(combo);
		frm.add(combo);
		combo.setLocation(220, 20);
		combo.setSize(40, 21);
		combo.setEditable(false);
	
		t1.setLocation(60, 20);
		t1.setSize(50, 21);
		t1.setEditable(false);
		t1.setBackground(null);
		t1.setBorder(new LineBorder(new Color(175,175,175)));
		
		t2.setLocation(270, 20);
		t2.setSize(50, 21);
		t2.setEditable(false);
		t2.setBackground(null);
		t2.setBorder(new LineBorder(new Color(175,175,175)));
		
		t3.setLocation(430, 20);
		t3.setSize(10, 21);
		t3.setEditable(false);
		t3.setBackground(null);
		t3.setBorder(new LineBorder(new Color(175,175,175)));
		
		a1.setLocation(120, 20);
		a1.setSize(90, 21);
		a1.setBorder(new LineBorder(new Color(173,190,220)));
	
		a2.setLocation(330, 20);
		a2.setSize(90, 21);
		a2.setBorder(new LineBorder(new Color(173,190,220)));
	
		a3.setLocation(450, 20);
		a3.setSize(90, 21);
		a3.setEditable(false);
		a3.setBackground(Color.CYAN);
		a3.setBorder(new LineBorder(new Color(173,190,220)));
	
		b1.setLocation(310, 70);
		b1.setSize(70, 30);
	
		b2.setLocation(390, 70);
		b2.setSize(70, 30);
	
		b3.setLocation(470, 70);
		b3.setSize(70, 30);
	
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		frm.add(t1);
		frm.add(t2);
		frm.add(t3);
		frm.add(a1);
		frm.add(a2);
		frm.add(a3);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		
		a1.addActionListener(this);
		a2.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="退出")
		{
			System.exit(0);
		}
		if(e.getActionCommand()=="清除")
		{
			a1.setText("");
			a2.setText("");
			a3.setText("");
		}
		double a,b,sum=0;
		a=Double.parseDouble(a1.getText());
		b=Double.parseDouble(a2.getText());
		if(e.getActionCommand()=="计算")
		{
			if(combo.getSelectedItem()=="+")
			{
				sum=(double)a+(double)b;
			}
			else if(combo.getSelectedItem()=="-")
			{
				sum=(double)a-(double)b;
			}
			else if(combo.getSelectedItem()=="*")
			{
				sum=(double)a*(double)b;
			}
			else if(combo.getSelectedItem()=="/")
			{
				sum=(double)a/(double)b;
			}
			a3.setText(String.valueOf(sum));
		}
	}
	public static void main(String[] args) 
	{
		new text11();
	}
}