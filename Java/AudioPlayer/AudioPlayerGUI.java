package fpg;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AudioPlayerGUI implements ActionListener
{
	private JFrame window;
	private JLabel songLabel;
	private JButton playButton, pauseButton, nextButton;
	private Song song;
	
	public AudioPlayerGUI(final String filename)
	{
		this.song = new Song(filename);
	}
	
	public void build()
	{
		//Creating + Altering Window
		window = new JFrame("AudioPlayer.exe");
		window.setResizable(false);
		window.setLayout(null);
		window.setSize(450,224);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creating + Altering Label displaying the 'Song'
		songLabel = new JLabel("Song: ");
		songLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		songLabel.setBounds(35, 10, 354, 62);
				
		//Creating + Altering the Pause Button
		pauseButton = new JButton("Stop");
		pauseButton.setFocusable(false);
		pauseButton.addActionListener(this);
		pauseButton.setActionCommand("stop");
		pauseButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pauseButton.setBounds(10, 94, 126, 62);
		
		//Creating + Altering the Play Song Button
		playButton = new JButton("Play");
		playButton.setFocusable(false);
		playButton.addActionListener(this);
		playButton.setActionCommand("play");
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playButton.setBounds(146, 94, 126, 62);
		
		//Creating + Altering the Play Next Button
		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		nextButton.setFocusable(false);
		nextButton.setActionCommand("next");
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nextButton.setBounds(282, 94, 126, 62);
		
		//Altering the window's panel
		window.getContentPane().setBackground(new Color(192, 192, 192));
		window.getContentPane().setLayout(null);
				
		//Adding the previous components to the window's panel
		window.getContentPane().add(songLabel);
		window.getContentPane().add(playButton);
		window.getContentPane().add(pauseButton);
		window.getContentPane().add(nextButton);
				
		//Final changes/modifications to the window
		window.setLocationRelativeTo(null); // this should be last right before setting window visible for it to work
		window.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		final String BASETEXT = "Song: ";
		// TODO
		//he he ^ cool text
		switch(e.getActionCommand().toString())
		{
		case "play": 	song.play();	 break;
		case "stop": 	song.stop();	 break;
		case "next":	song.playNext(); break;
		}
		this.songLabel.setText(BASETEXT + song.getSongName());
	}
}
