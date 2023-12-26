package com.pattern.design.behavioralDesignPatterns.iterator.iterators;

import com.pattern.design.behavioralDesignPatterns.iterator.profile.Profile;

/**
 * 반복자 인터페이스
 * - 컬렉션 순회에 필요한 작업들(ex. 다음 요소 가져오기, 현재 위치 가져오기, 반복자 다시 시작 등) 선언
 */
public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}