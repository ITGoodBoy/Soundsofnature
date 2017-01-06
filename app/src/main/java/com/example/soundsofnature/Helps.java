package com.example.soundsofnature;


import android.content.Context;
import android.media.MediaPlayer;

 class Helps {


    private static MediaPlayer player;
    void playSound(Context context, int... sounds)
    {
        if (player == null)
        {
            int sound = sounds[(int) (Math.random() * sounds.length)];
            player = MediaPlayer.create(context, sound);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    player = null;
                }
            });
        }
    }
     void stop()
     {
         if (player != null) {
             player.stop();
             player.release();
             player = null;
         }
     }
}
