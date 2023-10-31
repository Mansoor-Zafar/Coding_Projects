package fpg;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ClockGUI{

	private JFrame window;
	private JLabel time;
	private Clock clock = new Clock();
	
	public void build()
	{
		this.window = new JFrame("Clock.exe");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(706,336);
		this.window.setResizable(false);
		this.window.setLayout(null);
		
		this.window.getContentPane().setBackground(Color.gray);
		
		this.time = new JLabel("Getting time...");
		this.time.setFont(new Font("Cascadia Code", Font.PLAIN, 68));
		this.time.setBounds(70,45,577,198);
		
		this.window.add(time);
		this.window.setLocationRelativeTo(null);
		this.window.setVisible(true);
		
		this.setTime();
		
	}
	
	private void setTime()
	{
		clock.setTime(this.time);
		
	}

}
