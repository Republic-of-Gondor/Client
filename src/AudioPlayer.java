import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AudioPlayer extends JFXPanel	{

	private MediaPlayer musicPlayer;
	private MediaPlayer soundPlayer;

	public void playSong(String songName)	{
		if (soundPlayer != null && soundPlayer.getStatus() != MediaPlayer.Status.DISPOSED) soundPlayer.pause();

		File file = new File("resources/audio/music/" + songName + ".mp3");
		Media song = new Media(file.toURI().toString());

		if (musicPlayer != null)
			musicPlayer.dispose();

		musicPlayer = new MediaPlayer(song);
		musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		musicPlayer.play();
	}

	public void pauseSong()	{
		musicPlayer.pause();
	}

	public void resumeSong()	{
		musicPlayer.play();
	}

	public void playSound(String soundName)	{
		if (musicPlayer != null && musicPlayer.getStatus() != MediaPlayer.Status.DISPOSED)
			musicPlayer.pause();

		File file = new File("resources/audio/sound/" + soundName + ".mp3");
		Media sound = new Media(file.toURI().toString());

		if(soundPlayer != null)
			soundPlayer.dispose();

		soundPlayer = new MediaPlayer(sound);
		soundPlayer.play();

		soundPlayer.setOnEndOfMedia(() -> {
			if (musicPlayer != null && musicPlayer.getStatus() != MediaPlayer.Status.DISPOSED)
				musicPlayer.play();
		});
	}

	public void pauseSound()	{
		soundPlayer.pause();
	}

	public void resumeSound()	{
		soundPlayer.play();
	}
}


