package classes;
import java.io.File; 
import java.io.IOException; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioCue extends MediaCue implements Cue {
	public Clip clip;
	
	public AudioCue(String path, String name) {
		this.setName(name);
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
		clip = AudioSystem.getClip();
		clip.open(stream);
	}
	
	@Override
	public void _action() {
		clip.start();
	}
	
	public void stop() {
		clip.close();
	}
	
}
