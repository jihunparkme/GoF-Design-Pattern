package com.pattern.design.structuralDesignPatterns.proxy.downloader;

import com.pattern.design.structuralDesignPatterns.proxy.some_cool_media_library.ThirdPartyYouTubeLib;
import com.pattern.design.structuralDesignPatterns.proxy.some_cool_media_library.Video;

import java.util.HashMap;

/**
 * 클라이언트
 * - 같은 인터페이스를 통해 서비스 및 프록시와 함께 작동
 * - 서비스 객체를 기대하는 모든 코드에 프록시 전달 가능
 */
public class YouTubeDownloader {
    private ThirdPartyYouTubeLib api;

    public YouTubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Video page (imagine fancy HTML)");
        System.out.println("ID: " + video.id);
        System.out.println("Title: " + video.title);
        System.out.println("Video: " + video.data);
        System.out.println("-------------------------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = api.popularVideos();
        System.out.println("\n-------------------------------");
        System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.id + " / Title: " + video.title);
        }
        System.out.println("-------------------------------\n");
    }
}