package test;
import classes.*;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello World");
		AudioCue newCue = new AudioCue("/home/joseph/apps/JShow/testAudio/YCBM.wav");
		System.out.println(newCue.getName());
	}

}
