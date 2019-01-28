package com.example.bsmal.youtubeplayer;

import android.app.NotificationChannel;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import static com.example.bsmal.youtubeplayer.R.id.btnPlayVideo;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        Button btnPlaylist = (Button) findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this); // responds to the button Play Video that is being clicked can be use for multiple buttons
        btnPlaylist.setOnClickListener(this); // same for Play List button
    }

    @Override
    public void onClick(View v) { // (View v) is (View view) is the v isn't used as below an error will occur
        Intent intent = null; // this is where I pass data from one activity to another...binding the activities together

        switch(v.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false); // 0 the time and milisecs the video will be playing, true auto play, false lock box mode
                break; // this allows the videos to play automatically

            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 0, 0, true, true); // same as above lock box mode set to true
                break;

            default:

        }

        if(intent != null) {
            startActivity(intent);
        }

    }
}
