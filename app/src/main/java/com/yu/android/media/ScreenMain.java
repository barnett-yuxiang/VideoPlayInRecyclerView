package com.yu.android.media;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yu.android.media.activity.ExoPlayerActivity;
import com.yu.android.media.activity.MediaPlayerActivity;

public class ScreenMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpToMediaPlayerScreen(View view) {
        Intent intent = new Intent(this, MediaPlayerActivity.class);
        startActivity(intent);
    }

    public void jumpToExoPlayerScreen(View view) {
        Intent intent = new Intent(this, ExoPlayerActivity.class);
        startActivity(intent);
    }
}
