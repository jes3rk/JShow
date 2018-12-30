package test;
import java.util.ArrayList;

import javax.swing.*;
import classes.*;

final class Test {
	
	public static void main(String[] args) {
		String[][] filePaths = {
				{"/home/joseph/apps/JShow/testAudio/YCBM.wav", "YCBM"}
		};
		ArrayList<Cue> cueList = new ArrayList<Cue>(filePaths.length);
		JFrame frame = new JFrame("App");
		frame.setSize(300, 300);
		
		for (String[] str:filePaths) {
			cueList.add(new AudioCue(str[0], str[1]));
		}
		
		// make buttons
		for (Cue cue:cueList) {
			frame.add(cue.makePlayButton());
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}