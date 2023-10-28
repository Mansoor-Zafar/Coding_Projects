package fpg;

public class Main {
	public static void main(String[] args)
	{	
		AudioPlayerGUI gui = new AudioPlayerGUI("songs.txt");
		gui.build();
	}
}
