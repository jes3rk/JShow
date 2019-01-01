package test;
import javax.swing.*;
import classes.*;

final class Test {
	public static void main(String[] args) {
		String[][] filePaths = {
				{"/home/joseph/apps/JShow/testAudio/Musical Musicians Meticulously Munching Melons.wav", "Jazz"},
				{"/home/joseph/apps/JShow/testAudio/YCBM.wav", "YCBM"}
		};
		JFrame window = new JFrame("App");
		window.setSize(300, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Workspace workspace = new Workspace(300, 300);
		for (String[] str:filePaths) {
			workspace.addAudioCue(str[0], str[1]);
		}
		window.add(workspace.getWorkSpace());
		
		window.setVisible(true);
	}
}