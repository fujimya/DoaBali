package com.example.doabali;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class DetailKidungActivity extends AppCompatActivity {
    TextView title,isi;
    String url = "";
    MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kidung);
        title = findViewById(R.id.texttitle);
        isi = findViewById(R.id.isi);
        title.setText(""+getIntent().getExtras().getString("title"));
        isi.setText(""+getIntent().getExtras().getString("isi"));
        url = ""+getIntent().getExtras().getString("url");


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        finish();
    }

    public void playkuy(View view) {
        try {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
