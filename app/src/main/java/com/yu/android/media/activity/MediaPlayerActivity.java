package com.yu.android.media.activity;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.yu.android.media.R;
import com.yu.android.media.adapter.MediaPlayerAdapter;
import com.yu.android.media.adapter.MpViewHolder;
import com.yu.android.media.mock.VideoRepository;
import com.yu.android.media.model.VideoInfo;
import com.yu.android.media.ui.CardItemDecoration;

import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity implements MediaPlayerAdapter.OnItemClickListener,
        SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {
    private static final String TAG = "MediaPlayerActivity";
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private MediaPlayer mMediaPlayer;
    private RecyclerView mRecyclerView;
    private MediaPlayerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new MediaPlayerAdapter(this, VideoRepository.getVideoInfoList());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new CardItemDecoration(this));
        mAdapter.setOnItemClickListener(this);

        mSurfaceView = new SurfaceView(this);
        Log.d(TAG, "new SurfaceView");
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
        Log.d(TAG, "addCallback");
        mMediaPlayer = new MediaPlayer();
    }

    @Override
    public void onPlayClick(VideoInfo videoInfo, int pos) {
        mMediaPlayer.reset();
        Log.d(TAG, "reset");
        ViewParent parent = mSurfaceView.getParent();
        if (parent != null) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(mSurfaceView);
            }
        }
        Log.d(TAG, "removeView");
        MpViewHolder vh = (MpViewHolder) mRecyclerView.findViewHolderForAdapterPosition(pos);
        if (vh != null) {
            ImageView iv = vh.itemView.findViewById(R.id.video_cover);
            int height = iv.getHeight();
            int width = (int) ((height / 1.5f) + 0.5f);
            ((ViewGroup) vh.itemView).addView(mSurfaceView, width, height);
            Log.d(TAG, "addView");
        }

        try {
            mMediaPlayer.setDataSource(videoInfo.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated");
        mMediaPlayer.setDisplay(holder);
        try {
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");
        mMediaPlayer.stop();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mMediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
            mMediaPlayer = null;
        }
    }
}
