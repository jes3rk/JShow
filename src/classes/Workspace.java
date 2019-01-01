package classes;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import classes.Cue;

public class Workspace {
	private ArrayList<Cue> cueList = new ArrayList<Cue>();
	public int itr = 0;
	private JPanel space = new JPanel();
	
	public Workspace(int w, int h) {
		// first make the workspace
		space.setLayout(new BoxLayout(space, BoxLayout.Y_AXIS));
	}
	
	public void addAudioCue(String path, String name) {
		_addCue(new AudioCue(path, name));
	}
	
	private void _addCue(Cue newcue) {
		// TODO: be able to add a cue to any position in the list 
		this.cueList.add(newcue);
	}
	
	public JPanel getWorkSpace() {
		for (Cue c:cueList) {
			space.add(c.makePlayButton());
		}
		
		return space;
	}
}
