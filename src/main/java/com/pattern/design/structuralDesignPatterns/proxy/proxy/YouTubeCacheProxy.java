package com.pattern.design.structuralDesignPatterns.proxy.proxy;

import com.pattern.design.structuralDesignPatterns.proxy.some_cool_media_library.ThirdPartyYouTubeClass;
import com.pattern.design.structuralDesignPatterns.proxy.some_cool_media_library.ThirdPartyYouTubeLib;
import com.pattern.design.structuralDesignPatterns.proxy.some_cool_media_library.Video;

import java.util.HashMap;

/**
 * 프록시 클래스
 * - 서비스 객체를 가리키는 참조 필드 존재
 * -  프록시가 요청의 처리(예: 초기화 지연, 로깅, 액세스 제어, 캐싱 등)를 완료하면, 그 후 처리된 요청을 서비스 객체에 전달
 * - 일반적으로 프록시는 서비스 객체들의 전체 수명 주기를 관리
 */
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

    /**
     * 프록시는 실제 클래스와 같은 인터페이스를 구현하고 실제 클래스에 모든 작업을 위임
     */
    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    /**
     * 프록시를 통해 같은 비디오를 여러 번 요청 시 캐싱 된 결과 반환
     */
    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}