package com.yu.android.media.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.yu.android.media.GlideApp;
import com.yu.android.media.R;
import com.yu.android.media.model.VideoInfo;

import java.util.List;

public class MediaPlayerAdapter extends RecyclerView.Adapter<MpViewHolder> {

    private List<VideoInfo> mVideoInfoList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public MediaPlayerAdapter(@NonNull Context context, @NonNull List<VideoInfo> videoInfoList) {
        mContext = context;
        mVideoInfoList = videoInfoList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mVideoInfoList.size();
    }

    @NonNull
    @Override
    public MpViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_row_media_player, viewGroup, false);
        return new MpViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MpViewHolder mpViewHolder, int i) {
        View v = mpViewHolder.itemView;
        ImageView iv = v.findViewById(R.id.video_cover);
        ImageButton ib = v.findViewById(R.id.video_play);
        ib.setOnClickListener(v1 -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onPlayClick(mVideoInfoList.get(i), i);
            }
        });

        VideoInfo videoInfo = mVideoInfoList.get(i);
        GlideApp.with(mContext).load(videoInfo.getCoverUrl()).into(iv);
    }

    @Override
    public void onViewRecycled(@NonNull MpViewHolder holder) {
        super.onViewRecycled(holder);
        View v = holder.itemView;
        ImageView iv = v.findViewById(R.id.video_cover);
        iv.setImageDrawable(null);
    }

    public interface OnItemClickListener {
        void onPlayClick(VideoInfo videoInfo, int pos);
    }
}
