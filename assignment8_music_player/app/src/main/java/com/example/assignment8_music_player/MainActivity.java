package com.example.assignment8_music_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=null;
    }

    public void Music(View view) {

        int id = view.getId();
        if (id == R.id.Play) {
            // Handle play button click
            if(mediaPlayer==null){

                mediaPlayer=MediaPlayer.create(this,R.raw.song);
            }
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    StopMusic();
                }
            });
            mediaPlayer.start();

        } else if (id == R.id.Pause) {
            // Handle pause button click
            mediaPlayer.pause();

        } else if (id == R.id.Stop) {
            // Handle stop button click
            mediaPlayer.stop();
            StopMusic();
        }



    }

    public void StopMusic(){
        mediaPlayer.release();
        mediaPlayer=null;
    }
}