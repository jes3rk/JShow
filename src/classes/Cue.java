package classes;

import javax.swing.JButton;

/**
 * Interface representing a cue. All actions for the playing of a cue will be called using this.
 * @author Joseph
 */
public interface Cue {
	/**
	 * Go function
	 */
	public void go();

	/**
	 * Defines the stop action for a cue.
	 */
	public void stop();
	
	// placeholder for making the interface
	public JButton makePlayButton();
	
	/**
	 * Defines the go action for a cue.
	 */
	public void _action();
	
}
