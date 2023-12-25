package com.example.todoenuno;

import android.content.Context;
import android.media.MediaPlayer;

public class Sonido {
    private static MediaPlayer mediaPlayer;


    public static void startPlaying(Context context, int resourceId) {
        mediaPlayer = MediaPlayer.create(context, resourceId);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    public static void pulsarUnaVez(Context context, int resourceId) {
        MediaPlayer mediaPlayer2 = MediaPlayer.create(context, resourceId);
        mediaPlayer2.start();
    }

    public static void stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
