package fpg;

public class Main {
	public static void main(String[] args)
	{	
		System.out.println("hi");
		AudioPlayerGUI gui = new AudioPlayerGUI("songs.txt");
		gui.build();
	}
}