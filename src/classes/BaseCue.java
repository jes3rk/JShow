package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;


/**
 * Underlying cue object that contains properties and methods shared across all cues.
 * @author Joseph
 *
 */
public class BaseCue {
	private String Name;
	/**
	 * Pre-delay that determines the time from when the GO button is pressed to when the cue fires. 
	 */
	public Duration preDelay = Duration.ZERO; // default predelay is 0
	
	/**
	 * Returns the name of the cue
	 * @return String
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Name for the cue.
	 * @param name
	 */
	public void setName(String name) {
		this.Name = name;
	}
	
	/**
	 * Method called to cause the cue to fire. Creates a seperate thread and begins the pre-delay timer before firing the cue.
	 */
	public void go() {
		Timer perform = new Timer();
		perform.schedule(new _performAction(), preDelay.toMillis());
	}
	

	// set the predelay to  be a number of milliseconds
	/**
	 * Sets the pre-delay timer in terms of milliseconds;
	 * @param millis
	 */
	public void setPreDelay(long millis) {
		this.preDelay = Duration.ofMillis(millis);
	}
	
	public void _action() {
		System.out.println("Action not specified");
	}
	
	private class _performAction extends TimerTask {
		// suddenly multi-threading is implemented
		@Override
		public void run() {
			_action();
			
		}
	}
	
	/**
	 * Generates and returns UI for interacting with the cue.
	 * @return JButton
	 */
	public JButton makePlayButton() {
		JButton button = new JButton("Play " + getName());
		button.addActionListener(new goButton());
		return button;
	}
	
	private class goButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			go();
		}
	}
}
