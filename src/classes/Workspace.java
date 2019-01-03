package classes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		space.setFocusable(true);
		space.addKeyListener(new go());
	}
	
	public void playCue() {
		Cue goCue = cueList.get(itr);
		goCue.go();
		nextCue();
	}
	
	public void nextCue() {
		itr++;
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
	
	public class go implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int id = e.getID();
			//System.out.println(id);
			if (id == 401) {
				playCue();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
