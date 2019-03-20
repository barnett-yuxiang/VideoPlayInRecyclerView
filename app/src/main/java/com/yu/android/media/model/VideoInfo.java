package com.yu.android.media.model;

public class VideoInfo {
    private int mId;
    private String mUserHandle;
    private String mTitle;
    private String mCoverUrl;
    private String mUrl;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getUserHandle() {
        return mUserHandle;
    }

    public void setUserHandle(String userHandle) {
        this.mUserHandle = userHandle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getCoverUrl() {
        return mCoverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.mCoverUrl = coverUrl;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }
}
