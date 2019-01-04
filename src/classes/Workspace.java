package classes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import classes.Cue;

/**
 * Class that makes up the functional workspace for the application.
 * @author Joseph
 *
 */
public class Workspace {
	private ArrayList<Cue> cueList = new ArrayList<Cue>();
	private int itr = 0;
	private JPanel space = new JPanel();
	/**
	 * Key Code for playing the current cue in the list.
	 */
	public int GO_KEY = 32;
	/**
	 * Key Code for stopping all cues in the list.
	 */
	public int E_STOP = 27;
	
	public Workspace(int w, int h) {
		// first make the workspace
		space.setLayout(new BoxLayout(space, BoxLayout.Y_AXIS));
		space.setFocusable(true);
		space.addKeyListener(new go());
	}
	
	/**
	 * Plays the current cue and increments the cue counter
	 */
	public void playCue() {
		if (itr < cueList.size()) {
			getCurrent().go();
			nextCue();
		}
	}
	
	/**
	 * Stops all cues in the workspace. Emergency stop function.
	 */
	public void stopAll() {
		for (Cue cue:cueList) {
			cue.stop();
		}
		itr = 0;
	}
	
	/**
	 * Iterates to the next cue in the list.
	 */
	public void nextCue() {
		itr++;
	}
	
	/**
	 * Function to get the current cue in the list.
	 * @return Cue
	 */
	public Cue getCurrent() {
		return cueList.get(itr);
	}
	
	/**
	 * Appends an audio cue to the cueList.
	 * TODO: Allow for adding cue at any point in the list
	 * @param path Filepath to the audio file
	 * @param name Name of the cue to use in the workspace
	 */
	public void addAudioCue(String path, String name) {
		_addCue(new AudioCue(path, name));
	}
	
	private void _addCue(Cue newcue) {
		// generic function to append a new cue to the list
		
		// TODO: be able to add a cue to any position in the list 
		this.cueList.add(newcue);
	}
	
	/**
	 * Generates the workspace object out of the cues in the cuelist and defines behavior.
	 * @return JPanel
	 */
	public JPanel getWorkSpace() {
		for (Cue c:cueList) {
			space.add(c.makePlayButton());
		}
		
		return space;
	}
	
	private class go implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int id = e.getKeyCode();
			System.out.println(id);
			// if's to define behavior
			if (id == GO_KEY) {
				playCue();
			} else if (id == E_STOP) {
				stopAll();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
