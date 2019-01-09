package classes;
import java.io.File; 
import java.io.IOException; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Audio cue object.
 * @author Joseph
 *
 */
public class AudioCue extends MediaCue implements Cue {
	private Clip clip;
	
	/**
	 * Constructor
	 * @param path Location of the file
	 * @param name Name for the cue to display
	 */
	public AudioCue(String path, String name) {
		this.NAME = name;
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
		AudioInputStream stream = AudioSystem.getAudioInputStream(new File(FILE_PATH).getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(stream);
		clip.setMicrosecondPosition(this.START_TIME * 1000);
	}
	
	/* (non-Javadoc)
	 * @see classes.Cue#_action()
	 */
	@Override
	public void _action() {
		clip.start();
	}
	
	/* (non-Javadoc)
	 * @see classes.Cue#stop()
	 */
	public void stop() {
		//TODO: Fix stop behavior
		//clip.close();
		clip.stop();
		clip.setMicrosecondPosition(this.START_TIME * 1000);
	}
	
}
