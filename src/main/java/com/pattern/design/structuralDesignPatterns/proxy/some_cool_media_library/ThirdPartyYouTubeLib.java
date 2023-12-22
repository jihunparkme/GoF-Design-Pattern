package com.pattern.design.structuralDesignPatterns.proxy.some_cool_media_library;

import java.util.HashMap;

/**
 * 서비스 인터페이스
 * - 서비스의 인터페이스 선언
 * - 프록시가 서비스 객체로 위장할 수 있으려면 이 인터페이스를 따라야 한다.
 */
public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}