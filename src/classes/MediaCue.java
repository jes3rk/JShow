package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

abstract class MediaCue {
	private String filePath;
	private String Name;
	private String status;

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void go() {
		System.out.println("No Override");
	}
	
	public JButton makePlayButton() {
		JButton button = new JButton("Play " + this.Name);
		button.addActionListener(new goButton());
		return button;
	}
	
	public class goButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			go();
		}
	}
}
