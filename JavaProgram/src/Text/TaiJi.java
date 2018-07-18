package Text;

import java.awt.*;

import javax.swing.*;

public class TaiJi extends JFrame
{
	static JPanel pan = new JPanel();
	static TaiJi jrm = new TaiJi();
	public static void main(String[] args) 
	{
		jrm.setVisible(true);
		jrm.setTitle("Ì«¼«");
		jrm.setBounds(0, 0, 500, 500);
		jrm.setSize(500,500);
		jrm.setLayout(null); 
		jrm.add(pan);
		jrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		public void paintComponent(Graphics g)
		{
			g.drawOval(1, 1, 500, 500);
			g.setColor(Color.black);
		}
	
}
