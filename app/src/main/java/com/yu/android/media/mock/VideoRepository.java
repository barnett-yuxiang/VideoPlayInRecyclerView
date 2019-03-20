package com.yu.android.media.mock;

import com.yu.android.media.model.VideoInfo;

import java.util.ArrayList;
import java.util.List;

public class VideoRepository {

    public static List<VideoInfo> getVideoInfoList() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setId(1);
        videoInfo.setUserHandle("@h.pandya");
        videoInfo.setTitle("Do you think the concept of marriage will no longer exist in the future?");
        videoInfo.setCoverUrl("https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-1.png");
        videoInfo.setUrl("https://androidwave.com/media/androidwave-video-1.mp4");

        VideoInfo videoInfo2 = new VideoInfo();
        videoInfo2.setId(2);
        videoInfo2.setUserHandle("@hardik.patel");
        videoInfo2.setTitle("If my future husband doesn't cook food as good as my mother should I scold him?");
        videoInfo2.setCoverUrl("https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-2.png");
        videoInfo2.setUrl("https://androidwave.com/media/androidwave-video-2.mp4");

        VideoInfo videoInfo3 = new VideoInfo();
        videoInfo3.setId(3);
        videoInfo3.setUserHandle("@arun.gandhi");
        videoInfo3.setTitle("Give your opinion about the Ayodhya temple controversy.");
        videoInfo3.setCoverUrl("https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-3.png");
        videoInfo3.setUrl("https://androidwave.com/media/androidwave-video-3.mp4");

        VideoInfo videoInfo4 = new VideoInfo();
        videoInfo4.setId(4);
        videoInfo4.setUserHandle("@sachin.patel");
        videoInfo4.setTitle("When did kama founders find sex offensive to Indian traditions");
        videoInfo4.setCoverUrl("https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-4.png");
        videoInfo4.setUrl("https://androidwave.com/media/androidwave-video-6.mp4");

        VideoInfo videoInfo5 = new VideoInfo();
        videoInfo5.setId(5);
        videoInfo5.setUserHandle("@monika.sharma");
        videoInfo5.setTitle("When did you last cry in front of someone?");
        videoInfo5.setCoverUrl("https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-5.png");
        videoInfo5.setUrl("https://androidwave.com/media/androidwave-video-5.mp4");

        List<VideoInfo> result = new ArrayList<>();
        result.add(videoInfo);
        result.add(videoInfo2);
        result.add(videoInfo3);
        result.add(videoInfo4);
        result.add(videoInfo5);
        return result;
    }
}
