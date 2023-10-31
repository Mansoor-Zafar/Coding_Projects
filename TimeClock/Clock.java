package fpg;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;

public class Clock {
	
	private SimpleDateFormat timeFormat;
	private String time = "";
	
	public void setTime(JLabel txt)
	{
		System.out.println("I RAN");
		while(true)
		{
			txt.setText(time);
			this.timeFormat = new SimpleDateFormat("hh:mm::ss a");
			this.time = this.timeFormat.format(Calendar.getInstance().getTime());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
