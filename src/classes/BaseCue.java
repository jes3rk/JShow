package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;


public class BaseCue {
	private String Name;
	private Duration preDelay = Duration.ZERO; // default predelay is 0
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	public void go() {
		Timer perform = new Timer();
		perform.schedule(new _performAction(), preDelay.toMillis());
	}
	
	public Duration getPreDelay() {
		return preDelay;
	}

	// set the predelay to  be a number of milliseconds
	public void setPreDelay(long millis) {
		this.preDelay = Duration.ofMillis(millis);
	}
	
	public void _action() {
		System.out.println("Action not specified");
	}
	
	public class _performAction extends TimerTask {
		// suddenly multi-threading is implemented
		@Override
		public void run() {
			_action();
			
		}
	}
	
	public JButton makePlayButton() {
		JButton button = new JButton("Play " + getName());
		button.addActionListener(new goButton());
		return button;
	}
	
	public class goButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			go();
		}
	}
}
