package classes;
import java.util.ArrayList;

import classes.Cue;

public class Workspace {
	public ArrayList<Cue> cueList;
	
	public Workspace() {
		
	}
	
	public void addAudioCue(String path, String name) {
		cueList.add(new AudioCue(path, name));
	}
}
