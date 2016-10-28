package MP;

import java.applet.Applet;
import java.applet.AudioClip;


/**
 * Created by Jhessa on 26/10/2016.
 */
public class Sound{
        /*
         this class imports .wav Audioclips from the same package for other classes to use.
         BALL - a sound clip when ball hits the racquet.
         GAMEOVER - a sound clip when someone wins.
        */
        public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("hit.wav"));
        public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("Game-over-robotic-voice.wav"));
        public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("reol.wav"));
        public static final AudioClip FALL =  Applet.newAudioClip(Sound.class.getResource("Bleep-SoundBible.com-1927126940.wav"));
}
