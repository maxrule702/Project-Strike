package sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        //Sound files to go in the sound folder, and then the sound name will go after the "/sound/" bit
        soundURL[0] = getClass().getResource("/sound/RazorMind.wav");
        soundURL[1] = getClass().getResource("/sound/bomb.wav");
        soundURL[2] = getClass().getResource("/sound/ammoReload.wav");
        soundURL[3] = getClass().getResource("/sound/c4Beep.wav");

    }

    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {

        }
    }

    public void play() {

        clip.start();
    }

    public void loop() {

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {

        clip.stop();
    }

}
