package fpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Song {
	
	private ArrayList<File> songs = new ArrayList<File>();
	private AudioInputStream audio;
	private Clip sound;
	private String songName;
	private int index = 0;
	
	public Song(final String filename)
	{
		File file = new File(filename);
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null)
			{
				File current = new File("music/" + line);
				this.songs.add(current);
			}
			br.close();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void play()
	{
		this.songName = this.songs.get(index).toString().replace("music\\", "");
		try {
			this.audio = AudioSystem.getAudioInputStream(this.songs.get(index));
			this.sound = AudioSystem.getClip();
			this.sound.open(audio);
			this.sound.start();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void stop()
	{
		if(this.songName == null)
		{
			this.songName = "You cannot pause nothing...";
			return;
		}
		this.sound.stop();
	}
	
	public void playNext()
	{
		this.stop();
		this.index += 1;
		if(index >= this.songs.size())
			index = 0;
		this.songName = this.songs.get(index).toString().replace("music\\", "");
	}
	
	public String getSongName()
	{
		return this.songName;
	}
	
}
