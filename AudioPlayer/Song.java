package fpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Song {
	
	private ArrayList<File> songs = new ArrayList<File>();
	private AudioInputStream audio;
	private Clip sound;
	private ArrayList<String> songName = new ArrayList<String>();
	private String currentSong;
	private int index = 0;
	
	public Song(final String filename)
	{
		File file = new File(filename);
		try 
		{
			InputStream is = Song.class.getResourceAsStream("/songs.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while((line = br.readLine()) != null)
			{
				File current = new File("music/" + line);// = new File("/music/" + line);
				this.songs.add(current);
				this.songName.add(line);
			}
			br.close();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void play()
	{
		this.currentSong = this.songName.get(index);
		try {
			if(this.sound != null)
				this.sound.stop();
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
		if(this.currentSong == null || this.sound == null)
		{
			this.currentSong = "You cannot pause nothing...";
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
		this.currentSong = this.songName.get(index);
	}
	
	public String getSongName()
	{
		return this.currentSong;
	}
	
}
