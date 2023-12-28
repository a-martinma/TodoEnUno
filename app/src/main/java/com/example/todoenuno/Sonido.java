package com.example.todoenuno;

import android.content.Context;
import android.media.MediaPlayer;

public class Sonido {
    private static MediaPlayer mediaPlayer;

    private static int currentSong = -1;


    public static void startPlaying(Context context, int resourceId) {
        if(currentSong == -1) { //Si no hay ninguna música de fondo sonando, que suene. Se hace para que no se superponga una cancion sobre de otra
            mediaPlayer = MediaPlayer.create(context, resourceId);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            currentSong = R.raw.musicadefondo;
        }
    }
    public static void pulsarUnaVez(Context context, int resourceId) {
        MediaPlayer mediaPlayer2 = MediaPlayer.create(context, resourceId);
        mediaPlayer2.start();
    }

}
