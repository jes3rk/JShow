package classes;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioCue extends MediaCue {
	private Clip clip;
	//private String status;
	
	public AudioCue(String path) {
		this.setName("newCue");
		this.setFilePath(path);
		try {
			this._initializeAudio();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	private void _initializeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream stream = AudioSystem.getAudioInputStream(new File(this.getFilePath()).getAbsoluteFile());
		this.clip = AudioSystem.getClip();
		clip.open(stream);
	}
}
