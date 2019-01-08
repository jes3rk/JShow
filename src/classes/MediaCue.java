package classes;

/**
 * Abstract class for media cues, including Audio and Video cues.
 * @author Joseph
 *
 */
abstract class MediaCue extends BaseCue {
	/**
	 * Location of the media file to play.
	 */
	public String FILE_PATH;
	public long START_TIME = 0;
	public long END_TIME;

	public void setFilePath(String filePath) {
		this.FILE_PATH = filePath;
	}
}
